package com.lark.xw.core.net.rx;


import com.lark.xw.core.net.Entity.TestMyBanners;
import com.lark.xw.core.net.rx.Exception.Response;

import java.util.List;
import java.util.WeakHashMap;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.QueryMap;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

public interface RxRestService {

    @GET
    Observable<Response<List<TestMyBanners>>> getBanner(@Url String url, @QueryMap WeakHashMap<String, Object> params);

    @GET
    Observable<Response<String>> get(@Url String url, @QueryMap WeakHashMap<String, Object> params);

    @FormUrlEncoded
    @POST
    Observable<Response<String>> post(@Url String url, @FieldMap WeakHashMap<String, Object> params);

    @POST
    Observable<Response<String>> postRaw(@Url String url, @Body RequestBody body);

    @FormUrlEncoded
    @PUT
    Observable<Response<String>> put(@Url String url, @FieldMap WeakHashMap<String, Object> params);

    @PUT
    Observable<Response<String>> putRaw(@Url String url, @Body RequestBody body);

    @DELETE
    Observable<Response<String>> delete(@Url String url, @QueryMap WeakHashMap<String, Object> params);

    @Streaming
    @GET
    Observable<ResponseBody> download(@Url String url, @QueryMap WeakHashMap<String, Object> params);

    @Multipart
    @POST
    Observable<Response<String>> upload(@Url String url, @Part MultipartBody.Part file);
}
