package com.lark.xw.core.app.config.larkConfig;

import android.content.Context;
import android.os.Handler;

/**
 * 初始化配置类
 * Created by jx on 2018/5/3.
 */

public class LarkConfig {
    public static Configurator init(Context context) {
        getConfigurator().getLarkConfigConfigs()
                .put( ConfigKeys.APPLICATION_CONTEXT, context.getApplicationContext());
        return getConfigurator();
    }

    public static Configurator getConfigurator() {
        return Configurator.getInstance();
    }

    public static <T> T getConfiguration(Object key) {
        return getConfigurator().getConfiguration(key);
    }

    public static Context getApplicationContext() {
        return getConfiguration(ConfigKeys.APPLICATION_CONTEXT);
    }

    public static Handler getHandler() {
        return getConfiguration(ConfigKeys.HANDLER);
    }

}
