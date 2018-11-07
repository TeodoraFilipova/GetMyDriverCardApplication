package com.mystique.rt.getmydrivercardapplcation.views.applications.submittodatabase.step1submitselfie;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mystique.rt.getmydrivercardapplcation.R;
import com.mystique.rt.getmydrivercardapplcation.views.applications.submittodatabase.step2submitdrivinglicense.SaveDrivingLicensePicActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;
import dagger.android.support.DaggerAppCompatActivity;

public class SaveSelfieActivity extends DaggerAppCompatActivity implements SaveSelfieContracts.Navigator {

    @Inject
    SaveSelfieFragment mFragment;

    @Inject
    SaveSelfieContracts.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_selfie);

        ButterKnife.bind(this);

        mFragment.setPresenter(mPresenter);
        mFragment.setNavigator(this);

        getFragmentManager().beginTransaction().replace(R.id.content, mFragment).commit();
    }

    @Override
    public void navigateToNextActivity() {
        Intent intent = new Intent(this, SaveDrivingLicensePicActivity.class);
        startActivity(intent);
    }
}
