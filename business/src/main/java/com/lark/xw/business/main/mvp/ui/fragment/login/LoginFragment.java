package com.lark.xw.business.main.mvp.ui.fragment.login;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.blankj.utilcode.util.SPUtils;
import com.jess.arms.di.component.AppComponent;
import com.lark.xw.business.R;
import com.lark.xw.business.main.di.component.DaggerLoginComponent;
import com.lark.xw.business.main.di.module.LoginModule;
import com.lark.xw.business.main.mvp.contract.LoginContract;
import com.lark.xw.business.main.mvp.entity.userLogin.User;
import com.lark.xw.business.main.mvp.presenter.LoginPresenter;
import com.lark.xw.business.main.mvp.ui.fragment.LarkBottomFragment;
import com.lark.xw.core.app.model.api.SpContents;
import com.lark.xw.core.fragments.MvpBaseFragment;
import com.lark.xw.imsdk.tencent.business.LoginBusiness;
import com.tencent.imsdk.TIMCallBack;

import org.simple.eventbus.EventBus;
import org.simple.eventbus.Subscriber;

import butterknife.BindView;

public class LoginFragment extends MvpBaseFragment<LoginPresenter> implements LoginContract.View, View.OnClickListener, TIMCallBack {
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
        EventBus.getDefault().register(this);
        btn_login.setOnClickListener(this);
        tv_forget_pwd.setOnClickListener(this);
        tv_register.setOnClickListener(this);
        loginAgain();

    }

    private void loginAgain() {
        String name = SPUtils.getInstance(SpContents.SP_USER_TAB_NAME).getString(SpContents.SP_USER_NAME, "");
        String pwd = SPUtils.getInstance(SpContents.SP_USER_TAB_NAME).getString(SpContents.SP_USER_PWD, "");
        String userSig = SPUtils.getInstance(SpContents.SP_USER_TAB_NAME).getString(SpContents.SP_USER_SIG, "");
        String identify = SPUtils.getInstance(SpContents.SP_USER_TAB_NAME).getString(SpContents.SP_USER_SERVER_USER_ID, "");
        if (!name.equals("") && !pwd.equals("")) {
            //登录腾信IMsdk
            Log.e(TAG, "userSig: " + userSig);
            Log.e(TAG, "identify: " + identify);
            LoginBusiness.loginIm(identify, userSig, this);
            // mPresenter.Login(new User().setUsername(name).setPassword(pwd));
        } else {
            //清除
            SPUtils.getInstance(SpContents.SP_USER_TAB_NAME).clear();
        }
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
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
                String name = ed_userName.getText().toString();
                String pwd = ed_pwd.getText().toString();
                if (!name.equals("") && !pwd.equals("")) {
                    mPresenter.Login(new User().setUsername(name).setPassword(pwd));
                } else {
                    Toast.makeText(getContext(), "请输入正确的账号密码", Toast.LENGTH_SHORT).show();
                }

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


    //注册成功更新账号显示
    @Subscriber
    public void refreshName(User user) {
        if (user != null) {
            ed_userName.setText(user.getUsername());
            ed_pwd.setText(user.getPassword());
        }
    }


    @Override
    public void loginCallback(String message, boolean islogin) {
        if (islogin) {
            // 登录腾讯IMSDK
            String id = SPUtils.getInstance(SpContents.SP_USER_TAB_NAME).getString(SpContents.SP_USER_SERVER_USER_ID, "");
            String userSig = SPUtils.getInstance(SpContents.SP_USER_TAB_NAME).getString(SpContents.SP_USER_SIG, "");
            //登录腾信IMsdk
            LoginBusiness.loginIm(id, userSig, this);


        } else {
            Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
        }

    }


    //腾讯IMSDK登录的接口回调
    @Override
    public void onError(int i, String s) {
        Log.e(TAG, "onError: " + i + "\n ,msg: " + s);
        Toast.makeText(getContext(), "IM登录失败", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSuccess() {
        getSupportDelegate().startWithPop(new LarkBottomFragment());
    }


}
