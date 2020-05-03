package com.kkwagh.kkw_poly;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EditText phone_no, password;
        Button login;


        //This is the Id's for phone number, password and login button

        phone_no = (EditText) findViewById(R.id.phone_no);
        password = (EditText) findViewById(R.id.password);
        login = (Button) findViewById(R.id.login);


        setContentView(R.layout.activity_login2);
    }
}
