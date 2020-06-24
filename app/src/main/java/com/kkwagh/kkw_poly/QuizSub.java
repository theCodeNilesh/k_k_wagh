package com.kkwagh.kkw_poly;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class QuizSub extends AppCompatActivity {
    public static final String EXTRA_CATEGORY_ID = "extraCategoryID";
    public static final String EXTRA_CATEGORY_NAME = "extraCategoryName";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_sub);

        Button sub1, sub2, sub3, sub4;
        sub1 = findViewById(R.id.sub1);
        sub2 = findViewById(R.id.sub2);
        sub3 = findViewById(R.id.sub3);
        sub4 = findViewById(R.id.sub4);


        sub1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QuizSub.this, QuizLevel.class);
                int categoryID = 1;
                String categoryName = "English";
                intent.putExtra(EXTRA_CATEGORY_ID, categoryID);
                intent.putExtra(EXTRA_CATEGORY_NAME, categoryName);
                startActivity(intent);
            }
        });

        sub2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QuizSub.this, QuizLevel.class);
                int categoryID = 2;
                String categoryName = "Physics";
                intent.putExtra(EXTRA_CATEGORY_ID, categoryID);
                intent.putExtra(EXTRA_CATEGORY_NAME, categoryName);
                startActivity(intent);
            }
        });

        sub3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QuizSub.this, QuizLevel.class);
                int categoryID = 3;
                String categoryName = "Chemistry";
                intent.putExtra(EXTRA_CATEGORY_ID, categoryID);
                intent.putExtra(EXTRA_CATEGORY_NAME, categoryName);
                startActivity(intent);
            }
        });

        sub4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QuizSub.this, QuizLevel.class);
                int categoryID = 4;
                String categoryName = "Maths";
                intent.putExtra(EXTRA_CATEGORY_ID, categoryID);
                intent.putExtra(EXTRA_CATEGORY_NAME, categoryName);
                startActivity(intent);
            }
        });
    }
}