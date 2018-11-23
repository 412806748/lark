package com.lark.xw.business.main.mvp.ui.fragment.work.task;

import com.lark.xw.business.main.mvp.ui.fragment.work.WorkChildBaseFragment;
import com.lark.xw.core.fragments.LarkFragment;

import java.util.ArrayList;
import java.util.List;

public class TaskFragment extends WorkChildBaseFragment {

    @Override
    public List<LarkFragment> setChildFragments() {
        List<LarkFragment> fragments = new ArrayList<>();
        fragments.add(new TaskChildActionFragment());
        fragments.add(new TaskChildCompleteFragment());
        return fragments;
    }


}
