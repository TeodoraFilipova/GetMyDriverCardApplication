package com.mystique.rt.getmydrivercardapplcation.views.admin.details;


import android.app.Fragment;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.jaredrummler.materialspinner.MaterialSpinner;
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

    private static final String[] STATUS_FIELDS = { "approved", "rejected", "completed" };

    private String statusChangeItem = "";

    private CardApplicationDetailsContracts.Presenter mPresenter;

    @Inject
    BitmapParser mPictureParser;

    @BindView(R.id.status_spinner)
    MaterialSpinner mStatusSpinner;

    @BindView(R.id.btn_change_status)
    Button mChangeStatusButton;


    @BindView(R.id.tv_cardappformid_details)
    TextView mIDTextView;

    @BindView(R.id.tv_dateofsubmission_details)
    TextView mSubmissionTextView;

    @BindView(R.id.tv_status_details)
    TextView mStatusTextView;

    @BindView(R.id.tv_type_details)
    TextView mTypeTextView;

    @BindView(R.id.tv_firstname_details)
    TextView mFirstNameTextView;

    @BindView(R.id.tv_lastname_details)
    TextView mLastNameTextView;

    @BindView(R.id.tv_personal_number_details)
    TextView mPersonalNumberTextView;

    @BindView(R.id.tv_date_of_birth_details)
    TextView mDateOfBirthNumberTextView;

    @BindView(R.id.tv_address_details)
    TextView mAddressTextView;

    @BindView(R.id.tv_phone_number_details)
    TextView mPhoneTextView;

    @BindView(R.id.tv_email_details)
    TextView mEmailTextView;

    @BindView(R.id.iv_driverselfie_details)
    ImageView mSelfieImageView;

    @BindView(R.id.iv_drivinglicense_details)
    ImageView mDrivingPicImageView;

    @BindView(R.id.tv_license_number_details)
    TextView mDrivingNumberTextView;

    @BindView(R.id.tv_license_coutry_details)
    TextView mDrivingCountryTextView;

    @BindView(R.id.tv_placeofevent_details)
    TextView mPlaseOfEventTextView;

    @BindView(R.id.tv_dateofevent_details)
    TextView mDareOfEventTextView;

    @BindView(R.id.iv_oldcard_picture_details)
    ImageView mOldCardPicImageView;

    @BindView(R.id.tv_oldcard_country_details)
    TextView mOldCardCountryTextView;

    @BindView(R.id.tv_oldcard_authority_details)
    TextView mOldCardAuthorityTextView;

    @BindView(R.id.tv_oldcard_number_details)
    TextView mOldCardNumberTextView;

    @BindView(R.id.tv_oldcard_date_of_expiry_details)
    TextView mOldCardDateOfExpieryTextView;

    @BindView(R.id.tv_renewal_reason_details)
    TextView mRenewalReasonTextView;

    @BindView(R.id.tv_new_address_details)
    TextView mNewAddressTextView;

    @BindView(R.id.tv_new_firstname_details)
    TextView mNewFirstNameTextView;

    @BindView(R.id.tv_new_lastname_details)
    TextView mNewLastNameTextView;

    @BindView(R.id.iv_newselfie_picture_details)
    ImageView mNewSelfieImageView;

    @BindView(R.id.tv_details_details)
    TextView mDetailsTextView;

    @BindView(R.id.tv_status_checkcode_details)
    TextView mCheckCodeTextView;

    @BindView(R.id.tv_office_details)
    TextView mReceivingOfficeTextView;

    @BindView(R.id.iv_signature_details)
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

        mStatusSpinner.setItems(STATUS_FIELDS);
        mStatusSpinner.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener<String>() {
            @Override
            public void onItemSelected(MaterialSpinner view, int position, long id, String item) {
                Snackbar.make(view, "Status changed to " + item, Snackbar.LENGTH_SHORT).show();
                statusChangeItem = item;
            }
        });

        mChangeStatusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.updateCardApplicationForm(statusChangeItem);
                mPresenter.sendMail(statusChangeItem);
            }
        });



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
        mReceivingOfficeTextView.setText(form.getReceivingOffice());
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
