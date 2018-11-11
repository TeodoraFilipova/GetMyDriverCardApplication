/**
 * <h1>AppModule</h1>
 *
 * <b>Description: </b> This class is a part of the Dagger dependency injection configuration.
 * It binds the application context.
 *
 * @author  Mystique Team
 * @version 1.0
 * @since   2018-11-12
 */

package com.mystique.rt.getmydrivercardapplcation.diconfig;

import android.app.Application;
import android.content.Context;

import dagger.Binds;
import dagger.Module;


@Module
public abstract class AppModule {
    @Binds
    abstract Context bindContext(Application application);
}