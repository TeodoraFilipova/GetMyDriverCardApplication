package com.mystique.rt.getmydrivercardapplcation.diconfig;

import com.mystique.rt.getmydrivercardapplcation.views.statuscheck.StatusCheckContracts;
import com.mystique.rt.getmydrivercardapplcation.views.statuscheck.StatusCheckFragment;
import com.mystique.rt.getmydrivercardapplcation.views.statuscheck.StatusCheckPresenter;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class StatusCheckModule {
    @FragmentScoped
    @ContributesAndroidInjector
    abstract StatusCheckFragment statusCheckFragment();

    @ActivityScoped
    @Binds
    abstract StatusCheckContracts.Presenter statusCheckPresenter(StatusCheckPresenter presenter);
}
