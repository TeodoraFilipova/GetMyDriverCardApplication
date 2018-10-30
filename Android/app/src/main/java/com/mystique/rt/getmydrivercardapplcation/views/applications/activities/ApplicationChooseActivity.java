package com.mystique.rt.getmydrivercardapplcation.views.applications.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.mystique.rt.getmydrivercardapplcation.R;
import com.mystique.rt.getmydrivercardapplcation.views.BaseDrawerActivity;

import butterknife.ButterKnife;

public class ApplicationChooseActivity extends BaseDrawerActivity {

    public static final long IDENTIFIER = 543;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_application_choose);
        ButterKnife.bind(this);

        setSupportActionBar(getToolbar());

    }

    @Override
    protected long getIdentifier() {
        return IDENTIFIER;
    }

}
