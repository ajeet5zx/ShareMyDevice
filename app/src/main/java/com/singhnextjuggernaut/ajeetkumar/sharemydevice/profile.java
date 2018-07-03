package com.singhnextjuggernaut.ajeetkumar.sharemydevice;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.singhnextjuggernaut.ajeetkumar.sharemydevice.constant.AppConstant;
import com.singhnextjuggernaut.ajeetkumar.sharemydevice.data.ResponseMessage;
import com.singhnextjuggernaut.ajeetkumar.sharemydevice.data.UserData;
import com.singhnextjuggernaut.ajeetkumar.sharemydevice.database.CommonData;
import com.singhnextjuggernaut.ajeetkumar.sharemydevice.retrofit.ApiCaller;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class profile extends AppCompatActivity {
    EditText name, email, password, confirmPassowrd;
    Button save;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);


        name = findViewById(R.id.profile_name);
        password = findViewById(R.id.profile_password);
        email = findViewById(R.id.profile_email);
        confirmPassowrd = findViewById(R.id.profile_conf_password);
        save = findViewById(R.id.profile_save);

        name.setText(CommonData.getRegisterationData().getUserData().getName());
        email.setText(CommonData.getRegisterationData().getUserData().getEmail());
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HashMap<String,Object> body = new HashMap<>();
                UserData user = new UserData();
                final String password_t = password.getText().toString().trim();
                final String confirm_password_t = confirmPassowrd.getText().toString().trim();


                user.setDeviceType(AppConstant.DEVICE_TYPE);
                user.setDeviceToken(CommonData.getFCMToken());
                UserData userData = new UserData();
                userData.setName(name.getText().toString());
                userData.setEmail(email.getText().toString());
                body.put("user",user);
                body.put("userData",userData);
                Call<ResponseMessage> call = ApiCaller.getApiInterface().UpdateUsers(CommonData.getAccessToken(),body);
                call.enqueue(new Callback<ResponseMessage>() {
                    @Override
                    public void onResponse(Call<ResponseMessage> call, Response<ResponseMessage> response) {

                    }
                    @Override
                    public void onFailure(Call<ResponseMessage> call, Throwable t) {
                        Log.d("err",t.getMessage());
                    }
                });


            }
        });

    }
}
