package com.singhnextjuggernaut.ajeetkumar.sharemydevice.retrofit;

/**
 * Created by rahul on 19/3/18.
 */

public class ApiCaller {

    public static ApiInterface getApiInterface(){
        return ApiClient.getClient().create(ApiInterface.class);
    }
}
