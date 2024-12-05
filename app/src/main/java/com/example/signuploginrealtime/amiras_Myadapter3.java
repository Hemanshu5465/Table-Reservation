package com.example.signuploginrealtime;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class amiras_Myadapter3 extends RecyclerView.Adapter<amiras_Myadapter3.MyViewHolder> {

    Context
            amiras_context3;
    ArrayList<amiras_customer3>
            amiras_list3;

    public amiras_Myadapter3(Context amiras_context3, ArrayList<amiras_customer3> amiras_list3) {
        this.amiras_context3 =
                amiras_context3;
        this.amiras_list3 =
                amiras_list3;
    }

    @NonNull
    @Override
    public amiras_Myadapter3.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View amiras_v3= LayoutInflater.from(amiras_context3).inflate(R.layout.amiras_userentry3,parent,false);
        return new amiras_Myadapter3.MyViewHolder(amiras_v3);
    }

    @Override
    public void onBindViewHolder(@NonNull amiras_Myadapter3.MyViewHolder holder, int position) {
        amiras_customer3 amiras_cust3 = amiras_list3.get(position);
        holder.amiras_booknm3.setText(amiras_cust3.getAmiras_bname3());
        holder.amiras_bookdy3.setText(amiras_cust3.getAmiras_bday3());
        holder.amiras_booktm3.setText(amiras_cust3.getAmiras_btime3());
        holder.amiras_bookphn3.setText(amiras_cust3.getAmiras_bphone3());
    }

    @Override
    public int getItemCount() {
        return amiras_list3.size();

    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView
                amiras_booknm3,amiras_bookdy3,amiras_booktm3,amiras_bookphn3;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            amiras_booknm3=itemView.findViewById(R.id.amiras_txtname3);
            amiras_bookdy3=itemView.findViewById(R.id.amiras_txtday3);
            amiras_booktm3=itemView.findViewById(R.id.amiras_txttime3);
            amiras_bookphn3=itemView.findViewById(R.id.amiras_txtphone3);
        }
    }
}
