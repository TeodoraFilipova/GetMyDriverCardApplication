package com.mystique.rt.getmydrivercardapplcation.views.applications.submittodatabase.step1submitselfie;


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
public class SaveSelfieFragment extends Fragment implements SaveSelfieContracts.View {
    private RememberAll mRememberAll;
    SaveSelfieContracts.Presenter mPresenter;
    private SaveSelfieContracts.Navigator mNavigator;

    private int mNextPictureId;

    @BindView(R.id.text_completed)
    TextView mMessageTextView;

    @BindView(R.id.pb_loading)
    ProgressBar mLoading;

    @Inject
    public SaveSelfieFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_save_selfie, container, false);

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
    public void setPresenter(SaveSelfieContracts.Presenter presenter) {
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
        mRememberAll.getCardApplicationForm().getDriver().getSelfie().setPictureId(mNextPictureId);
        mRememberAll.getCardApplicationForm().getDriver().getSelfie().setLastUpdated(Constants.LAST_UPDATED_TRUE);
        mPresenter.savePicture(mRememberAll.getCardApplicationForm().getDriver().getSelfie());
    }

    @Override
    public void moveOnToNextSaveActivity() {
        mLoading.setVisibility(View.GONE);
        mNavigator.navigateToNextActivity();
    }

    public void setNavigator(SaveSelfieContracts.Navigator navigator) {
        this.mNavigator = navigator;
    }
}
