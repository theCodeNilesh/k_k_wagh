package com.kkwagh.kkw_poly;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

public class SportsFacility extends AppCompatActivity {

    //this is for image array import all images here
    private int[] mImages = new int[]{
            R.drawable.sport_1, R.drawable.sport_2, R.drawable.sport_3, R.drawable.sport_4, R.drawable.sport_5, R.drawable.sport_6, R.drawable.sport_7

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sports_facility);

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
    }
}