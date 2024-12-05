package com.example.signuploginrealtime;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class spice_villa_Myadapter2 extends RecyclerView.Adapter<spice_villa_Myadapter2.MyViewHolder>{

    Context
            spice_villa_context2;
    ArrayList<spice_villa_customer2>
            spice_villa_list2;

    public spice_villa_Myadapter2(Context spice_villa_context2, ArrayList<spice_villa_customer2> spice_villa_list2) {
        this.spice_villa_context2 =
                spice_villa_context2;
        this.spice_villa_list2 =
                spice_villa_list2;
    }

    @NonNull
    @Override
    public spice_villa_Myadapter2.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View spice_villa_v2= LayoutInflater.from(spice_villa_context2).inflate(R.layout.spice_villa_userentry2,parent,false);
        return new spice_villa_Myadapter2.MyViewHolder(spice_villa_v2);
    }

    @Override
    public void onBindViewHolder(@NonNull spice_villa_Myadapter2.MyViewHolder holder, int position) {
        spice_villa_customer2  spice_villa_cust2 = spice_villa_list2.get(position);
        holder.spice_villa_booknm2.setText(spice_villa_cust2.getSpice_villa_bname2());
        holder.spice_villa_bookdy2.setText(spice_villa_cust2.getSpice_villa_bday2());
        holder.spice_villa_booktm2.setText(spice_villa_cust2.getSpice_villa_btime2());
        holder.spice_villa_bookphn2.setText(spice_villa_cust2.getSpice_villa_bphone2());
    }

    @Override
    public int getItemCount() {
        return spice_villa_list2.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView
                spice_villa_booknm2,spice_villa_bookdy2,spice_villa_booktm2,spice_villa_bookphn2;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            spice_villa_booknm2=itemView.findViewById(R.id.spice_villa_txtname2);
            spice_villa_bookdy2=itemView.findViewById(R.id.spice_villa_txtday2);
            spice_villa_booktm2=itemView.findViewById(R.id.spice_villa_txttime2);
            spice_villa_bookphn2=itemView.findViewById(R.id.spice_villa_txtphone2);
        }
    }
}
