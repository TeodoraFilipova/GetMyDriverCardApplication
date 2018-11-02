package com.mystique.rt.getmydrivercardapplcation.views.admin.login;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;

import com.mystique.rt.getmydrivercardapplcation.R;
import com.mystique.rt.getmydrivercardapplcation.views.BaseDrawerActivity;
import com.mystique.rt.getmydrivercardapplcation.views.admin.applicationslist.CardApplicationFormsListActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;

public class LogInActivity extends BaseDrawerActivity implements LogInContracts.Navigator {
    public static final long IDENTIFIER = 545;

    @Inject
    LogInFragment mLogInFragment;

    @Inject
    LogInContracts.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        ButterKnife.bind(this);
        setSupportActionBar(getToolbar());

        mLogInFragment.setPresenter(mPresenter);
        mLogInFragment.setNavigator(this);

        getFragmentManager().beginTransaction()
                .replace(R.id.content, mLogInFragment)
                .commit();
    }

    @Override
    protected long getIdentifier() {
        return IDENTIFIER;
    }

    @Override
    public void navigateToAdminPanel() {
        Intent intent = new Intent(this, CardApplicationFormsListActivity.class);
        startActivity(intent);
    }
}
