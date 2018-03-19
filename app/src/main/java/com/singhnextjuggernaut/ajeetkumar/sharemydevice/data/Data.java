package com.singhnextjuggernaut.ajeetkumar.sharemydevice.data;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("access_token")
    @Expose
    private String accessToken;
    @SerializedName("user_data")
    @Expose
    private UserData userData;
    @SerializedName("device_data")
    @Expose
    private List<DeviceData> deviceData = null;

    /**
     * No args constructor for use in serialization
     *
     */
    public Data() {
    }

    /**
     *
     * @param deviceData
     * @param accessToken
     * @param userData
     */
    public Data(String accessToken, UserData userData, List<DeviceData> deviceData) {
        super();
        this.accessToken = accessToken;
        this.userData = userData;
        this.deviceData = deviceData;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public UserData getUserData() {
        return userData;
    }

    public void setUserData(UserData userData) {
        this.userData = userData;
    }

    public List<DeviceData> getDeviceData() {
        return deviceData;
    }

    public void setDeviceData(List<DeviceData> deviceData) {
        this.deviceData = deviceData;
    }

    private String getDeviceDataString(List<DeviceData> deviceData) {
        String deviceString="";
        for(int i=0;i<deviceData.size();i++) {
            deviceString+=deviceData.get(i).toString();
            if(i<deviceData.size()-1) {
                deviceString+=",";
            }
        }
        return deviceString;
    }

    @Override


    public String toString() {
        return "{"+
                "  accessToken : '" + accessToken +"' ," +
                "  userData : " + userData.toString() +" ," +
                "  deviceData : [" + getDeviceDataString(deviceData) + "]" +
                "}";
    }

}