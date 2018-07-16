package com.boophee.boophee.retrofit.api;

import android.content.Context;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.CallAdapter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by uday on 25/3/18.
 */

public class ApiClient {
    public static final String BASE_URL = "http://192.168.42.195:3000/";
    private static Retrofit retrofit = null;
    static int cacheSize = 10 * 1024 * 1024;


    public static Retrofit getClient(Context context) {
        okhttp3.Cache cache = new okhttp3.Cache(context.getCacheDir(), cacheSize);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .cache(cache)
                .addInterceptor(chain -> {
                    try {
                        return chain.proceed(chain.request());
                    } catch (Exception e) {
                        Request offlineRequest = chain.request().newBuilder()
                                .header("Cache-Control", "public, only-if-cached," +
                                        "max-stale=" + 60 * 60 * 24)
                                .build();
                        return chain.proceed(offlineRequest);
                    }
                })
                .build();


        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create());

        retrofit = builder.build();

        return retrofit;

    }
}