package com.lark.xw.business.main.mvp.model;

import android.app.Application;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.jess.arms.di.scope.FragmentScope;
import com.jess.arms.integration.IRepositoryManager;
import com.jess.arms.mvp.BaseModel;
import com.lark.xw.business.main.mvp.contract.LoginContract;
import com.lark.xw.business.main.mvp.entity.userLogin.Register;
import com.lark.xw.business.main.mvp.entity.userLogin.User;
import com.lark.xw.core.app.model.api.Api;
import com.lark.xw.core.net.RestClient;
import com.lark.xw.core.net.RestClientBuilder;
import com.lark.xw.core.net.callback.IError;
import com.lark.xw.core.net.callback.IFailure;
import com.lark.xw.core.net.callback.ISuccess;

import javax.inject.Inject;


@FragmentScope
public class LoginModel extends BaseModel implements LoginContract.Model {
    @Inject
    Gson mGson;
    @Inject
    Application mApplication;

    @Inject
    public LoginModel(IRepositoryManager repositoryManager) {
        super(repositoryManager);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mGson = null;
        this.mApplication = null;
    }


    @Override
    public RestClientBuilder loginRequest(User user) {
        String loginJson = JSON.toJSONString(user);
        //登录操作

        return RestClient.builder()
                .url(Api.LOGIN_URL)
                .raw(loginJson);
    }


}