package com.lark.xw.business.main.mvp.ui.fragment.work;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import com.lark.xw.business.R;
import com.lark.xw.core.fragments.LarkFragment;

public class MsgFragment extends LarkFragment {
    @Override
    public Object setLayout() {
        return R.layout.fragment_contacts;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View rootView) {

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
