/**
 * <h1>SaveNewSelfieModule</h1>
 *
 * <b>Description: </b> This class is a part of the Dagger dependency injection configuration.
 * It provides and injects instances of SaveNewSelfieFragment and SaveNewSelfiePresenter.
 *
 * @author  Mystique Team
 * @version 1.0
 * @since   2018-11-12
 */

package com.mystique.rt.getmydrivercardapplcation.diconfig;

import com.mystique.rt.getmydrivercardapplcation.views.applications.submittodatabase.step4submitnewselfie.SaveNewSelfieContracts;
import com.mystique.rt.getmydrivercardapplcation.views.applications.submittodatabase.step4submitnewselfie.SaveNewSelfieFragment;
import com.mystique.rt.getmydrivercardapplcation.views.applications.submittodatabase.step4submitnewselfie.SaveNewSelfiePresenter;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class SaveNewSelfieModule {
    @FragmentScoped
    @ContributesAndroidInjector
    abstract SaveNewSelfieFragment saveNewSelfieFragment();

    @ActivityScoped
    @Binds
    abstract SaveNewSelfieContracts.Presenter saveNewSelfiePresenter(SaveNewSelfiePresenter presenter);
}
