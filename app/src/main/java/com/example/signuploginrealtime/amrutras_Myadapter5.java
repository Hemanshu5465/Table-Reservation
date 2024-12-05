package com.example.signuploginrealtime;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class amrutras_Myadapter5 extends RecyclerView.Adapter<amrutras_Myadapter5.MyViewHolder>{

    Context
            amrutras_context5;
    ArrayList<amrutras_customer5>
            amrutras_list5;

    public amrutras_Myadapter5(Context amrutras_context5, ArrayList<amrutras_customer5> amrutras_list5) {
        this.amrutras_context5 =
                amrutras_context5;
        this.amrutras_list5 =
                amrutras_list5;
    }

    @NonNull
    @Override
    public amrutras_Myadapter5.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View amrutras_v5= LayoutInflater.from(amrutras_context5).inflate(R.layout.amrutras_userentry5,parent,false);
        return new amrutras_Myadapter5.MyViewHolder(amrutras_v5);
    }

    @Override
    public void onBindViewHolder(@NonNull amrutras_Myadapter5.MyViewHolder holder, int position) {
        amrutras_customer5 amrutras_cust5 = amrutras_list5.get(position);
        holder.amrutras_booknm5.setText(amrutras_cust5.getAmrutras_bname5());
        holder.amrutras_bookdy5.setText(amrutras_cust5.getAmrutras_bday5());
        holder.amrutras_booktm5.setText(amrutras_cust5.getAmrutras_btime5());
        holder.amrutras_bookphn5.setText(amrutras_cust5.getAmrutras_bphone5());
    }

    @Override
    public int getItemCount() {
        return amrutras_list5.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView
                amrutras_booknm5,amrutras_bookdy5,amrutras_booktm5,amrutras_bookphn5;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            amrutras_booknm5=itemView.findViewById(R.id.amrutras_txtname5);
            amrutras_bookdy5=itemView.findViewById(R.id.amrutras_txtday5);
            amrutras_booktm5=itemView.findViewById(R.id.amrutras_txttime5);
            amrutras_bookphn5=itemView.findViewById(R.id.amrutras_txtphone5);
        }
    }
}
