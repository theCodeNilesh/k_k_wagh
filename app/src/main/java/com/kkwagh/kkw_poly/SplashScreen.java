package com.kkwagh.kkw_poly;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

public class SplashScreen extends AppCompatActivity {

    private static int SPLASH_SCREEN = 1000;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                sp = getSharedPreferences("login", MODE_PRIVATE);
                if (sp.getBoolean("logged", true)) {
                    Intent intent = new Intent(SplashScreen.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    startActivity(new Intent(SplashScreen.this, WorkInProgressActivity.class));
                    finish();
                }

            }
        }, SPLASH_SCREEN);
    }
}
