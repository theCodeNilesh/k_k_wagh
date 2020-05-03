package com.kkwagh.kkw_poly;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private static int SPLASH_SCREEN = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);


        //Do not mess with this part its all designing part


        //variable declarrarion
        ImageView leafbg, circle, blur1, blur2, blur3, blurtop1, blurtop2, blurtop3, blurtop4;
        TextView first_letter, second_letter;


        //retriving variables

        leafbg = (ImageView) findViewById(R.id.leafbg);
        circle = (ImageView) findViewById(R.id.circle);
        blur1 = (ImageView) findViewById(R.id.blur1);
        blur2 = (ImageView) findViewById(R.id.blur2);
        blur3 = (ImageView) findViewById(R.id.blur3);
        blurtop1 = (ImageView) findViewById(R.id.blurtop1);
        blurtop2 = (ImageView) findViewById(R.id.blurtop2);
        blurtop3 = (ImageView) findViewById(R.id.blurtop3);
        blurtop4 = (ImageView) findViewById(R.id.blurtop4);
        first_letter = (TextView) findViewById(R.id.first_letter);
        second_letter = (TextView) findViewById(R.id.second_letter);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(LoginActivity.this, Login.class);
                startActivity(intent);
                finish();

            }
        }, SPLASH_SCREEN);
    }
}
