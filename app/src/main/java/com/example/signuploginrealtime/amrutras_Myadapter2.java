package com.example.signuploginrealtime;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class amrutras_Myadapter2 extends RecyclerView.Adapter<amrutras_Myadapter2.MyViewHolder>{

    Context
            amrutras_context2;
    ArrayList<amrutras_customer2>
            amrutras_list2;

    public amrutras_Myadapter2(Context amrutras_context2, ArrayList<amrutras_customer2> amrutras_list2) {
        this.amrutras_context2 =
                amrutras_context2;
        this.amrutras_list2 =
                amrutras_list2;
    }

    @NonNull
    @Override
    public amrutras_Myadapter2.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View amrutras_v2= LayoutInflater.from(amrutras_context2).inflate(R.layout.amrutras_userentry2,parent,false);
        return new amrutras_Myadapter2.MyViewHolder(amrutras_v2);
    }

    @Override
    public void onBindViewHolder(@NonNull amrutras_Myadapter2.MyViewHolder holder, int position) {
        amrutras_customer2 amrutras_cust2 = amrutras_list2.get(position);
        holder.amrutras_booknm2.setText(amrutras_cust2.getAmrutras_bname2());
        holder.amrutras_bookdy2.setText(amrutras_cust2.getAmrutras_bday2());
        holder.amrutras_booktm2.setText(amrutras_cust2.getAmrutras_btime2());
        holder.amrutras_bookphn2.setText(amrutras_cust2.getAmrutras_bphone2());
    }

    @Override
    public int getItemCount() {
        return amrutras_list2.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView
                amrutras_booknm2,amrutras_bookdy2,amrutras_booktm2,amrutras_bookphn2;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            amrutras_booknm2=itemView.findViewById(R.id.amrutras_txtname2);
            amrutras_bookdy2=itemView.findViewById(R.id.amrutras_txtday2);
            amrutras_booktm2=itemView.findViewById(R.id.amrutras_txttime2);
            amrutras_bookphn2=itemView.findViewById(R.id.amrutras_txtphone2);
        }
    }
}
