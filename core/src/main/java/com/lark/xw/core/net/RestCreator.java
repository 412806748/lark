package com.lark.xw.core.net;


import android.util.Log;

import com.lark.xw.core.app.ConfigKeys;
import com.lark.xw.core.app.LarkConfig;
import com.lark.xw.core.net.cookies.CookiesManager;
import com.lark.xw.core.net.rx.RxRestService;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public final class RestCreator {
    private static final String BASE_URL = LarkConfig.getConfiguration(ConfigKeys.NATIVE_API_HOST);

    /**
     * 构建OkHttp
     */
    private static final class OKHttpHolder {
        private static final int TIME_OUT = 60;
        private static final OkHttpClient.Builder BUILDER = new OkHttpClient.Builder();
        private static final ArrayList<Interceptor> INTERCEPTORS = LarkConfig.getConfiguration(ConfigKeys.INTERCEPTOR);

        private static OkHttpClient.Builder addInterceptor() {
            if (INTERCEPTORS != null && INTERCEPTORS.size() > 0) {
                for (Interceptor interceptor : INTERCEPTORS) {
                    BUILDER.addInterceptor(interceptor);
                }
            }
            return BUILDER;
        }

        private static final OkHttpClient OK_HTTP_CLIENT = addInterceptor()
                .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
                .cookieJar(new CookiesManager())
                .build();
    }

    /**
     * 构建全局Retrofit客户端
     */
    private static final class RetrofitHolder {
        private static final Retrofit RETROFIT_CLIENT = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(OKHttpHolder.OK_HTTP_CLIENT)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    /**
     * Service接口
     */
    private static final class RestServiceHolder {
        private static final RestService REST_SERVICE =
                RetrofitHolder.RETROFIT_CLIENT.create(RestService.class);
    }

    public static RestService getRestService() {
        Log.e("BASE_URL", BASE_URL + "");
        return RestServiceHolder.REST_SERVICE;
    }

    /**
     * rxService接口
     */
    private static final class RxRestServiceHolder {
        private static final RxRestService REST_SERVICE =
                RetrofitHolder.RETROFIT_CLIENT.create(RxRestService.class);
    }

    public static RxRestService getRxRestService() {
        Log.e("BASE_URL", BASE_URL + "");
        return RxRestServiceHolder.REST_SERVICE;
    }
}
