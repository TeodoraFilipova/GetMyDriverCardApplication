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
