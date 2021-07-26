package com.example.wastemanagement;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class timetableAdapter extends RecyclerView.Adapter<timetableAdapter.NumberViewHolder> {

    private Context context;
    private ArrayList nom, prenom, lieu, heure;

    public timetableAdapter(Context context, ArrayList nom, ArrayList prenom, ArrayList lieu, ArrayList heure) {
        this.context = context;
        this.nom = nom;
        this.prenom = prenom;
        this.lieu = lieu;
        this.heure = heure;
    }

    @NonNull
    @Override
    public NumberViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.number_list_item, parent, false);
        return new NumberViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NumberViewHolder holder, int position) {
        holder.bind(position);
    }

    public int getItemCount(){
        return nom.size();
    }

    public class NumberViewHolder extends RecyclerView.ViewHolder {
        TextView nom_txt, prenom_txt, lieu_txt, heure_txt;

        public NumberViewHolder(@NonNull View itemView) {
            super(itemView);

            nom_txt = itemView.findViewById(R.id.nom_txt);
            prenom_txt = itemView.findViewById(R.id.prenom_txt);
            lieu_txt = itemView.findViewById(R.id.lieu_txt);
            heure_txt = itemView.findViewById(R.id.heure_txt);
        }

        void bind(int listindex) { nom_txt.setText(String.valueOf(listindex));}
    }
}
