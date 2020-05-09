package com.kkwagh.kkw_poly;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Forget_Password extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget__password);

        Button send_otp_forgot;

        send_otp_forgot = (Button) findViewById(R.id.send_otp_forgot);


        send_otp_forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Forget_Password.this, ConfirmForgotPass.class);
                startActivity(intent);
            }

        });

    }
}
