

package com.mystique.rt.getmydrivercardapplcation.diconfig;

import com.mystique.rt.getmydrivercardapplcation.views.statuscheck.StatusCheckContracts;
import com.mystique.rt.getmydrivercardapplcation.views.statuscheck.StatusCheckFragment;
import com.mystique.rt.getmydrivercardapplcation.views.statuscheck.StatusCheckPresenter;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * <h1>StatusCheckModule</h1>
 *
 * <b>Description: </b> This class is a part of the Dagger dependency injection configuration.
 * It provides and injects instances of StatusCheckFragment and StatusCheckPresenter.
 *
 * @author  Mystique Team
 * @version 1.0
 * @since   2018-11-12
 */
@Module
public abstract class StatusCheckModule {
    @FragmentScoped
    @ContributesAndroidInjector
    abstract StatusCheckFragment statusCheckFragment();

    @ActivityScoped
    @Binds
    abstract StatusCheckContracts.Presenter statusCheckPresenter(StatusCheckPresenter presenter);
}
