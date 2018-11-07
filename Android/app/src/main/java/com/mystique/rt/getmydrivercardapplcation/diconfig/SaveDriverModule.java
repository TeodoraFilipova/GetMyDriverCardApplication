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
