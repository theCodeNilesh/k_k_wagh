package com.kkwagh.kkw_poly;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatRadioButton;

public class RegistrationActivity extends AppCompatActivity {

    AppCompatRadioButton rbleft, rbright;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        rbleft = findViewById(R.id.rbleft);
        rbright = findViewById(R.id.rbright);



    }


    public void onRadioButtonClicked(View view){
        boolean isSelected = ((AppCompatRadioButton)view).isChecked();
        switch (view.getId()){

            case R.id.rbleft:
                if (isSelected){
                    rbleft.setTextColor(Color.WHITE);
                    rbright.setTextColor(Color.BLACK);
                }

                break;
            case R.id.rbright:

                if (isSelected){
                    rbright.setTextColor(Color.WHITE);
                    rbleft.setTextColor(Color.BLACK);

                }
                break;

        }


    }

}
