package com.mystique.rt.getmydrivercardapplcation.views.admin.applicationslist;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.mystique.rt.getmydrivercardapplcation.R;
import com.mystique.rt.getmydrivercardapplcation.apputils.Navigator;
import com.mystique.rt.getmydrivercardapplcation.models.CardApplicationForm;
import com.mystique.rt.getmydrivercardapplcation.views.admin.details.DetailsActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;
import dagger.android.support.DaggerAppCompatActivity;

public class CardApplicationFormsListActivity extends DaggerAppCompatActivity
implements CardApplicationFormsListContracts.Navigator {

    public static final long IDENTIFIER = 2; // ??? put in the menu

    @Inject
    CardApplicationFormsListFragment mCardApplicationFormListFragment;

    @Inject
    CardApplicationFormsListContracts.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_application_list);

        ButterKnife.bind(this);

        mCardApplicationFormListFragment.setNavigator(this);
        mCardApplicationFormListFragment.setPresenter(mPresenter);



        getFragmentManager().beginTransaction()
                .replace(R.id.list_content, mCardApplicationFormListFragment)
                .commit();

    }

    /*@Override
    public void navigateToActivity(Class activityClass) {
        Intent intent = new Intent(this, activityClass);
        startActivity(intent);
    }*/

    @Override
    public void navigateWith(CardApplicationForm cardApplicationForm) {
        Intent intent = new Intent(this, DetailsActivity.class);
        intent.putExtra(DetailsActivity.EXTRA_KEY, cardApplicationForm);
        startActivity(intent);
    }
}
