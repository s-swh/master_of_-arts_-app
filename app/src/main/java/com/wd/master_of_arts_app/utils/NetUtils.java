package com.wd.master_of_arts_app.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import com.wd.master_of_arts_app.base.App;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author 时文豪
 * @description:
 * @date :2020/12/3 10:21
 */
public class NetUtils {
    private Api api;

    public NetUtils() {
        initModel();
    }
    private static class Coallack{
        private static final NetUtils NET_UTILS=new NetUtils();
    }
    public static NetUtils getInstance(){
        return Coallack.NET_UTILS;
    }
    private void initModel() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .writeTimeout(30, TimeUnit.SECONDS)
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .addNetworkInterceptor(new Arouter())
                .addNetworkInterceptor(httpLoggingInterceptor);
        OkHttpClient build = builder.build();
        Retrofit build1 = new Retrofit.Builder()
                .baseUrl("http://app.54artist.com/")
                .client(build)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        api = build1.create(Api.class);
    }

    public Api getApi() {
        return api;
    }
    //图片上传
    public RequestBody getRequestBody(List<File> files, HashMap<String,String> map){
        MultipartBody.Builder builder = new MultipartBody.Builder().setType(MultipartBody.FORM);
        for (Map.Entry<String,String>entry:map.entrySet()){
            builder.addFormDataPart(entry.getKey(), entry.getValue() + "");
        }
        for (int i = 0; i < files.size(); i++) {
            builder.addFormDataPart("image",files.get(i).getName(),
                    RequestBody.create(MediaType.parse("image/jepg"),files.get(i)));
        }
        return builder.build();
    }

    private class Arouter implements Interceptor {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            SharedPreferences sp = App.getContext().getSharedPreferences("into", Context.MODE_PRIVATE);
            String token = sp.getString("token", "");
            if(TextUtils.isEmpty(token)){
                return chain.proceed(request);
            }
            Request token1 = request.newBuilder().addHeader("token", token).build();
            Log.i("xxx",token);
            return chain.proceed(token1);
        }
    }

}
