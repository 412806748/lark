package com.lark.xw.core.app.config;

import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;

import com.jess.arms.base.delegate.AppLifecycles;
import com.joanzapata.iconify.Iconify;
import com.joanzapata.iconify.fonts.FontAwesomeModule;
import com.joanzapata.iconify.fonts.IoniconsModule;
import com.lark.xw.core.BuildConfig;
import com.lark.xw.core.app.LarkConfig;
import com.lark.xw.core.app.model.api.Api;
import com.lark.xw.core.ui.icon.FontLarkModule;
import com.squareup.leakcanary.LeakCanary;

import butterknife.ButterKnife;
import timber.log.Timber;

/**
 * 展示 {@link AppLifecycles} 的用法
 * Application配置入口
 */
public class AppLifecyclesImpl implements AppLifecycles {

    @Override
    public void attachBaseContext(@NonNull Context base) {
//          MultiDex.install(base);  //这里比 onCreate 先执行,常用于 MultiDex 初始化,插件化框架的初始化
    }

    @Override
    public void onCreate(@NonNull Application application) {
        //自定义全局配置
        LarkConfig.init(application)
                .withApiHost(Api.BASE_URL)
                .withIcon(new IoniconsModule())
                .withIcon(new FontAwesomeModule())
                .withIcon(new FontLarkModule())
                .configure();

        //
        if (LeakCanary.isInAnalyzerProcess(application)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        if (BuildConfig.LOG_DEBUG) {//Timber初始化
            //Timber 是一个日志框架容器,外部使用统一的Api,内部可以动态的切换成任何日志框架(打印策略)进行日志打印
            //并且支持添加多个日志框架(打印策略),做到外部调用一次 Api,内部却可以做到同时使用多个策略
            //比如添加三个策略,一个打印日志,一个将日志保存本地,一个将日志上传服务器
            Timber.plant(new Timber.DebugTree());
            // 如果你想将框架切换为 Logger 来打印日志,请使用下面的代码,如想切换为其他日志框架请根据下面的方式扩展
//                    Logger.addLogAdapter(new AndroidLogAdapter());
//                    Timber.plant(new Timber.DebugTree() {
//                        @Override
//                        protected void log(int priority, String tag, String message, Throwable t) {
//                            Logger.log(priority, tag, message, t);
//                        }
//                    });
            ButterKnife.setDebug(true);
        }
        //LeakCanary 内存泄露检查
        // ArmsUtils.obtainAppComponentFromContext(application).extras().put(RefWatcher.class.getName(), BuildConfig.USE_CANARY ? LeakCanary.install(application) : RefWatcher.DISABLED);

        //扩展 AppManager 的远程遥控功能
//        ArmsUtils.obtainAppComponentFromContext(application).appManager().setHandleListener((appManager, message) -> {
//            switch (message.what) {
        //case 0:
        //do something ...
        //   break;
//            }
//        });
        //Usage:
        //Message msg = new Message();
        //msg.what = 0;
        //AppManager.post(msg); like EventBus


    }

    @Override
    public void onTerminate(@NonNull Application application) {

    }
}
