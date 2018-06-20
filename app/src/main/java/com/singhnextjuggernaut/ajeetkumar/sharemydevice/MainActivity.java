package com.singhnextjuggernaut.ajeetkumar.sharemydevice;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.google.firebase.iid.FirebaseInstanceId;
import com.singhnextjuggernaut.ajeetkumar.sharemydevice.database.CommonData;


//Devloped by Ajeet singh

public class MainActivity extends AppCompatActivity {
    private Button login;
    private Button register;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login = findViewById(R.id.buttonLogin);
        //Paper.book("Device Data").write("deviceToken",FirebaseInstanceId.getInstance().getToken());
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    CommonData.updateFCMToken(FirebaseInstanceId.getInstance().getToken());
                Intent intent = new Intent(MainActivity.this, loginActivity.class);
                    startActivity(intent);
            }
        });
        register = findViewById(R.id.buttonRegister);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CommonData.updateFCMToken(FirebaseInstanceId.getInstance().getToken());
                Intent intent = new Intent(MainActivity.this, com.singhnextjuggernaut.ajeetkumar.sharemydevice.register.class);
                startActivity(intent);

            }
        });



        }







}


