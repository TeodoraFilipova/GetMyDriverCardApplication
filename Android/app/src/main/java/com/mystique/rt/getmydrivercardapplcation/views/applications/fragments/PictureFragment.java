package com.mystique.rt.getmydrivercardapplcation.views.applications.fragments;


import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
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
import com.mystique.rt.getmydrivercardapplcation.models.CardApplicationForm;
import com.mystique.rt.getmydrivercardapplcation.views.applications.fragments.interfaces.BaseView;
import com.mystique.rt.getmydrivercardapplcation.views.applications.fragments.interfaces.PictureMakeView;
import com.mystique.rt.getmydrivercardapplcation.views.applications.presenters.PictureFragmentPresenter;
import com.mystique.rt.getmydrivercardapplcation.views.applications.presenters.PresentersBase;

import java.io.File;
import java.security.InvalidParameterException;
import java.util.Objects;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pl.aprilapps.easyphotopicker.EasyImage;

/**
 * A simple {@link Fragment} subclass.
 */
public class PictureFragment extends Fragment implements PictureMakeView {


    @BindView(R.id.btn_selfiecamera)
    Button selfieButton;

    @BindView(R.id.btn_selfiesave)
    Button selfieSaveButton;

    @BindView(R.id.iv_selfie)
    ImageView selfieImageView;

    CardApplicationForm mCurrentCardApplicationForm;

   /* @BindView(R.id.btn_drivingliccamera)
    Button drivingLicButton;

    @BindView(R.id.iv_drivinglicence)
    ImageView drivingLicImageView;

    @BindView(R.id.btn_drivinglsafe)
    ImageView drivingLicSaveImageView;*/

    @Inject
    PictureFragmentPresenter mPresenter;

    public PictureFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_picture, container, false);

        ButterKnife.bind(this, view);

        return view;

    }

    @OnClick(R.id.btn_selfiecamera)
    public void makeSelfie() {
        mPresenter.openCamera(this);
    }


    @OnClick(R.id.btn_drivingliccamera)
    public void makeDrivingLicensePic () {
        mPresenter.openCamera(this);
    }

    @OnClick(R.id.btn_selfiesave)
    public void saveSelfie(){
        Bitmap bitmap = ((BitmapDrawable)selfieImageView
                .getDrawable())
                .getBitmap();

        byte[] byteImage = mPresenter.convertBitmapToByteArray(bitmap);

        // a method to save picture to current application
        mPresenter.setImageValueToCurrentCardApplicationForm(mCurrentCardApplicationForm,/* mImageAttribute,*/ byteImage);
        //navigate(SignaturePadActivity.class);
    };

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        mPresenter.handleActivityResult(requestCode, resultCode, data, getActivity());

    }

    @Override
    public void setPresenter(PresentersBase presenter) {
        if (presenter instanceof PictureFragmentPresenter) {
            this.mPresenter = (PictureFragmentPresenter) presenter;
        } else {
            throw new InvalidParameterException();
        }
    }

    @Override
    public void setBitmapPicture(Bitmap bitmap) {
        selfieImageView.setImageBitmap(bitmap);
    }
}
