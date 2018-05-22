package com.example.android.tourguideapp;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


public class CategoryAdapter extends FragmentPagerAdapter {

    // A context variable to add the name of the tabs via string resources. More information about
    //the code used can be found under:
    // https://stackoverflow.com/questions/31030580/unable-to-use-strings-for-tab-names
    Context mContext;

    public CategoryAdapter(FragmentManager fm, Context context) {
        super(fm);
        mContext = context;
    }

    // A context variable to add the name of the tabs via string resources.
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new HomeFragment();
        } else if (position == 1) {
            return new VillageFragment();
        } else if (position == 2) {
            return new WineFragment();
        } else if (position == 3) {
            return new HospitalityFragment();
        } else {
            return new FolkloreFragment();
        }
    }

    // Get the amount of tabs.
    @Override
    public int getCount() {
        int tabAmount = 5;
        return tabAmount;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        if (position == 0) {
            return mContext.getResources().getString(R.string.home);
        } else if (position == 1) {
            return mContext.getResources().getString(R.string.village);
        } else if (position == 2) {
            return mContext.getResources().getString(R.string.wine);
        } else if (position == 3) {
            return mContext.getResources().getString(R.string.hospitality);
        } else {
            return mContext.getResources().getString(R.string.folklore);
        }
    }
}
