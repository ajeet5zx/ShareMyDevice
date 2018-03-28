package com.singhnextjuggernaut.ajeetkumar.sharemydevice.fcm;


import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.NotificationCompat;
import android.util.Log;

import com.singhnextjuggernaut.ajeetkumar.sharemydevice.MainActivity;
import com.singhnextjuggernaut.ajeetkumar.sharemydevice.R;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.singhnextjuggernaut.ajeetkumar.sharemydevice.utils.Foreground;

import org.json.JSONObject;

import java.util.Map;

import static com.singhnextjuggernaut.ajeetkumar.sharemydevice.constant.ApiKeyConstant.BOOKINGID;
import static com.singhnextjuggernaut.ajeetkumar.sharemydevice.constant.ApiKeyConstant.MESSAGE;
import static com.singhnextjuggernaut.ajeetkumar.sharemydevice.constant.AppConstant.BOOKING_MODE;
import static com.singhnextjuggernaut.ajeetkumar.sharemydevice.constant.AppConstant.FROM_NOTIFICATION;
import static com.singhnextjuggernaut.ajeetkumar.sharemydevice.constant.AppConstant.NOTIFICATION_RECEIVED;
import static com.singhnextjuggernaut.ajeetkumar.sharemydevice.constant.AppConstant.NOTIFICATION_TYPE;


/**
 * Developer: Rahul Kumar
 * Dated: 27-03-2018.
 */

public class MyFirebaseMessagingService extends FirebaseMessagingService {
    private static final String TAG = MyFirebaseMessagingService.class.getName();
    private static NotificationManager notificationManager;
    private JSONObject jsonObject;
    private Dialog dialog;
    private Intent intent;

    /**
     *
     */
    public static void clearNotification() {
        if (notificationManager != null) {
            notificationManager.cancelAll();
        }
    }

    @Override
    public void onMessageReceived(final RemoteMessage remoteMessage) {
        // Handle data payload of FCM messages.
        Log.d(TAG, getString(R.string.log_fcm_data_message) + remoteMessage.getData().get(MESSAGE));
        /*
         * Foreground.get(getApplication()).isForeground() checks if the app is in foreground i.e visible not minimized or killed
         * if it is killed or minimized show notification
         */
        /*
        if (Foreground.get(getApplication()).isForeground()) {
            Intent mIntent = new Intent(NOTIFICATION_RECEIVED);
            Bundle mBundle = new Bundle();
            for (String key : remoteMessage.getData().keySet()) {
                mBundle.putString(key, remoteMessage.getData().get(key));
            }
            mIntent.putExtras(mBundle);
            LocalBroadcastManager.getInstance(this).sendBroadcast(mIntent);
        } else {
            //showNotification(remoteMessage.getData());
        }
        */
    }

    /**
     * @param data notification data
     */
    /*
    public void showNotification(final Map<String, String> data) {
        final Intent notificationIntent = new Intent(getApplicationContext(), MainActivity.class);
        notificationIntent.putExtra(NOTIFICATION_TYPE, data.get(NOTIFICATION_TYPE));
        PendingIntent pi = PendingIntent.getActivity(this, 0, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        Resources r = getResources();
        Notification notification = new Notification.Builder(this)
                //     .setTicker(r.getString(R.string.app_name))
                .setStyle(new Notification.BigTextStyle().bigText(data.get(MESSAGE)))
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle(r.getString(R.string.app_name))
                .setContentText(data.get(MESSAGE))
                .setContentIntent(pi)
                .setDefaults(Notification.DEFAULT_ALL)
                .setPriority(Notification.PRIORITY_MAX)
                .setAutoCancel(true)
                .build();
        notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0, notification);
    } */
}
