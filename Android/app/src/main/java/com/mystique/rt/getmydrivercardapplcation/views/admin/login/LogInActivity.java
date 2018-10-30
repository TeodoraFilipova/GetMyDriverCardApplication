package com.mystique.rt.getmydrivercardapplcation.views.admin.login;

import android.os.Bundle;
import android.app.Activity;

import com.mystique.rt.getmydrivercardapplcation.R;
import com.mystique.rt.getmydrivercardapplcation.views.BaseDrawerActivity;

import butterknife.ButterKnife;

public class LogInActivity extends BaseDrawerActivity {
    public static final long IDENTIFIER = 545;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        ButterKnife.bind(this);

        setSupportActionBar(getToolbar());

    }

    @Override
    protected long getIdentifier() {
        return IDENTIFIER;
    }
}
