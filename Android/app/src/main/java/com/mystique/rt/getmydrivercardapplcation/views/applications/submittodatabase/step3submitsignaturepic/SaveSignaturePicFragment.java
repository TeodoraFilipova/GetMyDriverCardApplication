package com.mystique.rt.getmydrivercardapplcation.views.applications.submittodatabase.step3submitsignaturepic;


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
import com.mystique.rt.getmydrivercardapplcation.views.applications.submittodatabase.step4submitnewselfie.SaveNewSelfieActivity;
import com.mystique.rt.getmydrivercardapplcation.views.applications.submittodatabase.step5submitoldcardpic.SaveOldCardPicActivity;
import com.mystique.rt.getmydrivercardapplcation.views.applications.submittodatabase.step6submitdriver.SaveDriverActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class SaveSignaturePicFragment extends Fragment implements SaveSignaturePicContracts.View {
    private RememberAll mRememberAll;
    SaveSignaturePicContracts.Presenter mPresenter;
    private SaveSignaturePicContracts.Navigator mNavigator;

    private int mNextPictureId;

    @BindView(R.id.text_completed)
    TextView mMessageTextView;

    @BindView(R.id.pb_loading)
    ProgressBar mLoading;

    @Inject
    public SaveSignaturePicFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_save_signature_pic, container, false);

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
    public void setPresenter(SaveSignaturePicContracts.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void showError(Throwable error) {
        mMessageTextView.setText("In Signature: " + error.getMessage());
        mLoading.setVisibility(View.GONE);    }

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
        mRememberAll.getCardApplicationForm().getSignaturePicture().setPictureId(mNextPictureId);
        mRememberAll.getCardApplicationForm().getSignaturePicture().setLastSetID(Constants.LAST_UPDATED_TRUE);
        mPresenter.savePicture(mRememberAll.getCardApplicationForm().getSignaturePicture());
    }

    @Override
    public void moveOnToNextSaveActivity() {
        mLoading.setVisibility(View.GONE);

        if (mRememberAll.getNewSelfiePic().getPicture() != null) {
            Class nextActivity = SaveNewSelfieActivity.class;
            mNavigator.navigateToNextActivity(nextActivity);
        } else if (mRememberAll.getOldCardPic().getPicture() != null) {
            Class nextActivity = SaveOldCardPicActivity.class;
            mNavigator.navigateToNextActivity(nextActivity);
        } else {
            Class nextActivity = SaveDriverActivity.class;
            mNavigator.navigateToNextActivity(nextActivity);
        }
    }

    public void setNavigator(SaveSignaturePicContracts.Navigator navigator) {
        this.mNavigator = navigator;
    }

}
