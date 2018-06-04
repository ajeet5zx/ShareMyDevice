package com.singhnextjuggernaut.ajeetkumar.sharemydevice;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

import com.singhnextjuggernaut.ajeetkumar.sharemydevice.database.CommonData;

public class Profile extends AppCompatActivity {
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
        password.setText(CommonData.getRegisterationData().getUserData().getPassword());
        confirmPassowrd.setText(CommonData.getRegisterationData().getUserData().getPassword());








    }
}
