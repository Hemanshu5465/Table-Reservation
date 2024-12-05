package com.example.signuploginrealtime;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class amrutras_Myadapter8  extends RecyclerView.Adapter<amrutras_Myadapter8.MyViewHolder>{

    Context
            amrutras_context8;
    ArrayList<amrutras_customer8>
            amrutras_list8;

    public amrutras_Myadapter8(Context amrutras_context8, ArrayList<amrutras_customer8> amrutras_list8) {
        this.amrutras_context8 =
                amrutras_context8;
        this.amrutras_list8 =
                amrutras_list8;
    }

    @NonNull
    @Override
    public amrutras_Myadapter8.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View amrutras_v8= LayoutInflater.from(amrutras_context8).inflate(R.layout.amrutras_userentry8,parent,false);
        return new amrutras_Myadapter8.MyViewHolder(amrutras_v8);
    }

    @Override
    public void onBindViewHolder(@NonNull amrutras_Myadapter8.MyViewHolder holder, int position) {
        amrutras_customer8 amrutras_cust8 = amrutras_list8.get(position);
        holder.amrutras_booknm8.setText(amrutras_cust8.getAmrutras_bname8());
        holder.amrutras_bookdy8.setText(amrutras_cust8.getAmrutras_bday8());
        holder.amrutras_booktm8.setText(amrutras_cust8.getAmrutras_btime8());
        holder.amrutras_bookphn8.setText(amrutras_cust8.getAmrutras_bphone8());
    }

    @Override
    public int getItemCount() {
        return amrutras_list8.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView
                amrutras_booknm8,amrutras_bookdy8,amrutras_booktm8,amrutras_bookphn8;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            amrutras_booknm8=itemView.findViewById(R.id.amrutras_txtname8);
            amrutras_bookdy8=itemView.findViewById(R.id.amrutras_txtday8);
            amrutras_booktm8=itemView.findViewById(R.id.amrutras_txttime8);
            amrutras_bookphn8=itemView.findViewById(R.id.amrutras_txtphone8);
        }
    }
}
