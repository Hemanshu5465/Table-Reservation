package com.example.signuploginrealtime;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class spice_villa_Myadapter9  extends RecyclerView.Adapter<spice_villa_Myadapter9.MyViewHolder>{

    Context
            spice_villa_context9;
    ArrayList<spice_villa_customer9>
            spice_villa_list9;

    public spice_villa_Myadapter9(Context spice_villa_context9, ArrayList<spice_villa_customer9> spice_villa_list9) {
        this.spice_villa_context9 =
                spice_villa_context9;
        this.spice_villa_list9 =
                spice_villa_list9;
    }

    @NonNull
    @Override
    public spice_villa_Myadapter9.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View spice_villa_v9= LayoutInflater.from(spice_villa_context9).inflate(R.layout.spice_villa_userentry9,parent,false);
        return new spice_villa_Myadapter9.MyViewHolder(spice_villa_v9);
    }

    @Override
    public void onBindViewHolder(@NonNull spice_villa_Myadapter9.MyViewHolder holder, int position) {
        spice_villa_customer9  spice_villa_cust9 = spice_villa_list9.get(position);
        holder.spice_villa_booknm9.setText(spice_villa_cust9.getSpice_villa_bname9());
        holder.spice_villa_bookdy9.setText(spice_villa_cust9.getSpice_villa_bday9());
        holder.spice_villa_booktm9.setText(spice_villa_cust9.getSpice_villa_btime9());
        holder.spice_villa_bookphn9.setText(spice_villa_cust9.getSpice_villa_bphone9());

    }

    @Override
    public int getItemCount() {
        return spice_villa_list9.size();

    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView
                spice_villa_booknm9,spice_villa_bookdy9,spice_villa_booktm9,spice_villa_bookphn9;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            spice_villa_booknm9=itemView.findViewById(R.id.spice_villa_txtname9);
            spice_villa_bookdy9=itemView.findViewById(R.id.spice_villa_txtday9);
            spice_villa_booktm9=itemView.findViewById(R.id.spice_villa_txttime9);
            spice_villa_bookphn9=itemView.findViewById(R.id.spice_villa_txtphone9);
        }
    }
}
