package com.mystique.rt.getmydrivercardapplcation.views.applications.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.mystique.rt.getmydrivercardapplcation.R;
import com.mystique.rt.getmydrivercardapplcation.views.applications.adapters.EUtoBGAdapter;

public class EUtoBGActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bgto_eu);

        ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        EUtoBGAdapter eUtoBGAdapterAdapter = new EUtoBGAdapter(getSupportFragmentManager());
        viewPager.setAdapter(eUtoBGAdapterAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tablayout);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

}
