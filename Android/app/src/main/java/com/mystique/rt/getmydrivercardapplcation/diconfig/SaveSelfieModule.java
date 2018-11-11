/**
 * <h1>SaveSelfieModule</h1>
 *
 * <b>Description: </b> This class is a part of the Dagger dependency injection configuration.
 * It provides and injects instances of SaveSelfieFragment and SaveSelfiePresenter.
 *
 * @author  Mystique Team
 * @version 1.0
 * @since   2018-11-12
 */

package com.mystique.rt.getmydrivercardapplcation.diconfig;

import com.mystique.rt.getmydrivercardapplcation.views.applications.submittodatabase.step1submitselfie.SaveSelfieContracts;
import com.mystique.rt.getmydrivercardapplcation.views.applications.submittodatabase.step1submitselfie.SaveSelfieFragment;
import com.mystique.rt.getmydrivercardapplcation.views.applications.submittodatabase.step1submitselfie.SaveSelfiePresenter;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class SaveSelfieModule {
    @FragmentScoped
    @ContributesAndroidInjector
    abstract SaveSelfieFragment saveSelfieFragment();

    @ActivityScoped
    @Binds
    abstract SaveSelfieContracts.Presenter saveSelfiePresenter(SaveSelfiePresenter presenter);
}
