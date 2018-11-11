/**
 * <h1>SaveCardApplicationFormModule</h1>
 *
 * <b>Description: </b> This class is a part of the Dagger dependency injection configuration.
 * It provides and injects instances of SaveCardApplicationFormFragment and SaveCardApplicationFormPresenter.
 *
 * @author  Mystique Team
 * @version 1.0
 * @since   2018-11-12
 */

package com.mystique.rt.getmydrivercardapplcation.diconfig;

import com.mystique.rt.getmydrivercardapplcation.views.applications.submittodatabase.step7submitcardapplicationform.SaveCardApplicationFormContracts;
import com.mystique.rt.getmydrivercardapplcation.views.applications.submittodatabase.step7submitcardapplicationform.SaveCardApplicationFormFragment;
import com.mystique.rt.getmydrivercardapplcation.views.applications.submittodatabase.step7submitcardapplicationform.SaveCardApplicationFormPresenter;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class SaveCardApplicationFormModule {
    @FragmentScoped
    @ContributesAndroidInjector
    abstract SaveCardApplicationFormFragment saveCardApplicationFormFragment();

    @ActivityScoped
    @Binds
    abstract SaveCardApplicationFormContracts.Presenter saveCardApplicationFormPresenter(SaveCardApplicationFormPresenter presenter);
}
