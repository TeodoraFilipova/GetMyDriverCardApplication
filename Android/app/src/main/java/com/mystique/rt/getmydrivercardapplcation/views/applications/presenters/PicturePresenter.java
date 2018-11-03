package com.mystique.rt.getmydrivercardapplcation.views.applications.presenters;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v4.app.Fragment;

import com.mystique.rt.getmydrivercardapplcation.models.CardApplicationForm;
import com.mystique.rt.getmydrivercardapplcation.views.applications.fragments.interfaces.BaseView;

public interface PicturePresenter extends PresentersBase {

    void openCamera(Fragment fragment);
    void handleActivityResult(int requestCode, int resultCode, Intent data,
                              Activity activity);
    byte[] convertBitmapToByteArray(Bitmap bitmap);
    void setImageValueToCurrentCardApplicationForm(CardApplicationForm mCardApplicationForm, byte[] byteImage);

}

