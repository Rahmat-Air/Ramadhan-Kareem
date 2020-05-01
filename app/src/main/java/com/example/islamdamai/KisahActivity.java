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

import com.example.islamdamai.adapter.KisahAdapter;
import com.example.islamdamai.model.Kisah;

import java.util.ArrayList;

public class KisahActivity extends AppCompatActivity {
    private RecyclerView recyclerVieww;
    private ArrayList<Kisah> kisahs = new ArrayList<>();
    private KisahAdapter adapter;
    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kisah);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        mp = MediaPlayer.create(KisahActivity.this, R.raw.dua_lima_nabi);


        recyclerVieww = findViewById(R.id.kisah);
        recyclerVieww.setHasFixedSize(true);

        kisahs.addAll(KisahNabi.getListData());

        TunjukkanRey();

    }

    private void TunjukkanRey() {

        recyclerVieww.setLayoutManager(new GridLayoutManager(this, 2));
        KisahAdapter kisahAdapter = new KisahAdapter(kisahs);
        recyclerVieww.setAdapter(kisahAdapter);

        kisahAdapter.setOnItemClickCallback(new KisahAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Kisah kisah) {
                showSelectedHero(kisah);
            }
        });
    }

    private void showSelectedHero(Kisah kisah) {


        Intent prgi = new Intent(KisahActivity.this, DetailActivity.class);
        prgi.putExtra("Nama", kisah.getNama());
        prgi.putExtra("Gambar", kisah.getGambar());
        prgi.putExtra("Banner", kisah.getBanner());
        prgi.putExtra("deskripsi", kisah.getDesk());
        prgi.putExtra("mujizat", kisah.getMujizat());
        startActivity(prgi);

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
                mp = MediaPlayer.create(KisahActivity.this, R.raw.dua_lima_nabi);
                break;

            case R.id.play:
                if (mp.isPlaying()) {
                    mp.pause();
                    item.setIcon(R.drawable.ic_play_arrow_black_24dp);
                } else {
                    mp.start();
                    Toast.makeText(KisahActivity.this, "Mulai", Toast.LENGTH_SHORT).show();
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

