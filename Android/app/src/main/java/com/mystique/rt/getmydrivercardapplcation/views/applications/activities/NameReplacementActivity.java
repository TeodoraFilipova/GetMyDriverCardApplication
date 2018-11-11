

package com.mystique.rt.getmydrivercardapplcation.views.applications.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.mystique.rt.getmydrivercardapplcation.R;
import com.mystique.rt.getmydrivercardapplcation.apputils.Navigator;
import com.mystique.rt.getmydrivercardapplcation.views.applications.adapters.NameReplacementAdapter;
/**
 * <h1>NameReplacement Activity</h1>
 *
 * <b>Description: </b> Activity with with editing information for
 * First card application form, which is organised by NameReplacement Adapter
 * to slider view of needed Fragments (exp. Personal information fragment etc.)
 *
 *
 * @author  Mystique Team
 * @version 1.0
 * @since   2018-11-12
 */

public class NameReplacementActivity extends AppCompatActivity implements Navigator {

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

    @Override
    public void navigateToActivity(Class activityClass) {
        Intent intent = new Intent(this, activityClass);
        startActivity(intent);
    }
// TODO RememberAll Things!
}
