package com.singhnextjuggernaut.ajeetkumar.sharemydevice.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DeviceData {

    @SerializedName("owner_id")
    @Expose
    private String ownerId;
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
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("os")
    @Expose
    private String os;
    @SerializedName("version")
    @Expose
    private String version;
    @SerializedName("imei")
    @Expose
    private String imei;
    @SerializedName("sticker_no")
    @Expose
    private String stickerNo;
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
     * @param name
     * @param stickerNo
     * @param isAvailable
     * @param version
     */
    public DeviceData(String ownerId, Object assigneeId, Boolean isAvailable, Integer sharedCount, String id, String name, String os, String version, String imei, String stickerNo, Integer v) {
        super();
        this.ownerId = ownerId;
        this.assigneeId = assigneeId;
        this.isAvailable = isAvailable;
        this.sharedCount = sharedCount;
        this.id = id;
        this.name = name;
        this.os = os;
        this.version = version;
        this.imei = imei;
        this.stickerNo = stickerNo;
        this.v = v;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public Object getAssigneeId() {
        return assigneeId;
    }

    public void setAssigneeId(Object assigneeId) {
        this.assigneeId = assigneeId;
    }

    public Boolean getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(Boolean isAvailable) {
        this.isAvailable = isAvailable;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
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

    public Integer getV() {
        return v;
    }

    public void setV(Integer v) {
        this.v = v;
    }


    @Override
    public String toString() {
        return "{" +
                "  ownerId : '" + ownerId +"' ," +
                "  id : '" + id +"' ," +
                "  assigneeId : '" + assigneeId +"' ," +
                "  isAvailable : '" + isAvailable +"' ," +
                "  sharedCount : '" + sharedCount +"' ," +
                "  name : '" + name +"' ," +
                "  os : '" + os +"' ," +
                "  version : '" + version +" '," +
                "  imei : '" + imei +"' ," +
                "  stickerNo : '" + stickerNo +
                "' }";
    }}