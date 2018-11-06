package com.mystique.rt.getmydrivercardapplcation.views.applications.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

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

/**
 * A simple {@link Fragment} subclass.
 */
public class LossTheftFragment extends Fragment implements FocusListener {

    private RememberAll mRememberAll;

    @BindView(R.id.et_date_of_event)
    EditText mDateOfEventEditText;

    @BindView(R.id.et_place_of_event)
    EditText mPlaceOfEventEditText;

    public LossTheftFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_loss_theft, container, false);
        ButterKnife.bind(this, view);
        mRememberAll = RememberAll.getInstance();

        SetDate fromDate = new SetDate(mDateOfEventEditText, getContext(), this);

        checkRememberAllForCurrentData();

        mPlaceOfEventEditText.setOnFocusChangeListener((v, hasFocus) -> {
            if(!hasFocus) {
                mRememberAll.setPlaceOfEvent(mPlaceOfEventEditText.getText().toString());
            }
        });

        return view;
    }

    private void checkRememberAllForCurrentData() {
        if (mRememberAll.getCardApplicationForm().getPlaceOfEvent() != null) {
            mPlaceOfEventEditText.setText(mRememberAll.getCardApplicationForm().getPlaceOfEvent());
        }

        if (mRememberAll.getCardApplicationForm().getDateOfEvent() != null) {
            DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
            Date dateOfEvent = mRememberAll.getCardApplicationForm().getDateOfEvent();
            String dateOfEventString = df.format(dateOfEvent);
            mDateOfEventEditText.setText(dateOfEventString);
        }
    }

    @Override
    public void saveDateToObject() {
        DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
        Date dateOfBirth = null;
        try {
            dateOfBirth = df.parse(mDateOfEventEditText.getText().toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        mRememberAll.setDateOfBirth(dateOfBirth);
    }
}
