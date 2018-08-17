package com.avium.extrasum.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import com.avium.extrasum.Custom_View_Pager;

import java.util.ArrayList;
import java.util.List;

public class PagerAdapter extends FragmentPagerAdapter {
    private final List<Fragment> mFragments = new ArrayList<>();
    private int mCurrentPosition = -1;

    public PagerAdapter(FragmentManager manager) {
        super(manager);
    }




    public void addFragment(Fragment fragment) {
        mFragments.add(fragment);
        notifyDataSetChanged();
    }
    @Override
    public void setPrimaryItem(ViewGroup container, int position, Object object) {
        super.setPrimaryItem(container, position, object);
//        if (position != mCurrentPosition) {
//            Fragment fragment = (Fragment) object;
//            Custom_View_Pager pager = (Custom_View_Pager) container;
//            if (fragment != null && fragment.getView() != null) {
//                mCurrentPosition = position;
//                pager.measureCurrentView(fragment.getView());
//            }
//        }
    }
    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }
}
