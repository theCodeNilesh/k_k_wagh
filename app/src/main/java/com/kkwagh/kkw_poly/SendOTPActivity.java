package com.kkwagh.kkw_poly;

import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;

public class SendOTPActivity extends AppCompatActivity {
    ImageView top_circle, circle_top;
    EditText phone_no;
    String PhoneNoHolder;
    Button send_otp;
    String finalResult;
    Boolean CheckEditText;
    String HttpURL = "http://192.168.43.238/KKWP/kkwp-app-backend/sendOTP_api.php";
    HashMap<String, String> hashMap = new HashMap<>();
    HttpParser httpParse = new HttpParser();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_otp);
        send_otp = findViewById(R.id.send_otp);

        send_otp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckEditTextIsEmptyOrNot();
                if (CheckEditText) {
                    OTPFunction(PhoneNoHolder);
                } else {
                    Toast.makeText(SendOTPActivity.this, "Please fill all form fields", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void CheckEditTextIsEmptyOrNot() {
        PhoneNoHolder = phone_no.getText().toString();

        if (TextUtils.isEmpty(PhoneNoHolder)) {
            CheckEditText = false;
        } else {
            CheckEditText = true;
        }
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
                Toast.makeText(SendOTPActivity.this, httpResponseMsg, Toast.LENGTH_LONG).show();
            }

            @Override
            protected String doInBackground(String... params) {
                hashMap.put("mobile_no", params[0]);
                finalResult = httpParse.postRequest(hashMap, HttpURL);
                return finalResult;
            }
        }
        OTPFunctionClass userRegisterFunctionClass = new OTPFunctionClass();
        userRegisterFunctionClass.execute(mobile_no);
    }
}
