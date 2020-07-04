package com.kkwagh.kkw_poly;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

public class GymFacility extends AppCompatActivity {


    //this is for image array import all images here
    private int[] mImages = new int[]{
            R.drawable.gym_1, R.drawable.gym_2, R.drawable.gym_3, R.drawable.gym_4
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gym_facility);

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