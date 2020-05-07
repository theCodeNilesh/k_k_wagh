package com.kkwagh.kkw_poly;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class WorkInProgressActivity extends AppCompatActivity {
    Button logOutButton;
    SharedPreferences sp;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workinprogress);
        sp = getSharedPreferences("login", MODE_PRIVATE);
        logOutButton = findViewById(R.id.log_out_btn);
        logOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sp.edit().putBoolean("logged", true).apply();
                startActivity(new Intent(WorkInProgressActivity.this, LoginActivity.class));
                finish();
            }
        });
    }
}
