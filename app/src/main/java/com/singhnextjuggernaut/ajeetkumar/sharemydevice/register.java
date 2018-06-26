package com.singhnextjuggernaut.ajeetkumar.sharemydevice;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.singhnextjuggernaut.ajeetkumar.sharemydevice.constant.AppConstant;
import com.singhnextjuggernaut.ajeetkumar.sharemydevice.data.UserData;
import com.singhnextjuggernaut.ajeetkumar.sharemydevice.database.CommonData;
import com.singhnextjuggernaut.ajeetkumar.sharemydevice.retrofit.ApiCaller;
import com.singhnextjuggernaut.ajeetkumar.sharemydevice.utils.Validations.Utils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class register extends AppCompatActivity {
    private EditText name,email,password,confirm_password;
    private Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        name = findViewById(R.id.registerName);
        email = findViewById(R.id.registerEmail);
        password = findViewById(R.id.registerPassword);
        confirm_password = findViewById(R.id.confregPassword);
        submit = findViewById(R.id.registerButton);
        LinearLayout linearLayout=findViewById(R.id.register_screen);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String email_t = email.getText().toString().trim();
                final String password_t = password.getText().toString().trim();
                final String confirm_password_t = confirm_password.getText().toString().trim();
                final String name_t = name.getText().toString().trim();
                String Expn =

                        "^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]{1}|[\\w-]{2,}))@"

                                + "((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"

                                + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."

                                + "([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"

                                + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])){1}|"

                                + "([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$";




                    if (!TextUtils.isEmpty(email_t) && !TextUtils.isEmpty(password_t) && !TextUtils.isEmpty(confirm_password_t) && !TextUtils.isEmpty(name_t)) {

                        if (email_t.matches(Expn) && email_t.length() > 0) {
                            if (Utils.chkLength(password_t, 6) && Utils.chkLength(confirm_password_t, 6)) {
                                if (Utils.matchPassword(password_t, confirm_password_t)) {
                                    UserData data = new UserData();
                                    data.setName(name_t);
                                    data.setEmail(email_t);
                                    data.setPassword(password_t);
                                    data.setDeviceToken(CommonData.getFCMToken());
                                    data.setDeviceType(AppConstant.DEVICE_TYPE);

                                    Call<UserData> call = ApiCaller.getApiInterface().registeruser(data);
                                    call.enqueue(new Callback<UserData>() {
                                        @Override
                                        public void onResponse(Call<UserData> call, Response<UserData> response) {
                                            if (response.isSuccessful()) {

                                                Snackbar snackbar = Snackbar
                                                        .make(linearLayout, "Registration successful ", Snackbar.LENGTH_LONG);
                                                View snackbar_view = snackbar.getView();
                                                snackbar_view.setBackgroundColor(getResources().getColor(R.color.green));
                                                snackbar.show();
                                                new Handler().postDelayed(new Runnable() {
                                                    @Override
                                                    public void run() {

                                                        Intent intent = new Intent(register.this, MainActivity.class);
                                                        startActivity(intent);
                                                        finish();

                                                    }
                                                }, 1700);

                                            } else {

                                            }
                                        }

                                        @Override
                                        public void onFailure(Call<UserData> call, Throwable t) {
                                            Log.d("err", t.getMessage());
                                        }
                                    });

                                } else {
                                    //password not matched
                                    Snackbar snackbar = Snackbar
                                            .make(linearLayout, "Passwords don't match", Snackbar.LENGTH_LONG);
                                    View snackbar_view = snackbar.getView();
                                    snackbar_view.setBackgroundColor(getResources().getColor(R.color.red));
                                    snackbar.show();
                                }
                            } else {
                                //password length err
                                Snackbar snackbar = Snackbar
                                        .make(linearLayout, "Passwords length is less than 6", Snackbar.LENGTH_LONG);
                                View snackbar_view = snackbar.getView();
                                snackbar_view.setBackgroundColor(getResources().getColor(R.color.red));
                                snackbar.show();
                            }
                        } else {
                            //all * fiels are required
                            Snackbar snackbar = Snackbar
                                    .make(linearLayout, "Email format is incorrect", Snackbar.LENGTH_LONG);
                            View snackbar_view = snackbar.getView();
                            snackbar_view.setBackgroundColor(getResources().getColor(R.color.red));
                            snackbar.show();
                        }
                } else

                {

                    Snackbar snackbar = Snackbar
                            .make(linearLayout, "All fields are mandatory", Snackbar.LENGTH_LONG);
                    View snackbar_view = snackbar.getView();
                    snackbar_view.setBackgroundColor(getResources().getColor(R.color.red));
                    snackbar.show();

                }
            }
        });

    }
}
