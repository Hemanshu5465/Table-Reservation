package com.example.signuploginrealtime;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class amrutras_Myadapter6 extends RecyclerView.Adapter<amrutras_Myadapter6.MyViewHolder>{

    Context
            amrutras_context6;
    ArrayList<amrutras_customer6>
            amrutras_list6;

    public amrutras_Myadapter6(Context amrutras_context6, ArrayList<amrutras_customer6> amrutras_list6) {
        this.amrutras_context6 =
                amrutras_context6;
        this.amrutras_list6 =
                amrutras_list6;
    }

    @NonNull
    @Override
    public amrutras_Myadapter6.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View amrutras_v6= LayoutInflater.from(amrutras_context6).inflate(R.layout.amrutras_userentry6,parent,false);
        return new amrutras_Myadapter6.MyViewHolder(amrutras_v6);
    }

    @Override
    public void onBindViewHolder(@NonNull amrutras_Myadapter6.MyViewHolder holder, int position) {
        amrutras_customer6 amrutras_cust6 = amrutras_list6.get(position);
        holder.amrutras_booknm6.setText(amrutras_cust6.getAmrutras_bname6());
        holder.amrutras_bookdy6.setText(amrutras_cust6.getAmrutras_bday6());
        holder.amrutras_booktm6.setText(amrutras_cust6.getAmrutras_btime6());
        holder.amrutras_bookphn6.setText(amrutras_cust6.getAmrutras_bphone6());
    }

    @Override
    public int getItemCount() {
        return amrutras_list6.size();

    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView
                amrutras_booknm6,amrutras_bookdy6,amrutras_booktm6,amrutras_bookphn6;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            amrutras_booknm6=itemView.findViewById(R.id.amrutras_txtname6);
            amrutras_bookdy6=itemView.findViewById(R.id.amrutras_txtday6);
            amrutras_booktm6=itemView.findViewById(R.id.amrutras_txttime6);
            amrutras_bookphn6=itemView.findViewById(R.id.amrutras_txtphone6);
        }
    }
}
