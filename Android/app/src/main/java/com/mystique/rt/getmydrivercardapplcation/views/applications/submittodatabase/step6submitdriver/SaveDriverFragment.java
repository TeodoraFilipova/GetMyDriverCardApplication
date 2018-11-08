package com.mystique.rt.getmydrivercardapplcation.views.applications.submittodatabase.step6submitdriver;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.mystique.rt.getmydrivercardapplcation.R;
import com.mystique.rt.getmydrivercardapplcation.apputils.Constants;
import com.mystique.rt.getmydrivercardapplcation.apputils.RememberAll;
import com.mystique.rt.getmydrivercardapplcation.models.Driver;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class SaveDriverFragment extends Fragment implements SaveDriverContracts.View {
    private RememberAll mRememberAll;
    SaveDriverContracts.Presenter mPresenter;
    private SaveDriverContracts.Navigator mNavigator;

    private int mNextDriverId;

    @BindView(R.id.text_completed)
    TextView mMessageTextView;

    @BindView(R.id.pb_loading)
    ProgressBar mLoading;

    @Inject
    public SaveDriverFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_save_driver, container, false);

        ButterKnife.bind(this, view);
        mRememberAll = RememberAll.getInstance();
        mPresenter.subscribe(this);

        showLoading();
        mPresenter.getAllDrivers();
     //   mPresenter.getLastUpdatedDriver();

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.subscribe(this);
    }

    @Override
    public void setPresenter(SaveDriverContracts.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void showError(Throwable error) {
        try {
            throw new Throwable(error);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
//        mMessageTextView.setText("In Driver: " + error.getMessage());
//        mLoading.setVisibility(View.GONE);
    }

    @Override
    public void showLoading() {
        mLoading.setVisibility(View.VISIBLE);
    }

    @Override
    public void setNextDriverId(Driver lastUpdatedDriver) {
        mNextDriverId = lastUpdatedDriver.getDriverId() + 1;
        mPresenter.updateLastDriver(lastUpdatedDriver);
    }

    @Override
    public void updateRememberAll() {
        mRememberAll.getCardApplicationForm().getDriver().setDriverId(mNextDriverId);
        mRememberAll.getCardApplicationForm().getDriver().setLastUpdated(Constants.LAST_UPDATED_TRUE);
        Driver testDriver = mRememberAll.getCardApplicationForm().getDriver();
        mPresenter.saveDriver(mRememberAll.getCardApplicationForm().getDriver());
    }

    @Override
    public void moveOnToNextSaveActivity() {
        mLoading.setVisibility(View.GONE);
        mNavigator.navigateToNextActivity();
    }

    @Override
    public void checkIfDriverExists(List<Driver> drivers) {
        boolean driverExists = false;
        int existingDriverId = 0;

        for (Driver driver : drivers) {
            if (driver.getPersonalNumber().equals(mRememberAll.getCardApplicationForm().getDriver().getPersonalNumber())) {
                driverExists = true;
                existingDriverId = driver.getDriverId();
                break;
            }
        }

        if (!driverExists) {
            mPresenter.getLastUpdatedDriver();
        } else {
            mRememberAll.getCardApplicationForm().getDriver().setDriverId(existingDriverId);
            mPresenter.updateExistingDriver(mRememberAll.getCardApplicationForm().getDriver());
        }
    }

    public void setNavigator(SaveDriverContracts.Navigator navigator) {
        this.mNavigator = navigator;
    }

}
