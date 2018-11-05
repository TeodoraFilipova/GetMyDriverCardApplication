package com.mystique.rt.getmydrivercardapplcation.views.applications.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.mystique.rt.getmydrivercardapplcation.R;
import com.mystique.rt.getmydrivercardapplcation.views.applications.adapters.NameReplacementAdapter;

public class NameReplacementActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name_replacement);

        ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        NameReplacementAdapter nameReplacementAdapter = new NameReplacementAdapter(getSupportFragmentManager());
        viewPager.setAdapter(nameReplacementAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tablayout);
        tabLayout.setupWithViewPager(viewPager);
    }

    // method might not be used, because camera will be set invisible
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

}
