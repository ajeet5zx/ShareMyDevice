package com.singhnextjuggernaut.ajeetkumar.sharemydevice.retrofit;

import com.singhnextjuggernaut.ajeetkumar.sharemydevice.data.Data;
import com.singhnextjuggernaut.ajeetkumar.sharemydevice.data.DeviceData;
import com.singhnextjuggernaut.ajeetkumar.sharemydevice.data.ResponseMessage;
import com.singhnextjuggernaut.ajeetkumar.sharemydevice.data.UserData;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

/**
 * Created by rahul on 19/3/18.
 */

public interface ApiInterface {
    @POST(ApiConstants.login)
    Call<Data> login(@Body UserData userData);

    @POST(ApiConstants.register_user)
    Call<UserData> registeruser(@Body UserData userData);

    @POST(ApiConstants.access_token_login)
    Call<UserData> accesstokenlogin(@Header("access_token") String value);

    @POST(ApiConstants.add_device)
    Call<DeviceData> adddevice(@Header("access_token") String value ,@Body DeviceData deviceData);

    @POST(ApiConstants.logout)
    Call<ResponseMessage> logout(@Header("access_token") String value);

    @POST(ApiConstants.forgotpassword)
    Call<ResponseMessage> forgotpassword(@Body UserData userData);

    @POST(ApiConstants.resetpassword)
    Call<UserData> resetpassword(@Header("access_token") String value ,@Body UserData userData);
}
