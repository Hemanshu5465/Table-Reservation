package com.example.signuploginrealtime;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class amiras_Myadapter extends RecyclerView.Adapter<amiras_Myadapter.MyViewHolder> {

    Context
            amiras_context;
    ArrayList<amiras_customer>
            amiras_list;

    public amiras_Myadapter(Context amiras_context, ArrayList<amiras_customer> amiras_list) {
        this.amiras_context =
                amiras_context;
        this.amiras_list =
                amiras_list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View amiras_v= LayoutInflater.from(amiras_context).inflate(R.layout.amiras_userentry,parent,false);
        return new amiras_Myadapter.MyViewHolder(amiras_v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        amiras_customer amiras_cust = amiras_list.get(position);
        holder.amiras_booknm.setText(amiras_cust.getAmiras_bname());
        holder.amiras_bookdy.setText(amiras_cust.getAmiras_bday());
        holder.amiras_booktm.setText(amiras_cust.getAmiras_btime());
        holder.amiras_bookphn.setText(amiras_cust.getAmiras_bphone());
    }

    @Override
    public int getItemCount() {

        return amiras_list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView amiras_booknm,amiras_bookdy,amiras_booktm,amiras_bookphn;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            amiras_booknm=itemView.findViewById(R.id.amiras_txtname);
            amiras_bookdy=itemView.findViewById(R.id.amiras_txtday);
            amiras_booktm=itemView.findViewById(R.id.amiras_txttime);
            amiras_bookphn=itemView.findViewById(R.id.amiras_txtphone);
        }
    }
}
