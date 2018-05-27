package com.singhnextjuggernaut.ajeetkumar.sharemydevice;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.provider.ContactsContract;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.firebase.iid.FirebaseInstanceId;
import com.singhnextjuggernaut.ajeetkumar.sharemydevice.constant.AppConstant;
import com.singhnextjuggernaut.ajeetkumar.sharemydevice.data.Data;
import com.singhnextjuggernaut.ajeetkumar.sharemydevice.data.ResponseMessage;
import com.singhnextjuggernaut.ajeetkumar.sharemydevice.database.CommonData;
import com.singhnextjuggernaut.ajeetkumar.sharemydevice.retrofit.ApiCaller;

import java.util.AbstractMap;
import java.util.HashMap;

import io.paperdb.Paper;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.google.android.gms.common.internal.safeparcel.SafeParcelable.NULL;


//Devloped by Ajeet singh

public class MainActivity extends AppCompatActivity {
    private Button login;
    private Button register;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login = (Button) findViewById(R.id.buttonLogin);
        //Paper.book("Device Data").write("deviceToken",FirebaseInstanceId.getInstance().getToken());
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    CommonData.updateFCMToken(FirebaseInstanceId.getInstance().getToken());
                    Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                    startActivity(intent);
            }
        });
        register = (Button) findViewById(R.id.buttonRegister);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CommonData.updateFCMToken(FirebaseInstanceId.getInstance().getToken());
                Intent intent = new Intent(MainActivity.this, Register.class);
                startActivity(intent);

            }
        });



        }







}


