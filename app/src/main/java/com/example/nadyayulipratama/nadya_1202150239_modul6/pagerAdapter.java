package com.example.nadyayulipratama.nadya_1202150239_modul6;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by nadya yuli pratama on 01/04/2018.
 */

public class pagerAdapter extends FragmentStatePagerAdapter {
    int mNoOfTabs;

    public pagerAdapter(FragmentManager fm, int NumberOfTabs)
    {
        super(fm);
        this.mNoOfTabs = NumberOfTabs;
    }


    @Override
    public Fragment getItem(int position) {
        switch(position)
        {

            case 0:
                TERBARU terbaru = new TERBARU();
                return terbaru;
            case 1:
               FOTOSAYA fotosaya = new FOTOSAYA();
                return  fotosaya;

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNoOfTabs;
    }
}


