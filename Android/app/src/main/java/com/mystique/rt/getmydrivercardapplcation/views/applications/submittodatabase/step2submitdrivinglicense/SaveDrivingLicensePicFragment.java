package com.mystique.rt.getmydrivercardapplcation.views.applications.submittodatabase.step2submitdrivinglicense;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.mystique.rt.getmydrivercardapplcation.R;
import com.mystique.rt.getmydrivercardapplcation.apputils.Constants;
import com.mystique.rt.getmydrivercardapplcation.apputils.RememberAll;
import com.mystique.rt.getmydrivercardapplcation.models.Picture;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class SaveDrivingLicensePicFragment extends Fragment implements SaveDrivingLicensePicContracts.View {

    private RememberAll mRememberAll;
    SaveDrivingLicensePicContracts.Presenter mPresenter;
    private SaveDrivingLicensePicContracts.Navigator mNavigator;

    private int mNextPictureId;

    @BindView(R.id.text_completed)
    TextView mMessageTextView;

    @BindView(R.id.pb_loading)
    ProgressBar mLoading;

    @Inject
    public SaveDrivingLicensePicFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_save_driving_license_pic, container, false);

        ButterKnife.bind(this, view);
        mRememberAll = RememberAll.getInstance();
        mPresenter.subscribe(this);

        showLoading();
        mPresenter.getLastUpdatedPicture();

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.subscribe(this);
    }

    @Override
    public void setPresenter(SaveDrivingLicensePicContracts.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void showError(Throwable error) {
        mMessageTextView.setText(error.getMessage());
    }

    @Override
    public void showLoading() {
        mLoading.setVisibility(View.VISIBLE);
    }

    @Override
    public void setNextPictureId(Picture lastUpdatedPicture) {
        mNextPictureId = lastUpdatedPicture.getPictureId() + 1;
        mPresenter.updateLastPicture(lastUpdatedPicture);
    }

    @Override
    public void updateRememberAll() {
        mRememberAll.getCardApplicationForm().getDriver().getDrivingPic().setPictureId(mNextPictureId);
        mRememberAll.getCardApplicationForm().getDriver().getDrivingPic().setLastUpdated(Constants.LAST_UPDATED_TRUE);
        mPresenter.savePicture(mRememberAll.getCardApplicationForm().getDriver().getDrivingPic());
    }

    @Override
    public void moveOnToNextSaveActivity() {
        mLoading.setVisibility(View.GONE);
        mNavigator.navigateToNextActivity();
    }

    public void setNavigator(SaveDrivingLicensePicContracts.Navigator navigator) {
        this.mNavigator = navigator;
    }
}
