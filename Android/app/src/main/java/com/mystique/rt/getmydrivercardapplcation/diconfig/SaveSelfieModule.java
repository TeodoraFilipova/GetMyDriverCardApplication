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
