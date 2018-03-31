package com.boophee.boophee.retrofit.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by uday on 25/3/18.
 */

public class ApiClient {
    public static final String BASE_URL = "http://192.168.0.34:3000/";
    private static Retrofit retrofit = null;
    public static  Retrofit getClient()
    {
        if (retrofit == null)
        {
            retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create()
                    ).build();
        }
        return retrofit;
    }
}
