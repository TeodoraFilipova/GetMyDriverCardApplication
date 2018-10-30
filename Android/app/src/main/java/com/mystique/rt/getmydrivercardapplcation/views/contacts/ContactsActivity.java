package com.mystique.rt.getmydrivercardapplcation.views.contacts;

import android.os.Bundle;
import android.app.Activity;

import com.mystique.rt.getmydrivercardapplcation.R;
import com.mystique.rt.getmydrivercardapplcation.views.BaseDrawerActivity;

import butterknife.ButterKnife;

public class ContactsActivity extends BaseDrawerActivity {

    public static final long IDENTIFIER = 547;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);

        ButterKnife.bind(this);

        setSupportActionBar(getToolbar());
    }

    @Override
    protected long getIdentifier() {
        return IDENTIFIER;
    }
}
