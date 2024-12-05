package com.example.signuploginrealtime;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class amrutras_Myadapter9  extends RecyclerView.Adapter<amrutras_Myadapter9.MyViewHolder>{
    Context
            amrutras_context9;
    ArrayList<amrutras_customer9>
            amrutras_list9;

    public amrutras_Myadapter9(Context amrutras_context9, ArrayList<amrutras_customer9> amrutras_list9) {
        this.amrutras_context9 =
                amrutras_context9;
        this.amrutras_list9 =
                amrutras_list9;
    }

    @NonNull
    @Override
    public amrutras_Myadapter9.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View amrutras_v9= LayoutInflater.from(amrutras_context9).inflate(R.layout.amrutras_userentry9,parent,false);
        return new amrutras_Myadapter9.MyViewHolder(amrutras_v9);
    }

    @Override
    public void onBindViewHolder(@NonNull amrutras_Myadapter9.MyViewHolder holder, int position) {
        amrutras_customer9 amrutras_cust9 = amrutras_list9.get(position);
        holder.amrutras_booknm9.setText(amrutras_cust9.getAmrutras_bname9());
        holder.amrutras_bookdy9.setText(amrutras_cust9.getAmrutras_bday9());
        holder.amrutras_booktm9.setText(amrutras_cust9.getAmrutras_btime9());
        holder.amrutras_bookphn9.setText(amrutras_cust9.getAmrutras_bphone9());
    }

    @Override
    public int getItemCount() {
        return amrutras_list9.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView
                amrutras_booknm9,amrutras_bookdy9,amrutras_booktm9,amrutras_bookphn9;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            amrutras_booknm9=itemView.findViewById(R.id.amrutras_txtname9);
            amrutras_bookdy9=itemView.findViewById(R.id.amrutras_txtday9);
            amrutras_booktm9=itemView.findViewById(R.id.amrutras_txttime9);
            amrutras_bookphn9=itemView.findViewById(R.id.amrutras_txtphone9);
        }
    }
}
