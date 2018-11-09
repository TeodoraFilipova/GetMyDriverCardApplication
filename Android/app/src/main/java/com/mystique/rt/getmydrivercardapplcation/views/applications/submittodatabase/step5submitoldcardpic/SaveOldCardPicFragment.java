package com.mystique.rt.getmydrivercardapplcation.views.applications.submittodatabase.step5submitoldcardpic;


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
public class SaveOldCardPicFragment extends Fragment implements SaveOldCardPicContracts.View {
    private RememberAll mRememberAll;
    SaveOldCardPicContracts.Presenter mPresenter;
    private SaveOldCardPicContracts.Navigator mNavigator;

    private int mNextPictureId;

    @BindView(R.id.text_completed)
    TextView mMessageTextView;

    @BindView(R.id.pb_loading)
    ProgressBar mLoading;

    @Inject
    public SaveOldCardPicFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_save_old_card_pic, container, false);

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
    public void setPresenter(SaveOldCardPicContracts.Presenter presenter) {
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
        mRememberAll.getCardApplicationForm().getOldCardPicture().setPictureId(mNextPictureId);
        mRememberAll.getCardApplicationForm().getOldCardPicture().setLastSetID(Constants.LAST_UPDATED_TRUE);
        mPresenter.savePicture(mRememberAll.getCardApplicationForm().getOldCardPicture());
    }

    @Override
    public void moveOnToNextSaveActivity() {
        mLoading.setVisibility(View.GONE);
        mNavigator.navigateToNextActivity();
    }

    public void setNavigator(SaveOldCardPicContracts.Navigator navigator) {
        this.mNavigator = navigator;
    }

}
