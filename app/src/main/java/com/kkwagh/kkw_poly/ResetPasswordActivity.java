package com.kkwagh.kkw_poly;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;

import static com.kkwagh.kkw_poly.URLenvActivity.reset_password;

public class ResetPasswordActivity extends AppCompatActivity {
    Button change_password;
    String appended_otp, digit1Holder, digit2Holder, digit3Holder, digit4Holder, PasswordHolder, ConfirmPasswordHolder, finalResult;
    EditText password, confirm_password;
    Boolean CheckEditText;
    String HttpURL = reset_password;
    HashMap<String, String> hashMap = new HashMap<>();
    HttpParser httpParse = new HttpParser();
    static  String phone_no1,from_api_otp ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);
        change_password = findViewById(R.id.change_pass);

        password = findViewById(R.id.password_confirm);
        confirm_password = findViewById(R.id.confirm_password_confirm);

        Intent i = getIntent();
        phone_no1 = i.getStringExtra("phone_no");
        from_api_otp = i.getStringExtra("otp");


        final EditText digit1 = findViewById(R.id.otp1);
        final EditText digit2 = findViewById(R.id.otp2);
        final EditText digit3 = findViewById(R.id.otp3);
        final EditText digit4 = findViewById(R.id.otp4);

        digit1Holder = digit1.getText().toString();
        digit2Holder = digit2.getText().toString();
        digit3Holder = digit3.getText().toString();
        digit4Holder = digit4.getText().toString();

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(digit1Holder).append(digit2Holder).append(digit3Holder).append(digit4Holder);
        appended_otp = stringBuilder.toString();

        change_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckEditTextIsEmptyOrNot();
                if (CheckEditText) {
                    ResetPasswordFunction(phone_no1, PasswordHolder);
                } else {
                    Toast.makeText(ResetPasswordActivity.this, "Please fill all form fields", Toast.LENGTH_LONG).show();
                }
            }
        });

        digit1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() == 1)
                    digit2.requestFocus();
            }
        });
        digit2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() == 1)
                    digit3.requestFocus();
            }
        });
        digit3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() == 1)
                    digit4.requestFocus();
            }
        });
        digit4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() == 1)
                    password.requestFocus();
            }
        });
    }

    public void CheckEditTextIsEmptyOrNot() {
        PasswordHolder = password.getText().toString();
        ConfirmPasswordHolder = confirm_password.getText().toString();

        if (TextUtils.isEmpty(PasswordHolder) || TextUtils.isEmpty(ConfirmPasswordHolder)) {
            CheckEditText = false;
        } else CheckEditText = !TextUtils.isEmpty(PasswordHolder);
    }

    public void ResetPasswordFunction(final String mobile_no, final String password) {
        class ResetPasswordClass extends AsyncTask<String, Void, String> {
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }

            @Override
            protected void onPostExecute(String httpResponseMsg) {
                super.onPostExecute(httpResponseMsg);
                Intent intent = new Intent(ResetPasswordActivity.this, LoginActivity.class);
                if (appended_otp.equals(from_api_otp)) {
                    if (PasswordHolder.equals(ConfirmPasswordHolder)) {
                        startActivity(intent);
                    }
                } else {
                    Toast.makeText(ResetPasswordActivity.this, "Failed", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            protected String doInBackground(String... params) {
                hashMap.put("password", params[1]);
                hashMap.put("mobile_no",params[0]);
                finalResult = httpParse.postRequest(hashMap, HttpURL);
                return finalResult;
            }
        }
        ResetPasswordClass resetPasswordClass = new ResetPasswordClass();
        resetPasswordClass.execute(mobile_no, password);
    }
}
