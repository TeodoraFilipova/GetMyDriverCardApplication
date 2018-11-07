package com.mystique.rt.getmydrivercardapplcation.views.applications.submittodatabase.step2submitdrivinglicense;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mystique.rt.getmydrivercardapplcation.R;
import com.mystique.rt.getmydrivercardapplcation.views.applications.submittodatabase.step3submitsignaturepic.SaveSignaturePicActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;
import dagger.android.support.DaggerAppCompatActivity;

public class SaveDrivingLicensePicActivity extends DaggerAppCompatActivity implements SaveDrivingLicensePicContracts.Navigator {

    @Inject
    SaveDrivingLicensePicFragment mFragment;

    @Inject
    SaveDrivingLicensePicContracts.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_driving_license_pic);

        ButterKnife.bind(this);

        mFragment.setPresenter(mPresenter);
        mFragment.setNavigator(this);

        getFragmentManager().beginTransaction().replace(R.id.content, mFragment).commit();
    }

    @Override
    public void navigateToNextActivity() {
        Intent intent = new Intent(this, SaveSignaturePicActivity.class);
        startActivity(intent);
    }
}
