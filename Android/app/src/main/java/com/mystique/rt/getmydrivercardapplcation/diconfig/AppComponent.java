package com.mystique.rt.getmydrivercardapplcation.diconfig;


import android.app.Application;

import com.mystique.rt.getmydrivercardapplcation.views.AndroidApplication;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;
import javax.inject.Singleton;


@Singleton
@Component(modules = {
        ActivityBindingModule.class,
        AppModule.class,
        AsyncModule.class,
        AndroidSupportInjectionModule.class})
public interface AppComponent extends AndroidInjector<AndroidApplication> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        AppComponent.Builder application(Application application);

        AppComponent build();
    }
}
