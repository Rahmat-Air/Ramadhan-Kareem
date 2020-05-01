package com.example.islamdamai.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.islamdamai.R;
import com.example.islamdamai.model.Asma;

import java.util.ArrayList;


public class AsmaulAdapter extends RecyclerView.Adapter<AsmaulAdapter.HolderList> {

    private ArrayList<Asma> asmas;
    private OnItemClickCallback onItemClickCallback2;

    public AsmaulAdapter(ArrayList<Asma> asmas) {
        this.asmas = asmas;

    }


    @NonNull
    @Override
    public HolderList onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lay, parent, false);
        return new HolderList(view);

    }

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback2 = onItemClickCallback;
    }


    @Override
    public void onBindViewHolder(@NonNull final HolderList holder, final int position) {
        final Asma asma = asmas.get(position);

        holder.nomor.setText(asma.getNomor());
        holder.arab.setText(asma.getArab());
        holder.latin.setText(asma.getLatin());
        holder.arti.setText(asma.getArti());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickCallback2.onItemClicked(asmas.get(holder.getAdapterPosition()));

            }
        });

    }

    @Override
    public int getItemCount() {
        return asmas.size();
    }

    class HolderList extends RecyclerView.ViewHolder {

        TextView nomor, arab, latin, arti;

        HolderList(@NonNull View itemView) {
            super(itemView);

            nomor = itemView.findViewById(R.id.nomor);
            arab = itemView.findViewById(R.id.Arab);
            latin = itemView.findViewById(R.id.latin);
            arti = itemView.findViewById(R.id.arti);

        }
    }

    public interface OnItemClickCallback {
        void onItemClicked(Asma data);
    }

}

