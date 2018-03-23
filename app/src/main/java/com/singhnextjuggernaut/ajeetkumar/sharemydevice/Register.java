package com.singhnextjuggernaut.ajeetkumar.sharemydevice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.singhnextjuggernaut.ajeetkumar.sharemydevice.Validations.Utils;

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
            }
        });

    }
}
