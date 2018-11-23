package com.lark.xw.business.main.mvp.ui.fragment.work;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.lark.xw.core.fragments.LarkFragment;

import java.util.List;

public class WorkChildVpAdapter extends FragmentPagerAdapter {
    private List<LarkFragment> FRAGMENT;

    public WorkChildVpAdapter(FragmentManager fm, List<LarkFragment> fragments) {
        super(fm);
        FRAGMENT = fragments;
    }

    @Override
    public Fragment getItem(int i) {
        return FRAGMENT.get(i);
    }

    @Override
    public int getCount() {
        return FRAGMENT.size();
    }


}
