package com.mystique.rt.getmydrivercardapplcation.async;

import io.reactivex.Scheduler;

public interface SchedulerProvider {
    Scheduler background();
    Scheduler ui();
}
