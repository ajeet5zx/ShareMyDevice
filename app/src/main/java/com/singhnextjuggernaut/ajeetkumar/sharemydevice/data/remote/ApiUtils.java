package com.singhnextjuggernaut.ajeetkumar.sharemydevice.data.remote;

public class ApiUtils {

    private ApiUtils() {
    }

    public static final String BASE_URL = "https://sharemydevise.herokuapp.com/";

    public static APIService getAPIService() {

        return RetrofitClient.getClient(BASE_URL).create(APIService.class);

    }
}