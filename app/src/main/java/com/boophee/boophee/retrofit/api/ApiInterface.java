package com.boophee.boophee.retrofit.api;

import com.boophee.boophee.retrofit.DataResponse;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by uday on 25/3/18.
 */

public interface ApiInterface {
    @GET("api/v1/cards")
    Call<DataResponse> getAllCards();
}
