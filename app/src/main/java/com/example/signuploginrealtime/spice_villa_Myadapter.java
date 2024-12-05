package com.example.signuploginrealtime;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class spice_villa_Myadapter extends RecyclerView.Adapter<spice_villa_Myadapter.MyViewHolder>{

    Context
            spice_villa_context;
    ArrayList<spice_villa_customer>
            spice_villa_list;



    public spice_villa_Myadapter(Context spice_villa_context, ArrayList<spice_villa_customer> spice_villa_list) {
        this.spice_villa_context =
                spice_villa_context;
        this.spice_villa_list =
                spice_villa_list;
    }

    @NonNull
    @Override
    public spice_villa_Myadapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View spice_villa_v= LayoutInflater.from(spice_villa_context).inflate(R.layout.spice_villa_userentry,parent,false);
        return new spice_villa_Myadapter.MyViewHolder(spice_villa_v);
    }

    @Override
    public void onBindViewHolder(@NonNull spice_villa_Myadapter.MyViewHolder holder, int position) {
        spice_villa_customer  spice_villa_cust = spice_villa_list.get(position);
        holder.spice_villa_booknm.setText(spice_villa_cust.getSpice_villa_bname());
        holder.spice_villa_bookdy.setText(spice_villa_cust.getSpice_villa_bday());
        holder.spice_villa_booktm.setText(spice_villa_cust.getSpice_villa_btime());
        holder.spice_villa_bookphn.setText(spice_villa_cust.getSpice_villa_bphone());

    }

    @Override
    public int getItemCount() {
        return spice_villa_list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView spice_villa_booknm,spice_villa_bookdy,spice_villa_booktm,spice_villa_bookphn;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            spice_villa_booknm=itemView.findViewById(R.id.spice_villa_txtname);
            spice_villa_bookdy=itemView.findViewById(R.id.spice_villa_txtday);
            spice_villa_booktm=itemView.findViewById(R.id.spice_villa_txttime);
            spice_villa_bookphn=itemView.findViewById(R.id.spice_villa_txtphone);
        }
    }
}
