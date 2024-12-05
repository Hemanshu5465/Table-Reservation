package com.example.signuploginrealtime;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class amiras_Myadapter9 extends RecyclerView.Adapter<amiras_Myadapter9.MyViewHolder>{

    Context
            amiras_context9;
    ArrayList<amiras_customer9>
            amiras_list9;

    public amiras_Myadapter9(Context amiras_context9, ArrayList<amiras_customer9> amiras_list9) {
        this.amiras_context9 =
                amiras_context9;
        this.amiras_list9 =
                amiras_list9;
    }

    @NonNull
    @Override
    public amiras_Myadapter9.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View amiras_v9= LayoutInflater.from(amiras_context9).inflate(R.layout.amiras_userentry9,parent,false);
        return new amiras_Myadapter9.MyViewHolder(amiras_v9);
    }

    @Override
    public void onBindViewHolder(@NonNull amiras_Myadapter9.MyViewHolder holder, int position) {
        amiras_customer9 amiras_cust9 = amiras_list9.get(position);
        holder.amiras_booknm9.setText(amiras_cust9.getAmiras_bname9());
        holder.amiras_bookdy9.setText(amiras_cust9.getAmiras_bday9());
        holder.amiras_booktm9.setText(amiras_cust9.getAmiras_btime9());
        holder.amiras_bookphn9.setText(amiras_cust9.getAmiras_bphone9());
    }

    @Override
    public int getItemCount() {
        return amiras_list9.size();

    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView
                amiras_booknm9,amiras_bookdy9,amiras_booktm9,amiras_bookphn9;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            amiras_booknm9=itemView.findViewById(R.id.amiras_txtname9);
            amiras_bookdy9=itemView.findViewById(R.id.amiras_txtday9);
            amiras_booktm9=itemView.findViewById(R.id.amiras_txttime9);
            amiras_bookphn9=itemView.findViewById(R.id.amiras_txtphone9);

        }
    }
}
