package com.kkwagh.kkw_poly;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class QuizSubjectActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_sub);

        Button btn = findViewById(R.id.sub1);
        Button btn2 = findViewById(R.id.sub2);
        Button btn3 = findViewById(R.id.sub3);
        Button btn4 = findViewById(R.id.sub4);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(QuizSubjectActivity.this, QuizLevelActivity.class).putExtra("Subject", "English"));
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(QuizSubjectActivity.this, QuizLevelActivity.class).putExtra("Subject", "Physics"));
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(QuizSubjectActivity.this, QuizLevelActivity.class).putExtra("Subject", "Chemistry"));
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(QuizSubjectActivity.this, QuizLevelActivity.class).putExtra("Subject", "Maths"));
            }
        });

    }

}
