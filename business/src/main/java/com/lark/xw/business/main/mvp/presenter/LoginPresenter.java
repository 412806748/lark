package com.lark.xw.business.main.mvp.presenter;

import android.app.Application;
import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.blankj.utilcode.util.SPUtils;
import com.jess.arms.di.scope.FragmentScope;
import com.jess.arms.http.imageloader.ImageLoader;
import com.jess.arms.integration.AppManager;
import com.jess.arms.mvp.BasePresenter;
import com.lark.xw.business.main.mvp.contract.LoginContract;
import com.lark.xw.business.main.mvp.entity.userLogin.LoginInfo;
import com.lark.xw.business.main.mvp.entity.userLogin.User;
import com.lark.xw.core.app.model.api.SpContents;
import com.lark.xw.core.net.callback.IError;
import com.lark.xw.core.net.callback.IFailure;
import com.lark.xw.core.net.callback.ISuccess;

import javax.inject.Inject;

import me.jessyan.rxerrorhandler.core.RxErrorHandler;


@FragmentScope
public class LoginPresenter extends BasePresenter<LoginContract.Model, LoginContract.View> {
    @Inject
    RxErrorHandler mErrorHandler;
    @Inject
    Application mApplication;
    @Inject
    ImageLoader mImageLoader;
    @Inject
    AppManager mAppManager;

    @Inject
    public LoginPresenter(LoginContract.Model model, LoginContract.View rootView) {
        super(model, rootView);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mErrorHandler = null;
        this.mAppManager = null;
        this.mImageLoader = null;
        this.mApplication = null;
    }

    public void Login(User user) {
        mModel.loginRequest(user).success(new ISuccess() {
            @Override
            public void onSuccess(String response) {
                LoginInfo loginInfo = JSON.parseObject(response, LoginInfo.class);
                if (loginInfo.getSuccess() == 1) {
                    //存储数据
                    SPUtils.getInstance(SpContents.SP_USER_TAB_NAME).put(SpContents.SP_USER_NAME, user.getUsername());
                    SPUtils.getInstance(SpContents.SP_USER_TAB_NAME).put(SpContents.SP_USER_PWD, user.getPassword());
                    SPUtils.getInstance(SpContents.SP_USER_TAB_NAME).put(SpContents.SP_USER_SERVER_USER_ID, loginInfo.getData().getUserid() + "");
                    SPUtils.getInstance(SpContents.SP_USER_TAB_NAME).put(SpContents.SP_USER_SIG, loginInfo.getData().getSig());
                    SPUtils.getInstance(SpContents.SP_USER_TAB_NAME).put(SpContents.SP_USER_TIME, loginInfo.getData().getServertime());
                    SPUtils.getInstance(SpContents.SP_USER_TAB_NAME).put(SpContents.SP_USER_TOKEN, loginInfo.getData().getToken());
                    //
                    mRootView.loginCallback(loginInfo.getMessage(), true);
                } else if (loginInfo.getSuccess() == 0) {
                    SPUtils.getInstance(SpContents.SP_USER_TAB_NAME).clear();
                    mRootView.loginCallback(loginInfo.getMessage(), false);
                }
            }
        }).error(new IError() {
            @Override
            public void onError(int code, String msg) {
                Log.e(TAG, "onError: " + code + "\n" + msg);
                mRootView.loginCallback("服务器异常,code: " + code, false);
            }
        }).failure(new IFailure() {
            @Override
            public void onFailure(Throwable t) {
                Log.e(TAG, "onFailure: " + t.getMessage());
                mRootView.loginCallback("请求失败", false);
            }
        }).build()
                .post();

    }


}
