package com.mystique.rt.getmydrivercardapplcation.views.applications.submittodatabase.step6submitdriver;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mystique.rt.getmydrivercardapplcation.R;
import com.mystique.rt.getmydrivercardapplcation.views.applications.submittodatabase.step5submitoldcardpic.SaveOldCardPicFragment;
import com.mystique.rt.getmydrivercardapplcation.views.applications.submittodatabase.step7submitcardapplicationform.SaveCardApplicationFormActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;
import dagger.android.support.DaggerAppCompatActivity;

public class SaveDriverActivity extends DaggerAppCompatActivity implements SaveDriverContracts.Navigator {

    @Inject
    SaveDriverFragment mFragment;

    @Inject
    SaveDriverContracts.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_driver);

        ButterKnife.bind(this);

        mFragment.setPresenter(mPresenter);
        mFragment.setNavigator(this);

        getFragmentManager().beginTransaction().replace(R.id.content, mFragment).commit();
    }

    @Override
    public void navigateToNextActivity() {
        Intent intent = new Intent(this, SaveCardApplicationFormActivity.class);
        startActivity(intent);
    }
}
