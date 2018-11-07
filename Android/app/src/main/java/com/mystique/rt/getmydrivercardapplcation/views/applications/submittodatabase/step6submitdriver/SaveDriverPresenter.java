package com.mystique.rt.getmydrivercardapplcation.views.applications.submittodatabase.step6submitdriver;

import com.mystique.rt.getmydrivercardapplcation.async.SchedulerProvider;
import com.mystique.rt.getmydrivercardapplcation.models.Driver;
import com.mystique.rt.getmydrivercardapplcation.services.base.DriverService;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.Disposable;

public class SaveDriverPresenter implements SaveDriverContracts.Presenter {
    private final DriverService mDriverService;

    private final SchedulerProvider mSchedulerProvider;
    private SaveDriverContracts.View mView;

    @Inject
    public SaveDriverPresenter(DriverService driverService, SchedulerProvider schedulerProvider) {
        mDriverService = driverService;
        mSchedulerProvider = schedulerProvider;
    }

    @Override
    public void subscribe(SaveDriverContracts.View view) {
        mView = view;
    }

    @Override
    public void saveDriver(Driver driver) {
        Disposable observable = Observable
                .create((ObservableOnSubscribe<Driver>) emitter -> {
                    Driver dr = mDriverService.addDriver(driver);
                    emitter.onNext(dr);
                    emitter.onComplete();
                })
                .subscribeOn(mSchedulerProvider.background())
                .observeOn(mSchedulerProvider.ui())
                .subscribe(this::tellViewToNavigateToNextSaveActivity, error -> mView.showError(error));
    }

    private void tellViewToNavigateToNextSaveActivity(Driver picture) {
        mView.moveOnToNextSaveActivity();
    }

    @Override
    public void getLastUpdatedDriver() {
//        Disposable observable = Observable
//                .create((ObservableOnSubscribe<Driver>) emitter -> {
//                    Driver lastUpdatedDriver = mDriverService.getLastUpdatedDriver();
//                    emitter.onNext(lastUpdatedDriver);
//                    emitter.onComplete();
//                })
//                .subscribeOn(mSchedulerProvider.background())
//                .observeOn(mSchedulerProvider.ui())
//                .subscribe(this::tellViewToSetNextDriverId, error -> mView.showError(error));
        Driver driver = new Driver();
        driver.setDriverId(1);
        tellViewToSetNextDriverId(driver);
    }

    private void tellViewToSetNextDriverId(Driver driver) {
        mView.setNextDriverId(driver);
    }

    @Override
    public void updateLastDriver(Driver driver) {
//        Disposable observable = Observable
//                .create((ObservableOnSubscribe<Driver>) emitter -> {
//                    driver.setLastUpdated("");
//                    Driver dr = mDriverService.updateDriverById(driver.getDriverId(), driver);
//                    emitter.onNext(dr);
//                    emitter.onComplete();
//                })
//                .subscribeOn(mSchedulerProvider.background())
//                .observeOn(mSchedulerProvider.ui())
//                .subscribe(this::tellViewToUpdateRememberAll, error -> mView.showError(error));
        tellViewToUpdateRememberAll(driver);

    }

    private void tellViewToUpdateRememberAll(Driver lastUpdatedDriver) {
        mView.updateRememberAll();
    }

    @Override
    public void getAllDrivers() {
        Disposable observable = Observable
                .create((ObservableOnSubscribe< List<Driver>>) emitter -> {
                    List<Driver> drivers = mDriverService.getAllDrivers();
                    emitter.onNext(drivers);
                    emitter.onComplete();
                })
                .subscribeOn(mSchedulerProvider.background())
                .observeOn(mSchedulerProvider.ui())
                .subscribe(this::tellViewToCheckIfDriverExists, error -> mView.showError(error));
    }

    @Override
    public void updateExistingDriver(Driver driver) {
        Disposable observable = Observable
                .create((ObservableOnSubscribe<Driver>) emitter -> {
                    Driver dr = mDriverService.updateDriverById(driver.getDriverId(), driver);
                    emitter.onNext(dr);
                    emitter.onComplete();
                })
                .subscribeOn(mSchedulerProvider.background())
                .observeOn(mSchedulerProvider.ui())
                .subscribe(this::tellViewToNavigateToNextSaveActivity, error -> mView.showError(error));
    }

    private void tellViewToCheckIfDriverExists(List<Driver> drivers) {
        mView.checkIfDriverExists(drivers);
    }
}


