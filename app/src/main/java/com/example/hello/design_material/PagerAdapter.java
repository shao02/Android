/**
 *
 */
package com.example.hello.design_material;

import java.util.List;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

/**
 * The <code>PagerAdapter</code> serves the fragments when paging.
 * @author mwho
 */
public class PagerAdapter extends FragmentPagerAdapter {
    private String[] titles = new String[]{
      "Tab 1","Tab 2","Tab 3"
    };
    private List<Fragment> fragments;
    private ViewPager pager;
    /**
     * @param fm
     * @param fragments
     */
    public PagerAdapter(FragmentManager fm, List<Fragment> fragments,ViewPager pager) {
        super(fm);
        this.fragments = fragments;
        this.pager = pager;
    }
    /* (non-Javadoc)
     * @see android.support.v4.app.FragmentPagerAdapter#getItem(int)
     */
    @Override
    public Fragment getItem(int position) {
        pager.setCurrentItem(position);
        return this.fragments.get(position);
    }

    /* (non-Javadoc)
     * @see android.support.v4.view.PagerAdapter#getCount()
     */
    @Override
    public int getCount() {
        return this.fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // return your title there
        return titles[position];
    }
}