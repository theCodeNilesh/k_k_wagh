package com.kkwagh.kkw_poly;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Quiz extends AppCompatActivity {
    QuizLibrary mQuestionLibrary = new QuizLibrary();
    Button back_btn, next;
    TextView questionView;
    RadioButton choice1, choice2, choice3, choice4;
    int questionNumber = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);


        next = findViewById(R.id.next);
        questionView = findViewById(R.id.question);
        choice1 = findViewById(R.id.op1);
        choice2 = findViewById(R.id.op2);
        choice3 = findViewById(R.id.op3);
        choice4 = findViewById(R.id.op4);

        updateQuestion();


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateQuestion();
            }
        });
    }

    private void updateQuestion() {
        questionView.setText(mQuestionLibrary.getQuestion(questionNumber));
        choice1.setText(mQuestionLibrary.getChoice1(questionNumber));
        choice2.setText(mQuestionLibrary.getChoice2(questionNumber));
        choice3.setText(mQuestionLibrary.getChoice3(questionNumber));
        choice4.setText(mQuestionLibrary.getChoice4(questionNumber));
        questionNumber++;
    }
}
