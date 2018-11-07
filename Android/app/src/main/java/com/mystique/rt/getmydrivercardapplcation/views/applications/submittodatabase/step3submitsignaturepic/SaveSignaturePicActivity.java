package com.mystique.rt.getmydrivercardapplcation.views.applications.submittodatabase.step3submitsignaturepic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mystique.rt.getmydrivercardapplcation.R;

import javax.inject.Inject;

import butterknife.ButterKnife;
import dagger.android.support.DaggerAppCompatActivity;

public class SaveSignaturePicActivity extends DaggerAppCompatActivity implements SaveSignaturePicContracts.Navigator {

    @Inject
    SaveSignaturePicFragment mFragment;

    @Inject
    SaveSignaturePicContracts.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_signature_pic);

        ButterKnife.bind(this);

        mFragment.setPresenter(mPresenter);
        mFragment.setNavigator(this);

        getFragmentManager().beginTransaction().replace(R.id.content, mFragment).commit();
    }

    @Override
    public void navigateToNextActivity(Class nextActivity) {
        Intent intent = new Intent(this, nextActivity);
        startActivity(intent);
    }
}
