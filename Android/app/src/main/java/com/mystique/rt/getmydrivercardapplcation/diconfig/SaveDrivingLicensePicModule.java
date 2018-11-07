package com.mystique.rt.getmydrivercardapplcation.diconfig;

import com.mystique.rt.getmydrivercardapplcation.views.applications.submittodatabase.step2submitdrivinglicense.SaveDrivingLicensePicContracts;
import com.mystique.rt.getmydrivercardapplcation.views.applications.submittodatabase.step2submitdrivinglicense.SaveDrivingLicensePicFragment;
import com.mystique.rt.getmydrivercardapplcation.views.applications.submittodatabase.step2submitdrivinglicense.SaveDrivingLicensePicPresenter;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class SaveDrivingLicensePicModule {
    @FragmentScoped
    @ContributesAndroidInjector
    abstract SaveDrivingLicensePicFragment saveDrivingLicensePicFragment();

    @ActivityScoped
    @Binds
    abstract SaveDrivingLicensePicContracts.Presenter saveDrivingLicensePicPresenter(SaveDrivingLicensePicPresenter presenter);
}
