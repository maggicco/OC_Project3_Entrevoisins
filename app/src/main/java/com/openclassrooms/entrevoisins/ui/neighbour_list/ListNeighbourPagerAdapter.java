package com.openclassrooms.entrevoisins.ui.neighbour_list;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


public class ListNeighbourPagerAdapter extends FragmentPagerAdapter {

    private int numberOfTabs;

    public ListNeighbourPagerAdapter(FragmentManager fm, int numberOfTabs) {

        super(fm);
        this.numberOfTabs = numberOfTabs;
    }

    /**
     * getItem is called to instantiate the fragment for the given page.
     * @param position
     * @return
     */
    @Override
    public Fragment getItem(int position) {

        //switching Tabs
        switch (position) {

            case 0:
                return new NeighbourFragment();
            case 1:
                return new FavoriteListNeighbourFragment();
            default:
                return null;

        }
    }

    /**
     * get the number of pages
     * @return
     */
    @Override
    public int getCount() {
        return numberOfTabs;
    }
}