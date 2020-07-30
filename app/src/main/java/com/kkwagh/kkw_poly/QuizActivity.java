package com.kkwagh.kkw_poly;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import java.util.Random;

import static com.kkwagh.kkw_poly.URLenvActivity.ip;

public class QuizActivity extends AppCompatActivity {


    private static final long COUNTDOWN_IN_MILLIS = 30000;
    ArrayList<String> questions_list = new ArrayList<String>();
    ArrayList<String> options_list = new ArrayList<String>();
    ArrayList<String> answer_list = new ArrayList<String>();
    TextView question_text_view, text_view_countdown;
    private RadioGroup rbGroup;
    private RadioButton rb1, rb2, rb3, rb4;
    private CountDownTimer countDownTimer;
    private long timeLeftInMillis, backPressedTime;
    private Button buttonConfirmNext;
    private ColorStateList textColorDefaultCd;
    private int questionCounter, question_index, questionCountTotal, score;
    private String currentQuestion, quizURL, group;
    private boolean answered;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        final Bundle lastIntent = getIntent().getExtras();
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());


        question_text_view = findViewById(R.id.text_view_question);

        TextView category = findViewById(R.id.text_view_category);
        category.append(lastIntent.get("Subject").toString());
        TextView difficulty = findViewById(R.id.text_view_difficulty);
        difficulty.append(lastIntent.get("Difficulty").toString());
        rbGroup = findViewById(R.id.radio_group);
        rb1 = findViewById(R.id.radio_button1);
        rb2 = findViewById(R.id.radio_button2);
        rb3 = findViewById(R.id.radio_button3);
        rb4 = findViewById(R.id.radio_button4);
        text_view_countdown = findViewById(R.id.text_view_countdown);
        buttonConfirmNext = findViewById(R.id.button_confirm_next);
        textColorDefaultCd = text_view_countdown.getTextColors();

        group = lastIntent.get("group").toString();

        quizURL = "";
        if (lastIntent.get("Subject").toString().equals("English")) {
            if (group.equals("1")) {
                if (lastIntent.get("Difficulty").toString().equals("Low"))
                    quizURL = ip + "quiz/English/quiz_g1_l1.php";
                else if (lastIntent.get("Difficulty").toString().equals("Medium"))
                    quizURL = ip + "quiz/English/quiz_g1_l2.php";
                else if (lastIntent.get("Difficulty").toString().equals("High"))
                    quizURL = ip + "quiz/English/quiz_g1_l3.php";
            } else if (group.equals("2")) {
                if (lastIntent.get("Difficulty").toString().equals("Low"))
                    quizURL = ip + "quiz/English/quiz_g2_l1.php";
                else if (lastIntent.get("Difficulty").toString().equals("Medium"))
                    quizURL = ip + "quiz/English/quiz_g2_l2.php";
                else if (lastIntent.get("Difficulty").toString().equals("High"))
                    quizURL = ip + "quiz/English/quiz_g2_l3.php";
            }
        } else if (lastIntent.get("Subject").toString().equals("Physics")) {
            if (group.equals("1")) {
                if (lastIntent.get("Difficulty").toString().equals("Low"))
                    quizURL = ip + "quiz/Physics/quiz_g1_l1.php";
                else if (lastIntent.get("Difficulty").toString().equals("Medium"))
                    quizURL = ip + "quiz/Physics/quiz_g1_l2.php";
                else if (lastIntent.get("Difficulty").toString().equals("High"))
                    quizURL = ip + "quiz/Physics/quiz_g1_l3.php";
            } else if (group.equals("2")) {
                if (lastIntent.get("Difficulty").toString().equals("Low"))
                    quizURL = ip + "quiz/Physics/quiz_g2_l1.php";
                else if (lastIntent.get("Difficulty").toString().equals("Medium"))
                    quizURL = ip + "quiz/Physics/quiz_g2_l2.php";
                else if (lastIntent.get("Difficulty").toString().equals("High"))
                    quizURL = ip + "quiz/Physics/quiz_g2_l3.php";
            }
        } else if (lastIntent.get("Subject").toString().equals("Maths")) {
            if (group.equals("1")) {
                if (lastIntent.get("Difficulty").toString().equals("Low"))
                    quizURL = ip + "quiz/Maths/quiz_g1_l1.php";
                else if (lastIntent.get("Difficulty").toString().equals("Medium"))
                    quizURL = ip + "quiz/Maths/quiz_g1_l2.php";
                else if (lastIntent.get("Difficulty").toString().equals("High"))
                    quizURL = ip + "quiz/Maths/quiz_g1_l3.php";
            } else if (group.equals("2")) {
                if (lastIntent.get("Difficulty").toString().equals("Low"))
                    quizURL = ip + "quiz/Maths/quiz_g2_l1.php";
                else if (lastIntent.get("Difficulty").toString().equals("Medium"))
                    quizURL = ip + "quiz/Maths/quiz_g2_l2.php";
                else if (lastIntent.get("Difficulty").toString().equals("High"))
                    quizURL = ip + "quiz/Maths/quiz_g2_l3.php";
            }
        } else if (lastIntent.get("Subject").toString().equals("Chemistry")) {
            if (group.equals("1")) {
                if (lastIntent.get("Difficulty").toString().equals("Low"))
                    quizURL = ip + "quiz/Chemistry/quiz_g1_l1.php";
                else if (lastIntent.get("Difficulty").toString().equals("Medium"))
                    quizURL = ip + "quiz/Chemistry/quiz_g1_l2.php";
                else if (lastIntent.get("Difficulty").toString().equals("High"))
                    quizURL = ip + "quiz/Chemistry/quiz_g1_l3.php";
            } else if (group.equals("2")) {
                if (lastIntent.get("Difficulty").toString().equals("Low"))
                    quizURL = ip + "quiz/Chemistry/quiz_g2_l1.php";
                else if (lastIntent.get("Difficulty").toString().equals("Medium"))
                    quizURL = ip + "quiz/Chemistry/quiz_g2_l2.php";
                else if (lastIntent.get("Difficulty").toString().equals("High"))
                    quizURL = ip + "quiz/Chemistry/quiz_g2_l3.php";
            }
        }

        Log.d("URL", quizURL);


        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST,
                quizURL, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray questions = response.getJSONArray("question");
                    for (int i = 0; i < questions.length(); i++) {
                        JSONObject question = questions.getJSONObject(i);

                        String queStr = question.getString("question");
                        String option = question.getString("options");
                        String ansStr = question.getString("answer");
                        questions_list.add(queStr);
                        options_list.add(option);
                        answer_list.add(ansStr);

                        Log.d("data", queStr + " " + option + " " + ansStr + "\n");
                    }
                    Log.d("array", questions_list.get(0));
                    quiz();
//                    txtShow.append("===\n");

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(jsonObjectRequest);


    }

    private void quiz() {
        questionCountTotal = questions_list.size();
        long seed = new Random().nextLong();
        Collections.shuffle(questions_list, new Random(seed));
        Collections.shuffle(options_list, new Random(seed));
        Collections.shuffle(answer_list, new Random(seed));
        showNextQuestion();
        buttonConfirmNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!answered)
                    if (rb1.isChecked() || rb2.isChecked() || rb3.isChecked() || rb4.isChecked())
                        checkAnswer();
                    else
                        Toast.makeText(QuizActivity.this, "Please select an answer", Toast.LENGTH_SHORT).show();
                else
                    showNextQuestion();
            }
        });

    }

    private void showNextQuestion() {
        rbGroup.clearCheck();
        rb1.setEnabled(true);
        rb2.setEnabled(true);
        rb3.setEnabled(true);
        rb4.setEnabled(true);
        if (questionCounter < 10) {
            currentQuestion = questions_list.get(questionCounter);
            question_index = questions_list.indexOf(currentQuestion);
            question_text_view.setText("Q" + (questionCounter + 1) + ": " + currentQuestion);
            String[] temp = options_list.get(question_index).split(",");
            rb1.setText(temp[0]);
            rb2.setText(temp[1]);
            rb3.setText(temp[2]);
            rb4.setText(temp[3]);
            questionCounter++;
            Log.d("quiz", "Question: " + questionCounter + "/" + questionCountTotal);
//            textViewQuestionCount.setText("Question: " + questionCounter + "/" + questionCountTotal);
            answered = false;
            buttonConfirmNext.setText("Confirm");
            timeLeftInMillis = COUNTDOWN_IN_MILLIS;
            startCountDown();
        } else
            finishQuiz();
    }

    private void startCountDown() {
        countDownTimer = new CountDownTimer(timeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftInMillis = millisUntilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                timeLeftInMillis = 0;
                updateCountDownText();
                checkAnswer();
            }
        }.start();
    }

    private void updateCountDownText() {
        int minutes = (int) (timeLeftInMillis / 1000) / 60;
        int seconds = (int) (timeLeftInMillis / 1000) % 60;
        String timeFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);
        text_view_countdown.setText(timeFormatted);
        if (timeLeftInMillis < 10000)
            text_view_countdown.setTextColor(Color.RED);
        else
            text_view_countdown.setTextColor(textColorDefaultCd);
    }

    private void checkAnswer() {
        answered = true;
        rb1.setEnabled(false);
        rb2.setEnabled(false);
        rb3.setEnabled(false);
        rb4.setEnabled(false);
        countDownTimer.cancel();
        RadioButton rbSelected = findViewById(rbGroup.getCheckedRadioButtonId());
        int answerNr = rbGroup.indexOfChild(rbSelected) + 1;
        if (answerNr == Integer.parseInt(answer_list.get(question_index)))
            score += 10;
        Log.d("quiz", String.valueOf(score));
        if (questionCounter < questionCountTotal)
            buttonConfirmNext.setText("Next");
        else
            buttonConfirmNext.setText("Finish");
    }

    private void finishQuiz() {
        startActivity(new Intent(QuizActivity.this, QuizCompleted.class));
        finish();
    }

    public void onBackPressed() {
        if (backPressedTime + 2000 > System.currentTimeMillis())
            finishQuiz();
        else
            Toast.makeText(this, "Press back again to finish", Toast.LENGTH_SHORT).show();
        backPressedTime = System.currentTimeMillis();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (countDownTimer != null)
            countDownTimer.cancel();
    }

}

