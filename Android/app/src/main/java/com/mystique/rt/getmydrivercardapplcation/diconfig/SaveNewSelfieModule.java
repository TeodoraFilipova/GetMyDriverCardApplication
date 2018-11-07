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
