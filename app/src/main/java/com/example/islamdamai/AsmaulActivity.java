package com.example.islamdamai;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.Toast;

import com.example.islamdamai.adapter.AsmaulAdapter;
import com.example.islamdamai.adapter.KisahAdapter;
import com.example.islamdamai.model.Asma;
import com.example.islamdamai.model.Kisah;

import java.util.ArrayList;

public class AsmaulActivity extends AppCompatActivity {
    private RecyclerView recyclerVieww;
    private ArrayList<Asma> kisahs = new ArrayList<>();
    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asmaul);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        mp = MediaPlayer.create(AsmaulActivity.this, R.raw.asmaul_husna);


        recyclerVieww = findViewById(R.id.asmaul_husnwa);
        recyclerVieww.setHasFixedSize(true);

        kisahs.addAll(AsmaulHusna.getListData());

        TunjukkanRey();

    }

    private void TunjukkanRey() {

        recyclerVieww.setLayoutManager(new LinearLayoutManager(this));
        AsmaulAdapter kisahAdapter = new AsmaulAdapter(kisahs);
        recyclerVieww.setAdapter(kisahAdapter);

        kisahAdapter.setOnItemClickCallback(new AsmaulAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Asma kisah) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.maenu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.stop:
                mp.reset();
                mp = MediaPlayer.create(AsmaulActivity.this, R.raw.asmaul_husna);
                break;

            case R.id.play:
                if (mp.isPlaying()) {
                    mp.pause();
                    item.setIcon(R.drawable.ic_play_arrow_black_24dp);
                } else {
                    mp.start();
                    Toast.makeText(AsmaulActivity.this, "Mulai", Toast.LENGTH_SHORT).show();
                    item.setIcon(R.drawable.ic_pause_black_24dp);
                }
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPause() {

        mp.stop();
        super.onPause();
    }

}

