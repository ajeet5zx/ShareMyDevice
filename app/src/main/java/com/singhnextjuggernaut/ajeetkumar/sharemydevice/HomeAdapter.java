package com.singhnextjuggernaut.ajeetkumar.sharemydevice;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/*
CREATED BY AJEET SINGH
*/public class HomeAdapter extends FragmentStatePagerAdapter {

    int tabCount;

    public HomeAdapter(FragmentManager fm) {
        super(fm);
        this.tabCount=tabCount;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                AndroidFragment tab1 = new AndroidFragment();
                return tab1;
            case 1:
                IosFragment tab2 = new IosFragment();
                return tab2;
            case 2:
                CableFragment tab3 = new CableFragment();
                return tab3;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}
