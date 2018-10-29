package com.mystique.rt.getmydrivercardapplcation.views.applications.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.mystique.rt.getmydrivercardapplcation.views.applications.fragments.NameChangeFragment;
import com.mystique.rt.getmydrivercardapplcation.views.applications.fragments.PersonalInfoFragment;
import com.mystique.rt.getmydrivercardapplcation.views.applications.fragments.PictureFragment;
import com.mystique.rt.getmydrivercardapplcation.views.applications.fragments.SignDeclarationFragment;

public class NameReplacementAdapter extends FragmentStatePagerAdapter {

    public NameReplacementAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0: return "Personal Info";
            case 1: return "Selfie"; // trying to combine in one camera 2 pictures
            case 2: return "Driving Licence Pic";
            case 3: return "New names";
            case 4: return "Declaration and sign";
            default: return null;
        }
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0: return new PersonalInfoFragment();
            case 1: return new PictureFragment();
            case 2: return new PictureFragment();
            case 3: return new NameChangeFragment();
            case 4: return new SignDeclarationFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 5;
    }
}
