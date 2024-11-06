package com.raselacademy.homework;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.activity.EdgeToEdge;
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;

import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ImageSlider image_slider;

    CardView calculator, nagad, hotel, shohoz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        image_slider = findViewById(R.id.image_slider);
        calculator = findViewById(R.id.calculator);
        nagad = findViewById(R.id.nagad);
        hotel = findViewById(R.id.hotel);
        shohoz = findViewById(R.id.shohoz);

        ArrayList<SlideModel> imageList = new ArrayList<>();

        imageList.add(new SlideModel(R.drawable.beauty, ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel(R.drawable.beauty_1,ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel(R.drawable.beauty_2,ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel(R.drawable.islamic4,ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel(R.drawable.islamic5,ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel(R.drawable.islamic7,ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel(R.drawable.islamic8,ScaleTypes.CENTER_CROP));

        image_slider.setImageList(imageList);

        if (Build.VERSION.SDK_INT >= 33) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.blue));
            window.setNavigationBarColor(this.getResources().getColor(R.color.blue));}

        calculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //code here
                Intent myIntent = new Intent(MainActivity.this, Calculator.class);
                startActivity(myIntent);
            }
        });

        nagad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //code here
                Intent myIntent = new Intent(MainActivity.this, Nagad.class);
                startActivity(myIntent);
            }
        });

        hotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //code here
                Intent myIntent = new Intent(MainActivity.this, Hotel.class);
                startActivity(myIntent);
            }
        });

        shohoz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //code here
                Intent myIntent = new Intent(MainActivity.this, Shohoz.class);
                startActivity(myIntent);
            }
        });

        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                //code here
                new AlertDialog.Builder(MainActivity.this)
                        .setIcon(R.mipmap.ic_launcher)
                        .setTitle(R.string.app_name)
                        .setCancelable(true)
                        .setMessage("Do you want to really exit?")
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //code here
                                dialog.cancel();
                            }
                        })
                        .setPositiveButton("Yes, Exit", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //code here
                                dialog.dismiss();
                                finishAffinity();
                            }
                        })
                        .show();
            }
        });

    }
}