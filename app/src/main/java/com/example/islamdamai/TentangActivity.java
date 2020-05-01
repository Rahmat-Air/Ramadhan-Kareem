package com.example.islamdamai;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

public class TentangActivity extends AppCompatActivity {
    private ImageView ig1, yt1, gt1, fb1;

    String ig = "https://www.instagram.com/rahmat__09/?hl=id";
    String yt = "https://www.youtube.com/channel/UCwf5j8_4jorra9H3XYtH_EA?view_as=subscriber";
    String github = "https://github.com/Rahmat-Wii";
    String fb = "https://www.facebook.com/rahmat.jr.23";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tentang);

        ig1 = findViewById(R.id.ig);
        yt1 = findViewById(R.id.yt);
        gt1 = findViewById(R.id.github);
        fb1 = findViewById(R.id.fb);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        fb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent go = new Intent(Intent.ACTION_VIEW);
                go.setData(Uri.parse(fb));
                startActivity(go);
            }
        });

        gt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent go = new Intent(Intent.ACTION_VIEW);
                go.setData(Uri.parse(github));
                startActivity(go);
            }
        });
        yt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pergi = new Intent(Intent.ACTION_VIEW);
                pergi.setData(Uri.parse(yt));
                startActivity(pergi);
            }
        });

        ig1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent go = new Intent(Intent.ACTION_VIEW);
                go.setData(Uri.parse(ig));
                startActivity(go);
            }
        });
    }
}
