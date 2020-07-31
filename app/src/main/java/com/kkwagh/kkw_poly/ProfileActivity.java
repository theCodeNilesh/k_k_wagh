package com.kkwagh.kkw_poly;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        TextView txt1,txt2;
        Button logout_btn;
        CardView card1, card2, card3, card4;

        txt1=(TextView)findViewById(R.id.txt1);
        txt2=(TextView)findViewById(R.id.txt2);
        logout_btn=(Button) findViewById(R.id.logout_btn2);

        card1 = findViewById(R.id.card1);
        card2 = findViewById(R.id.card2);
        card3 = findViewById(R.id.card3);
        card4 = findViewById(R.id.card4);

        txt1.setAlpha((float) 0.0);
        txt2.setAlpha((float) 0.0);

        txt1.setScaleX((float) 0.5);
        txt1.setScaleY((float) 0.5);
        txt2.setScaleX((float) 0.5);
        txt2.setScaleY((float) 0.5);

        card1.setScaleX((float) 0.0);
        card1.setScaleY((float) 0.0);
        card2.setScaleX((float) 0.0);
        card2.setScaleY((float) 0.0);
        card3.setScaleX((float) 0.0);
        card3.setScaleY((float) 0.0);
        card4.setScaleX((float) 0.0);
        card4.setScaleY((float) 0.0);

        txt1.animate().alpha((float) 1.0).setDuration(400).setStartDelay(250);
        txt1.animate().scaleX((float) 1.0).scaleY((float) 1.0).setDuration(400).setStartDelay(250);

        txt2.animate().alpha((float) 1.0).setDuration(400).setStartDelay(450);
        txt2.animate().scaleX((float) 1.0).scaleY((float) 1.0).setDuration(400).setStartDelay(450);

        card1.animate().scaleX((float) 1.0).scaleY((float) 1.0).setDuration(300).setStartDelay(800);
        card2.animate().scaleX((float) 1.0).scaleY((float) 1.0).setDuration(300).setStartDelay(900);
        card3.animate().scaleX((float) 1.0).scaleY((float) 1.0).setDuration(300).setStartDelay(1000);
        card4.animate().scaleX((float) 1.0).scaleY((float) 1.0).setDuration(300).setStartDelay(1100);


        card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, QuizScores.class);
                startActivity(intent);
            }
        });
        card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProfileActivity.this, QuizScores.class));
            }
        });

        card3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, QuizScores.class);
                startActivity(intent);
            }
        });
        card4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProfileActivity.this, QuizScores.class));
            }
        });

    }
}