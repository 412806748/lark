package com.lark.xw.business.main.mvp.ui.fragment;

import com.lark.xw.business.main.mvp.ui.fragment.user.UserFragment;
import com.lark.xw.business.main.mvp.ui.fragment.work.WorkFragment;
import com.lark.xw.core.fragments.LarkFragment;
import com.lark.xw.core.fragments.bottom.BaseBottomDelegate;
import com.lark.xw.core.fragments.bottom.BottomTabBean;
import com.lark.xw.core.fragments.bottom.ItemBuilder;

import java.util.LinkedHashMap;

public class LarkBottomFragment extends BaseBottomDelegate {
    @Override
    public LinkedHashMap<BottomTabBean, LarkFragment> setItems(ItemBuilder itemBuilder) {
        final LinkedHashMap<BottomTabBean, LarkFragment> items = new LinkedHashMap<>();
        items.put(new BottomTabBean("{fa-commenting-o}", "任务"), new WorkFragment());
        items.put(new BottomTabBean("{fa-user}", "我的"), new UserFragment());
        return itemBuilder.addItems(items).buid();
    }



    @Override
    public int setIndexDelegate() {
        return 0;
    }

    @Override
    public int setClickedColor() {
        return 0;
    }


    @Override
    public int setTitleBar() {
        return 0;
    }

    @Override
    public int setStatusBarView() {
        return 0;
    }

    @Override
    public void post(Runnable runnable) {

    }
}
