package com.singhnextjuggernaut.ajeetkumar.sharemydevice.fcm;


import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.singhnextjuggernaut.ajeetkumar.sharemydevice.MainActivity;
import com.singhnextjuggernaut.ajeetkumar.sharemydevice.R;

import org.json.JSONObject;

import java.util.Map;

import static com.singhnextjuggernaut.ajeetkumar.sharemydevice.constant.ApiKeyConstant.MESSAGE;
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
    private String channel_id = "1";
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
        showNotification(remoteMessage.getData());

    }

    /**
     * @param data notification data
     */

    public void showNotification(final Map<String, String> data) {
        notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        final Intent notificationIntent = new Intent(getApplicationContext(), MainActivity.class);
        notificationIntent.putExtra(NOTIFICATION_TYPE, data.get(NOTIFICATION_TYPE));

        PendingIntent pi = PendingIntent.getActivity(this, 0, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            Uri uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
            NotificationChannel notificationChannel = new NotificationChannel(channel_id, "MAIN", NotificationManager.IMPORTANCE_HIGH);
            notificationChannel.enableLights(true);
            notificationChannel.enableVibration(true);
            notificationChannel.setVibrationPattern(new long[]{100, 200, 300, 400, 500, 400, 300, 200, 400});
            notificationChannel.setSound(null, Notification.AUDIO_ATTRIBUTES_DEFAULT);
            notificationManager.createNotificationChannel(notificationChannel);
        }



        Resources r = getResources();

        NotificationCompat.Builder mNotificationCompact = new NotificationCompat.Builder(this, channel_id)
                //     .setTicker(r.getString(R.string.app_name))
                .setStyle(new NotificationCompat.BigTextStyle().bigText(data.get(MESSAGE)))
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle(r.getString(R.string.app_name))
                .setContentText(data.get(MESSAGE))
                .setContentIntent(pi)
                .setDefaults(Notification.DEFAULT_ALL)
                // .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))
                .setPriority(Notification.PRIORITY_MAX)
                .setAutoCancel(true);

        mNotificationCompact.setChannelId(channel_id);
        notificationManager.notify(0, mNotificationCompact.build());

    }
}
