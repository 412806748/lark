package com.lark.xw.business.main.mvp.ui.fragment;

import android.os.Binder;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jess.arms.di.component.AppComponent;
import com.lark.xw.business.R;
import com.lark.xw.business.main.di.component.DaggerMessageComponent;
import com.lark.xw.business.main.di.module.MessageModule;
import com.lark.xw.business.main.mvp.contract.MessageContract;
import com.lark.xw.business.main.mvp.presenter.MessagePresenter;
import com.lark.xw.core.fragments.MvpBaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MessageFragment extends MvpBaseFragment<MessagePresenter> implements MessageContract.View {

    @BindView(R.id.id_tv_message)
    TextView textView;

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
        return R.layout.fragment_message;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View rootView) {
        ButterKnife.bind(this, rootView);
        mPresenter.getMessage();

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
        textView.setText(sting);
    }
}
