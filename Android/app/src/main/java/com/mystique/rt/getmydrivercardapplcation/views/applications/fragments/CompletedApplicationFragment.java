package com.mystique.rt.getmydrivercardapplcation.views.applications.fragments;


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
import com.mystique.rt.getmydrivercardapplcation.apputils.email.SendMail;
import com.mystique.rt.getmydrivercardapplcation.views.applications.CompletedApplicationContracts;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class CompletedApplicationFragment extends Fragment implements CompletedApplicationContracts.View {
    private RememberAll mRememberAll;
    CompletedApplicationContracts.Presenter mPresenter;

    private int mNextPictureId;
    private int mNextDriverId;
    private int mNextCardApplicationFormId;

    @BindView(R.id.text_completed)
    TextView mMessageTextView;

    @BindView(R.id.pb_loading)
    ProgressBar mLoading;

    @Inject
    public CompletedApplicationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_completed_application, container, false);
        ButterKnife.bind(this, view);
        mRememberAll = RememberAll.getInstance();
        showLoading();

        // SELFIE
        mPresenter.getLastUpdatedPicture();

        mRememberAll.getCardApplicationForm().getDriver().getSelfie().setPictureId(mNextPictureId);
        mRememberAll.getCardApplicationForm().getDriver().getSelfie().setLastUpdated(Constants.LAST_UPDATED_TRUE);

        mPresenter.savePicture(mRememberAll.getCardApplicationForm().getDriver().getSelfie());

        // DRIVING LICENSE PIC
        mPresenter.getLastUpdatedPicture();

        mRememberAll.getCardApplicationForm().getDriver().getDrivingPic().setPictureId(mNextPictureId);
        mRememberAll.getCardApplicationForm().getDriver().getDrivingPic().setLastUpdated(Constants.LAST_UPDATED_TRUE);

        mPresenter.savePicture(mRememberAll.getCardApplicationForm().getDriver().getDrivingPic());

        // SIGNATURE PIC
        mPresenter.getLastUpdatedPicture();

        mRememberAll.getCardApplicationForm().getSignaturePicture().setPictureId(mNextPictureId);
        mRememberAll.getCardApplicationForm().getSignaturePicture().setLastUpdated(Constants.LAST_UPDATED_TRUE);

        mPresenter.savePicture(mRememberAll.getCardApplicationForm().getSignaturePicture());

        // NEW SELFIE PIC
        if (mRememberAll.getNewSelfiePic().getPicture() != null) {
            mPresenter.getLastUpdatedPicture();

            mRememberAll.getCardApplicationForm().getNewSelfie().setPictureId(mNextPictureId);
            mRememberAll.getCardApplicationForm().getNewSelfie().setLastUpdated(Constants.LAST_UPDATED_TRUE);

            mPresenter.savePicture(mRememberAll.getCardApplicationForm().getNewSelfie());
        }

        // OLD CARD PIC
        if (mRememberAll.getOldCardPic().getPicture() != null) {
            mPresenter.getLastUpdatedPicture();

            mRememberAll.getCardApplicationForm().getOldCardPicture().setPictureId(mNextPictureId);
            mRememberAll.getCardApplicationForm().getOldCardPicture().setLastUpdated(Constants.LAST_UPDATED_TRUE);

            mPresenter.savePicture(mRememberAll.getCardApplicationForm().getOldCardPicture());
        }

        // DRIVER
        if (mRememberAll.getCardApplicationForm().getType().equals(Constants.APP_TYPE_FIRST)) {
            mPresenter.getLastUpdatedDriver();

            mRememberAll.getCardApplicationForm().getDriver().setDriverId(mNextDriverId);
            mRememberAll.getCardApplicationForm().getDriver().setLastUpdated(Constants.LAST_UPDATED_TRUE);

            mPresenter.saveDriver(mRememberAll.getCardApplicationForm().getDriver());
        } else {
            mPresenter.findDriver(mRememberAll.getCardApplicationForm().getDriver().getPersonalNumber());
        }

        // CARD APPLICATION FORM
        mPresenter.getLastUpdatedCardApplicationForm();

        mRememberAll.getCardApplicationForm().setCardApplicationFormId(mNextCardApplicationFormId);
        mRememberAll.getCardApplicationForm().setLastUpdated(Constants.LAST_UPDATED_TRUE);

        mPresenter.saveCardApplicationForm(mRememberAll.getCardApplicationForm());

        // SEND EMAIL WITH STATUS CHECK CODE
        sendMail();

        // CLEAR REMEMBERALL FOR FUTURE APPLICATIONS
        mRememberAll.resetRememberAll();

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.subscribe(this, mRememberAll);
    }

    public static CompletedApplicationFragment getInstance() {
        return new CompletedApplicationFragment();
    }

    @Override
    public void setPresenter(CompletedApplicationContracts.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void showMessageApplicationCompleted() {
        hideLoading();
        mMessageTextView.setText("Your application has been submitted! Please check your email!");
    }

    @Override
    public void hideLoading() {
        mLoading.setVisibility(View.GONE);
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
    public void setNextPictureId(int nextPictureId) {
        mNextPictureId = nextPictureId;
    }

    @Override
    public void setNextDriverId(int nextDriverId) {
        mNextDriverId = nextDriverId;
    }

    @Override
    public void setNextCardApplicationFormId(int nextCardApplicationFormId) {
        mNextCardApplicationFormId = nextCardApplicationFormId;
    }

    @Override
    public void showFirstMessage() {
        mMessageTextView.setText("Your personal details have been processed. Please do NOT close this window!");
    }

    @Override
    public void showSecondMessage() {
        mMessageTextView.setText("Your photographs have been processed. Please wait while we complete this application!");
    }

    @Override
    public void sendMail() {
        //Getting content for email
        String email = mRememberAll.getCardApplicationForm().getDriver().getEmail();
        String subject = Constants.EMAIL_SUBJECT;
        String message = Constants.EMAIL_MESSAGE + mRememberAll.getCardApplicationForm().getStatusCheckCode();

        //Creating SendMail object
        SendMail sm = new SendMail(getContext(), email, subject, message);

        //Executing sendmail to send email
        sm.execute();
//    }
    }
}
