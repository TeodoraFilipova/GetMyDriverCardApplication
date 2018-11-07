package com.mystique.rt.getmydrivercardapplcation.views.applications.fragments;


import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Spinner;

import com.jaredrummler.materialspinner.MaterialSpinner;
import com.mystique.rt.getmydrivercardapplcation.R;
import com.mystique.rt.getmydrivercardapplcation.apputils.RememberAll;
import com.mystique.rt.getmydrivercardapplcation.apputils.SetDate;
import com.mystique.rt.getmydrivercardapplcation.views.applications.FocusListener;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnFocusChange;

/**
 * A simple {@link Fragment} subclass.
 */
public class PersonalInfoFragment extends Fragment implements FocusListener {

    @BindView(R.id.et_personal_number)
    EditText mPersonalNumberEditText;

    @BindView(R.id.et_first_name)
    EditText mFirstNameEditText;

    @BindView(R.id.et_last_name)
    EditText mLastNameEditText;

    @BindView(R.id.et_date_of_birth)
    EditText mDateOfBirthEditText;

    @BindView(R.id.et_address)
    EditText mAddressEditText;

    @BindView(R.id.et_phone_number)
    EditText mPhoneNumberEditText;

    @BindView(R.id.et_email)
    EditText mEmailEditText;

    @BindView(R.id.dropdown_spinner)
    MaterialSpinner mOfficeChooseSpinner;

    private RememberAll mRememberAll;

    private static final String[] OFFICES = {
            "London - Central office",
            "London - office Bromley",
            "London - office Hillington",
            "Glasgow",
            "Leeds",
            "Cambridge"
    };
    private int mSelectedOfficeIndex;

    public PersonalInfoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_personal_info, container, false);
        ButterKnife.bind(this, view);

        SetDate fromDate = new SetDate(mDateOfBirthEditText, getContext(), this);

        mRememberAll = RememberAll.getInstance();

        checkRememberAllForCurrentData();

        mPersonalNumberEditText.setOnFocusChangeListener((v, hasFocus) -> {
            if (!hasFocus) {
                mRememberAll.setPersonalNumber(mPersonalNumberEditText.getText().toString());
            }
        });

        mFirstNameEditText.setOnFocusChangeListener((v, hasFocus) -> {
            if (!hasFocus) {
                mRememberAll.setFirstName(mFirstNameEditText.getText().toString());
            }
        });

        mLastNameEditText.setOnFocusChangeListener((v, hasFocus) -> {
            if (!hasFocus) {
                mRememberAll.setLastName(mLastNameEditText.getText().toString());
            }
        });

//        mDateOfBirthEditText.setOnFocusChangeListener((v, hasFocus) -> {
//            if(!hasFocus) {
//                DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
//                Date dateOfBirth = null;
//                try {
//                    dateOfBirth = df.parse(mDateOfBirthEditText.getText().toString());
//                } catch (ParseException e) {
//                    e.printStackTrace();
//                }
//                mRememberAll.setDateOfBirth(dateOfBirth);
//            }
//        });

        mAddressEditText.setOnFocusChangeListener((v, hasFocus) -> {
            if (!hasFocus) {
                mRememberAll.setAddress(mAddressEditText.getText().toString());
            }
        });

        mPhoneNumberEditText.setOnFocusChangeListener((v, hasFocus) -> {
            if (!hasFocus) {
                mRememberAll.setPhoneNumber(mPhoneNumberEditText.getText().toString());
            }
        });

        mEmailEditText.setOnFocusChangeListener((v, hasFocus) -> {
            if (!hasFocus) {
                mRememberAll.setEmail(mEmailEditText.getText().toString());
            }
        });

        mOfficeChooseSpinner.setItems(OFFICES);
        mOfficeChooseSpinner.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener<String>() {

            @Override
            public void onItemSelected(MaterialSpinner view, int position, long id, String item) {
                mRememberAll.getCardApplicationForm().setReceivingOffice(item);
                mSelectedOfficeIndex = position;
                Snackbar.make(view, "Selected office " + item, Snackbar.LENGTH_LONG).show();
            }
        });


        /*(
                (MaterialSpinner.OnItemSelectedListener<String>)
                    (materialSpinner, possition, id, item)
                            -> Snackbar.make(view, "Office is selected " + item, Snackbar.LENGTH_LONG).show());*/

        mOfficeChooseSpinner.setOnNothingSelectedListener(new MaterialSpinner.OnNothingSelectedListener() {

            @Override
            public void onNothingSelected(MaterialSpinner spinner) {
                Snackbar.make(spinner, "No office selected", Snackbar.LENGTH_LONG).show();
            }
        });
        /*(
                spinner -> Snackbar.make(spinner, "No office selected", Snackbar.LENGTH_LONG).show()
        );
*/
        return view;
    }

    private void checkRememberAllForCurrentData() {
        if (mRememberAll.getDriver().getPersonalNumber() != null) {
            mPersonalNumberEditText.setText(mRememberAll.getDriver().getPersonalNumber());
        }

        if (mRememberAll.getDriver().getFirstName() != null) {
            mFirstNameEditText.setText(mRememberAll.getDriver().getFirstName());
        }

        if (mRememberAll.getDriver().getLastName() != null) {
            mLastNameEditText.setText(mRememberAll.getDriver().getLastName());
        }

        if (mRememberAll.getDriver().getDateOfBirth() != null) {
            DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
            Date dateOfBirth = mRememberAll.getDriver().getDateOfBirth();
            String dateOfBirthString = df.format(dateOfBirth);
            mDateOfBirthEditText.setText(dateOfBirthString);
        }

        if (mRememberAll.getDriver().getAddress() != null) {
            mAddressEditText.setText(mRememberAll.getDriver().getAddress());
        }

        if (mRememberAll.getDriver().getPhoneNumber() != null) {
            mPhoneNumberEditText.setText(mRememberAll.getDriver().getPhoneNumber());
        }

        if (mRememberAll.getDriver().getEmail() != null) {
            mEmailEditText.setText(mRememberAll.getDriver().getEmail());
        }

        if (mRememberAll.getCardApplicationForm().getReceivingOffice() != null) {
            mOfficeChooseSpinner.setSelectedIndex(mSelectedOfficeIndex);
        }
    }

    @Override
    public void saveDateToObject() {
        DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
        Date dateOfBirth = null;
        try {
            dateOfBirth = df.parse(mDateOfBirthEditText.getText().toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        mRememberAll.setDateOfBirth(dateOfBirth);
    }


}
