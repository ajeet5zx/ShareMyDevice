package com.singhnextjuggernaut.ajeetkumar.sharemydevice;

import android.app.Application;

import io.paperdb.Paper;

/**
 * Created by rahul on 21/3/18.
 */

public class MyInitilizer extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Paper.init(this);
    }
}
