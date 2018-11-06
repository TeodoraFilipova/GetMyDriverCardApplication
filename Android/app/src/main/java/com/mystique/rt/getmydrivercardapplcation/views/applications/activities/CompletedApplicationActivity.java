package com.mystique.rt.getmydrivercardapplcation.views.applications.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mystique.rt.getmydrivercardapplcation.R;
import com.mystique.rt.getmydrivercardapplcation.views.applications.CompletedApplicationContracts;
import com.mystique.rt.getmydrivercardapplcation.views.applications.fragments.CompletedApplicationFragment;

import javax.inject.Inject;

public class CompletedApplicationActivity extends AppCompatActivity {

    @Inject
    CompletedApplicationFragment mFragment;

    @Inject
    CompletedApplicationContracts.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_completed_application);

    //    mFragment = CompletedApplicationFragment.getInstance();

        mFragment.setPresenter(mPresenter);

        getFragmentManager().beginTransaction().replace(R.id.content, mFragment).commit();
    }
}
