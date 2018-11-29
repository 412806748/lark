package com.lark.xw.business.main.mvp.ui.fragment.login;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.lark.xw.business.R;
import com.lark.xw.business.main.mvp.entity.userLogin.Register;
import com.lark.xw.business.main.mvp.entity.userLogin.User;
import com.lark.xw.core.app.model.api.Api;
import com.lark.xw.core.fragments.LarkFragment;
import com.lark.xw.core.net.RestClient;
import com.lark.xw.core.net.callback.IError;
import com.lark.xw.core.net.callback.ISuccess;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import org.json.JSONObject;
import org.simple.eventbus.EventBus;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;

public class RegisterFragment extends LarkFragment {
    @BindView(R.id.id_login_ed_name)
    public TextInputEditText ed_userName;
    @BindView(R.id.id_login_ed_pwd)
    public TextInputEditText ed_pwd;
    private final String TAG = "RegisterFragment ";

    public static RegisterFragment create() {
        return new RegisterFragment();
    }

    @Override
    public Object setLayout() {
        return R.layout.fgm_register;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View rootView) {

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

    @OnClick(R.id.id_back)
    public void back() {
        getSupportDelegate().pop();
    }

    @OnClick(R.id.id_btn_register)
    public void regist() {
        //注册
        String userName = ed_userName.getText().toString();
        String pwd = ed_pwd.getText().toString();
        if (!userName.equals("") && !pwd.equals("")) {
            //  register(pwd, userName);

            retrofitPostReg(userName, pwd);


        } else {
            Toast.makeText(getContext(), "请输入正确的账号密码", Toast.LENGTH_SHORT).show();
        }

    }

    private void retrofitPostReg(String userName, String pwd) {
        User user = new User().setUsername(userName).setPassword(pwd);
        String regesterInfo = JSON.toJSON(user).toString();
        Log.d(TAG, "regist: " + regesterInfo);
        RestClient.builder()
                .url(Api.REGESTER_URL)
                .raw(regesterInfo)
                .success(new ISuccess() {
                    @Override
                    public void onSuccess(String response) {
                        Log.d(TAG, "onSuccess: " + response);
                        Register register = JSON.parseObject(response, Register.class);
                        if (register.getSuccess() == 0) {
                            Toast.makeText(getContext(), register.getMessage(), Toast.LENGTH_SHORT).show();
                        } else if (register.getSuccess() == 1) {
                            Toast.makeText(getContext(), register.getMessage(), Toast.LENGTH_SHORT).show();
                            //post到LoginFragment
                            EventBus.getDefault().post(user);
                            getSupportDelegate().pop();
                        }
                    }
                })
                .error(new IError() {
                           @Override
                           public void onError(int code, String msg) {
                               Toast.makeText(getContext(), "网络连接异常: ", Toast.LENGTH_SHORT).show();
                           }
                       }
                ).build()
                .post();
    }


}
