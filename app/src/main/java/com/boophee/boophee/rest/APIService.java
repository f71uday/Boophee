package com.boophee.boophee.rest;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by uday on 25/1/18.
 */

public interface APIService {
    @POST("cards")
    @FormUrlEncoded
    Call<Item> savePost(@Field("front") String que,
                             @Field("back") String ans);

}
