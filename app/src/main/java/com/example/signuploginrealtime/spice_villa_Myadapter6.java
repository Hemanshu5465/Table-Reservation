package com.example.signuploginrealtime;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class spice_villa_Myadapter6 extends RecyclerView.Adapter<spice_villa_Myadapter6.MyViewHolder>{

    Context
            spice_villa_context6;
    ArrayList<spice_villa_customer6>
            spice_villa_list6;

    public spice_villa_Myadapter6(Context spice_villa_context6, ArrayList<spice_villa_customer6> spice_villa_list6) {
        this.spice_villa_context6 =
                spice_villa_context6;
        this.spice_villa_list6 =
                spice_villa_list6;
    }

    @NonNull
    @Override
    public spice_villa_Myadapter6.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View spice_villa_v6= LayoutInflater.from(spice_villa_context6).inflate(R.layout.spice_villa_userentry6,parent,false);
        return new spice_villa_Myadapter6.MyViewHolder(spice_villa_v6);
    }

    @Override
    public void onBindViewHolder(@NonNull spice_villa_Myadapter6.MyViewHolder holder, int position) {
        spice_villa_customer6  spice_villa_cust6 = spice_villa_list6.get(position);
        holder.spice_villa_booknm6.setText(spice_villa_cust6.getSpice_villa_bname6());
        holder.spice_villa_bookdy6.setText(spice_villa_cust6.getSpice_villa_bday6());
        holder.spice_villa_booktm6.setText(spice_villa_cust6.getSpice_villa_btime6());
        holder.spice_villa_bookphn6.setText(spice_villa_cust6.getSpice_villa_bphone6());
    }

    @Override
    public int getItemCount() {
        return spice_villa_list6.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView
                spice_villa_booknm6,spice_villa_bookdy6,spice_villa_booktm6,spice_villa_bookphn6;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            spice_villa_booknm6=itemView.findViewById(R.id.spice_villa_txtname6);
            spice_villa_bookdy6=itemView.findViewById(R.id.spice_villa_txtday6);
            spice_villa_booktm6=itemView.findViewById(R.id.spice_villa_txttime6);
            spice_villa_bookphn6=itemView.findViewById(R.id.spice_villa_txtphone6);
        }
    }
}
