package com.example.signuploginrealtime;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class amrutras_Myadapter3 extends RecyclerView.Adapter<amrutras_Myadapter3.MyViewHolder>{

    Context
            amrutras_context3;
    ArrayList<amrutras_customer3>
            amrutras_list3;

    public amrutras_Myadapter3(Context amrutras_context3, ArrayList<amrutras_customer3> amrutras_list3) {
        this.amrutras_context3 =
                amrutras_context3;
        this.amrutras_list3 =
                amrutras_list3;
    }

    @NonNull
    @Override
    public amrutras_Myadapter3.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View amrutras_v3= LayoutInflater.from(amrutras_context3).inflate(R.layout.amrutras_userentry3,parent,false);
        return new amrutras_Myadapter3.MyViewHolder(amrutras_v3);
    }

    @Override
    public void onBindViewHolder(@NonNull amrutras_Myadapter3.MyViewHolder holder, int position) {
        amrutras_customer3 amrutras_cust3 = amrutras_list3.get(position);
        holder.amrutras_booknm3.setText(amrutras_cust3.getAmrutras_bname3());
        holder.amrutras_bookdy3.setText(amrutras_cust3.getAmrutras_bday3());
        holder.amrutras_booktm3.setText(amrutras_cust3.getAmrutras_btime3());
        holder.amrutras_bookphn3.setText(amrutras_cust3.getAmrutras_bphone3());
    }

    @Override
    public int getItemCount() {
        return amrutras_list3.size();

    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView
                amrutras_booknm3,amrutras_bookdy3,amrutras_booktm3,amrutras_bookphn3;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            amrutras_booknm3=itemView.findViewById(R.id.amrutras_txtname3);
            amrutras_bookdy3=itemView.findViewById(R.id.amrutras_txtday3);
            amrutras_booktm3=itemView.findViewById(R.id.amrutras_txttime3);
            amrutras_bookphn3=itemView.findViewById(R.id.amrutras_txtphone3);
        }
    }
}
