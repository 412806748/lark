package com.lark.xw.business.main.mvp.ui.fragment.login;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.jess.arms.di.component.AppComponent;
import com.lark.xw.business.R;
import com.lark.xw.business.main.di.component.DaggerLoginComponent;
import com.lark.xw.business.main.di.module.LoginModule;
import com.lark.xw.business.main.mvp.contract.ContactsContract;
import com.lark.xw.business.main.mvp.presenter.LoginPresenter;
import com.lark.xw.core.fragments.MvpBaseFragment;

import butterknife.BindView;

public class LoginFragment extends MvpBaseFragment<LoginPresenter> implements ContactsContract.View, View.OnClickListener {
    @BindView(R.id.id_login_ed_name)
    public TextInputEditText ed_userName;
    @BindView(R.id.id_login_ed_pwd)
    public TextInputEditText ed_pwd;
    @BindView(R.id.id_btn_login)
    public Button btn_login;
    @BindView(R.id.id_login_forget_pwd)
    public TextView tv_forget_pwd;
    @BindView(R.id.id_register)
    public TextView tv_register;

    @Override
    public void setupFragmentComponent(@NonNull AppComponent appComponent) {
        DaggerLoginComponent.builder()
                .appComponent(appComponent)
                .loginModule(new LoginModule(this))
                .build()
                .inject(this);


    }

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
        return R.layout.fgm_login;
    }


    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View rootView) {
        btn_login.setOnClickListener(this);
        tv_forget_pwd.setOnClickListener(this);
        tv_register.setOnClickListener(this);

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
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.id_btn_login:
                //登录


                break;
            case R.id.id_login_forget_pwd:
                //忘记密码

                break;
            case R.id.id_register:
                //前往注册
                getSupportDelegate().start(RegisterFragment.create());
                break;

        }


    }
}
