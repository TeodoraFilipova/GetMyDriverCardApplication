/**
 * <h1>SaveSignaturePicModule</h1>
 *
 * <b>Description: </b> This class is a part of the Dagger dependency injection configuration.
 * It provides and injects instances of SaveSignaturePicFragment and SaveSignaturePicPresenter.
 *
 * @author  Mystique Team
 * @version 1.0
 * @since   2018-11-12
 */

package com.mystique.rt.getmydrivercardapplcation.diconfig;

import com.mystique.rt.getmydrivercardapplcation.views.applications.submittodatabase.step3submitsignaturepic.SaveSignaturePicContracts;
import com.mystique.rt.getmydrivercardapplcation.views.applications.submittodatabase.step3submitsignaturepic.SaveSignaturePicFragment;
import com.mystique.rt.getmydrivercardapplcation.views.applications.submittodatabase.step3submitsignaturepic.SaveSignaturePicPresenter;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class SaveSignaturePicModule {
    @FragmentScoped
    @ContributesAndroidInjector
    abstract SaveSignaturePicFragment saveSignaturePicFragment();

    @ActivityScoped
    @Binds
    abstract SaveSignaturePicContracts.Presenter saveSignaturePicPresenter(SaveSignaturePicPresenter presenter);
}
