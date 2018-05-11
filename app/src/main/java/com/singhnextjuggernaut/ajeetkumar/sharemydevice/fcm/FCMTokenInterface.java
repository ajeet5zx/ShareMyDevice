package com.singhnextjuggernaut.ajeetkumar.sharemydevice.fcm;


public interface FCMTokenInterface {
    /**
     * On token received.
     *
     * @param token the token
     */
    void onTokenReceived(String token);

    /**
     * On failure.
     */
    void onFailure();
}
