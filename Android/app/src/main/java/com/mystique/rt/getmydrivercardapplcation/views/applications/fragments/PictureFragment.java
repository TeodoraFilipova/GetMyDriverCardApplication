package com.mystique.rt.getmydrivercardapplcation.views.applications.fragments;


import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.mystique.rt.getmydrivercardapplcation.R;
import com.mystique.rt.getmydrivercardapplcation.models.Picture;
import com.mystique.rt.getmydrivercardapplcation.parsers.bitmap.BitmapParser;

import java.io.File;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pl.aprilapps.easyphotopicker.DefaultCallback;
import pl.aprilapps.easyphotopicker.EasyImage;

/**
 * A simple {@link Fragment} subclass.
 */
public class PictureFragment extends Fragment {


    @BindView(R.id.btn_picturecamera)
    Button selfieButton;

    @BindView(R.id.btn_picturesave)
    Button selfieSaveButton;

    @BindView(R.id.iv_picture)
    ImageView selfieImageView;

    @Inject
    BitmapParser mPictureParser;

    //CardApplicationForm mCurrentCardApplicationForm;

   /* @BindView(R.id.btn_drivingliccamera)
    Button drivingLicButton;

    @BindView(R.id.iv_drivinglicence)
    ImageView drivingLicImageView;

    @BindView(R.id.btn_drivinglsafe)
    ImageView drivingLicSaveImageView;*/

    public PictureFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_picture, container, false);

        ButterKnife.bind(this, view);

        Context context = getActivity();

        PackageManager packageManager = context.getPackageManager();

        if(!packageManager.hasSystemFeature(PackageManager.FEATURE_CAMERA)){
            Toast.makeText(getActivity(), "This device does not have a camera.", Toast.LENGTH_SHORT)
                    .show();
        }

        if (!checkPermissions(context)){
            Toast.makeText(getActivity(), "This device camera is restricted. Switch the camera to use it.",
                    Toast.LENGTH_SHORT)
                    .show();
        }

        selfieButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeSelfie();
            }
        });

        selfieSaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveSelfie();
            }
        });

        return view;
    }


    public void makeSelfie() {
        EasyImage.openCamera(this, EasyImage.REQ_SOURCE_CHOOSER);
    }


    public void saveSelfie(){
        Bitmap bitmap = ((BitmapDrawable)selfieImageView
                .getDrawable())
                .getBitmap();

        byte[] byteImage = mPictureParser.fromBitmap(bitmap);

        Picture currentImage = new Picture();
        currentImage.setPicture(byteImage);
        //mCardApplicationForm.getDriver().setSelfie(selfiePic);

    };

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        //mPresenter.handleActivityResult(requestCode, resultCode, data, getActivity());

        EasyImage.handleActivityResult(requestCode, resultCode, data, getActivity(), new DefaultCallback() {
            @Override
            public void onImagePicked(File imageFile, EasyImage.ImageSource source, int type) {
                String path = imageFile.getPath();
                Bitmap bitmap = BitmapFactory.decodeFile(path);
                selfieImageView.setImageBitmap(bitmap);
            }
        });
    }

    static boolean checkPermissions(Context context) {
        return ActivityCompat.checkSelfPermission(context, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(context, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED;
    }
}
