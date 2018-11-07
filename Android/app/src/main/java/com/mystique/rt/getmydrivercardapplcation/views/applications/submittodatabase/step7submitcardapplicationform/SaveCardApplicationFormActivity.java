package com.mystique.rt.getmydrivercardapplcation.views.applications.submittodatabase.step7submitcardapplicationform;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mystique.rt.getmydrivercardapplcation.R;

import javax.inject.Inject;

import butterknife.ButterKnife;
import dagger.android.support.DaggerAppCompatActivity;

public class SaveCardApplicationFormActivity extends DaggerAppCompatActivity {

    @Inject
    SaveCardApplicationFormFragment mFragment;

    @Inject
    SaveCardApplicationFormContracts.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_card_application_form);

        ButterKnife.bind(this);

        mFragment.setPresenter(mPresenter);

        getFragmentManager().beginTransaction().replace(R.id.content, mFragment).commit();
    }
}
