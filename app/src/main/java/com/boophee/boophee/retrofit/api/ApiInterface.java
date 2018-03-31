package com.boophee.boophee.retrofit.api;

import com.boophee.boophee.retrofit.Data;
import com.boophee.boophee.retrofit.DataResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by uday on 25/3/18.
 */

public interface ApiInterface {
    @GET("api/v1/cards")
    Call<DataResponse> getAllCards();
    @POST ("api/v1/cards")
    Call<Data> createCard(@Field("que") String que, @Field("ans") String ans,@Field("difficulty") int difficulty);

}
