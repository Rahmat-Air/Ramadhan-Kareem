package com.example.islamdamai;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;


public class DetailActivity extends AppCompatActivity {

    TextView nama, desk, mujizat;
    ImageView banner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        banner = findViewById(R.id.banner1);
        desk = findViewById(R.id.desk1);
        nama = findViewById(R.id.nama1);
        mujizat = findViewById(R.id.mujizat2);


        gambarDetail();
        nama();
        deskr();
        mujizat12();

    }

    @SuppressLint("SetTextI18n")
    private void mujizat12() {
        mujizat.setText("" + getIntent().getStringExtra("mujizat"));
    }

    private void gambarDetail() {
        banner.setImageResource(getIntent().getIntExtra("Banner", 0));
    }


    @SuppressLint("SetTextI18n")
    private void nama() {
        nama.setText(" " + getIntent().getStringExtra("Nama"));
    }

    @SuppressLint("SetTextI18n")
    private void deskr() {
        desk.setText(" " + getIntent().getStringExtra("deskripsi"));

    }


}
