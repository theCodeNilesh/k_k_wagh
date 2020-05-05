package com.kkwagh.kkw_poly;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class VerifyOTPActivity extends AppCompatActivity {
    Button verify_otp;
    String appended_otp, digit1Holder, digit2Holder, digit3Holder, digit4Holder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_otp);
        verify_otp = findViewById(R.id.verify_otp);

        final EditText digit1 = findViewById(R.id.otp1);
        final EditText digit2 = findViewById(R.id.otp2);
        final EditText digit3 = findViewById(R.id.otp3);
        final EditText digit4 = findViewById(R.id.otp4);

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
                    verify_otp.requestFocus();
            }
        });

        verify_otp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                digit1Holder = digit1.getText().toString();
                digit2Holder = digit2.getText().toString();
                digit3Holder = digit3.getText().toString();
                digit4Holder = digit4.getText().toString();

                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(digit1Holder).append(digit2Holder).append(digit3Holder).append(digit4Holder);
                appended_otp = stringBuilder.toString();

                Intent i = getIntent();
                String phone_no1 = i.getStringExtra("phone_no");
                String from_api_otp = i.getStringExtra("otp");

                if (appended_otp.equals(from_api_otp)) {
                    Intent intent5 = new Intent(VerifyOTPActivity.this, RegistrationActivity.class);
                    intent5.putExtra("phone_no", phone_no1);
                    startActivity(intent5);
                    finish();
                } else {
                    Toast.makeText(VerifyOTPActivity.this, "OTP is not valid", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
