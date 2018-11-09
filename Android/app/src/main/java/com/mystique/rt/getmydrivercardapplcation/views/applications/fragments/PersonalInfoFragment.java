package com.mystique.rt.getmydrivercardapplcation.views.applications.fragments;


import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.jaredrummler.materialspinner.MaterialSpinner;
import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.annotation.Digits;
import com.mobsandgeeks.saripaar.annotation.Email;
import com.mobsandgeeks.saripaar.annotation.Length;
import com.mobsandgeeks.saripaar.annotation.Max;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;
import com.mobsandgeeks.saripaar.annotation.Past;
import com.mobsandgeeks.saripaar.annotation.Pattern;
import com.mystique.rt.getmydrivercardapplcation.R;
import com.mystique.rt.getmydrivercardapplcation.apputils.RememberAll;
import com.mystique.rt.getmydrivercardapplcation.apputils.SetDate;
import com.mystique.rt.getmydrivercardapplcation.views.applications.FocusListener;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnFocusChange;

/**
 * A simple {@link Fragment} subclass.
 */
public class PersonalInfoFragment extends Fragment implements FocusListener, Validator.ValidationListener {

    @BindView(R.id.et_personal_number)
    @NotEmpty
    @Digits(integer = 45, message = "Should contain only numbers and be no longer than 45 characters!")
    EditText mPersonalNumberEditText;

    @BindView(R.id.et_first_name)
    @NotEmpty
    @Pattern(regex = "^[\\p{L} .'-]+$", message = "Must not contain special characters!")
    EditText mFirstNameEditText;

    @BindView(R.id.et_last_name)
    @NotEmpty
    @Pattern(regex = "^[\\p{L} .'-]+$", message = "Must not contain special characters!")
    EditText mLastNameEditText;

    @BindView(R.id.et_date_of_birth)
    @NotEmpty
    @Past(dateFormat = "yyyy-MM-dd")
    EditText mDateOfBirthEditText;

    @BindView(R.id.et_address)
    @NotEmpty
    @Length(max = 500, message = "Must be less than 500 characters")
    EditText mAddressEditText;

    @BindView(R.id.et_phone_number)
    @NotEmpty
    @Pattern(regex = "^\\+(?:[0-9] ?){6,14}[0-9]$", message = "Must start with a + sign followed by digits!")
    EditText mPhoneNumberEditText;

    @BindView(R.id.et_email)
    @NotEmpty
    @Email
    EditText mEmailEditText;

    @BindView(R.id.dropdown_spinner)
    MaterialSpinner mOfficeChooseSpinner;

    private RememberAll mRememberAll;
    private Validator mValidator;

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
        mRememberAll.getCardApplicationForm().setReceivingOffice(OFFICES[0]);

        mValidator = new Validator(this);
        mValidator.setValidationListener(this);

        checkRememberAllForCurrentData();

        mPersonalNumberEditText.setOnFocusChangeListener((v, hasFocus) -> {
            if (!hasFocus) {
                mRememberAll.setPersonalNumber(mPersonalNumberEditText.getText().toString());
                mValidator.validate();
            }
        });

        mFirstNameEditText.setOnFocusChangeListener((v, hasFocus) -> {
            if (!hasFocus) {
                mRememberAll.setFirstName(mFirstNameEditText.getText().toString());
                mValidator.validate();
            }
        });

        mLastNameEditText.setOnFocusChangeListener((v, hasFocus) -> {
            if (!hasFocus) {
                mRememberAll.setLastName(mLastNameEditText.getText().toString());
                mValidator.validate();
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
                mValidator.validate();
            }
        });

        mPhoneNumberEditText.setOnFocusChangeListener((v, hasFocus) -> {
            if (!hasFocus) {
                mRememberAll.setPhoneNumber(mPhoneNumberEditText.getText().toString());
                mValidator.validate();
            }
        });

        mEmailEditText.setOnFocusChangeListener((v, hasFocus) -> {
            if (!hasFocus) {
                mRememberAll.setEmail(mEmailEditText.getText().toString());
                mValidator.validate();
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
            DateFormat df = new SimpleDateFormat(getString(R.string.date_format));
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
        DateFormat df = new SimpleDateFormat(getString(R.string.date_format));
        Date dateOfBirth = null;
        try {
            dateOfBirth = df.parse(mDateOfBirthEditText.getText().toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        mRememberAll.setDateOfBirth(dateOfBirth);

        mValidator.validate();
    }
    @Override
    public void onValidationSucceeded() {
  //      Toast.makeText(getContext(), "Yay! we got it right!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onValidationFailed(List<ValidationError> errors) {
        for (ValidationError error : errors) {
            View view = error.getView();
            String message = error.getCollatedErrorMessage(getContext());

            // Display error messages ;)
            if (view instanceof EditText) {
                ((EditText) view).setError(message);
            } else {
                Toast.makeText(getContext(), message, Toast.LENGTH_LONG).show();
            }
        }
    }

}
