package com.kkwagh.kkw_poly;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        TextView txt1;
        Button logout_btn;

        txt1=(TextView)findViewById(R.id.txt1);
        logout_btn=(Button) findViewById(R.id.logout_btn2);

        txt1.setAlpha((float) 0.0);
        logout_btn.setAlpha((float) 0.0);

        txt1.setScaleX((float) 0.5);
        txt1.setScaleY((float) 0.5);

        txt1.animate().alpha((float) 1.0).setDuration(400).setStartDelay(250);
        txt1.animate().scaleX((float) 1.0).scaleY((float) 1.0).setDuration(400).setStartDelay(250);
        logout_btn.animate().alpha((float) 1.0).setDuration(400).setStartDelay(450);

    }
}