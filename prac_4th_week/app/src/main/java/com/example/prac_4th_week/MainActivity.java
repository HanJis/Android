package com.example.prac_4th_week;

import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    ScrollView scrup, scrdwon;
    ImageView imgup, imgdown;
    Button btnup, btndown;
    BitmapDrawable bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scrup= (ScrollView) findViewById(R.id.ScrUp);
        scrdwon = (ScrollView)findViewById(R.id.ScrDown);
        scrup.setHorizontalScrollBarEnabled(true);

        imgup = (ImageView) findViewById(R.id.ImgUp);
        imgdown = (ImageView)findViewById(R.id.ImgDown);
        btnup = (Button) findViewById(R.id.BtnUp);
        btndown = (Button) findViewById(R.id.BtnDown);

        Resources res = getResources();
        bitmap = (BitmapDrawable) res.getDrawable(R.drawable.morning);

        int bitmapWidth = bitmap.getIntrinsicWidth();
        int bitmapHeight = bitmap.getIntrinsicHeight();


        imgup.setImageDrawable(bitmap);
        imgup.getLayoutParams().width = bitmapWidth;
        imgup.getLayoutParams().height = bitmapHeight;

        imgdown.setImageDrawable(bitmap);
        imgdown.getLayoutParams().width = bitmapWidth;
        imgdown.getLayoutParams().height = bitmapHeight;
        imgdown.setImageResource(0);
        btnup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgup.setImageResource(R.drawable.morning);
                imgdown.setImageResource(0);
            }
        });
        btndown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgup.setImageResource(0);
                imgdown.setImageResource(R.drawable.morning);
            }
        });


    }
}