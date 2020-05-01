package com.example.islamdamai;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class Main3Activity extends AppCompatActivity {

    private int waktu_loading = 4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent home = new Intent(Main3Activity.this, MainActivity.class);
                startActivity(home);
                finish();

            }
        }, waktu_loading);
    }
}