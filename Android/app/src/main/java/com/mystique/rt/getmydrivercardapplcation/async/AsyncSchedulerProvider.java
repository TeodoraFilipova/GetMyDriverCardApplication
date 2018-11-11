/**
 * <h1>AsyncSchedulerProvider class</h1>
 *
 * <b>Description: </b> This class implements the SchedulerProvider interface,
 * providing an io Scheduler and an Android main thread Scheduler.
 *
 * @author  Mystique Team
 * @version 1.0
 * @since   2018-11-12
 */

package com.mystique.rt.getmydrivercardapplcation.async;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class AsyncSchedulerProvider implements SchedulerProvider {
    private static SchedulerProvider instance;

    private AsyncSchedulerProvider() {
        // Empty private constructor for singleton
    }

    public static SchedulerProvider getInstance() {
        if (instance == null) {
            instance = new AsyncSchedulerProvider();
        }
        return instance;
    }

    @Override
    public Scheduler background() {
        return Schedulers.io();
    }

    @Override
    public Scheduler ui() {
        return AndroidSchedulers.mainThread();
    }
}
