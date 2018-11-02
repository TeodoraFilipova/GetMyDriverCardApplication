package com.mystique.rt.getmydrivercardapplcation.diconfig;

import com.mystique.rt.getmydrivercardapplcation.views.admin.details.CardApplicationDetailsContracts;
import com.mystique.rt.getmydrivercardapplcation.views.admin.details.CardApplicationDetailsFragment;
import com.mystique.rt.getmydrivercardapplcation.views.admin.details.CardApplicationDetailsPresenter;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class CardApplicationDetailsModule {
    @FragmentScoped
    @ContributesAndroidInjector
    abstract CardApplicationDetailsFragment cardApplicationDetailsFragment();

    @ActivityScoped
    @Binds
    abstract CardApplicationDetailsContracts.Presenter cardApplicationDetailsPresenter(CardApplicationDetailsPresenter presenter);
}
