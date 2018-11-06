package com.mystique.rt.getmydrivercardapplcation.views.applications.fragments;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mystique.rt.getmydrivercardapplcation.R;
import com.mystique.rt.getmydrivercardapplcation.apputils.Constants;
import com.mystique.rt.getmydrivercardapplcation.apputils.RememberAll;
import com.mystique.rt.getmydrivercardapplcation.apputils.email.SendMail;
import com.mystique.rt.getmydrivercardapplcation.views.applications.CompletedApplicationContracts;

import javax.inject.Inject;

import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class CompletedApplicationFragment extends Fragment implements CompletedApplicationContracts.View {
    private RememberAll mRememberAll;
    private CompletedApplicationContracts.Presenter mPresenter;

    private int mNextPictureId;
    private int mNextDriverId;
    private int mNextCardApplicationFormId;

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

    }

    @Override
    public void showMessageApplicationCompleted() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showError(Throwable error) {

    }

    @Override
    public void showLoading() {

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

    }

    @Override
    public void showSecondMessage() {

    }

    @Override
    public void showThirdMessage() {

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
