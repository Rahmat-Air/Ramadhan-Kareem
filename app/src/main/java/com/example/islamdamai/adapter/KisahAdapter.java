package com.example.islamdamai.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.islamdamai.R;
import com.example.islamdamai.model.Kisah;

import java.util.ArrayList;


public class KisahAdapter extends RecyclerView.Adapter<KisahAdapter.HolderList> {

    private ArrayList<Kisah> kisahs;
    private OnItemClickCallback onItemClickCallback2;

    public KisahAdapter(ArrayList<Kisah> kisahs) {
        this.kisahs = kisahs;

    }


    @NonNull
    @Override
    public HolderList onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.kisah, parent, false);
        return new HolderList(view);

    }

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback2 = onItemClickCallback;
    }


    @Override
    public void onBindViewHolder(@NonNull final HolderList holder, final int position) {
        final Kisah kisah = kisahs.get(position);
        Glide.with(holder.itemView.getContext())
                .load(kisah.getGambar())
                .apply(new RequestOptions().override(150, 235))
                .into(holder.gambar);

        Glide.with(holder.itemView.getContext())
                .load(kisah.getBanner())
                .apply(new RequestOptions().override(80, 80))
                .into(holder.banner);

        holder.nama.setText(kisah.getNama());
        holder.desk.setText(kisah.getDesk());
        holder.mujizat.setText(kisah.getMujizat());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickCallback2.onItemClicked(kisahs.get(holder.getAdapterPosition()));

            }
        });

    }

    @Override
    public int getItemCount() {
        return kisahs.size();
    }

    class HolderList extends RecyclerView.ViewHolder {

        ImageView gambar, banner;
        TextView nama, desk,mujizat;

        HolderList(@NonNull View itemView) {
            super(itemView);

            gambar = itemView.findViewById(R.id.thumbnail_ebook);
            banner = itemView.findViewById(R.id.banner12);
            nama = itemView.findViewById(R.id.ebook_judul);
            desk = itemView.findViewById(R.id.desk1);
            mujizat = itemView.findViewById(R.id.mujizat1);

        }
    }

    public interface OnItemClickCallback {
        void onItemClicked(Kisah data);
    }

}



