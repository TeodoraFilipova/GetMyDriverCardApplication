package com.mystique.rt.getmydrivercardapplcation.views.applications.activities;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.mystique.rt.getmydrivercardapplcation.R;
import com.mystique.rt.getmydrivercardapplcation.views.applications.adapters.RenewalAdapter;

public class RenewalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_renewal);

        ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        RenewalAdapter renewalAdapter = new RenewalAdapter(getSupportFragmentManager());
        viewPager.setAdapter(renewalAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tablayout);
        tabLayout.setupWithViewPager(viewPager);
    }

}
