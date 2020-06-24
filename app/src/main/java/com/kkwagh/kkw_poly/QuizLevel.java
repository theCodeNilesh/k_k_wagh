package com.kkwagh.kkw_poly;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class QuizLevel extends AppCompatActivity {
    public static final String EXTRA_DIFFICULTY = "extraDifficulty";
    public static final String EXTRA_CATEGORY_ID = "extraCategoryID";
    public static final String EXTRA_CATEGORY_NAME = "extraCategoryName";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_level);

        Intent intent = getIntent();
        final int categoryID = intent.getIntExtra(QuizSub.EXTRA_CATEGORY_ID, 0);
        final String categoryName = intent.getStringExtra(QuizSub.EXTRA_CATEGORY_NAME);

        Button low, medium, high;
        low = findViewById(R.id.low);
        medium = findViewById(R.id.medium);
        high = findViewById(R.id.high);

        low.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QuizLevel.this, QuizActivity.class);
                String difficulty = "Low";
                intent.putExtra(EXTRA_DIFFICULTY, difficulty);
                intent.putExtra(EXTRA_CATEGORY_ID, categoryID);
                intent.putExtra(EXTRA_CATEGORY_NAME, categoryName);
                startActivity(intent);
            }
        });

        medium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QuizLevel.this, QuizActivity.class);
                String difficulty = "Medium";
                intent.putExtra(EXTRA_DIFFICULTY, difficulty);
                startActivity(intent);
            }
        });

        high.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QuizLevel.this, QuizActivity.class);
                String difficulty = "High";
                intent.putExtra(EXTRA_DIFFICULTY, difficulty);
                startActivity(intent);
            }
        });
    }
}