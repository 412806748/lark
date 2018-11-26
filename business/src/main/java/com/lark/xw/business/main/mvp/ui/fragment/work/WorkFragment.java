package com.lark.xw.business.main.mvp.ui.fragment.work;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.Toolbar;
import android.util.JsonToken;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.flyco.tablayout.widget.MsgView;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.widget.CustomPopupWindow;
import com.lark.xw.business.R;
import com.lark.xw.business.main.di.component.DaggerMessageComponent;
import com.lark.xw.business.main.di.module.MessageModule;
import com.lark.xw.business.main.mvp.contract.MessageContract;
import com.lark.xw.business.main.mvp.entity.TabEntity;
import com.lark.xw.business.main.mvp.presenter.MessagePresenter;
import com.lark.xw.core.fragments.MvpBaseFragment;
import com.lark.xw.core.utils.ppw.popupwindowUtil;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class WorkFragment extends MvpBaseFragment<MessagePresenter> implements MessageContract.View, OnTabSelectListener, ViewPager.OnPageChangeListener {
    @BindView(R.id.id_message_tabLayout)
    public CommonTabLayout tabLayout;
    @BindView(R.id.id_message_viewPager)
    public ViewPager viewPager;
    @BindView(R.id.id_toolbar)
    public Toolbar mToolbar;


    //
    private String[] mTitles = {"信息", "项目", "任务"};

    private int[] mIconUnselectIds = {
            R.mipmap.pic_more_32px, R.mipmap.pic_more_32px,
            R.mipmap.pic_more_32px};

    private int[] mIconSelectIds = {
            R.mipmap.pic_more_32px, R.mipmap.pic_more_32px,
            R.mipmap.pic_more_32px};

    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();

    @Override
    public void setupFragmentComponent(@NonNull AppComponent appComponent) {
        DaggerMessageComponent
                .builder()
                .messageModule(new MessageModule(this))
                .appComponent(appComponent)
                .build()
                .inject(this);

    }

    //使用setLayout设置
    @Override
    public View initView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return null;
    }


    @SuppressLint("CheckResult")
    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
    }

    @Override
    public void setData(@Nullable Object data) {

    }

    @Override
    public void showMessage(@NonNull String message) {

    }

    @Override
    public Object setLayout() {
        return R.layout.fragment_work;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View rootView) {
        ButterKnife.bind(this, rootView);
        setTabLayout();

    }

    @Override
    public int setTitleBar() {
        return R.id.id_toolbar;
    }

    @Override
    public int setStatusBarView() {
        return 0;
    }

    @Override
    public void post(Runnable runnable) {

    }

    @Override
    public void setMessage(String sting) {

    }


    @SuppressLint("Range")
    private void setTabLayout() {
        for (int i = 0; i < mTitles.length; i++) {
            mTabEntities.add(new TabEntity(mTitles[i], mIconSelectIds[i], mIconUnselectIds[i]));
        }
        tabLayout.setTabData(mTabEntities);
        tabLayout.setOnTabSelectListener(this);
        tabLayout.setCurrentTab(0);

        for (int i = 0; i < mTitles.length; i++) {
            MsgView msgVieww = tabLayout.getMsgView(i);
            if (msgVieww != null) {
                msgVieww.setBackgroundColor(Color.alpha(0));
                msgVieww.setTextColor(Color.RED);
                msgVieww.setTextSize(9);
            }
            tabLayout.showMsg(i, i + 11);
            tabLayout.setMsgMargin(i, 0, 10);
        }
        tabLayout.hideMsg(1);
        tabLayout.hideMsg(2);
        //
        viewPager.setAdapter(new WorkVpAdapter(getChildFragmentManager(), mTitles));
        viewPager.addOnPageChangeListener(this);
        viewPager.setCurrentItem(0);
        viewPager.setOffscreenPageLimit(3);
    }


    @Override
    public void onTabSelect(int position) {
        viewPager.setCurrentItem(position);
        //根据不同的title设置toolbar的相关属性

    }

    @Override
    public void onTabReselect(int position) {

    }

    //
    @Override
    public void onPageScrolled(int i, float v, int i1) {

    }

    @Override
    public void onPageSelected(int i) {
        tabLayout.setCurrentTab(i);
        //根据不同的title设置toolbar的相关属性


    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }


    //右上角点击更多按钮
    @OnClick(R.id.id_work_more)
    public void clickMore() {
        popupwindowUtil.create().showPPw(getActivity(), R.layout.ppw_work_more, LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT, mToolbar
                , Gravity.TOP | Gravity.RIGHT,
                30, mToolbar.getHeight() + 30, new popupwindowUtil.ClickListener() {
                    @Override
                    public void setUplistener(popupwindowUtil.PopBuilder builder) {
                        TextView tv_addProject = builder.getView(R.id.id_add_project);
                        TextView tv_addTask = builder.getView(R.id.id_add_task);
                        TextView tv_addFriend = builder.getView(R.id.id_add_friend);
                        TextView tv_scan = builder.getView(R.id.id_add_scan);


                    }
                });
    }


}
