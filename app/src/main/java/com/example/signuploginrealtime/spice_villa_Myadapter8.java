package com.example.signuploginrealtime;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class spice_villa_Myadapter8  extends RecyclerView.Adapter<spice_villa_Myadapter8.MyViewHolder>{

    Context
            spice_villa_context8;
    ArrayList<spice_villa_customer8>
            spice_villa_list8;

    public spice_villa_Myadapter8(Context spice_villa_context8, ArrayList<spice_villa_customer8> spice_villa_list8) {
        this.spice_villa_context8 =
                spice_villa_context8;
        this.spice_villa_list8 =
                spice_villa_list8;
    }

    @NonNull
    @Override
    public spice_villa_Myadapter8.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View spice_villa_v8= LayoutInflater.from(spice_villa_context8).inflate(R.layout.spice_villa_userentry8,parent,false);
        return new spice_villa_Myadapter8.MyViewHolder(spice_villa_v8);
    }

    @Override
    public void onBindViewHolder(@NonNull spice_villa_Myadapter8.MyViewHolder holder, int position) {
        spice_villa_customer8  spice_villa_cust8 = spice_villa_list8.get(position);
        holder.spice_villa_booknm8.setText(spice_villa_cust8.getSpice_villa_bname8());
        holder.spice_villa_bookdy8.setText(spice_villa_cust8.getSpice_villa_bday8());
        holder.spice_villa_booktm8.setText(spice_villa_cust8.getSpice_villa_btime8());
        holder.spice_villa_bookphn8.setText(spice_villa_cust8.getSpice_villa_bphone8());

    }

    @Override
    public int getItemCount() {
        return spice_villa_list8.size();

    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView
                spice_villa_booknm8,spice_villa_bookdy8,spice_villa_booktm8,spice_villa_bookphn8;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            spice_villa_booknm8=itemView.findViewById(R.id.spice_villa_txtname8);
            spice_villa_bookdy8=itemView.findViewById(R.id.spice_villa_txtday8);
            spice_villa_booktm8=itemView.findViewById(R.id.spice_villa_txttime8);
            spice_villa_bookphn8=itemView.findViewById(R.id.spice_villa_txtphone8);
        }
    }
}
