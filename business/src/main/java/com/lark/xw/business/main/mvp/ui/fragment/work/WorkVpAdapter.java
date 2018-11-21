package com.lark.xw.business.main.mvp.ui.fragment.work;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.lark.xw.core.fragments.LarkFragment;

import java.util.ArrayList;
import java.util.List;

public class WorkVpAdapter extends FragmentPagerAdapter {
    private List<LarkFragment> FRAGMENT = new ArrayList<>();
    private String[] mTitles;

    public WorkVpAdapter(FragmentManager fm, String[] strings) {
        super(fm);
        FRAGMENT.add(new MsgFragment());
        FRAGMENT.add(new ProjectFragment());
        FRAGMENT.add(new TaskFragment());
        mTitles = strings;
    }

    @Override
    public Fragment getItem(int i) {
        return FRAGMENT.get(i);
    }

    @Override
    public int getCount() {
        return FRAGMENT.size();
    }


    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }


}
