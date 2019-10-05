package com.meichao.imageview;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.testroundimageview);

        SimpleRoundImageView imageView=findViewById(R.id.testroundimage01);
        Bitmap bitmap= BitmapFactory.decodeResource(getResources(),R.drawable.penny_bank);
        imageView.setBitmap(bitmap);
    }
}
