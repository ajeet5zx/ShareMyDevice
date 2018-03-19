package com.singhnextjuggernaut.ajeetkumar.sharemydevice.constant;

/**
 * Developer: Saurabh Verma
 * Dated: 19-02-2017.
 */

public interface ApiKeyConstant {

    //Response Google
    String RESPONSE_GOOGLE = "OK";
    String RESPONSE_GOOGLE_ERROR = "ZERO_RESULTS";
    String RESPONSE_OVER_QUERY_LIMIT = "OVER_QUERY_LIMIT";
    String RESPONSE_INVALID_REQUEST = "INVALID_REQUEST";


    //Error Messages
    String ERROR_MSG_PATH_NOT_FOUND = "Invalid path or Path not found.";
    String ERROR_MSG_REQUEST_DENIED = "Invalid key parameter or Unknown Error";
    String ERROR_MSG_API_ERROR = "Api Hit Error.";
    String ERROR_MSG_ZERO_RESULTS = "Sucessfull but search was passed a bounds in a remote location";
    String ERROR_MSG_INVALID_REQUEST = "Some input Parameter is Missing.";
    String ERROR_MSG_UNKNOWN_ERROR = "Unknown Error. Try Again.";


    //Google Api parameters
    String SOURCE = "origin";
    String DESTINATION = "destination";
    String WAYPOINTS = "waypoints";
    String LATLNG = "latlng";
    //    String SEARCH = "input";
//    String LANGUAGE = "language";
    String KEY = "key";


    String MESSAGE = "messageToDisplay";
    String DATA = "data";
    String STATUS_CODE = "statusCode";
    String AUTHORIZATION = "authorization";
    String BOOKING_ID = "bookingId";
    String BOOKINGID = "bookingID";
    //    String LATITUDE = "lat";
//    String LONGITUDE = "lng";
    String TIMESTAMP = "timestamp";

    //-------------------user location ----------------

    String LOCALITY = "locality";
    String LATITUDE = "latitude";
    String LONGITUDE = "longitude";
    String ADDRESS_TAG = "addressTag";
    String COMPANY_ADDRESS = "companyAddress";
    String STREET = "street";
    String APARTMENT_NUMBER = "apartmentNumber";
    String OPTIONAL_INFO = "optionalInfo";
    String _ID = "_id";

    //-----------booking details---------------

    String BOOKING_TYPE = "bookingType";
    String VEHICLE_TYPE = "vehicleType";
    String BOOKING_HEADLINE = "bookingHeadline";
    String BOOKING_IMAGES = "bookingImages";
    String SHORT_SUMMARY = "shortSummery";
    String DURATION = "duration";
    String PRICE = "price";
    String LOCATIONS = "locations";
    String NO_OF_STOPS = "noOfStops";

    //-----------reset password-----------
    String NEW_PASSWORD = "newPassword";
    String OLD_PASSWORD = "oldPassword";
    String RESET_TOKEN_PASSWORD = "passwordResetToken";

    //------------user signin----------------
    String PRIMARY_MOBILE = "primaryMobile";
    String ROLE = "role";
    String DEVICETOKEN = "deviceToken";
    String DEVICETYPE = "deviceType";
    String APPVERSION = "appVersion";
    String PASSWORD = "password";

    //------------user signup ------------------

    String FIRST_NAME = "name";
    String LAST_NAME = "lastName";
    String EMAIL = "email";
    String MOBILE = "mobile";
    String COUNTRY_CODE = "countryCode";
    String IMAGE = "image";
    String THUMBNAIL = "thumbnail";
    String FACEBOOK_ID = "facebookId";
    String GOOGLE_PLUS_ID = "googlePlusId";

    //-------------verify user-----------
    String OLD_PHONE = "oldMobile";
    String NEW_PHONE = "newMobile";
    String OTP_CODE = "OTPCode";
    String CHANGE_PHONE_OTP = "changePhoneOTP";


}
