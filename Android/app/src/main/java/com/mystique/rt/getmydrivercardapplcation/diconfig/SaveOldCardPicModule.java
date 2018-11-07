package com.mystique.rt.getmydrivercardapplcation.diconfig;

import com.mystique.rt.getmydrivercardapplcation.views.applications.submittodatabase.step5submitoldcardpic.SaveOldCardPicContracts;
import com.mystique.rt.getmydrivercardapplcation.views.applications.submittodatabase.step5submitoldcardpic.SaveOldCardPicFragment;
import com.mystique.rt.getmydrivercardapplcation.views.applications.submittodatabase.step5submitoldcardpic.SaveOldCardPicPresenter;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class SaveOldCardPicModule {
    @FragmentScoped
    @ContributesAndroidInjector
    abstract SaveOldCardPicFragment saveOldCardPicFragment();

    @ActivityScoped
    @Binds
    abstract SaveOldCardPicContracts.Presenter saveOldCardPicPresenter(SaveOldCardPicPresenter presenter);
}
