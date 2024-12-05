package com.example.signuploginrealtime;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class amrutras_Myadapter7 extends RecyclerView.Adapter<amrutras_Myadapter7.MyViewHolder>{

    Context
            amrutras_context7;
    ArrayList<amrutras_customer7>
            amrutras_list7;

    public amrutras_Myadapter7(Context amrutras_context7, ArrayList<amrutras_customer7> amrutras_list7) {
        this.amrutras_context7 =
                amrutras_context7;
        this.amrutras_list7 =
                amrutras_list7;
    }

    @NonNull
    @Override
    public amrutras_Myadapter7.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View amrutras_v7= LayoutInflater.from(amrutras_context7).inflate(R.layout.amrutras_userentry7,parent,false);
        return new amrutras_Myadapter7.MyViewHolder(amrutras_v7);
    }

    @Override
    public void onBindViewHolder(@NonNull amrutras_Myadapter7.MyViewHolder holder, int position) {
        amrutras_customer7 amrutras_cust7 = amrutras_list7.get(position);
        holder.amrutras_booknm7.setText(amrutras_cust7.getAmrutras_bname7());
        holder.amrutras_bookdy7.setText(amrutras_cust7.getAmrutras_bday7());
        holder.amrutras_booktm7.setText(amrutras_cust7.getAmrutras_btime7());
        holder.amrutras_bookphn7.setText(amrutras_cust7.getAmrutras_bphone7());
    }

    @Override
    public int getItemCount() {
        return  amrutras_list7.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView
                amrutras_booknm7,amrutras_bookdy7,amrutras_booktm7,amrutras_bookphn7;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            amrutras_booknm7=itemView.findViewById(R.id.amrutras_txtname7);
            amrutras_bookdy7=itemView.findViewById(R.id.amrutras_txtday7);
            amrutras_booktm7=itemView.findViewById(R.id.amrutras_txttime7);
            amrutras_bookphn7=itemView.findViewById(R.id.amrutras_txtphone7);
        }
    }
}
