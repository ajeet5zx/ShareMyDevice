package com.singhnextjuggernaut.ajeetkumar.sharemydevice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.iid.FirebaseInstanceId;
import com.singhnextjuggernaut.ajeetkumar.sharemydevice.database.CommonData;

import io.paperdb.Paper;


//Devloped by Ajeet singh

public class MainActivity extends AppCompatActivity {
    private Button login;
    private Button register;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login = (Button) findViewById(R.id.buttonLogin);
        CommonData.updateFCMToken(FirebaseInstanceId.getInstance().getToken());
        //Paper.book("Device Data").write("deviceToken",FirebaseInstanceId.getInstance().getToken());
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);

            }
        });
        register = (Button) findViewById(R.id.buttonRegister);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Register.class);
                startActivity(intent);

            }
        });
    }

    }


