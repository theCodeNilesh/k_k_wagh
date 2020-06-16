package com.kkwagh.kkw_poly;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class QuizSub extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_sub);

        Button sub1, sub2, sub3, sub4;

        sub1 = (Button) findViewById(R.id.sub1);
        sub2 = (Button) findViewById(R.id.sub2);
        sub3 = (Button) findViewById(R.id.sub3);
        sub4 = (Button) findViewById(R.id.sub4);


        sub1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QuizSub.this, QuizLevel.class);
                startActivity(intent);
            }
        });

        sub2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QuizSub.this, QuizLevel.class);
                startActivity(intent);
            }
        });

        sub3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QuizSub.this, QuizLevel.class);
                startActivity(intent);
            }
        });

        sub4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QuizSub.this, QuizLevel.class);
                startActivity(intent);
            }
        });
    }
}