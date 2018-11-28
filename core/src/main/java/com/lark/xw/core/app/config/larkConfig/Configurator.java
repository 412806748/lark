package com.lark.xw.core.app.config.larkConfig;

import android.os.Handler;

import com.joanzapata.iconify.IconFontDescriptor;
import com.joanzapata.iconify.Iconify;

import java.util.ArrayList;
import java.util.HashMap;

import okhttp3.Interceptor;

/**
 * 配置类
 * Created by xdj on 2018/1/6.
 */

public class Configurator {
    private static final Handler HANDLER = new Handler();
    private static final HashMap<Object, Object> LarkConfig_CONFIGS = new HashMap<>();
    private static final ArrayList<IconFontDescriptor> ICONS = new ArrayList<>();
    private static final ArrayList<Interceptor> INTERCEPTORS = new ArrayList<>();

    public Configurator() {
        LarkConfig_CONFIGS.put(ConfigKeys.CONFIG_READY, false);
        LarkConfig_CONFIGS.put(ConfigKeys.HANDLER, HANDLER);
    }

    //单例，初始内部静态类
    private static class Holder {
        private static final Configurator INSTANCE = new Configurator();
    }

    public static Configurator getInstance() {
        return Holder.INSTANCE;
    }

    final HashMap<Object, Object> getLarkConfigConfigs() {
        return LarkConfig_CONFIGS;
    }

    public final void configure() {
        //初始化图标框架
        initIcons();
        //设置配置
        LarkConfig_CONFIGS.put(ConfigKeys.CONFIG_READY, true);
    }

    private void initIcons() {
        if (ICONS.size() > 0) {
            final Iconify.IconifyInitializer initializer = Iconify.with(ICONS.get(0));
            for (int i = 0; i < ICONS.size(); i++) {
                initializer.with(ICONS.get(i));
            }
        }
    }


    public final Configurator withIcon(IconFontDescriptor descriptor) {
        ICONS.add(descriptor);
        return this;
    }


    public final Configurator withApiHost(String host) {
        LarkConfig_CONFIGS.put(ConfigKeys.NATIVE_API_HOST, host);
        return this;
    }

    public final Configurator withInterceptor(Interceptor interceptors) {
        INTERCEPTORS.add(interceptors);
        LarkConfig_CONFIGS.put(ConfigKeys.INTERCEPTOR, INTERCEPTORS);
        return this;
    }


    public final Configurator withInterceptors(ArrayList<Interceptor> interceptors) {
        INTERCEPTORS.addAll(interceptors);
        LarkConfig_CONFIGS.put(ConfigKeys.INTERCEPTOR, INTERCEPTORS);
        return this;
    }

    private static void checkConfiguration() {
        final boolean isReady = (boolean) LarkConfig_CONFIGS.get(ConfigKeys.CONFIG_READY);
        if (!isReady) {
            throw new RuntimeException("configuration is not read");
        }
    }

    final <T> T getConfiguration(Object key) {
        checkConfiguration();
        final Object o = LarkConfig_CONFIGS.get(key);
        if (o == null) {
            throw new NullPointerException(key.toString() + " IS NULL");
        }
        return (T) o;
    }


}
