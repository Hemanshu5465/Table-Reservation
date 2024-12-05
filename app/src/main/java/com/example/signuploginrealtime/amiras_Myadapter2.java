package com.example.signuploginrealtime;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class amiras_Myadapter2 extends RecyclerView.Adapter<amiras_Myadapter2.MyViewHolder> {

    Context
            amiras_context2;
    ArrayList<amiras_customer2>
            amiras_list2;

    public amiras_Myadapter2(Context amiras_context2, ArrayList<amiras_customer2> amiras_list2) {
        this.amiras_context2 =
                amiras_context2;
        this.amiras_list2 =
                amiras_list2;
    }

    @NonNull
    @Override
    public amiras_Myadapter2.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View amiras_v2= LayoutInflater.from(amiras_context2).inflate(R.layout.amiras_userentry2,parent,false);
        return new amiras_Myadapter2.MyViewHolder(amiras_v2);
    }

    @Override
    public void onBindViewHolder(@NonNull amiras_Myadapter2.MyViewHolder holder, int position) {
        amiras_customer2 amiras_cust2 = amiras_list2.get(position);
        holder.amiras_booknm2.setText(amiras_cust2.getAmiras_bname2());
        holder.amiras_bookdy2.setText(amiras_cust2.getAmiras_bday2());
        holder.amiras_booktm2.setText(amiras_cust2.getAmiras_btime2());
        holder.amiras_bookphn2.setText(amiras_cust2.getAmiras_bphone2());
    }

    @Override
    public int getItemCount() {
        return amiras_list2.size();

    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView
                amiras_booknm2,amiras_bookdy2,amiras_booktm2,amiras_bookphn2;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            amiras_booknm2=itemView.findViewById(R.id.amiras_txtname2);
            amiras_bookdy2=itemView.findViewById(R.id.amiras_txtday2);
            amiras_booktm2=itemView.findViewById(R.id.amiras_txttime2);
            amiras_bookphn2=itemView.findViewById(R.id.amiras_txtphone2);
        }
    }
}
