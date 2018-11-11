/**
 * <h1>LogInModule</h1>
 *
 * <b>Description: </b> This class is a part of the Dagger dependency injection configuration.
 * It provides and injects instances of LogInFragment and LogInPresenter.
 *
 * @author  Mystique Team
 * @version 1.0
 * @since   2018-11-12
 */

package com.mystique.rt.getmydrivercardapplcation.diconfig;

import com.mystique.rt.getmydrivercardapplcation.views.admin.login.LogInContracts;
import com.mystique.rt.getmydrivercardapplcation.views.admin.login.LogInFragment;
import com.mystique.rt.getmydrivercardapplcation.views.admin.login.LogInPresenter;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class LogInModule {
    @FragmentScoped
    @ContributesAndroidInjector
    abstract LogInFragment logInFragment();

    @ActivityScoped
    @Binds
    abstract LogInContracts.Presenter logInPresenter(LogInPresenter presenter);

}
