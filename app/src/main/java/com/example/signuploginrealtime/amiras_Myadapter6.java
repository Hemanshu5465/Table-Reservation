package com.example.signuploginrealtime;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class amiras_Myadapter6 extends RecyclerView.Adapter<amiras_Myadapter6.MyViewHolder> {

    Context
            amiras_context6;
    ArrayList<amiras_customer6>
            amiras_list6;

    public amiras_Myadapter6(Context amiras_context6, ArrayList<amiras_customer6> amiras_list6) {
        this.amiras_context6 =
                amiras_context6;
        this.amiras_list6 =
                amiras_list6;
    }

    @NonNull
    @Override
    public amiras_Myadapter6.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View amiras_v6= LayoutInflater.from(amiras_context6).inflate(R.layout.amiras_userentry6,parent,false);
        return new amiras_Myadapter6.MyViewHolder(amiras_v6);
    }

    @Override
    public void onBindViewHolder(@NonNull amiras_Myadapter6.MyViewHolder holder, int position) {
        amiras_customer6 amiras_cust6 = amiras_list6.get(position);
        holder.amiras_booknm6.setText(amiras_cust6.getAmiras_bname6());
        holder.amiras_bookdy6.setText(amiras_cust6.getAmiras_bday6());
        holder.amiras_booktm6.setText(amiras_cust6.getAmiras_btime6());
        holder.amiras_bookphn6.setText(amiras_cust6.getAmiras_bphone6());
    }

    @Override
    public int getItemCount() {
        return amiras_list6.size();

    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView
                amiras_booknm6,amiras_bookdy6,amiras_booktm6,amiras_bookphn6;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            amiras_booknm6=itemView.findViewById(R.id.amiras_txtname6);
            amiras_bookdy6=itemView.findViewById(R.id.amiras_txtday6);
            amiras_booktm6=itemView.findViewById(R.id.amiras_txttime6);
            amiras_bookphn6=itemView.findViewById(R.id.amiras_txtphone6);
        }
    }
}
