/**
 * <h1>Main Activity</h1>
 *
 * <b>Description: </b> Starting screen of the application with
 * drawer menu and buttons to go in the main functional parts -
 * Start a new card application, Check application status and
 * Admin panel.
 *
 *
 * @author  Mystique Team
 * @version 1.0
 * @since   2018-11-12
 */
package com.mystique.rt.getmydrivercardapplcation.views;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.mystique.rt.getmydrivercardapplcation.R;
import com.mystique.rt.getmydrivercardapplcation.apputils.Navigator;
import com.mystique.rt.getmydrivercardapplcation.views.admin.login.LogInActivity;
import com.mystique.rt.getmydrivercardapplcation.views.applications.activities.ApplicationChooseActivity;
import com.mystique.rt.getmydrivercardapplcation.views.statuscheck.StatusCheckActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseDrawerActivity implements Navigator{

    @BindView(R.id.button_new_application_start)
    Button mNewApplicationButton;

    @BindView(R.id.button_check_status)
    Button mCheckStatusButton;

    @BindView(R.id.button_admin_panel)
    Button mAdminLogInButton;

    public static final long IDENTIFIER = 544;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        setSupportActionBar(getToolbar());

        mNewApplicationButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                navigateToActivity(ApplicationChooseActivity.class);
            }
        });

        mCheckStatusButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                navigateToActivity(StatusCheckActivity.class);
            }
        });

        mAdminLogInButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                navigateToActivity(LogInActivity.class);
            }
        });
    }

    @Override
    protected long getIdentifier() {
        return IDENTIFIER;
    }

    @Override
    public void navigateToActivity(Class activityClass) {
        Intent intent = new Intent(this, activityClass);
        startActivity(intent);
    }
}
