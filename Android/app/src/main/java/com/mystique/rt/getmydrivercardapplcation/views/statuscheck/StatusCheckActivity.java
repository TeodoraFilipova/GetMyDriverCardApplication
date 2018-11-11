package com.mystique.rt.getmydrivercardapplcation.views.statuscheck;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.mystique.rt.getmydrivercardapplcation.R;
import com.mystique.rt.getmydrivercardapplcation.views.BaseDrawerActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * <h1>StatusCheckActivity</h1>
 *
 * <b>Description: </b> This activity is responsible for user status check and using StatuCheckFragment.
 *
 * @author  Mystique Team
 * @version 1.0
 * @since   2018-11-12
 */

public class StatusCheckActivity extends BaseDrawerActivity {
    public static final long IDENTIFIER = 546;

    @Inject
    StatusCheckFragment mStatusCheckFragment;

    @Inject
    StatusCheckContracts.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status_check);

        ButterKnife.bind(this);
        setSupportActionBar(getToolbar());

        mStatusCheckFragment.setPresenter(mPresenter);

        getFragmentManager().beginTransaction()
                .replace(R.id.content, mStatusCheckFragment).commit();

    }

    @Override
    protected long getIdentifier() {
        return IDENTIFIER;
    }
}
