package com.kkwagh.kkw_poly;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SplashScreen extends AppCompatActivity {

    private static int SPLASH_SCREEN = 1500;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView txt1,txt2,txt3,txt4;

        Animation splashanim;



        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);

        txt1=(TextView)findViewById(R.id.txt1);
        txt2=(TextView)findViewById(R.id.txt2);
        txt3=(TextView)findViewById(R.id.txt3);
        txt4=(TextView)findViewById(R.id.txt4);

        // This commented code is for tasting dont messup with this

        //splashanim = AnimationUtils.loadAnimation(this, R.anim.splashanim);
        //top1.startAnimation(splashanim);

        txt1.setAlpha((float) 0.0);
        txt2.setAlpha((float) 0.0);
        txt3.setAlpha((float) 0.0);
        txt4.setAlpha((float) 0.0);

        txt1.animate().alpha((float) 1.0).setDuration(400).setStartDelay(250);
        txt2.animate().alpha((float) 1.0).setDuration(400).setStartDelay(325);
        txt3.animate().alpha((float) 1.0).setDuration(400).setStartDelay(525);
        txt4.animate().alpha((float) 1.0).setDuration(400).setStartDelay(725);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                sp = getSharedPreferences("login", MODE_PRIVATE);
                if (sp.getBoolean("logged", true)) {
                    Intent intent = new Intent(SplashScreen.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    startActivity(new Intent(SplashScreen.this, HomeScreen.class));
                    finish();
                }

            }
        }, SPLASH_SCREEN);
    }
}
