package com.singhnextjuggernaut.ajeetkumar.sharemydevice.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserData {

    @SerializedName("device_count")
    @Expose
    private Integer deviceCount;
    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("first_name")
    @Expose
    private String firstName;
    @SerializedName("last_name")
    @Expose
    private String lastName;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("__v")
    @Expose
    private Integer v;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("deviceType")
    @Expose
    private String deviceType;
    @SerializedName("deviceToken")
    @Expose
    private String deviceToken;

    /**
     * No args constructor for use in serialization
     *
     */
    public UserData() {
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public void setDeviceToken(String deviceToken) {
        this.deviceToken = deviceToken;
    }

    /**
     *
     * @param id
     * @param v
     * @param lastName
     * @param deviceCount
     * @param email
     * @param password
     * @param firstName
     * @param deviceType
     * @param deviceToken
     */
    public UserData(Integer deviceCount, String id, String firstName, String lastName, String email, Integer v, String password, String deviceType, String deviceToken) {
        super();
        this.deviceCount = deviceCount;
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.v = v;
        this.password = password;
        this.deviceType = deviceType;
        this.deviceToken = deviceToken;

    }

    public Integer getDeviceCount() {
        return deviceCount;
    }

    public void setDeviceCount(Integer deviceCount) {
        this.deviceCount = deviceCount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getV() {
        return v;
    }

    public void setV(Integer v) {
        this.v = v;
    }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    @Override
    public String toString() {
        return "{"+
                "  deviceCount : " + deviceCount +" ," +
                "  id : '" + id +"' ," +
                "  firstName : '" + firstName +"' ," +
                "  lastName : '" + lastName +"' ," +
                "  email : '" + email +
                "' }";
    }

}