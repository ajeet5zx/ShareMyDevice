package com.singhnextjuggernaut.ajeetkumar.sharemydevice;

import android.app.Application;

import com.google.firebase.iid.FirebaseInstanceId;
import com.singhnextjuggernaut.ajeetkumar.sharemydevice.database.CommonData;
import com.singhnextjuggernaut.ajeetkumar.sharemydevice.utils.Foreground;

import io.paperdb.Paper;

/**
 * Created by rahul on 21/3/18.
 */

public class MyInitilizer extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Paper.init(this);
        Foreground.init(this);
//        CommonData.updateFCMToken(FirebaseInstanceId.getInstance().getToken());

    }
}
