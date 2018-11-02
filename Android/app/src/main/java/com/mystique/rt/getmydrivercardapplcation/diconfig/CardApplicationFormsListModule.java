package com.mystique.rt.getmydrivercardapplcation.diconfig;

import com.mystique.rt.getmydrivercardapplcation.views.admin.applicationslist.CardApplicationFormsListContracts;
import com.mystique.rt.getmydrivercardapplcation.views.admin.applicationslist.CardApplicationFormsListFragment;
import com.mystique.rt.getmydrivercardapplcation.views.admin.applicationslist.CardApplicationFormsListPresenter;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class CardApplicationFormsListModule {
    @FragmentScoped
    @ContributesAndroidInjector
    abstract CardApplicationFormsListFragment cardApplicationFormsListFragment();

    @ActivityScoped
    @Binds
    abstract CardApplicationFormsListContracts.Presenter cardApplicationFormsListPresenter(CardApplicationFormsListPresenter presenter);
}
