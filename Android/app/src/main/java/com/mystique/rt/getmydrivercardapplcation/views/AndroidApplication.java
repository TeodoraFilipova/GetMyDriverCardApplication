package com.mystique.rt.getmydrivercardapplcation.views;

import com.mystique.rt.getmydrivercardapplcation.diconfig.DaggerAppComponent;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;

/**
 * <h1>AndroidApplication class</h1>
 *
 * <b>Description: </b> This class extends DaggerApplication and handles the build
 * and DI of the application.
 *
 * @author  Mystique Team
 * @version 1.0
 * @since   2018-11-12
 */
public class AndroidApplication extends DaggerApplication {
    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerAppComponent.builder().application(this).build();
    }
}
