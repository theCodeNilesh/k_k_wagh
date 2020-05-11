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

public class ForgetPasswordActivity extends AppCompatActivity {
    Button send_otp_forgot;
    EditText phone_no;
    String PhoneNoHolder;
    String finalResult;
    Boolean CheckEditText;
    String HttpURL = "http://192.168.0.12/KKWP/kkwp-app-backend/sendOTP_api.php";
    HashMap<String, String> hashMap = new HashMap<>();
    HttpParser httpParse = new HttpParser();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);
        phone_no = findViewById(R.id.phone_no_forgot);
        send_otp_forgot = findViewById(R.id.send_otp_forgot);

        send_otp_forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckEditTextIsEmptyOrNot();
                if (CheckEditText) {
                    OTPFunction(PhoneNoHolder);
                } else {
                    Toast.makeText(ForgetPasswordActivity.this, "Please fill all form fields", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void CheckEditTextIsEmptyOrNot() {
        PhoneNoHolder = phone_no.getText().toString();

        CheckEditText = !TextUtils.isEmpty(PhoneNoHolder);
    }

    public void OTPFunction(final String mobile_no) {
        class OTPFunctionClass extends AsyncTask<String, Void, String> {
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }

            @Override
            protected void onPostExecute(String httpResponseMsg) {
                super.onPostExecute(httpResponseMsg);
                Toast.makeText(ForgetPasswordActivity.this, httpResponseMsg, Toast.LENGTH_LONG).show();
                Intent intent = new Intent(ForgetPasswordActivity.this, ResetPasswordActivity.class);
                intent.putExtra("phone_no", PhoneNoHolder);
                intent.putExtra("otp", httpResponseMsg);
                startActivity(intent);
                finish();
            }

            @Override
            protected String doInBackground(String... params) {
                hashMap.put("mobile_no", params[0]);
                finalResult = httpParse.postRequest(hashMap, HttpURL);
                return finalResult;
            }
        }
        OTPFunctionClass otpFunctionClass = new OTPFunctionClass();
        otpFunctionClass.execute(mobile_no);
    }
}
