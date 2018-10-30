package com.mystique.rt.getmydrivercardapplcation.views;


import android.os.Bundle;

import com.mystique.rt.getmydrivercardapplcation.R;

import butterknife.ButterKnife;

public class MainActivity extends BaseDrawerActivity {

    public static final long IDENTIFIER = 544;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        setSupportActionBar(getToolbar());

    }

    @Override
    protected long getIdentifier() {
        return IDENTIFIER;
    }
}
