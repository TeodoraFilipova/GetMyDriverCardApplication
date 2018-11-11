package com.mystique.rt.getmydrivercardapplcation.views.admin.details;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.mystique.rt.getmydrivercardapplcation.R;
import com.mystique.rt.getmydrivercardapplcation.models.CardApplicationForm;

import javax.inject.Inject;

import butterknife.ButterKnife;
import dagger.android.support.DaggerAppCompatActivity;

/**
 * <h1>CardApplicationDetailsActivity</h1>
 *
 * <b>Description: </b> This activity handles and manages the screen which is responsible for
 * visualizing a list of the details of a selected application for viewing by the admin.
 *
 * @author  Mystique Team
 * @version 1.0
 * @since   2018-11-12
 */
public class CardApplicationDetailsActivity extends DaggerAppCompatActivity {

    public static final String EXTRA_KEY = "CARDAPPLICATIONFORM_EXTRA_KEY";

    @Inject
    CardApplicationDetailsFragment mDetailsFragment;

    @Inject
    CardApplicationDetailsContracts.Presenter mDetailsPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        ButterKnife.bind(this);

        Intent intent = getIntent();
        CardApplicationForm form = (CardApplicationForm) intent.getSerializableExtra(CardApplicationDetailsActivity.EXTRA_KEY);

        mDetailsPresenter.setCardApplicationFormId(form.getCardApplicationFormId());
        mDetailsFragment.setPresenter(mDetailsPresenter);

        getFragmentManager()
                .beginTransaction()
                .replace(R.id.context, mDetailsFragment)
                .commit();

    }

}
