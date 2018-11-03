package com.mystique.rt.getmydrivercardapplcation.views.applications.presenters;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.app.Fragment;

import com.mystique.rt.getmydrivercardapplcation.models.CardApplicationForm;
import com.mystique.rt.getmydrivercardapplcation.models.Picture;
import com.mystique.rt.getmydrivercardapplcation.parsers.bitmap.BitmapParser;
import com.mystique.rt.getmydrivercardapplcation.views.applications.fragments.PictureFragment;
import com.mystique.rt.getmydrivercardapplcation.views.applications.fragments.interfaces.BaseView;
import com.mystique.rt.getmydrivercardapplcation.views.applications.fragments.interfaces.PictureMakeView;

import java.io.File;
import java.security.InvalidParameterException;

import javax.inject.Inject;

import pl.aprilapps.easyphotopicker.DefaultCallback;
import pl.aprilapps.easyphotopicker.EasyImage;

public class PictureFragmentPresenter implements PicturePresenter {

    @Inject
    BitmapParser mPictureParser;

    @Inject
    PictureFragment mPictureView;



    @Override
    public void openCamera(Fragment fragment) {
        EasyImage.openCamera(fragment, EasyImage.REQ_SOURCE_CHOOSER);
    }

    @Override
    public void handleActivityResult(int requestCode, int resultCode, Intent data, Activity activity) {
        EasyImage.handleActivityResult(requestCode, resultCode, data, activity, new DefaultCallback() {
            @Override
            public void onImagePicked(File imageFile, EasyImage.ImageSource source, int type) {
                String path = imageFile.getPath();
                Bitmap bitmap = BitmapFactory.decodeFile(path);
                mPictureView.setBitmapPicture(bitmap);
            }
        });
    }

    @Override
    public byte[] convertBitmapToByteArray(Bitmap bitmap) {
        return mPictureParser.fromBitmap(bitmap);
    }

    @Override
    public void setImageValueToCurrentCardApplicationForm(CardApplicationForm mCardApplicationForm, byte[] byteImage) {
        Picture selfiePic = new Picture();
        selfiePic.setPicture(byteImage);
        mCardApplicationForm.getDriver().setSelfie(selfiePic); }

    @Override
    public void subscribePresenter(BaseView view) {
        if (view instanceof PictureMakeView) {
            this.mPictureView = (PictureFragment) view;
        } else {
            throw new InvalidParameterException();
        }
    }
}
