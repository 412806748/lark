package com.lark.xw.business.main.mvp.ui.fragment.work;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.View;
import android.widget.TextView;

import com.lark.xw.business.R;
import com.lark.xw.business.main.mvp.ui.fragment.work.msg.MsgChildActionFragment;
import com.lark.xw.business.main.mvp.ui.fragment.work.msg.MsgChildCompleteFragment;
import com.lark.xw.core.fragments.LarkFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public abstract class WorkChildBaseFragment extends LarkFragment implements ViewPager.OnPageChangeListener, View.OnClickListener {
    @BindView(R.id.id_work_message_viewPager)
    public ViewPager viewPager;
    @BindView(R.id.id_ln_work_msg_action)
    public LinearLayoutCompat ln_action;

    @BindView(R.id.id_tv_work_msg_action)
    public TextView tv_action;

    @BindView(R.id.id_ln_work_msg_complete)
    public LinearLayoutCompat ln_complete;

    @BindView(R.id.id_tv_work_msg_complete)
    public TextView tv_complete;
    //

    @Override
    public Object setLayout() {
        return R.layout.fragment_work_tabs;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View rootView) {
        setViewPager();
        ln_action.setOnClickListener(this);
        ln_complete.setOnClickListener(this);
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

    private void setViewPager() {
        viewPager.setAdapter(new WorkChildVpAdapter(getChildFragmentManager(), setChildFragments()));
        viewPager.setOffscreenPageLimit(2);
        viewPager.addOnPageChangeListener(this);
    }


    public abstract List<LarkFragment> setChildFragments();


    @Override
    public void onPageScrolled(int i, float v, int i1) {

    }

    @Override
    public void onPageSelected(int i) {
        if (i == 0) {
            setAction();

        } else if (i == 1) {
            setComplete();
        }
    }


    @Override
    public void onPageScrollStateChanged(int i) {

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.id_ln_work_msg_action:
                setAction();
                //
                viewPager.setCurrentItem(0);
                break;

            case R.id.id_ln_work_msg_complete:
                setComplete();
                //
                viewPager.setCurrentItem(1);

                break;


        }
    }

    private void setComplete() {
        tv_complete.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
        tv_complete.setTextColor(Color.BLACK);
        tv_action.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
        tv_action.setTextColor(Color.GRAY);
    }


    private void setAction() {
        tv_action.setTextColor(Color.BLACK);
        tv_action.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
        tv_complete.setTextColor(Color.GRAY);
        tv_complete.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
    }

}
