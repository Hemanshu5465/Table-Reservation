package com.example.signuploginrealtime;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class spice_villa_Myadapter3 extends RecyclerView.Adapter<spice_villa_Myadapter3.MyViewHolder> {
    Context
            spice_villa_context3;
    ArrayList<spice_villa_customer3>
            spice_villa_list3;

    public spice_villa_Myadapter3(Context spice_villa_context3, ArrayList<spice_villa_customer3> spice_villa_list3) {
        this.spice_villa_context3 =
                spice_villa_context3;
        this.spice_villa_list3 =
                spice_villa_list3;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View
                spice_villa_v3 =
                LayoutInflater.from(spice_villa_context3).inflate(R.layout.spice_villa_userentry3, parent, false);
        return new MyViewHolder(spice_villa_v3);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        spice_villa_customer3
                spice_villa_cust3 =
                spice_villa_list3.get(position);
        holder.spice_villa_booknm3.setText(spice_villa_cust3.getSpice_villa_bname3());
        holder.spice_villa_bookdy3.setText(spice_villa_cust3.getSpice_villa_bday3());
        holder.spice_villa_booktm3.setText(spice_villa_cust3.getSpice_villa_btime3());
        holder.spice_villa_bookphn3.setText(spice_villa_cust3.getSpice_villa_bphone3());

    }

    @Override
    public int getItemCount() {
        return spice_villa_list3.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView spice_villa_booknm3, spice_villa_bookdy3, spice_villa_booktm3, spice_villa_bookphn3;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            spice_villa_booknm3 = itemView.findViewById(R.id.spice_villa_txtname3);
            spice_villa_bookdy3 = itemView.findViewById(R.id.spice_villa_txtday3);
            spice_villa_booktm3 = itemView.findViewById(R.id.spice_villa_txttime3);
            spice_villa_bookphn3 = itemView.findViewById(R.id.spice_villa_txtphone3);

        }
    }
}
