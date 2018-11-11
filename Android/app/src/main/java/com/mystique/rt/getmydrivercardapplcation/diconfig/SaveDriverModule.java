/**
 * <h1>SaveDriverModule</h1>
 *
 * <b>Description: </b> This class is a part of the Dagger dependency injection configuration.
 * It provides and injects instances of SaveDriverFragment and SaveDriverPresenter.
 *
 * @author  Mystique Team
 * @version 1.0
 * @since   2018-11-12
 */

package com.mystique.rt.getmydrivercardapplcation.diconfig;

import com.mystique.rt.getmydrivercardapplcation.views.applications.submittodatabase.step6submitdriver.SaveDriverContracts;
import com.mystique.rt.getmydrivercardapplcation.views.applications.submittodatabase.step6submitdriver.SaveDriverFragment;
import com.mystique.rt.getmydrivercardapplcation.views.applications.submittodatabase.step6submitdriver.SaveDriverPresenter;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class SaveDriverModule {
    @FragmentScoped
    @ContributesAndroidInjector
    abstract SaveDriverFragment saveDriverFragment();

    @ActivityScoped
    @Binds
    abstract SaveDriverContracts.Presenter saveDriverPresenter(SaveDriverPresenter presenter);
}
