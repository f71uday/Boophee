package com.boophee.boophee.rest;

/**
 * Created by uday on 25/1/18.
 */

public class APIUtils {
    private APIUtils() {}

    public static final String BASE_URL = "http://192.168.0.32:3000/";

    public static APIService getAPIService() {

        return RetrofitClient.getClient(BASE_URL).create(APIService.class);
    }
}
