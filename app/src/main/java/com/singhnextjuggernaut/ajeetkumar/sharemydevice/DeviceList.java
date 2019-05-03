package com.singhnextjuggernaut.ajeetkumar.sharemydevice;

/*
CREATED BY AJEET SINGH
*/public class DeviceList {
    private boolean status;
    private String owner_name, brand, model, version, screen_size, resolution;
    private int sticker_no;

    public DeviceList(boolean status, String owner_name, String brand, String model, String version, String screen_size, String resolution, int sticker_no) {
        this.status = status;
        this.owner_name = owner_name;
        this.brand = brand;
        this.model = model;
        this.version = version;
        this.screen_size = screen_size;
        this.resolution = resolution;
        this.sticker_no = sticker_no;
    }

    public boolean isStatus() {
        return status;
    }

    public String getOwner_name() {
        return owner_name;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getVersion() {
        return version;
    }

    public String getScreen_size() {
        return screen_size;
    }

    public String getResolution() {
        return resolution;
    }

    public int getSticker_no() {
        return sticker_no;
    }
}
