package com.mystique.rt.getmydrivercardapplcation.views.applications.activities;

import android.content.Intent;
import android.os.Bundle;

import com.mystique.rt.getmydrivercardapplcation.R;
import com.mystique.rt.getmydrivercardapplcation.apputils.Navigator;
import com.mystique.rt.getmydrivercardapplcation.views.BaseDrawerActivity;
import com.mystique.rt.getmydrivercardapplcation.views.applications.fragments.ApplicationChooseFragment;

import butterknife.ButterKnife;

public class ApplicationChooseActivity extends BaseDrawerActivity
        implements Navigator {

    public static final long IDENTIFIER = 543;
    private ApplicationChooseFragment mApplicationChooseFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_application_choose);

        ButterKnife.bind(this);
        setSupportActionBar(getToolbar());

        mApplicationChooseFragment = ApplicationChooseFragment.getInstance();
        mApplicationChooseFragment.setNavigator(this);

        getFragmentManager().beginTransaction()
                .replace(R.id.content, mApplicationChooseFragment)
                .commit();
    }

    @Override
    protected long getIdentifier() {
        return IDENTIFIER;
    }

    @Override
    public void navigateToActivity(Class activityClass) {
        Intent intent = new Intent(this, activityClass);
        startActivity(intent);
    }
}
