package com.singhnextjuggernaut.ajeetkumar.sharemydevice.constant;


/**
 * Developer: Saurabh Verma
 * Dated: 19-02-2017.
 */

public interface AppConstant {
    String DEVICE_TYPE = "ANDROID";

    //Intent Filter
    String NOTIFICATION_RECEIVED = "notification_received";

    //Error
    String ERROR_VALUE_MISSING = "Either start or Destination Missing";

    String CHAT_SERVER_URL = "https://socketio-chat.now.sh/";


    String HOUR = "hr";
    String MINUTES = "min";

    //
    int SESSION_EXPIRED = 401;

    int REQUEST_CODE_PLAY_STORE = 500;
    int SDK_MIN = 23;

    //Request code
    int REQ_CODE_DEFAULT_SETTINGS = 16061;
    int REQ_CODE_PLAY_SERVICES_RESOLUTION = 16061;
    int REQ_CODE_SCREEN_OVERLAY = 10101;


    float DEFAULT_POLYLINE_WIDTH = 15;
    int CONVERT_TIME_MIN = 60;
    int CONVERT_KM = 1000;
    /*
   PolyLine decoding
    */
    int POLYDECODING_1 = 63;
    int POLYDECODING_2 = 0x1f;
    int POLYDECODING_3 = 0x20;
    double POLYDECODING_4 = 1E5;


    //Geo Model TrackData
    String STREET_NAME = "street_number";
    String ROUTE = "route";
    String LOCALITY = "locality";
    String COUNTRY = "country";
    String POSTAL_CODE = "postal_code";
    String POLITICAL = "political";
    String FORMATTED_ADDRESS = "formatted_address";


    float DIM_AMOUNT = 0.6f;

    String LIVE = "LIVE";
    String DEV = "DEV";
    String QA = "QA";


    //Save logs Address
    String ADD_LOGS = "/logcat-base.txt";
    /**
     * GetLocationconstants
     */
    int REQUEST_PERMISSIONS_REQUEST_CODE = 34;
    int SET_TIME_INTERVAL = 101;


    //Log file deletion day set
    int LOGS_SET_DAY = 7;

    //date format
    String DATE_FORMAT = "dd-MMM-yyyy";

    //otp edit text;
    int MOVE_CURSOR = 1;
    String USER_PHONE = "USER_PHONE";

    //content language;
    String CONTENT_LANGUAGE = "en";

    //singup request code;
    int REQ_CODE_SIGNUP = 5001;
    String USER_SIGNUP = "user_signup";
    int SIGNUP_MODE = 3000;

    //signin;
    String USER_SIGNIN = "user_signin";
    int SIGNIN_MODE = 3010;
    int FACEBOOK_SIGNIN_MODE = 3011;

    //facebook signup;
    int REQ_FACEBOOK_SIGNUP = 7000;
    int REQ_FACEBOOK_SIGNIN = 7001;
    //signin req code;
    int REQ_CODE_SIGNIN = 5002;
    //otp screen;
    int REQ_CODE_VERIFY = 5003;
    //change password screen;
    int REQ_CODE_CHANGE_PASS = 5004;

    int REQ_CODE_NEW_PASSWORD = 5005;

    //utc offset;
    int GENERATE_MINUTES = 1000;

    //role of user;
    String USER_ROLE = "customer";

    //mode for verify otp;
    String VERIFY_MODE = "verify_mode";
    int FORGOT_PASSWORD_MODE = 2;
    int VERIFY_OTP_MODE = 1;
    int CHANGE_NUMBER_MODE = 3;
    int SPLASH_VERIFY_MODE = 4;
    int REQ_CODE_SPLASH = 4001;

    int SPLASH_VERIFY_PHONE = 5007;
    int IMAGE_WIDTH = 600;
    int IMAGE_HEIGHT = 200;

    String PASSWORD_RESET_TOKEN = "reset_token";
    String FIRST = "first";
    String SECOND = "second";
    String THIRD = "third";

    //forgot password;
    int FORGOT_PASSWORD = 5005;

    //reset password;
    int RESET_PASSWORD_MODE = 5010;
    int RESET_PASS_ONBOARD = 5011;
    String RESET_PASSWORD = "reset_password";

    String DEVICE_TOKEN = "100";
    String APP_VERSION = "100";

    //mode to handle fragments;
    int MODE_OPEN_TASK = 1;
    int MODE_COMPLETE_TASK = 2;
    int MODE_LOCATION = 3;
    int MODE_HELP = 4;
    int MODE_LOGOUT = 5;

    //facebook check;
    int FACEBOOK_MODE = 7001;
    int GOOGLE_PLUS_MODE = 7010;
    String FACEBOOK_USER_DETAILS = "facebook_details";
    String CHECK_FACEBOOK = "check_facebook";
    String GOOGLE_USER_DETAILS = "google_details";

    //paper db constants;
    String PAPER_SAVE_DATA = "save_data";
    String PAPER_GET_DATA = "save_data";

    //splash timer;
    int SPLASH_TIMER = 1000;

    //google signin;
    int RC_SIGN_IN = 007;

    //google maps and location;
    int LOCATION_INTERVAL = 3000;
    int RADIUS = 10000;
    int ADD_LOCATION = 1001;
    int EDIT_LOCATION = 1003;
    String REQ_LOCATION = "req_location";
    String REQ_FAV_LOCATION = "REQ_FAV_LOCATION";
    String CUSTOMER_LIST = "customer_list";
    String REQ_ADDRESS_ID = "req_address_id";
    int EDIT_LOCATION_MODE = 11;
    int EDIT_GOOGLE_MAPS = 21;
    String REQ_MAPS = "req_maps";
    int EDIT_MAP_MODE = 22;
    int ADD_MAP_MODE = 23;
    int ADD_MAP_BOOKING_MODE = 24;
    int SAVE_LOCATION = 25;
    int SAVE_BOOKING_LOCATION = 26;
    int ADD_LOCATION_MODE = 12;
    int ADD_LOCATION_BOOKING_MODE = 13;

    //image picker mode;
    int MODE1 = 111;
    int MODE2 = 112;
    int MODE3 = 113;
    int MODE4 = 114;

    //booking process;
    String LATLNG = "latlng";
    String ESTIMATE = "estimate";
    String BEARER = "bearer ";
    int PICK_LOCATION = 51;
    String FAVORITE_PLACE = "favorite_place";
    int FAVORITE_LOCATION = 52;
    String ESTIMATE_PRICE = "budget";
    String PAPER_SAVE_TASK_HEADER = "task_header";
    String PAPER_SAVE_IS_TUTORIAL = "save_tutorial_check";
    String PAPER_SAVE_TASK_SUMMARY = "task_summary";
    String PAPER_SAVE_DURATION = "task_duration";
    String PAPER_SAVE_PRICE = "task_price";
    String PAPER_SAVE_LOCATIONS = "task_locations";
    String SINGLE_LOCATION = "SINGLE_LOCATION";
    String LOCATION_POSITION = "LOCATION_POSITION";
    int FAVORITE_PLACE_MODE = 88;
    int CREATE_TASK = 60;
    int CHOOSE_LOCATION = 61;
    int TASK_DETAILS_ADDED = 62;
    int REQ_CODE_DURATION = 63;
    int REQ_CODE_BUDGET_ESTIMATE = 64;
    int REQ_CODE_PROPOSED_PRICE = 65;
    int CHOOSE_MULTI_LOCATION = 66;
    String LOCATION_MODE_TYPE = "location_mode_type";
    int REQ_SINGLE_LOCATION = 67;
    int REQ_MULTI_LOCATION = 68;
    int ADD_MAP_SINGLE_LOCATION_BOOKING_MODE = 69;
    int ADD_MAP_MULTI_LOCATION_BOOKING_MODE = 70;
    int ADD_MULTI_LOCATION_BOOKING_MODE = 71;
    String PAPER_SAVE_MULTI_LOCATION = "save_multi_location_task";
    int PICK_MULTI_LOCATION = 72;
    int SAVE_MULTI_BOOKING_LOCATION = 73;
    int FAVORITE_MODE = 77;
    int MULTI_LOCATION_MODE = 78;
    int FROM_PREVIEW_TO_DURATION = 79;
    int FROM_PREVIEW_TO_LOCATION = 80;
    int CHANGE_SINGLE_LOCATION_MODE = 81;
    int CHANGE_SINGLE_LOCATION = 82;
    int ADD_CHANGE_SINGLE_LOCATION_BOOKING_MODE = 83;
    int SAVE_SINGLE_CHANGE_BOOKING_LOCATION = 84;
    int CHANGE_SINGLE_LOCATION_REQ = 85;
    int REQ_FAV_SINGLE_LOCATION_MODE = 86;
    int FROM_MULTI_PREVIEW_TO_LOCATION = 87;
    int CHANGE_MULTI_LOCATION = 89;
    int CHANGE_MULTI_LOCATION_MODE = 90;
    int ADD_CHANGE_MULTI_LOCATION_BOOKING_MODE = 91;
    int SAVE_MULTI_CHANGE_BOOKING_LOCATION = 92;
    int REQ_FAV_MULTI_LOCATION_MODE = 93;
    int CHOOSE_MULTI_LOCATION_REVIEW = 94;
    int VIEW_TYPE_NO_RESULT = 95;
    int VIEW_TYPE_RESULT = 96;
    String BOOKING_DATUM = "bookingDatum";
    String FROM_NOTIFICATION = "FROM_NOTIFICATION";
    String INTENT_DATA = "INTENT_DATA";
    String VEHICLE_TYPE = "vehicleType";
    String MULTIPLE_LOCATION = "MULTIPLE_LOCATION";
    String CHANGE_PRICE = "change_price";
    String TASK_DATA = "task_data";
    String TAG = "tag";
    String FROM_REVIEW = "fromreview";
    String FROM_VIEW_TIME_LINE = "from_view_time_line";
    String BOOKING_MODE = "BOOKING_MODE";
    String BIKE = "BIKE";
    String CAR = "CAR";
    String TRUCK = "TRUCK";
    String SUMMERY = "Summery";
    String BIDDING = "bidding";
    String HIRE = "hire";
    String SUCCESS = "Success";
    String MOST_RECENT = "MOST_RECENT";
    String LOWEST_PRICE = "LOWEST_PRICE";
    String HIGHEST_PRICE = "HIGHEST_PRICE";
    String NEAREST = "NEAREST";
    String BEST_RATED = "BEST_RATED";
    String PENDING = "PENDING";
    String ACCEPTED = "ACCEPTED";
    String ONGOING = "ONGOING";
    String ENROUTE = "ENROUTE";
    String ARRIVED = "ARRIVED";
    String STARTED = "STARTED";
    String COMPLETED = "COMPLETED";
    String EXPIRED = "EXPIRED";
    String CANCELLED_BY_ADMIN = "CANCELLED_BY_ADMIN";
    String CANCELLED_BY_CUSTOMER = "CANCELLED_BY_CUSTOMER";
    String DRIVERID = "DRIVERID";
    String TASK_ID = "TASK_ID";
    String BID_PLACED = "BID_PLACED";
    String GENERAL = "GENERAL";
    String NOTIFICATION_TYPE = "notificationType";
    String BOOKING_KEY = "BOOKING_KEY";
    String PAST_BOOKING_DATA = "PASTBOOKINGDATA";
    String MODE = "MODE";
    String MODE_REVIEWS = "MODE_REVIEWS";
    String LINK = "LINK";
    String COMPLETE_TASK_DETAIL_MODE = "COMPLETE_TASK_DETAIL_MODE";
    String LOCAL_FORMAT = "dd/MM/yyyy, hh:mm a";
    String NOW_FORMAT = "d MMMM yyyy, hh:mm aa";
    String COMPLETED_FROMAT = "dd MMM yyyy";
    String PAST_BOOKING_KEY = "PAST_BOOKING_KEY";
    //String LANDING_PAGE_URL = "http://18.220.26.175:3006/#/landing-page"; //for test server
    //for live server
    String LANDING_PAGE_URL = "http://18.220.26.175:3006/#/landing-page";
}
