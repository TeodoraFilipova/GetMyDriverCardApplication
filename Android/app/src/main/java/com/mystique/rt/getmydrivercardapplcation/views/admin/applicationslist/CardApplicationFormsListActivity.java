

package com.mystique.rt.getmydrivercardapplcation.views.admin.applicationslist;

import android.content.Intent;
import android.os.Bundle;

import com.mystique.rt.getmydrivercardapplcation.R;
import com.mystique.rt.getmydrivercardapplcation.models.CardApplicationForm;
import com.mystique.rt.getmydrivercardapplcation.views.admin.details.CardApplicationDetailsActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;
import dagger.android.support.DaggerAppCompatActivity;

/**
 * <h1>CardApplicationFormListActivity</h1>
 *
 * <b>Description: </b> This activity handles and manages the screen which is responsible for
 * visualizing a list of all applications from the database for viewing by the admin. It also
 * handles navigation.
 *
 * @author  Mystique Team
 * @version 1.0
 * @since   2018-11-12
 */
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
        Intent intent = new Intent(this, CardApplicationDetailsActivity.class);
        intent.putExtra(CardApplicationDetailsActivity.EXTRA_KEY, cardApplicationForm);
        startActivity(intent);
    }
}
