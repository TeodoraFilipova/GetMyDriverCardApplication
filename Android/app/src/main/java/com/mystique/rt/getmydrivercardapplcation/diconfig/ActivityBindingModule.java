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


    @ActivityScoped
    @ContributesAndroidInjector()
    abstract StatusCheckActivity statusCheckActivity();

    @ActivityScoped
    @ContributesAndroidInjector()
    abstract LogInActivity logInActivity();

    @ActivityScoped
    @ContributesAndroidInjector
    abstract CardApplicationFormsListActivity cardApplicationFormsListActivity();

    @ActivityScoped
    @ContributesAndroidInjector()
    abstract CardApplicationDetailsActivity detailsActivity();


    @ActivityScoped
    @ContributesAndroidInjector()
    abstract ContactsActivity contactsActivity();

}
