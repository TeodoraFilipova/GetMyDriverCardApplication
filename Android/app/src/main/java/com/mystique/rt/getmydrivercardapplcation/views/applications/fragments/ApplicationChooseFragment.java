package com.mystique.rt.getmydrivercardapplcation.views.applications.fragments;


import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.mystique.rt.getmydrivercardapplcation.R;
import com.mystique.rt.getmydrivercardapplcation.apputils.Constants;
import com.mystique.rt.getmydrivercardapplcation.apputils.Navigator;
import com.mystique.rt.getmydrivercardapplcation.apputils.RememberAll;
import com.mystique.rt.getmydrivercardapplcation.views.applications.activities.AddressReplacementActivity;
import com.mystique.rt.getmydrivercardapplcation.views.applications.activities.ApplicationChooseActivity;
import com.mystique.rt.getmydrivercardapplcation.views.applications.activities.EUtoBGActivity;
import com.mystique.rt.getmydrivercardapplcation.views.applications.activities.FirstApplicationActivity;
import com.mystique.rt.getmydrivercardapplcation.views.applications.activities.LossOrTheftActivity;
import com.mystique.rt.getmydrivercardapplcation.views.applications.activities.NameReplacementActivity;
import com.mystique.rt.getmydrivercardapplcation.views.applications.activities.PictureReplacementActivity;
import com.mystique.rt.getmydrivercardapplcation.views.applications.activities.RenewalActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class ApplicationChooseFragment extends Fragment {
    private Class mKlass;
    private String mType;
    private String mRenewalReason;

    private Navigator mNavigator;
    private RememberAll mRememberAll;

    @BindView(R.id.radio_group)
    RadioGroup mRadioGroup;

    @BindView(R.id.button_submit_application_choice)
    Button mSubmitButton;


    public ApplicationChooseFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_application_choose, container, false);
        ButterKnife.bind(this, view);
        mRememberAll = RememberAll.getInstance();

        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // checkedId is the RadioButton selected
                switch (checkedId) {
                    case R.id.radio_first:
                        mKlass = FirstApplicationActivity.class;
                        mType = Constants.APP_TYPE_FIRST;
                        mRenewalReason = Constants.RENEWAL_REASON_FIRST;
                        Toast.makeText(getContext(), "First application selected", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.radio_EU_for_BG:
                        mKlass = EUtoBGActivity.class;
                        mType = Constants.APP_TYPE_EUTOBG;
                        mRenewalReason = Constants.RENEWAL_REASON_EUTOBG;
                        Toast.makeText(getContext(), "EU for BG card application selected", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.radio_loss:
                        mKlass = LossOrTheftActivity.class;
                        mType = Constants.APP_TYPE_REPLACEMENT_CARD;
                        mRenewalReason = Constants.RENEWAL_REASON_LOST;
                        Toast.makeText(getContext(), "Loss application selected", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.radio_theft:
                        mKlass = LossOrTheftActivity.class;
                        mType = Constants.APP_TYPE_REPLACEMENT_CARD;
                        mRenewalReason = Constants.RENEWAL_REASON_STOLEN;
                        Toast.makeText(getContext(), "Theft application selected", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.radio_damaged:
                        mKlass = RenewalActivity.class;
                        mType = Constants.APP_TYPE_REPLACEMENT_CARD;
                        mRenewalReason = Constants.RENEWAL_REASON_DAMAGED;
                        Toast.makeText(getContext(), "Damaged application selected", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.radio_malfunction:
                        mKlass = RenewalActivity.class;
                        mType = Constants.APP_TYPE_REPLACEMENT_CARD;
                        mRenewalReason = Constants.RENEWAL_REASON_MALFUNCTIONING;
                        Toast.makeText(getContext(), "Malfunction application selected", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.radio_name:
                        mKlass = NameReplacementActivity.class;
                        mType = Constants.APP_TYPE_REPLACEMENT_PERSON;
                        mRenewalReason = Constants.RENEWAL_REASON_NAME;
                        Toast.makeText(getContext(), "Name change application selected", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.radio_address:
                        mKlass = AddressReplacementActivity.class;
                        mType = Constants.APP_TYPE_REPLACEMENT_PERSON;
                        mRenewalReason = Constants.RENEWAL_REASON_ADDRESS;
                        Toast.makeText(getContext(), "Address change application selected", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.radio_selfie:
                        mKlass = PictureReplacementActivity.class;
                        mType = Constants.APP_TYPE_REPLACEMENT_PERSON;
                        mRenewalReason = Constants.RENEWAL_REASON_SELFIE;
                        Toast.makeText(getContext(), "Photo change application selected", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.radio_expired:
                        mKlass = RenewalActivity.class;
                        mType = Constants.APP_TYPE_RENEWAL;
                        mRenewalReason = Constants.RENEWAL_REASON_EXPIRED;
                        Toast.makeText(getContext(), "Expired application selected", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.radio_suspended:
                        mKlass = RenewalActivity.class;
                        mType = Constants.APP_TYPE_RENEWAL;
                        mRenewalReason = Constants.RENEWAL_REASON_SUSPENDED;
                        Toast.makeText(getContext(), "Suspended application selected", Toast.LENGTH_LONG).show();
                        break;
                    default:
                        mKlass = null;
                        break;
                }
            }
        });

        mSubmitButton.setOnClickListener(v -> {
            // go to the appropriate application form slider/activity
            if (mKlass != null) {
                mRememberAll.startNewApplicationForm(mType, mRenewalReason);
                mNavigator.navigateToActivity(mKlass);
            } else {
                Toast.makeText(getContext(), "Please select application type before continuing!!!", Toast.LENGTH_LONG).show();
            }
        });

        return view;
    }

    public static ApplicationChooseFragment getInstance() {
        return new ApplicationChooseFragment();
    }

    public void setNavigator(Navigator navigator) {
        mNavigator = navigator;
    }
}
