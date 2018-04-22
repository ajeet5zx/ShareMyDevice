package com.singhnextjuggernaut.ajeetkumar.sharemydevice.data;

import java.util.List;

/**
 * Developer: rahul
 * Dated: 21/4/18.
 */
public class DeviceList {
    List<DeviceData> deviceDataList;

    public DeviceList(List<DeviceData> deviceDataList) {
        this.deviceDataList = deviceDataList;
    }

    public List<DeviceData> getDeviceDataList() {
        return deviceDataList;
    }

    public void setDeviceDataList(List<DeviceData> deviceDataList) {
        this.deviceDataList = deviceDataList;
    }
}
