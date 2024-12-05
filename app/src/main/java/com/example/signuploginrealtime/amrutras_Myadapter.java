package com.example.signuploginrealtime;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class amrutras_Myadapter extends RecyclerView.Adapter<amrutras_Myadapter.MyViewHolder>{

    Context
            amrutras_context;
    ArrayList<amrutras_customer>
            amrutras_list;

    public amrutras_Myadapter(Context amrutyras_context, ArrayList<amrutras_customer> amrutras_list) {
        this.amrutras_context =
                amrutyras_context;
        this.amrutras_list =
                amrutras_list;
    }

    @NonNull
    @Override
    public amrutras_Myadapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View amrutras_v= LayoutInflater.from(amrutras_context).inflate(R.layout.amrutras_userentry,parent,false);
        return new amrutras_Myadapter.MyViewHolder(amrutras_v);
    }

    @Override
    public void onBindViewHolder(@NonNull amrutras_Myadapter.MyViewHolder holder, int position) {
        amrutras_customer amrutras_cust = amrutras_list.get(position);
        holder.amrutras_booknm.setText(amrutras_cust.getAmrutras_bname());
        holder.amrutras_bookdy.setText(amrutras_cust.getAmrutras_bday());
        holder.amrutras_booktm.setText(amrutras_cust.getAmrutras_btime());
        holder.amrutras_bookphn.setText(amrutras_cust.getAmrutras_bphone());

    }

    @Override
    public int getItemCount() {
        return amrutras_list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView amrutras_booknm,amrutras_bookdy,amrutras_booktm,amrutras_bookphn;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            amrutras_booknm=itemView.findViewById(R.id.amrutras_txtname);
            amrutras_bookdy=itemView.findViewById(R.id.amrutras_txtday);
            amrutras_booktm=itemView.findViewById(R.id.amrutras_txttime);
            amrutras_bookphn=itemView.findViewById(R.id.amrutras_txtphone);
        }
    }
}
