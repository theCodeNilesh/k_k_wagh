package com.kkwagh.kkw_poly;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.chinodev.androidneomorphframelayout.NeomorphFrameLayout;
import com.google.android.material.navigation.NavigationView;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageClickListener;
import com.synnapps.carouselview.ImageListener;

public class HomeScreen extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    DrawerLayout drawerLayout;
    NavigationView navigationView;
    androidx.appcompat.widget.Toolbar toolbar;

    private int[] mImages = new int[]{
            R.drawable.demo1, R.drawable.demo2, R.drawable.demo3,R.drawable.demo4

    };

    private String[] mImagesTitle = new String[] {
            "demo1","demo2","demo3","demo4"
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_home_screen);

        //declaring hooks
        NeomorphFrameLayout image_sl;
        CardView card1,card2,card3,card4,card5,card6,card7;

        //finding hooks
        image_sl = (NeomorphFrameLayout)findViewById(R.id.image_sl) ;
        card1 =(CardView) findViewById(R.id.card1);
        card2 =(CardView) findViewById(R.id.card2);
        card3 =(CardView) findViewById(R.id.card3);
        card4 =(CardView) findViewById(R.id.card4);
        card5 =(CardView) findViewById(R.id.card5);
        card6 =(CardView) findViewById(R.id.card6);
        card7 =(CardView) findViewById(R.id.card7);






        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);
        CarouselView carouselView = findViewById(R.id.carousel);
        carouselView.setPageCount(mImages.length);


        //will hide the title.


        setSupportActionBar(toolbar);






        //thus code for imageslider
        carouselView.setImageListener(new ImageListener() {
            @Override
            public void setImageForPosition(int position, ImageView imageView) {

                imageView.setImageResource(mImages[position]);

            }
        });

        carouselView.setImageClickListener(new ImageClickListener() {
            @Override
            public void onClick(int position) {
                Toast.makeText(HomeScreen.this, mImagesTitle[position], Toast.LENGTH_SHORT).show();
            }
        });
        //here it ends

        //this code is for navigation drawer
        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_home);



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

    //this method is for navigation drawer

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer((GravityCompat.START));

        }else {
            super.onBackPressed();

        }
    }

    // This function is for to switch between activities when user click on a driver(items in Drawer) so call activities in this
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {


        switch (item.getItemId()){
            case R.id.nav_home:
                break;

            case R.id.nav_about:
                Intent intent = new Intent(HomeScreen.this,AboutUs.class);
                startActivity(intent);
                break;


        }
        drawerLayout.closeDrawer(GravityCompat.START);



        return true;
    }
}
