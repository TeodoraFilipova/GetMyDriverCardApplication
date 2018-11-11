package com.mystique.rt.getmydrivercardapplcation.views.statuscheck;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.mystique.rt.getmydrivercardapplcation.R;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * <h1>StatusCheckFragment</h1>
 *
 * <b>Description: </b> This fragment represents the visualisation of the fields
 * which constitute the status check functionality. It is the View of the MVP.
 *
 * @author  Mystique Team
 * @version 1.0
 * @since   2018-11-12
 */
public class StatusCheckFragment extends Fragment implements StatusCheckContracts.View {
    @BindView(R.id.button_check_status)
    Button mSubmitButton;

    @BindView(R.id.tv_show_status)
    TextView mStatusTextView;

    @BindView(R.id.et_write_status_code)
    EditText mStatusCodeEditText;

    @BindView(R.id.pb_loading)
    ProgressBar mLoading;

    StatusCheckContracts.Presenter mPresenter;

    @Inject
    public StatusCheckFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_status_check, container, false);
        ButterKnife.bind(this, view);

        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                // check status with database
                mPresenter.checkStatus(mStatusCodeEditText.getText().toString());
                // TextView setText with status
                // TextView setVisibility to visible
            }
        });

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.subscribe(this);
    }

    @Override
    public void setPresenter(StatusCheckContracts.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void showStatus(String status) {
        mStatusTextView.setText("Application status: " + status);
    }

    @Override
    public void hideLoading() {
        mLoading.setVisibility(View.GONE);
        mStatusTextView.setVisibility(View.VISIBLE);
    }

    @Override
    public void showError(Throwable error) {
        Toast.makeText(getContext(), "Error: " + error.getMessage(), Toast.LENGTH_LONG)
                .show();    }

    @Override
    public void showNotFound() {
        mStatusTextView.setText(R.string.wrong_status_number);
    }

    @Override
    public void showLoading() {
        mLoading.setVisibility(View.VISIBLE);
        mStatusTextView.setVisibility(View.GONE);
    }
}
