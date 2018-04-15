package com.singhnextjuggernaut.ajeetkumar.sharemydevice;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.iid.FirebaseInstanceId;
import com.singhnextjuggernaut.ajeetkumar.sharemydevice.constant.AppConstant;
import com.singhnextjuggernaut.ajeetkumar.sharemydevice.data.Data;
import com.singhnextjuggernaut.ajeetkumar.sharemydevice.data.ResponseMessage;
import com.singhnextjuggernaut.ajeetkumar.sharemydevice.data.UserData;
import com.singhnextjuggernaut.ajeetkumar.sharemydevice.database.CommonData;
import com.singhnextjuggernaut.ajeetkumar.sharemydevice.retrofit.ApiCaller;
import com.singhnextjuggernaut.ajeetkumar.sharemydevice.retrofit.ApiInterface;

import java.util.zip.Inflater;

import io.paperdb.Paper;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LoginActivity extends AppCompatActivity {

    private TextView emailText,passwordText;
    Button loginButton,forgotpassButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        emailText = (EditText) findViewById(R.id.loginEmail);
        passwordText = (EditText) findViewById(R.id.loginPassword);
        loginButton = findViewById(R.id.loginButton);
        forgotpassButton = findViewById(R.id.forgotPassword);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Onclick","1");
                final String email = emailText.getText().toString().trim();
                final String password = passwordText.getText().toString().trim();
                if(!TextUtils.isEmpty(email) && !TextUtils.isEmpty(password)) {
                    UserData userData = new UserData();
                    userData.setEmail(email);
                    userData.setPassword(password);
                    userData.setDeviceType(AppConstant.DEVICE_TYPE);
                    userData.setDeviceToken(FirebaseInstanceId.getInstance().getToken());
                    Call<Data> call = ApiCaller.getApiInterface().login(userData);
                    call.enqueue(new Callback<Data>() {
                        @Override
                        public void onResponse(Call<Data> call, Response<Data> response) {
                            if(response.isSuccessful()) {
                                //Log.d("Token",response.body().getAccessToken());
                                CommonData.saveAccessToken(response.body().getAccessToken());
                                CommonData.saveRegisterationData(response.body());
                                Log.d("Paper Data",CommonData.getRegisterationData().toString());
                                Intent intent = new Intent(LoginActivity.this, home.class);
                                startActivity(intent);
                            } else {

                            }
                        }

                        @Override
                        public void onFailure(Call<Data> call, Throwable t) {
                            Log.d("err",t.getMessage());
                            Log.d("SSGS","dgahAEhAEH");
                        }
                    });
                }
            }
        });

        forgotpassButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                LayoutInflater inflater = LoginActivity.this.getLayoutInflater();
                final View forgotpasswordView = inflater.inflate(R.layout.forgot_password_diolog, null);
                builder.setView(forgotpasswordView)
                .setPositiveButton("Submit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        EditText email = (EditText) forgotpasswordView.findViewById(R.id.forgotPasswordEmail);
                        final String email_t = email.getText().toString().trim();
                        if(!TextUtils.isEmpty(email_t)) {
                            UserData userData = new UserData();
                            userData.setEmail(email_t);
                            Call<ResponseMessage> call = ApiCaller.getApiInterface().forgotpassword(userData);
                            call.enqueue(new Callback<ResponseMessage>() {
                                @Override
                                public void onResponse(Call<ResponseMessage> call, Response<ResponseMessage> response) {
                                    if(response.isSuccessful()) {
                                        Log.d("Responce",response.body().toString());
                                        AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                                        builder.setMessage(response.body().getMessage())
                                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                dialog.dismiss();
                                            }
                                        })
                                        .show();

                                    } else {
                                        //respose is unsecessful
                                    }
                                }

                                @Override
                                public void onFailure(Call<ResponseMessage> call, Throwable t) {
                                    Log.d("err",t.getMessage());
                                }
                            });

                        } else {
                            //email is empty
                        }
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                    }
                })
                .show();

            }
        });
    }


}