package com.wd.master_of_arts_app.utils;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
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
              //  .addInterceptor(new ShunPreanter())
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
    //做处理 用来存放token
  /*  private class ShunPreanter implements Interceptor {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            SharedPreferences sp = App.getContext().getSharedPreferences("路径", Context.MODE_PRIVATE);
            String token = sp.getString("token", "");
            if(!TextUtils.isEmpty(token)){
                return chain.proceed(request);
            }
            Request token1 = request.newBuilder().addHeader("token", token).build();
            return chain.proceed(token1);
        }
    }*/
}
