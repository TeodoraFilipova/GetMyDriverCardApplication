/**
 * <h1>SaveDrivingLicensePicModule</h1>
 *
 * <b>Description: </b> This class is a part of the Dagger dependency injection configuration.
 * It provides and injects instances of SaveDrivingLicensePicFragment and SaveDrivingLicensePicPresenter.
 *
 * @author  Mystique Team
 * @version 1.0
 * @since   2018-11-12
 */

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
