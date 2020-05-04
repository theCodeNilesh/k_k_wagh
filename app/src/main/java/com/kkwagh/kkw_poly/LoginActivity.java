package com.kkwagh.kkw_poly;

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
    Button login;
    String finalResult;
    Boolean CheckEditText;
    String HttpURL = "http://192.168.43.238/KKWP/kkwp-app-backend/login_api.php";
    HashMap<String, String> hashMap = new HashMap<>();
    HttpParser httpParse = new HttpParser();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        phone_no = findViewById(R.id.phone_no);
        password = findViewById(R.id.password);
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
    }

    public void CheckEditTextIsEmptyOrNot() {
        PhoneNoHolder = phone_no.getText().toString();
        PasswordHolder = password.getText().toString();

        if (TextUtils.isEmpty(PhoneNoHolder)) {
            CheckEditText = false;
        } else if (TextUtils.isEmpty(PasswordHolder)) {
            CheckEditText = false;
        } else {
            CheckEditText = true;
        }
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
                if (httpResponseMsg.equals("Success")) {
                    Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_LONG).show();
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

