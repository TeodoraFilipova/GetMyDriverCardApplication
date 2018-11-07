package com.mystique.rt.getmydrivercardapplcation.diconfig;

import com.mystique.rt.getmydrivercardapplcation.views.MainActivity;
import com.mystique.rt.getmydrivercardapplcation.views.admin.applicationslist.CardApplicationFormsListActivity;
import com.mystique.rt.getmydrivercardapplcation.views.admin.details.CardApplicationDetailsActivity;
import com.mystique.rt.getmydrivercardapplcation.views.admin.login.LogInActivity;
import com.mystique.rt.getmydrivercardapplcation.views.applications.activities.AddressReplacementActivity;
import com.mystique.rt.getmydrivercardapplcation.views.applications.activities.ApplicationChooseActivity;
import com.mystique.rt.getmydrivercardapplcation.views.applications.activities.EUtoBGActivity;
import com.mystique.rt.getmydrivercardapplcation.views.applications.activities.FirstApplicationActivity;
import com.mystique.rt.getmydrivercardapplcation.views.applications.activities.LossOrTheftActivity;
import com.mystique.rt.getmydrivercardapplcation.views.applications.activities.NameReplacementActivity;
import com.mystique.rt.getmydrivercardapplcation.views.applications.activities.PictureReplacementActivity;
import com.mystique.rt.getmydrivercardapplcation.views.applications.activities.RenewalActivity;
import com.mystique.rt.getmydrivercardapplcation.views.applications.submittodatabase.step1submitselfie.SaveSelfieActivity;
import com.mystique.rt.getmydrivercardapplcation.views.applications.submittodatabase.step2submitdrivinglicense.SaveDrivingLicensePicActivity;
import com.mystique.rt.getmydrivercardapplcation.views.applications.submittodatabase.step3submitsignaturepic.SaveSignaturePicActivity;
import com.mystique.rt.getmydrivercardapplcation.views.applications.submittodatabase.step4submitnewselfie.SaveNewSelfieActivity;
import com.mystique.rt.getmydrivercardapplcation.views.applications.submittodatabase.step5submitoldcardpic.SaveOldCardPicActivity;
import com.mystique.rt.getmydrivercardapplcation.views.applications.submittodatabase.step6submitdriver.SaveDriverActivity;
import com.mystique.rt.getmydrivercardapplcation.views.applications.submittodatabase.step7submitcardapplicationform.SaveCardApplicationFormActivity;
import com.mystique.rt.getmydrivercardapplcation.views.contacts.ContactsActivity;
import com.mystique.rt.getmydrivercardapplcation.views.statuscheck.StatusCheckActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBindingModule {

    @ActivityScoped
    @ContributesAndroidInjector()
    abstract MainActivity mainActivity();

    @ActivityScoped
    @ContributesAndroidInjector()
    abstract ApplicationChooseActivity applicationChooseActivity();


    @ActivityScoped
    @ContributesAndroidInjector()
    abstract AddressReplacementActivity addressReplacementActivity();

    @ActivityScoped
    @ContributesAndroidInjector()
    abstract EUtoBGActivity eUtoBGActivity();

    @ActivityScoped
    @ContributesAndroidInjector()
    abstract FirstApplicationActivity firstApplicationActivity();

    @ActivityScoped
    @ContributesAndroidInjector()
    abstract LossOrTheftActivity lossOrTheftActivity();

    @ActivityScoped
    @ContributesAndroidInjector()
    abstract NameReplacementActivity nameReplacementActivity();

    @ActivityScoped
    @ContributesAndroidInjector()
    abstract PictureReplacementActivity pictureReplacementActivity();

    @ActivityScoped
    @ContributesAndroidInjector()
    abstract RenewalActivity renewalActivity();

//    @ActivityScoped
//    @ContributesAndroidInjector(modules = {
//            CompletedApplicationModule.class
//    })
//    abstract CompletedApplicationActivity completedApplicationActivity();

    @ActivityScoped
    @ContributesAndroidInjector(modules = {
            SaveSelfieModule.class
    })
    abstract SaveSelfieActivity saveSelfieActivity();

    @ActivityScoped
    @ContributesAndroidInjector(modules = {
            SaveDrivingLicensePicModule.class
    })
    abstract SaveDrivingLicensePicActivity saveDrivingLicensePicActivity();

    @ActivityScoped
    @ContributesAndroidInjector(modules = {
            SaveSignaturePicModule.class
    })
    abstract SaveSignaturePicActivity saveSignaturePicActivity();

    @ActivityScoped
    @ContributesAndroidInjector(modules = {
            SaveNewSelfieModule.class
    })
    abstract SaveNewSelfieActivity saveNewSelfieActivity();

    @ActivityScoped
    @ContributesAndroidInjector(modules = {
            SaveOldCardPicModule.class
    })
    abstract SaveOldCardPicActivity saveOldCardPicActivity();

    @ActivityScoped
    @ContributesAndroidInjector(modules = {
            SaveDriverModule.class
    })
    abstract SaveDriverActivity saveDriverActivity();

    @ActivityScoped
    @ContributesAndroidInjector(modules = {
            SaveCardApplicationFormModule.class
    })
    abstract SaveCardApplicationFormActivity saveCardApplicationFormActivity();


    @ActivityScoped
    @ContributesAndroidInjector(modules = {
            StatusCheckModule.class
    })
    abstract StatusCheckActivity statusCheckActivity();

    @ActivityScoped
    @ContributesAndroidInjector(modules = {
            LogInModule.class
    })
    abstract LogInActivity logInActivity();

    @ActivityScoped
    @ContributesAndroidInjector(modules = {
            CardApplicationFormsListModule.class
    })
    abstract CardApplicationFormsListActivity cardApplicationFormsListActivity();

    @ActivityScoped
    @ContributesAndroidInjector(modules = {
            CardApplicationDetailsModule.class
    })
    abstract CardApplicationDetailsActivity detailsActivity();


    @ActivityScoped
    @ContributesAndroidInjector()
    abstract ContactsActivity contactsActivity();

}
