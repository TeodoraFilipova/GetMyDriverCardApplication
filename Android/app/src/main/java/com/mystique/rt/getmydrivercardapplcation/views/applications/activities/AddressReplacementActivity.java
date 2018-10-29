package com.mystique.rt.getmydrivercardapplcation.views.applications.activities;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.mystique.rt.getmydrivercardapplcation.R;
import com.mystique.rt.getmydrivercardapplcation.views.applications.adapters.AddressReplacementAdapter;


public class AddressReplacementActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address_replacement);

        ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        AddressReplacementAdapter addressReplacementAdapter = new AddressReplacementAdapter(getSupportFragmentManager());
        viewPager.setAdapter(addressReplacementAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tablayout);
        tabLayout.setupWithViewPager(viewPager);
    }

}
