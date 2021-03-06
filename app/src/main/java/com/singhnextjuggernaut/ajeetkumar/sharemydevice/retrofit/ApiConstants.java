package com.singhnextjuggernaut.ajeetkumar.sharemydevice.retrofit;

/**
 * Created by rahul on 19/3/18.
 */

public interface ApiConstants {
    String login = "/api/v1/login";
    String access_token_login = "/api/v1/access_token_login";
    String register_user = "/api/v1/user_signup";
    String add_device = "/api/v1/add_device";
    String logout = "/api/v1/logout";
    String resetpassword = "/api/v1/resetpassword";
    String forgotpassword = "/api/v1/forgotpassword";
    String devivelist = "/api/v1/getDeviceList";
    String updateDeviceStatus = "/api/v1/updatedevicestatus";
    String deviceNotification = "/api/v1/deviceNotification";
    String UpdateDevices = "/api/v1/updatedevices";
    String UpdateUsers = "/api/v1/updateusers";
    String ReturnDevice = "/api/v1/deviceReturnNotification";
}
