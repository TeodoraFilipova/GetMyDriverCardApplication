package com.mystique.rt.getmydrivercardapplcation.views.applications.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.mystique.rt.getmydrivercardapplcation.R;
import com.mystique.rt.getmydrivercardapplcation.views.applications.adapters.PictureReplacementAdapter;


public class PictureReplacementActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture_replacement);

        ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        PictureReplacementAdapter pictureReplacementAdapter = new PictureReplacementAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pictureReplacementAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tablayout);
        tabLayout.setupWithViewPager(viewPager);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

}
