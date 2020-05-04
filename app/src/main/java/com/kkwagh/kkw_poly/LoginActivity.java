package com.kkwagh.kkw_poly;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;

public class LoginActivity extends AppCompatActivity {
    EditText phone_no, password;
    String PhoneNoHolder, PasswordHolder;
    Button login, forgot_password, sign_in;
    String finalResult;
    Boolean CheckEditText;
    String HttpURL = "http://192.168.0.12/KKWP/kkwp-app-backend/login_api.php";
    HashMap<String, String> hashMap = new HashMap<>();
    HttpParser httpParse = new HttpParser();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        phone_no = findViewById(R.id.phone_no);
        password = findViewById(R.id.password);
        forgot_password = findViewById(R.id.forgot_password);
        sign_in = findViewById(R.id.sign_in);
        login = findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckEditTextIsEmptyOrNot();
                if (CheckEditText) {
                    UserLoginFunction(PhoneNoHolder, PasswordHolder);
                } else {
                    Toast.makeText(LoginActivity.this, "Please fill all form fields", Toast.LENGTH_LONG).show();
                }
            }
        });

        forgot_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, WorkInProgressActivity.class);
                startActivity(intent);
            }
        });

        sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, WorkInProgressActivity.class);
                startActivity(intent);
            }
        });
    }

    public void CheckEditTextIsEmptyOrNot() {
        PhoneNoHolder = phone_no.getText().toString();
        PasswordHolder = password.getText().toString();

        if (TextUtils.isEmpty(PhoneNoHolder)) {
            CheckEditText = false;
        } else CheckEditText = !TextUtils.isEmpty(PasswordHolder);
    }

    public void UserLoginFunction(final String mobile_no, final String password) {
        class UserLoginClass extends AsyncTask<String, Void, String> {
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }

            @Override
            protected void onPostExecute(String httpResponseMsg) {
                super.onPostExecute(httpResponseMsg);
                Intent intent = new Intent(LoginActivity.this, WorkInProgressActivity.class);
                if (httpResponseMsg.equals("Success")) {
                    startActivity(intent);
                    Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_LONG).show();
                    finish();
                } else {
                    Toast.makeText(LoginActivity.this, "Login Failed", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            protected String doInBackground(String... params) {
                hashMap.put("mobile_no", params[0]);
                hashMap.put("password", params[1]);
                finalResult = httpParse.postRequest(hashMap, HttpURL);
                return finalResult;
            }
        }
        UserLoginClass userLoginClass = new UserLoginClass();
        userLoginClass.execute(mobile_no, password);
    }
}

