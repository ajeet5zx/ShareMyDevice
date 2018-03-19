package com.singhnextjuggernaut.ajeetkumar.sharemydevice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.iid.FirebaseInstanceId;
import com.singhnextjuggernaut.ajeetkumar.sharemydevice.constant.AppConstant;
import com.singhnextjuggernaut.ajeetkumar.sharemydevice.data.Data;
import com.singhnextjuggernaut.ajeetkumar.sharemydevice.data.UserData;
import com.singhnextjuggernaut.ajeetkumar.sharemydevice.retrofit.ApiCaller;
import com.singhnextjuggernaut.ajeetkumar.sharemydevice.retrofit.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LoginActivity extends AppCompatActivity {

    private TextView emailText,passwordText;
    Button loginButton;
    ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        emailText = (EditText) findViewById(R.id.loginEmail);
        passwordText = (EditText) findViewById(R.id.loginPassword);
        loginButton = (Button) findViewById(R.id.loginButton);


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
                    userData.setDeviceToken("qAFWhgqEhbWRnhjWRhnWRhwerhnwene");
                    apiInterface = ApiCaller.getApiInterface();
                    Call<Data> call = apiInterface.login(userData);
                    call.enqueue(new Callback<Data>() {
                        @Override
                        public void onResponse(Call<Data> call, Response<Data> response) {
                            Log.d("Response",response.body().toString());
                        }

                        @Override
                        public void onFailure(Call<Data> call, Throwable t) {
                            Log.d("err",t.getMessage());
                        }
                    });
                }
            }
        });
    }


}