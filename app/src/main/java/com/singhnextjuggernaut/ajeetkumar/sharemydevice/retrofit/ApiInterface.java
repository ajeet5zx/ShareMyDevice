package com.singhnextjuggernaut.ajeetkumar.sharemydevice.retrofit;

import com.singhnextjuggernaut.ajeetkumar.sharemydevice.data.Data;
import com.singhnextjuggernaut.ajeetkumar.sharemydevice.data.DeviceData;
import com.singhnextjuggernaut.ajeetkumar.sharemydevice.data.DeviceList;
import com.singhnextjuggernaut.ajeetkumar.sharemydevice.data.ResponseMessage;
import com.singhnextjuggernaut.ajeetkumar.sharemydevice.data.UserData;
import com.singhnextjuggernaut.ajeetkumar.sharemydevice.database.CommonData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PartMap;

/**
 * Created by rahul on 19/3/18.
 */

public interface ApiInterface {
    @POST(ApiConstants.login)
    Call<Data> login(@Body UserData userData);

    @POST(ApiConstants.register_user)
    Call<UserData> registeruser(@Body UserData userData);

    @POST(ApiConstants.access_token_login)
    Call<UserData> accesstokenlogin(@Header("Authorization") String value);

    @POST(ApiConstants.add_device)
    Call<ResponseMessage> adddevice(@Header("Authorization") String value , @Body DeviceData deviceData);

    @POST(ApiConstants.logout)
    Call<ResponseMessage> logout(@Header("Authorization") String value);

    @POST(ApiConstants.forgotpassword)
    Call<ResponseMessage> forgotpassword(@Body UserData userData);

    @POST(ApiConstants.resetpassword)
    Call<UserData> resetpassword(@Header("Authorization") String value ,@Body UserData userData);

    @POST(ApiConstants.devivelist)
    Call<List<DeviceData>> devicelist(@Header("Authorization") String value);

    @POST(ApiConstants.updateDeviceStatus)
    Call<ResponseMessage> updateDeviceStatus(@Header("Authorization") String value, @Body DeviceData deviceData);

    @POST(ApiConstants.deviceNotification)
    Call<ResponseMessage> deviceNotification(@Header("Authorization") String value, @Body HashMap<String, Object> map);

}
