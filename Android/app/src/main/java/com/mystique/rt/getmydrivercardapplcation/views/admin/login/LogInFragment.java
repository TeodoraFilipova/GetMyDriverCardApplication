package com.mystique.rt.getmydrivercardapplcation.views.admin.login;


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
import com.mystique.rt.getmydrivercardapplcation.models.User;

import java.io.IOException;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * <h1>LogInFragment</h1>
 *
 * <b>Description: </b> This fragment represents the visualisation of the fields
 * which constitute the log in functionality. It is the View of the MVP.
 *
 * @author  Mystique Team
 * @version 1.0
 * @since   2018-11-12
 */
public class LogInFragment extends Fragment implements LogInContracts.View {
    private LogInContracts.Presenter mPresenter;
    private LogInContracts.Navigator mNavigator;

    @BindView(R.id.et_username)
    EditText mUsername;

    @BindView(R.id.et_password)
    EditText mPassword;

    @BindView(R.id.button_log_in)
    Button mLogInButton;

    @BindView(R.id.tv_wrong_user_info)
    TextView mWrongUserTextView;

    @BindView(R.id.pb_loading)
    ProgressBar mLoading;

    @Inject
    public LogInFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_log_in, container, false);
        ButterKnife.bind(this, view);

        mLogInButton.setOnClickListener(v -> {
            try {
                mPresenter.loadUser(mUsername.getText().toString(), mPassword.getText().toString());
            } catch (IOException e) {
                e.printStackTrace();
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
    public void setPresenter(LogInContracts.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void logInUser(User user) {
        mNavigator.navigateToAdminPanel();
    }

    @Override
    public void showWrongUserInfo() {
        mWrongUserTextView.setVisibility(View.VISIBLE);
    }

    @Override
    public void showLoading() {
        mLoading.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        mLoading.setVisibility(View.GONE);
    }

    @Override
    public void showError(Throwable error) {
        Toast.makeText(getContext(), "Error: " + error.getMessage(), Toast.LENGTH_LONG)
                .show();
    }

    public void setNavigator(LogInContracts.Navigator navigator) {
        this.mNavigator = navigator;
    }
}
