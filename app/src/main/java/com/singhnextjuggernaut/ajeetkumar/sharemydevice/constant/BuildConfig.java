package com.singhnextjuggernaut.ajeetkumar.sharemydevice.constant;


public interface  BuildConfig {
    boolean DEBUG = Boolean.parseBoolean("true");
    String APPLICATION_ID = "com.getAltitude";
    String BUILD_TYPE = "debug";
    String FLAVOR = "DEV";
    int VERSION_CODE = 100;
    String VERSION_NAME = "1.0.0";
    // Fields from product flavor: DEV
    String BASE_URL = "http://ec2-13-127-185-75.ap-south-1.compute.amazonaws.com:8080";
    String BUILD_SERVER_TYPE = "Dev";
    boolean IS_UNIVERSAL = false;
    boolean WATER_MARK = false;
    // Fields from default config.
    String APP_NAME = "Get ALtitude";
}