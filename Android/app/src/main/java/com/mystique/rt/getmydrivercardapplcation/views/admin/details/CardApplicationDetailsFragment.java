package com.mystique.rt.getmydrivercardapplcation.views.admin.details;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mystique.rt.getmydrivercardapplcation.R;
import com.mystique.rt.getmydrivercardapplcation.models.CardApplicationForm;
import com.mystique.rt.getmydrivercardapplcation.parsers.bitmap.BitmapParser;
import com.mystique.rt.getmydrivercardapplcation.parsers.bitmap.ByteArrayBitmapParser;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class CardApplicationDetailsFragment extends Fragment implements CardApplicationDetailsContracts.View{
    private CardApplicationDetailsContracts.Presenter mPresenter;

    @Inject
    BitmapParser mPictureParser;

    @BindView(R.id.tv_cardappformid)
    TextView mIDTextView;

    @BindView(R.id.tv_dateofsubmission)
    TextView mSubmissionTextView;

    @BindView(R.id.tv_status)
    TextView mStatusTextView;

    @BindView(R.id.tv_type)
    TextView mTypeTextView;

    @BindView(R.id.tv_firstname)
    TextView mFirstNameTextView;

    @BindView(R.id.tv_lastname)
    TextView mLastNameTextView;

    @BindView(R.id.tv_personalnumber)
    TextView mPersonalNumberTextView;

    @BindView(R.id.tv_dateofbirth)
    TextView mDateOfBirthNumberTextView;

    @BindView(R.id.tv_address)
    TextView mAddressTextView;

    @BindView(R.id.tv_phone)
    TextView mPhoneTextView;

    @BindView(R.id.tv_email)
    TextView mEmailTextView;

    @BindView(R.id.iv_selfie)
    ImageView mSelfieImageView;

    @BindView(R.id.iv_drivingpic)
    ImageView mDrivingPicImageView;

    @BindView(R.id.tv_driving_number)
    TextView mDrivingNumberTextView;

    @BindView(R.id.tv_driving_country)
    TextView mDrivingCountryTextView;

    @BindView(R.id.tv_placeofevent)
    TextView mPlaseOfEventTextView;

    @BindView(R.id.tv_dateofevent)
    TextView mDareOfEventTextView;

    @BindView(R.id.iv_oldcardpic)
    ImageView mOldCardPicImageView;

    @BindView(R.id.tv_oldcardcountry)
    TextView mOldCardCountryTextView;

    @BindView(R.id.tv_oldcardauthority)
    TextView mOldCardAuthorityTextView;

    @BindView(R.id.tv_oldcardnumber)
    TextView mOldCardNumberTextView;

    @BindView(R.id.tv_oldcarddateofexpiry)
    TextView mOldCardDateOfExpieryTextView;

    @BindView(R.id.tv_renewalreason)
    TextView mRenewalReasonTextView;

    @BindView(R.id.tv_newaddress)
    TextView mNewAddressTextView;

    @BindView(R.id.tv_newFirsName)
    TextView mNewFirstNameTextView;

    @BindView(R.id.tv_newLastName)
    TextView mNewLastNameTextView;

    @BindView(R.id.iv_newselfie)
    ImageView mNewSelfieImageView;

    @BindView(R.id.tv_details)
    TextView mDetailsTextView;

    @BindView(R.id.tv_checkcode)
    TextView mCheckCodeTextView;

    @BindView(R.id.tv_paymentinfo)
    TextView mPaymentInfoTextView;

    @BindView(R.id.iv_signature)
    ImageView mSignatureImageView;

    @Inject
    public CardApplicationDetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_card_application_details, container, false);

        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.subscribe(this);
        mPresenter.loadCardApplicationForm();
    }

    @Override
    public void showCardApplicationFormDetails(CardApplicationForm form) {
        mIDTextView.setText(form.getCardApplicationFormId());
        mSubmissionTextView.setText((CharSequence) form.getDateOfSubmission());
        mStatusTextView.setText(form.getStatus());
        mTypeTextView.setText(form.getType());
        mFirstNameTextView.setText(form.getDriver().getFirstName());
        mLastNameTextView.setText(form.getDriver().getLastName());
        mPersonalNumberTextView.setText(form.getDriver().getPersonalNumber());
        mDateOfBirthNumberTextView.setText((CharSequence) form.getDriver().getDateOfBirth());
        mAddressTextView.setText(form.getDriver().getAddress());
        mPhoneTextView.setText(form.getDriver().getPhoneNumber());
        mEmailTextView.setText(form.getDriver().getEmail());

        //???
        mSelfieImageView.setImageBitmap(mPictureParser.toBitmap(form.getDriver().getSelfie().getPicture()));
        mDrivingPicImageView.setImageBitmap(mPictureParser.toBitmap(form.getDriver().getDrivingPic().getPicture()));

        mDrivingNumberTextView.setText(form.getDrivingLicenseNumber());
        mDrivingCountryTextView.setText(form.getDrivingLicenseCountry());
        mPlaseOfEventTextView.setText(form.getPlaceOfEvent());
        mDareOfEventTextView.setText((CharSequence) form.getDateOfEvent());
        mOldCardPicImageView.setImageBitmap(mPictureParser.toBitmap(form.getOldCardPicture().getPicture()));
        mOldCardCountryTextView.setText(form.getOldCardCountry());
        mOldCardAuthorityTextView.setText(form.getOldCardAuthority());
        mOldCardNumberTextView.setText(form.getOldCardNumber());
        mOldCardDateOfExpieryTextView.setText((CharSequence) form.getOldCardDateOfExpiry());
        mRenewalReasonTextView.setText(form.getRenewalReason());
        mNewAddressTextView.setText(form.getNewAddress());
        mNewFirstNameTextView.setText(form.getNewFirstName());
        mNewLastNameTextView.setText(form.getNewLastName());
        mNewSelfieImageView.setImageBitmap(mPictureParser.toBitmap(form.getNewSelfie().getPicture()));
        mDetailsTextView.setText(form.getDetails());
        mCheckCodeTextView.setText(form.getStatusCheckCode());
        mPaymentInfoTextView.setText(form.getPaymentInformation());
        mSignatureImageView.setImageBitmap(mPictureParser.toBitmap(form.getSignaturePicture().getPicture()));

    }

    @Override
    public void setPresenter(CardApplicationDetailsContracts.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void showError(Throwable e) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }
}
