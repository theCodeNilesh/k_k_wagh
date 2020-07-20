package com.kkwagh.kkw_poly;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class QuizLevelActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_level);
        Button low = findViewById(R.id.low);
        Button medium = findViewById(R.id.medium);
        Button high = findViewById(R.id.high);
        final Bundle lastIntent = getIntent().getExtras();

        low.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(QuizLevelActivity.this, QuizActivity.class).putExtra("Subject", lastIntent.get("Subject").toString()).putExtra("Difficulty", "Low"));
            }
        });
        medium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(QuizLevelActivity.this, QuizActivity.class).putExtra("Subject", lastIntent.get("Subject").toString()).putExtra("Difficulty", "Medium"));
            }
        });
        high.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(QuizLevelActivity.this, QuizActivity.class).putExtra("Subject", lastIntent.get("Subject").toString()).putExtra("Difficulty", "High"));
            }
        });
    }
}
