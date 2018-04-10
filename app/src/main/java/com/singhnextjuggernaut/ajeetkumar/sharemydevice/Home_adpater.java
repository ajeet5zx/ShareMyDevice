package com.singhnextjuggernaut.ajeetkumar.sharemydevice;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/*
CREATED BY AJEET SINGH
*/public class Home_adpater extends FragmentStatePagerAdapter{

    int tabCount;

    public Home_adpater(FragmentManager fm) {
        super(fm);
        this.tabCount=tabCount;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                Android_Fragment tab1 = new Android_Fragment();
                return tab1;
            case 1:
                IosFragment tab2 = new IosFragment();
                return tab2;
            case 2:
                Cables_fragment tab3 = new Cables_fragment();
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
