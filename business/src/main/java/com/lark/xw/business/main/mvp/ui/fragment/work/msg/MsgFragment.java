package com.lark.xw.business.main.mvp.ui.fragment.work.msg;

import com.lark.xw.business.main.mvp.ui.fragment.work.WorkChildBaseFragment;
import com.lark.xw.core.fragments.LarkFragment;

import java.util.ArrayList;
import java.util.List;

public class MsgFragment extends WorkChildBaseFragment {

    @Override
    public List<LarkFragment> setChildFragments() {
        List<LarkFragment> fragments = new ArrayList<>();
        fragments.add(new MsgChildActionFragment());
        fragments.add(new MsgChildCompleteFragment());
        return fragments;
    }


}
