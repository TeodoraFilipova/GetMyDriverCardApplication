package com.mystique.rt.getmydrivercardapplcation.views.applications.submittodatabase.step5submitoldcardpic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mystique.rt.getmydrivercardapplcation.R;
import com.mystique.rt.getmydrivercardapplcation.views.applications.submittodatabase.step6submitdriver.SaveDriverActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;
import dagger.android.support.DaggerAppCompatActivity;

public class SaveOldCardPicActivity extends DaggerAppCompatActivity implements SaveOldCardPicContracts.Navigator {

    @Inject
    SaveOldCardPicFragment mFragment;

    @Inject
    SaveOldCardPicContracts.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_old_card_pic);

        ButterKnife.bind(this);

        mFragment.setPresenter(mPresenter);
        mFragment.setNavigator(this);

        getFragmentManager().beginTransaction().replace(R.id.content, mFragment).commit();
    }

    @Override
    public void navigateToNextActivity() {
        Intent intent = new Intent(this, SaveDriverActivity.class);
        startActivity(intent);
    }
}
