package com.lark.xw.core.net.callback;

import android.os.Handler;
import android.support.annotation.NonNull;


import com.jess.arms.utils.LogUtils;
import com.lark.xw.core.app.config.larkConfig.ConfigKeys;
import com.lark.xw.core.app.config.larkConfig.LarkConfig;
import com.lark.xw.core.ui.lorder.LatteLoader;
import com.lark.xw.core.ui.lorder.LoaderStyle;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public final class RequestCallbacks implements Callback<String> {

    private final IRequest REQUEST;
    private final ISuccess SUCCESS;
    private final IFailure FAILURE;
    private final IError ERROR;
    private final LoaderStyle LOADER_STYLE;
    private static final Handler HANDLER = LarkConfig.getHandler();

    public RequestCallbacks(IRequest request, ISuccess success, IFailure failure, IError error, LoaderStyle style) {
        this.REQUEST = request;
        this.SUCCESS = success;
        this.FAILURE = failure;
        this.ERROR = error;
        this.LOADER_STYLE = style;
    }

    @Override
    public void onResponse(@NonNull Call<String> call, @NonNull Response<String> response) {
        if (response.isSuccessful()) {
            if (call.isExecuted()) {
                if (SUCCESS != null) {
                    SUCCESS.onSuccess(response.body());
                }
            }
        } else {
            if (ERROR != null) {
                ERROR.onError(response.code(), response.message());
            }
        }

        //onRequestFinish();
    }

    @Override
    public void onFailure(@NonNull Call<String> call, @NonNull Throwable t) {
        LogUtils.debugInfo(t.getMessage());
        if (FAILURE != null) {
            FAILURE.onFailure(t);
        }
        if (REQUEST != null) {
            REQUEST.onRequestEnd();
        }

        // onRequestFinish();
    }

    private void onRequestFinish() {
        final long delayed = LarkConfig.getConfiguration(ConfigKeys.LOADER_DELAYED);
        if (LOADER_STYLE != null) {
            HANDLER.postDelayed(LatteLoader::stopLoading, delayed);
        }
    }
}
