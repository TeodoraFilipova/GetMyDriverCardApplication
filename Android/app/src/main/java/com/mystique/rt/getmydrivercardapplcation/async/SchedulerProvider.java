/**
 * <h1>SchedulerProvider interface</h1>
 *
 * <b>Description: </b> This interface defines a background and
 * a UI thread for running tasks.
 *
 * @author  Mystique Team
 * @version 1.0
 * @since   2018-11-12
 */

package com.mystique.rt.getmydrivercardapplcation.async;

import io.reactivex.Scheduler;

public interface SchedulerProvider {
    Scheduler background();
    Scheduler ui();
}
