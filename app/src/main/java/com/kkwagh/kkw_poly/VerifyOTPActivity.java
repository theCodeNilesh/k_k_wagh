package com.kkwagh.kkw_poly;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class VerifyOTPActivity extends AppCompatActivity {
    Button verify_otp;
    EditText digit1, digit2, digit3, digit4;
    String appended_otp, digit1Holder, digit2Holder, digit3Holder, digit4Holder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_otp);
        verify_otp = findViewById(R.id.verify_otp);

        digit1 = findViewById(R.id.otp1);
        digit2 = findViewById(R.id.otp2);
        digit3 = findViewById(R.id.otp3);
        digit4 = findViewById(R.id.otp4);

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
                } else {
                    Toast.makeText(VerifyOTPActivity.this, "OTP is not valid", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
