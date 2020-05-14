package com.kkwagh.kkw_poly;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.chinodev.androidneomorphframelayout.NeomorphFrameLayout;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;



public class HomeScreen extends AppCompatActivity {

    //this is for image array import all images here
    private int[] mImages = new int[]{
            R.drawable.demo1, R.drawable.demo2, R.drawable.demo3, R.drawable.demo4

    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_home_screen);

        //declaring hooks
        NeomorphFrameLayout image_sl;
        CardView card1, card2, card3, card4, card5, card6, card7;

        //finding hooks
        image_sl = (NeomorphFrameLayout) findViewById(R.id.image_sl);
        card1 = (CardView) findViewById(R.id.card1);
        card2 = (CardView) findViewById(R.id.card2);
        card3 = (CardView) findViewById(R.id.card3);
        card4 = (CardView) findViewById(R.id.card4);
        card5 = (CardView) findViewById(R.id.card5);
        card6 = (CardView) findViewById(R.id.card6);
        card7 = (CardView) findViewById(R.id.card7);


        CarouselView carouselView = findViewById(R.id.carousel);
        carouselView.setPageCount(mImages.length);






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


    }


}
