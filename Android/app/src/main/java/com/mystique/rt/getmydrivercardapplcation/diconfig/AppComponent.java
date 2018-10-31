package com.mystique.rt.getmydrivercardapplcation.diconfig;


import android.app.Application;

import com.mystique.rt.getmydrivercardapplcation.views.AndroidApplication;
import com.mystique.rt.getmydrivercardapplcation.views.MainActivity;
import com.mystique.rt.getmydrivercardapplcation.views.admin.login.LogInActivity;
import com.mystique.rt.getmydrivercardapplcation.views.applications.activities.ApplicationChooseActivity;
import com.mystique.rt.getmydrivercardapplcation.views.contacts.ContactsActivity;
import com.mystique.rt.getmydrivercardapplcation.views.statuscheck.StatusCheckActivity;

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
        HttpModule.class,
        ParsersModule.class,
        RepositoriesModule.class,
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
