package com.kkwagh.kkw_poly;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.chinodev.androidneomorphframelayout.NeomorphFrameLayout;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;



public class HomeScreen extends AppCompatActivity {

    //this is for image array import all images here
    private int[] mImages = new int[]{
            R.drawable.welcome, R.drawable.img1,R.drawable.img1_2, R.drawable.img2,R.drawable.img3,R.drawable.img3_2, R.drawable.img4,R.drawable.img4_2, R.drawable.img5,R.drawable.img5_2, R.drawable.img6,R.drawable.img6_2, R.drawable.img7,R.drawable.img7_2, R.drawable.img8,R.drawable.img8_2, R.drawable.img9,R.drawable.img9_2, R.drawable.img10,R.drawable.img10_2, R.drawable.img11,R.drawable.img11_2, R.drawable.img12,R.drawable.img12_2, R.drawable.img13, R.drawable.img13_2

    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_home_screen);

        //declaring hooks
        NeomorphFrameLayout image_sl;
        CardView card1, card2, card3, card4, card5, card6, card7, card8;
        Button logout;
        final SharedPreferences sp;

        //finding hooks
        image_sl = findViewById(R.id.image_sl);
        card1 = findViewById(R.id.card1);
        card2 = findViewById(R.id.card2);
        card3 = findViewById(R.id.card3);
        card4 = findViewById(R.id.card4);
        card5 = findViewById(R.id.card5);
        card6 = findViewById(R.id.card6);
        card7 = findViewById(R.id.card7);
        card8 = findViewById(R.id.card8);
        logout = findViewById(R.id.logout);
        sp = getSharedPreferences("login", MODE_PRIVATE);


        CarouselView carouselView = findViewById(R.id.carousel);
        carouselView.setPageCount(mImages.length);


        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sp.edit().putBoolean("logged", true).apply();
                startActivity(new Intent(HomeScreen.this, LoginActivity.class));
                finish();
            }
        });




        //this code for image slider
        carouselView.setImageListener(new ImageListener() {
            @Override
            public void setImageForPosition(int position, ImageView imageView) {

                imageView.setImageResource(mImages[position]);

            }
        });

        //here it ends


        //Here all animation code starts so interrupt here
        image_sl.setScaleX(0);
        image_sl.setScaleY(0);


        card1.setTranslationY(1100);
        card2.setTranslationY(1100);
        card3.setTranslationY(1200);
        card4.setTranslationY(1200);
        card5.setTranslationY(1300);
        card6.setTranslationY(1300);
        card7.setTranslationY(1400);


        //starts animation
        image_sl.animate().scaleX(1).scaleY(1).setDuration(500).setStartDelay(50);
        card1.animate().translationY(0).setDuration(300).setStartDelay(250);
        card2.animate().translationY(0).setDuration(300).setStartDelay(350);
        card3.animate().translationY(0).setDuration(300).setStartDelay(450);
        card4.animate().translationY(0).setDuration(300).setStartDelay(550);
        card5.animate().translationY(0).setDuration(300).setStartDelay(650);
        card6.animate().translationY(0).setDuration(300).setStartDelay(750);
        card7.animate().translationY(0).setDuration(300).setStartDelay(850);


        card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeScreen.this, AboutUs.class);
                startActivity(intent);
            }
        });
        card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeScreen.this, Departments.class));
            }
        });

        card3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeScreen.this, QuizLevel.class);
                startActivity(intent);
            }
        });
        card4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeScreen.this, WorkInProgressActivity.class));
            }
        });

        card5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeScreen.this, AdmissionProcess.class);
                startActivity(intent);
            }
        });

        card6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeScreen.this, Achievment.class);
                startActivity(intent);
            }
        });
        card7
                .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeScreen.this, WorkInProgressActivity.class));
            }
        });

        card8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeScreen.this, ContactUs.class);
                startActivity(intent);
            }
        });

    }


}

