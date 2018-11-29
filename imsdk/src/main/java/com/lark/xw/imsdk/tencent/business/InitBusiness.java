package com.lark.xw.imsdk.tencent.business;

import android.content.Context;
import android.util.Log;

import com.lark.xw.imsdk.tencent.TencentContents;
import com.lark.xw.imsdk.tencent.event.FriendshipEvent;
import com.lark.xw.imsdk.tencent.event.GroupEvent;
import com.lark.xw.imsdk.tencent.event.MessageEvent;
import com.lark.xw.imsdk.tencent.event.RefreshEvent;
import com.tencent.imsdk.TIMConnListener;
import com.tencent.imsdk.TIMLogLevel;
import com.tencent.imsdk.TIMManager;
import com.tencent.imsdk.TIMSdkConfig;
import com.tencent.imsdk.TIMUserConfig;
import com.tencent.imsdk.TIMUserStatusListener;


/**
 * 初始化
 * 包括imsdk等
 */
public class InitBusiness {

    private static final String TAG = InitBusiness.class.getSimpleName();


    public static void start(Context context) {
        initImsdk(context, 0);
        initUserConfig();
    }

    public static void start(Context context, int logLevel) {
        initImsdk(context, logLevel);
        initUserConfig();
    }


    /**
     * 初始化imsdk
     */
    private static void initImsdk(Context context, int logLevel) {
        TIMSdkConfig config = new TIMSdkConfig(TencentContents.SDK_APPID);
        config.enableLogPrint(true)
                .setAccoutType(TencentContents.ACCOUNT_TYPE + "")
                .setLogLevel(TIMLogLevel.values()[logLevel]);
        //初始化imsdk
        boolean init = TIMManager.getInstance().init(context, config);
        //禁止服务器自动代替上报已读
        Log.d(TAG, "initIMsdk:  " + init);
        Log.d(TAG, "Version:  " + TIMManager.getInstance().getVersion());

    }


    private static void initUserConfig() {
        //基本用户配置
        TIMUserConfig userConfig = new TIMUserConfig()
                .setUserStatusListener(new TIMUserStatusListener() {
                    @Override
                    public void onForceOffline() {
                        //被其他终端踢下线
                        Log.i(TAG, "onForceOffline");
//                        App.TOKEN = "";
//                        UserControl.getInstance().clear();
//                        DataCleanManager.clearAllCache(getContext());
//                        PageRouter.startLogin(getContext());
//                        finish();
                    }

                    @Override
                    public void onUserSigExpired() {
                        //用户签名过期了，需要刷新userSig重新登录SDK
                        Log.i(TAG, "onUserSigExpired");
                    }
                })
                //设置连接状态事件监听器
                .setConnectionListener(new TIMConnListener() {
                    @Override
                    public void onConnected() {
                        Log.i(TAG, "onConnected");
                    }

                    @Override
                    public void onDisconnected(int code, String desc) {
                        Log.i(TAG, "onDisconnected");
                    }

                    @Override
                    public void onWifiNeedAuth(String name) {
                        Log.i(TAG, "onWifiNeedAuth");
                    }
                });
        RefreshEvent.getInstance().init(userConfig);
        userConfig = FriendshipEvent.getInstance().init(userConfig);
        userConfig = MessageEvent.getInstance().init(userConfig);
        userConfig = GroupEvent.getInstance().init(userConfig);
        //将用户配置与通讯管理器进行绑定
        TIMManager.getInstance().setUserConfig(userConfig);

    }


    public interface OffLineNotify {
        void exit();
    }


}
