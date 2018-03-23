package com.singhnextjuggernaut.ajeetkumar.sharemydevice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.singhnextjuggernaut.ajeetkumar.sharemydevice.Validations.Utils;
import com.singhnextjuggernaut.ajeetkumar.sharemydevice.data.UserData;

public class Register extends AppCompatActivity {
    private EditText name,email,password,confirm_password;
    private Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        name = (EditText) findViewById(R.id.registerName);
        email = (EditText) findViewById(R.id.registerEmail);
        password = (EditText) findViewById(R.id.registerPassword);
        confirm_password = (EditText) findViewById(R.id.confregPassword);
        submit = (Button) findViewById(R.id.registerButton);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String email_t = email.getText().toString().trim();
                final String password_t = password.getText().toString().trim();
                final String confirm_password_t = confirm_password.getText().toString().trim();
                final String name_t = name.getText().toString().trim();

                if(!TextUtils.isEmpty(email_t) && !TextUtils.isEmpty(password_t) && !TextUtils.isEmpty(confirm_password_t) && !TextUtils.isEmpty(name_t)) {
                    if(Utils.chkLength(password_t,6) && Utils.chkLength(confirm_password_t,6)) {
                        if(Utils.matchPassword(password_t,confirm_password_t)) {
                            UserData data = new UserData();
                            //data.set
                        } else {
                            //password not matched
                        }
                    } else {
                        //password length err
                    }
                } else {
                    //all * fiels are required
                }
            }
        });

    }
}
