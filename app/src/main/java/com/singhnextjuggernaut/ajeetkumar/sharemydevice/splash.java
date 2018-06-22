package com.singhnextjuggernaut.ajeetkumar.sharemydevice;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.singhnextjuggernaut.ajeetkumar.sharemydevice.constant.AppConstant;
import com.singhnextjuggernaut.ajeetkumar.sharemydevice.data.Data;
import com.singhnextjuggernaut.ajeetkumar.sharemydevice.database.CommonData;
import com.singhnextjuggernaut.ajeetkumar.sharemydevice.retrofit.ApiCaller;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        autologin();
    }
    @Override
    protected void onRestart() {
        super.onRestart();

    }

    @Override
    protected void onResume() {
        super.onResume();

    }


    public void autologin()
    {
        HashMap<String, Object> body = new HashMap<>();
        body.put("deviceToken", CommonData.getFCMToken());
        body.put("deviceType", AppConstant.DEVICE_TYPE);
        Call<Data> call = ApiCaller.getApiInterface().accesstokenlogin(CommonData.getAccessToken(), body);
        call.enqueue(new Callback<Data>() {
            @TargetApi(Build.VERSION_CODES.M)
            @Override
            public void onResponse(Call<Data>

                                           call, Response<Data> response) {
                if (response.isSuccessful()) {
                    //Log.d("Token",response.body().getAccessToken());
                    CommonData.saveAccessToken("Bearer " + response.body().getAccessToken());
                    CommonData.saveRegisterationData(response.body());

                    Intent intent = new Intent(splash.this, HomeActivity.class);
                    startActivity(intent);
                    finish();


                } else {


                    Intent intent = new Intent(splash.this, MainActivity.class);
                    startActivity(intent);
                    finish();


                }
            }

            @Override
            public void onFailure(Call<Data> call, Throwable t) {
                Log.d("err", t.getMessage());
                Log.d("SSGS", "dgahAEhAEH");
                Intent intent = new Intent(splash.this, MainActivity.class);
                startActivity(intent);
                finish();

            }
        });
    }

}
