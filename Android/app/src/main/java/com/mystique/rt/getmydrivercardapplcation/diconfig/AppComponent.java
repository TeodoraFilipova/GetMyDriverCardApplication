

package com.mystique.rt.getmydrivercardapplcation.diconfig;


import android.app.Application;

import com.mystique.rt.getmydrivercardapplcation.views.AndroidApplication;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;
import javax.inject.Singleton;

/**
 * <h1>AppComponent interface</h1>
 *
 * <b>Description: </b> This interface is a part of the Dagger dependency injection configuration.
 * It provides, binds, and builds modules.
 *
 * @author  Mystique Team
 * @version 1.0
 * @since   2018-11-12
 */
@Singleton
@Component(modules = {
        ActivityBindingModule.class,
        AppModule.class,
        AsyncModule.class,
        CardApplicationDetailsModule.class,
        CardApplicationFormsListModule.class,
        HttpModule.class,
        LogInModule.class,
        ParsersModule.class,
        RepositoriesModule.class,
        SaveCardApplicationFormModule.class,
        SaveDriverModule.class,
        SaveDrivingLicensePicModule.class,
        SaveNewSelfieModule.class,
        SaveOldCardPicModule.class,
        SaveSelfieModule.class,
        SaveSignaturePicModule.class,
        ServicesModule.class,
        StatusCheckModule.class,
        ValidatorsModule.class,
        AndroidSupportInjectionModule.class})
public interface AppComponent extends AndroidInjector<AndroidApplication> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        AppComponent.Builder application(Application application);

        AppComponent build();
    }
}
