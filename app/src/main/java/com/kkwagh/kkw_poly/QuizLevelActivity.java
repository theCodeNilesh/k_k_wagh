package com.kkwagh.kkw_poly;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

import static com.kkwagh.kkw_poly.URLenvActivity.ip;

public class QuizLevelActivity extends AppCompatActivity {
    String group, url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_level);
        Button low = findViewById(R.id.low);
        Button medium = findViewById(R.id.medium);
        Button high = findViewById(R.id.high);
        final Bundle lastIntent = getIntent().getExtras();
        final RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        url = ip + "get_group.php";
        SharedPreferences sp = getSharedPreferences("login", MODE_PRIVATE);
        final String userID = sp.getString("userID", "0");
        Log.d("POST", userID);

        low.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        group = response;
                        startActivity(new Intent(QuizLevelActivity.this, QuizActivity.class).putExtra("Subject", lastIntent.get("Subject").toString()).putExtra("Difficulty", "Low").putExtra("group", group));
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                    }
                }) {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> parameters = new HashMap<String, String>();
                        parameters.put("userID", userID);
                        return parameters;
                    }
                };
                requestQueue.add(stringRequest);
            }
        });
        medium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        group = response;
                        startActivity(new Intent(QuizLevelActivity.this, QuizActivity.class).putExtra("Subject", lastIntent.get("Subject").toString()).putExtra("Difficulty", "Medium").putExtra("group", group));
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                    }
                }) {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> parameters = new HashMap<String, String>();
                        parameters.put("userID", userID);
                        return parameters;
                    }
                };
                requestQueue.add(stringRequest);
            }
        });
        high.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        group = response;
                        startActivity(new Intent(QuizLevelActivity.this, QuizActivity.class).putExtra("Subject", lastIntent.get("Subject").toString()).putExtra("Difficulty", "High").putExtra("group", group));
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                    }
                }) {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> parameters = new HashMap<String, String>();
                        parameters.put("userID", userID);
                        return parameters;
                    }
                };
                requestQueue.add(stringRequest);

            }
        });
    }
}
