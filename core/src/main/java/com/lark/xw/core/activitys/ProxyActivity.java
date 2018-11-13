package com.lark.xw.core.activitys;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.FrameLayout;

import com.gyf.barlibrary.ImmersionBar;
import com.lark.xw.core.R;
import com.lark.xw.core.fragments.BaseDelegate;

import me.yokeyword.fragmentation.SupportActivity;

/**
 * Created by jx on 2018/5/3.
 */

public abstract class ProxyActivity extends SupportActivity {

    public abstract BaseDelegate setRootDelegate();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initContainer(savedInstanceState);
        //初始化状态栏
        ImmersionBar.with(this)
                //.statusBarDarkFont(true)
                .keyboardEnable(true)
                .init();
    }

    private void initContainer(@Nullable Bundle savedInstanceState) {
        final FrameLayout contentFrameLayout = new FrameLayout(this);
        contentFrameLayout.setId(R.id.delegate_container);
        setContentView(contentFrameLayout);
        //初始化根fragment
        if (savedInstanceState == null) {
            loadRootFragment(R.id.delegate_container, setRootDelegate());
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.gc();
        System.runFinalization();
        ImmersionBar.with(this).destroy();
    }
}
