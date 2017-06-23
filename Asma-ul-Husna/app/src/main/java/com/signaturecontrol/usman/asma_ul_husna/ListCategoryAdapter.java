package com.signaturecontrol.usman.asma_ul_husna;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Usman on 3/14/2017.
 */
public class ListCategoryAdapter extends FragmentPagerAdapter {
    private Context context;
    @Override
    public Fragment getItem(int position) {
        if (position == 0)
        {
            return new AllahNamesFragment();
        }
        else
        {
            return new ProphetsFragment();
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    public ListCategoryAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return "Allah";
        }  else {
            return "Prophets";
        }
    }
}
