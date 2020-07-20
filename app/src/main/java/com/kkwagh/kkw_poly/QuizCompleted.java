package com.kkwagh.kkw_poly;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class QuizCompleted extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_completed);

        TextView txt1,txt2;
        Button homeScreen,playAgain;


        txt1=(TextView)findViewById(R.id.txt1);
        txt2=(TextView)findViewById(R.id.txt2);

        homeScreen=(Button)findViewById(R.id.homeScreen);
        playAgain=(Button)findViewById(R.id.playAgain);


        txt1.setAlpha((float) 0.0);
        txt2.setAlpha((float) 0.0);

        txt1.animate().alpha((float) 1.0).setDuration(400).setStartDelay(250);
        txt2.animate().alpha((float) 1.0).setDuration(400).setStartDelay(425);

        homeScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QuizCompleted.this, HomeScreen.class);
                startActivity(intent);
            }
        });

        playAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QuizCompleted.this, QuizSubjectActivity.class);
                startActivity(intent);
            }
        });


    }
}