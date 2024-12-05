package com.example.signuploginrealtime;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class amiras_Myadapter8 extends RecyclerView.Adapter<amiras_Myadapter8.MyViewHolder>{

    Context
            amiras_context8;
    ArrayList<amiras_customer8>
            amiras_list8;

    public amiras_Myadapter8(Context amiras_context8, ArrayList<amiras_customer8> amiras_list8) {
        this.amiras_context8 =
                amiras_context8;
        this.amiras_list8 =
                amiras_list8;
    }

    @NonNull
    @Override
    public amiras_Myadapter8.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View amiras_v8= LayoutInflater.from(amiras_context8).inflate(R.layout.amiras_userentry8,parent,false);
        return new amiras_Myadapter8.MyViewHolder(amiras_v8);
    }

    @Override
    public void onBindViewHolder(@NonNull amiras_Myadapter8.MyViewHolder holder, int position) {
        amiras_customer8 amiras_cust8 = amiras_list8.get(position);
        holder.amiras_booknm8.setText(amiras_cust8.getAmiras_bname8());
        holder.amiras_bookdy8.setText(amiras_cust8.getAmiras_bday8());
        holder.amiras_booktm8.setText(amiras_cust8.getAmiras_btime8());
        holder.amiras_bookphn8.setText(amiras_cust8.getAmiras_bphone8());
    }

    @Override
    public int getItemCount() {
        return amiras_list8.size();

    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView
                amiras_booknm8,amiras_bookdy8,amiras_booktm8,amiras_bookphn8;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            amiras_booknm8=itemView.findViewById(R.id.amiras_txtname8);
            amiras_bookdy8=itemView.findViewById(R.id.amiras_txtday8);
            amiras_booktm8=itemView.findViewById(R.id.amiras_txttime8);
            amiras_bookphn8=itemView.findViewById(R.id.amiras_txtphone8);
        }
    }
}
