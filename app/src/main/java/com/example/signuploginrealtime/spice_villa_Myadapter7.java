package com.example.signuploginrealtime;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class spice_villa_Myadapter7 extends RecyclerView.Adapter<spice_villa_Myadapter7.MyViewHolder>{

    Context
            spice_villa_context7;
    ArrayList<spice_villa_customer7>
            spice_villa_list7;

    public spice_villa_Myadapter7(Context spice_villa_context7, ArrayList<spice_villa_customer7> spice_villa_list7) {
        this.spice_villa_context7 =
                spice_villa_context7;
        this.spice_villa_list7 =
                spice_villa_list7;
    }

    @NonNull
    @Override
    public spice_villa_Myadapter7.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View spice_villa_v7= LayoutInflater.from(spice_villa_context7).inflate(R.layout.spice_villa_userentry7,parent,false);
        return new spice_villa_Myadapter7.MyViewHolder(spice_villa_v7);
    }

    @Override
    public void onBindViewHolder(@NonNull spice_villa_Myadapter7.MyViewHolder holder, int position) {
        spice_villa_customer7  spice_villa_cust7 = spice_villa_list7.get(position);
        holder.spice_villa_booknm7.setText(spice_villa_cust7.getSpice_villa_bname7());
        holder.spice_villa_bookdy7.setText(spice_villa_cust7.getSpice_villa_bday7());
        holder.spice_villa_booktm7.setText(spice_villa_cust7.getSpice_villa_btime7());
        holder.spice_villa_bookphn7.setText(spice_villa_cust7.getSpice_villa_bphone7());
    }

    @Override
    public int getItemCount() {
        return spice_villa_list7.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView
                spice_villa_booknm7,spice_villa_bookdy7,spice_villa_booktm7,spice_villa_bookphn7;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            spice_villa_booknm7=itemView.findViewById(R.id.spice_villa_txtname7);
            spice_villa_bookdy7=itemView.findViewById(R.id.spice_villa_txtday7);
            spice_villa_booktm7=itemView.findViewById(R.id.spice_villa_txttime7);
            spice_villa_bookphn7=itemView.findViewById(R.id.spice_villa_txtphone7);
        }
    }
}
