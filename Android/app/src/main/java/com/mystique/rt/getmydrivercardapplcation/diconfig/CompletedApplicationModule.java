package com.mystique.rt.getmydrivercardapplcation.diconfig;

import com.mystique.rt.getmydrivercardapplcation.views.applications.CompletedApplicationContracts;
import com.mystique.rt.getmydrivercardapplcation.views.applications.CompletedApplicationPresenter;
import com.mystique.rt.getmydrivercardapplcation.views.applications.fragments.CompletedApplicationFragment;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class CompletedApplicationModule {
    @FragmentScoped
    @ContributesAndroidInjector
    abstract CompletedApplicationFragment completedApplicationFragment();

    @ActivityScoped
    @Binds
    abstract CompletedApplicationContracts.Presenter completedApplicationPresenter(CompletedApplicationPresenter presenter);
}
