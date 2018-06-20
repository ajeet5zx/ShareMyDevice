package com.singhnextjuggernaut.ajeetkumar.sharemydevice.retrofit;

import com.singhnextjuggernaut.ajeetkumar.sharemydevice.data.Data;
import com.singhnextjuggernaut.ajeetkumar.sharemydevice.data.DeviceData;
import com.singhnextjuggernaut.ajeetkumar.sharemydevice.data.ResponseMessage;
import com.singhnextjuggernaut.ajeetkumar.sharemydevice.data.UserData;

import java.util.HashMap;
import java.util.List;

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
    Call<Data> accesstokenlogin(@Header("Authorization") String value,  @Body HashMap<String, Object> map);

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

    @POST(ApiConstants.UpdateDevices)
    Call<ResponseMessage> UpdateDevices(@Header("Authorization") String value, @Body HashMap<String, Object> map);

    @POST(ApiConstants.UpdateUsers)
    Call<ResponseMessage> UpdateUsers(@Header("Authorization") String value, @Body HashMap<String, Object> map);

    @POST(ApiConstants.ReturnDevice)
    Call<ResponseMessage> ReturnDevice(@Header("Authorization") String value, @Body HashMap<String, Object> map);

}
