package com.mystique.rt.getmydrivercardapplcation.views.applications.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.mystique.rt.getmydrivercardapplcation.R;
import com.mystique.rt.getmydrivercardapplcation.apputils.SetDate;
import com.mystique.rt.getmydrivercardapplcation.views.applications.FocusListener;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class LossTheftFragment extends Fragment implements FocusListener {

    @BindView(R.id.et_date_of_event)
    EditText mDateOfEventEditText;

    public LossTheftFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_loss_theft, container, false);
        ButterKnife.bind(this, view);

        SetDate fromDate = new SetDate(mDateOfEventEditText, getContext(), this);

        return view;
    }

    @Override
    public void saveDateToObject() {

    }
}
