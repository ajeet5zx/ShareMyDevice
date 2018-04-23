package com.singhnextjuggernaut.ajeetkumar.sharemydevice.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DeviceData {

    @SerializedName("owner_id")
    @Expose
    private Object ownerId;
    @SerializedName("assignee_id")
    @Expose
    private Object assigneeId;
    @SerializedName("is_available")
    @Expose
    private Boolean isAvailable;
    @SerializedName("shared_count")
    @Expose
    private Integer sharedCount;
    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("brand")
    @Expose
    private String brand;
    @SerializedName("model")
    @Expose
    private String model;
    @SerializedName("os")
    @Expose
    private String os;
    @SerializedName("screen_size")
    @Expose
    private String screen_size;
    @SerializedName("resolution")
    @Expose
    private String resolution;
    @SerializedName("version")
    @Expose
    private String version;
    @SerializedName("imei")
    @Expose
    private String imei;
    @SerializedName("sticker_no")
    @Expose
    private String stickerNo;
    @SerializedName("deviceCategory")
    @Expose
    private String deviceCategory;
    @SerializedName("__v")
    @Expose
    private Integer v;

    /**
     * No args constructor for use in serialization
     *
     */
    public DeviceData() {
    }

    /**
     *
     * @param id
     * @param v
     * @param os
     * @param sharedCount
     * @param assigneeId
     * @param ownerId
     * @param imei
     * @param brand
     * @param model
     * @param screen_size
     * @param resolution
     * @param deviceCategory
     * @param stickerNo
     * @param isAvailable
     * @param version
     */
    public DeviceData(Object ownerId, Object assigneeId, Boolean isAvailable, Integer sharedCount, String id, String brand, String model, String screen_size, String resolution, String deviceCategory, String os, String version, String imei, String stickerNo, Integer v) {
        super();
        this.ownerId = ownerId;
        this.assigneeId = assigneeId;
        this.isAvailable = isAvailable;
        this.sharedCount = sharedCount;
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.screen_size = screen_size;
        this.resolution = resolution;
        this.deviceCategory = deviceCategory;
        this.os = os;
        this.version = version;
        this.imei = imei;
        this.stickerNo = stickerNo;
        this.v = v;
    }

    public Object getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Object ownerId) {
        this.ownerId = ownerId;
    }

    public Object getAssigneeId() {
        return assigneeId;
    }

    public void setAssigneeId(Object assigneeId) {
        this.assigneeId = assigneeId;
    }

    public Boolean getAvailable() {
        return isAvailable;
    }

    public void setAvailable(Boolean available) {
        isAvailable = available;
    }

    public Integer getSharedCount() {
        return sharedCount;
    }

    public void setSharedCount(Integer sharedCount) {
        this.sharedCount = sharedCount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getScreen_size() {
        return screen_size;
    }

    public void setScreen_size(String screen_size) {
        this.screen_size = screen_size;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getStickerNo() {
        return stickerNo;
    }

    public void setStickerNo(String stickerNo) {
        this.stickerNo = stickerNo;
    }

    public  String getDeviceCategory() {
        return deviceCategory;
    }

    public void setDeviceCategory(String deviceCategory) {
        this.deviceCategory = deviceCategory;
    }

    public Integer getV() {
        return v;
    }

    public void setV(Integer v) {
        this.v = v;
    }

    @Override
    public String toString() {
        return "{" +
                "  ownerId : '" + ownerId.toString() +"' ," +
                "  id : '" + id +"' ," +
                "  assigneeId : '" + assigneeId.toString() +"' ," +
                "  isAvailable : '" + isAvailable +"' ," +
                "  sharedCount : '" + sharedCount +"' ," +
                "  name : '" + model +"' ," +
                "  os : '" + os +"' ," +
                "  version : '" + version +" '," +
                "  imei : '" + imei +"' ," +
                "  stickerNo : '" + stickerNo +
                "' }";
    }}