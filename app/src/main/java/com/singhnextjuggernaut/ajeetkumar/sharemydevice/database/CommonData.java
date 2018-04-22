package com.singhnextjuggernaut.ajeetkumar.sharemydevice.database;

import com.singhnextjuggernaut.ajeetkumar.sharemydevice.constant.BuildConfig;
import com.singhnextjuggernaut.ajeetkumar.sharemydevice.constant.PaperDbConstant;
import com.singhnextjuggernaut.ajeetkumar.sharemydevice.data.Data;
import com.singhnextjuggernaut.ajeetkumar.sharemydevice.data.DeviceData;
import com.singhnextjuggernaut.ajeetkumar.sharemydevice.data.DeviceList;
import com.singhnextjuggernaut.ajeetkumar.sharemydevice.data.UserData;

import java.util.ArrayList;

import io.paperdb.Paper;
import static com.singhnextjuggernaut.ajeetkumar.sharemydevice.constant.AppConstant.DEV;
import static com.singhnextjuggernaut.ajeetkumar.sharemydevice.constant.AppConstant.PAPER_GET_DATA;
import static com.singhnextjuggernaut.ajeetkumar.sharemydevice.constant.AppConstant.PAPER_SAVE_DATA;
import static com.singhnextjuggernaut.ajeetkumar.sharemydevice.constant.AppConstant.PAPER_SAVE_DEVICE_LIST;
import static com.singhnextjuggernaut.ajeetkumar.sharemydevice.constant.AppConstant.PAPER_SAVE_TASK_HEADER;


/**
 * Developer: Saurabh Verma
 * Dated: 19-02-2017.
 */
public final class CommonData implements PaperDbConstant {
    /**
     * Empty Constructor
     * not called
     */
    private CommonData() {
    }

    /**
     * Update fcm token.
     *
     * @param token the token
     */
//======================================== FCM token ==============================================
    public static void updateFCMToken(final String token) {
        Paper.book().write(PAPER_DEVICE_TOKEN, token);
    }

    /**
     * retrieving base url as per build flavor
     *
     * @return base url from paper db
     */
    public static String getBaseUrl() {
        return Paper.book().read(BASE_SERVER_URL, BuildConfig.BASE_URL);
    }

    /**
     * settting universal flavor url(based on flavor type selected from universal flavor list) if product flavor selected is URL
     *
     * @param universalFlavorUrl , universal flavor type to be set
     */
    public static void setBaseUrl(final String universalFlavorUrl) {
        Paper.book().write(BASE_SERVER_URL, universalFlavorUrl);
    }

    /**
     * returns type of universal App flavor(dev,test,client) ,if Build Variant is universal
     *
     * @return Universal App Flavor Type (default value, DEV)
     */
    public static String getFlavorType() {
        return Paper.book().read(UNIVERSAL_TYPE, DEV);
    }

    /**
     * sets type of universal App flavor(dev,test,client) ,if Build Variant is universal
     *
     * @param flavorType , which type of flavor (DEV,QA,LIVE) in case of Universal App build variant is selected
     */
    public static void setFlavorType(final String flavorType) {
        Paper.book().write(UNIVERSAL_TYPE, flavorType);
    }

    /**
     * Gets fcm token.
     *
     * @return the fcm token
     */
    public static String getFCMToken() {
        return Paper.book().read(PAPER_DEVICE_TOKEN);
    }

    /**
     * Save access token.
     *
     * @param accessToken the access token
     */
//======================================== Access Token ============================================
    public static void saveAccessToken(final String accessToken) {
        Paper.book().write(PAPER_ACCESS_TOKEN, accessToken);
    }

    /**
     * Gets access token.
     *
     * @return the access token
     */
    public static String getAccessToken() {
        return Paper.book().read(PAPER_ACCESS_TOKEN);
    }


    /**
     * @param registrationDataObj user details;
     */
    public static void saveRegisterationData(final Data registrationDataObj) {
        Paper.book().write(PAPER_SAVE_DATA, registrationDataObj);
    }



    /**
     * @return return data;
     */
    public static Data getRegisterationData() {
        return Paper.book().read(PAPER_GET_DATA);
    }

    /**
     * @param deviceList user details;
     */
    public static void saveDeviceList(final DeviceList deviceList) {
        Paper.book().write(PAPER_SAVE_DEVICE_LIST, deviceList);
    }



    /**
     * @return return data;
     */
    public static DeviceList getDeviceList() {
        return Paper.book().read(PAPER_SAVE_DEVICE_LIST);
    }



    //-------------task details save and retreived---------------------

    /**
     * @param tutorial tutorial screen check;
     */
    public static void saveTutorialCheck(final boolean tutorial) {
        Paper.book().write(PAPER_SAVE_TASK_HEADER, tutorial);
    }

    /**
     * @return return tutorial screen check;
     */
    public static boolean getTutorialCheck() {
        return Paper.book().exist(PAPER_SAVE_TASK_HEADER);
    }


    //===================phone verification===================

    /**
     * @return boolean;
     */
    public static boolean getPhoneVerified() {
        return Paper.book().read(PHONE_VERIFY);
    }

    /**
     * @param phoneVerify phone verify
     */

    public static void setPhoneVerified(final boolean phoneVerify) {
        Paper.book().write(PHONE_VERIFY, phoneVerify);
    }


    //======================================== Clear TrackData ===============================================

    /**
     * Delete paper.
     */
    public static void clearData() {
        String deviceToken = getFCMToken();
        Paper.book().destroy();
        updateFCMToken(deviceToken);
    }

    /**
     * Get application server port.
     *
     * @return c
     */
    public static String getApplicationServer() {
        if (BuildConfig.IS_UNIVERSAL) {
            return Paper.book().read(KEY_APP_SERVER, BuildConfig.BASE_URL);
        }

        return BuildConfig.BASE_URL;
    }

    /**
     * Get application server port.
     *
     * @return appliction server port
     */
    public static String getApplicationType() {
        if (BuildConfig.IS_UNIVERSAL) {
            return Paper.book().read(KEY_APP_TYPE, BuildConfig.BUILD_SERVER_TYPE);
        }

        return BuildConfig.BUILD_SERVER_TYPE;
    }

    /**
     * Save application server.
     *
     * @param serverPort server port
     */
    public static void saveApplicationServer(final String serverPort) {
    /*If there is no default server saved, return default server from configuration.*/
        Paper.book().write(KEY_APP_SERVER, serverPort);
    }

    /**
     * Save application server.
     *
     * @param type type
     */
    public static void saveApplicationType(final String type) {
    /*If there is no default server saved, return default server from configuration.*/
        Paper.book().write(KEY_APP_TYPE, type);
    }

    /**
     * @return return the date of when log file is created
     */
    public static String getLogCreatedDate() {
        return Paper.book().read(KEY_LOG_FILE_CREATED);
    }

    /**
     * @param mCreatedDate date when log is created
     */
    public static void setLogCreatedDate(final String mCreatedDate) {

        Paper.book().write(KEY_LOG_FILE_CREATED, mCreatedDate);
    }

}