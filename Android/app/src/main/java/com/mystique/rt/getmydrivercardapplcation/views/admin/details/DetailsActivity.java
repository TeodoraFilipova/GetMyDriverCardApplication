package com.mystique.rt.getmydrivercardapplcation.views.admin.details;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.mystique.rt.getmydrivercardapplcation.R;

public class DetailsActivity extends AppCompatActivity {

    public static final String EXTRA_KEY = "CARDAPPLICATIONFORM_EXTRA_KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

    }

}
