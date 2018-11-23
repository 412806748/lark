package com.lark.xw.business.main.mvp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.ArmsUtils;

import com.lark.xw.business.R;
import com.lark.xw.business.main.di.component.DaggerMainComponent;
import com.lark.xw.business.main.di.module.MainModule;
import com.lark.xw.business.main.mvp.contract.MainContract;
import com.lark.xw.business.main.mvp.presenter.MainPresenter;
import com.lark.xw.business.main.mvp.ui.fragment.LarkBottomFragment;
import com.lark.xw.core.activitys.MvpProxyBaseActivity;
import com.lark.xw.core.fragments.BaseDelegate;


import static com.jess.arms.utils.Preconditions.checkNotNull;


/**
 * 继承MvpProxyBaseActivity后，作为单Activity的入口
 */
public class MainActivity extends MvpProxyBaseActivity<MainPresenter> implements MainContract.View {

    @Override
    public void setupActivityComponent(@NonNull AppComponent appComponent) {
        DaggerMainComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .mainModule(new MainModule(this))
                .build()
                .inject(this);
    }

    @Override
    public int initView(@Nullable Bundle savedInstanceState) {
        return 0; //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {

    }

    @Override
    public void showLoading() {


    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showMessage(@NonNull String message) {
        checkNotNull(message);
        ArmsUtils.snackbarText(message);
    }

    @Override
    public void launchActivity(@NonNull Intent intent) {
        checkNotNull(intent);
        ArmsUtils.startActivity(intent);
    }

    @Override
    public void killMyself() {
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public BaseDelegate setRootDelegate() {
        return new LarkBottomFragment();
    }
}
