package com.singhnextjuggernaut.ajeetkumar.sharemydevice.data.remote;

import com.singhnextjuggernaut.ajeetkumar.sharemydevice.data.Data;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

public interface APIService {

    @POST("/api/v1/login")
    @FormUrlEncoded
    Observable <Data> post(
            @Field("method") String method,
            @Field("email") String email,
            @Field("password") String password,
            @Field("deviceToken") String deviceToken,
            @Field("deviceType") String deviceType
    );

}