package com.lark.xw.business.main.mvp.ui.fragment.work;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.jess.arms.di.component.AppComponent;
import com.lark.xw.business.R;
import com.lark.xw.business.main.di.component.DaggerMessageComponent;
import com.lark.xw.business.main.di.module.MessageModule;
import com.lark.xw.business.main.mvp.contract.MessageContract;
import com.lark.xw.business.main.mvp.entity.TabEntity;
import com.lark.xw.business.main.mvp.presenter.MessagePresenter;
import com.lark.xw.core.app.utils.dimen.DimenUtil;
import com.lark.xw.core.fragments.MvpBaseFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WorkFragment extends MvpBaseFragment<MessagePresenter> implements MessageContract.View, OnTabSelectListener, ViewPager.OnPageChangeListener {
    @BindView(R.id.id_message_tabLayout)
    public CommonTabLayout tabLayout;
    @BindView(R.id.id_message_viewPager)
    public ViewPager viewPager;

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


    private String[] mTitles = {"信息", "项目", "任务"};

    private int[] mIconUnselectIds = {
            R.mipmap.ic_launcher, R.mipmap.ic_launcher,
            R.mipmap.ic_launcher};

    private int[] mIconSelectIds = {
            R.mipmap.ic_launcher, R.mipmap.ic_launcher,
            R.mipmap.ic_launcher};

    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();

    private void setTabLayout() {
        for (int i = 0; i < mTitles.length; i++) {
            mTabEntities.add(new TabEntity(mTitles[i], mIconSelectIds[i], mIconUnselectIds[i]));
        }
        tabLayout.setTabData(mTabEntities);
        tabLayout.setOnTabSelectListener(this);
        tabLayout.setCurrentTab(0);
        //
        viewPager.setAdapter(new WorkVpAdapter(getChildFragmentManager(), mTitles));
        viewPager.addOnPageChangeListener(this);
        viewPager.setCurrentItem(0);


    }


    @Override
    public void onTabSelect(int position) {
        viewPager.setCurrentItem(position);
    }

    @Override
    public void onTabReselect(int position) {

    }

    @Override
    public void onPageScrolled(int i, float v, int i1) {

    }

    @Override
    public void onPageSelected(int i) {
        tabLayout.setCurrentTab(i);
    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }


}
