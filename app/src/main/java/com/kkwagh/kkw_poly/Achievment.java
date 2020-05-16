package com.kkwagh.kkw_poly;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

public class Achievment extends AppCompatActivity {

    //this is for image array import all images here
    private int[] mImages = new int[]{
            R.drawable.demo1, R.drawable.demo2, R.drawable.demo3, R.drawable.demo4

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_achievment);

        Button back_btn;


        back_btn= (Button) findViewById(R.id.back_btn);


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


        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Achievment.this, HomeScreen.class);
                startActivity(intent);
            }
        });



    }
}
