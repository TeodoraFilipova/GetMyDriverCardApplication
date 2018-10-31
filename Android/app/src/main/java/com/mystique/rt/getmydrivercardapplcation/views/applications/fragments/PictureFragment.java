package com.mystique.rt.getmydrivercardapplcation.views.applications.fragments;


import android.content.Intent;
import android.media.VolumeShaper;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.hardware.Camera;
import android.widget.Button;
import android.widget.ImageView;

import com.mystique.rt.getmydrivercardapplcation.R;

import java.io.File;

import pl.aprilapps.easyphotopicker.EasyImage;

/**
 * A simple {@link Fragment} subclass.
 */
public class PictureFragment extends Fragment {

    Button selfieButton;
    ImageView selfieImageView;

    Button drivingLicButton;
    ImageView drivingLicImageView;

    public PictureFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        selfieButton.findViewById(R.id.btn_selfiecamera);
        selfieImageView.findViewById(R.id.iv_selfie);
        drivingLicButton.findViewById(R.id.btn_drivingliccamera);
        drivingLicImageView.findViewById(R.id.iv_drivinglicence);

        EasyImage.openCamera(PictureFragment.this, EasyImage.REQ_SOURCE_CHOOSER);

        return inflater.inflate(R.layout.fragment_picture, container, false);

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

       /* EasyImage.handleActivityResult(requestCode, resultCode, data, this, new EasyImage.Callbacks() {
            @Override
            public void onImagePickerError(Exception e, EasyImage.ImageSource source, int type) {

            }

            @Override
            public void onImagePicked(File imageFile, EasyImage.ImageSource source, int type) {

            }

            @Override
            public void onCanceled(EasyImage.ImageSource source, int type) {

            }
        });*/
    }
}
