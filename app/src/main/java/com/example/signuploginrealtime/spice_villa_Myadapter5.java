package com.example.signuploginrealtime;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class spice_villa_Myadapter5 extends RecyclerView.Adapter<spice_villa_Myadapter5.MyViewHolder>{

    Context
            spice_villa_context5;
    ArrayList<spice_villa_customer5>
            spice_villa_list5;

    public spice_villa_Myadapter5(Context spice_villa_context5, ArrayList<spice_villa_customer5> spice_villa_list5) {
        this.spice_villa_context5 =
                spice_villa_context5;
        this.spice_villa_list5 =
                spice_villa_list5;
    }

    @NonNull
    @Override
    public spice_villa_Myadapter5.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View spice_villa_v5= LayoutInflater.from(spice_villa_context5).inflate(R.layout.spice_villa_userentry5,parent,false);
        return new spice_villa_Myadapter5.MyViewHolder(spice_villa_v5);
    }

    @Override
    public void onBindViewHolder(@NonNull spice_villa_Myadapter5.MyViewHolder holder, int position) {
        spice_villa_customer5  spice_villa_cust5 = spice_villa_list5.get(position);
        holder.spice_villa_booknm5.setText(spice_villa_cust5.getSpice_villa_bname5());
        holder.spice_villa_bookdy5.setText(spice_villa_cust5.getSpice_villa_bday5());
        holder.spice_villa_booktm5.setText(spice_villa_cust5.getSpice_villa_btime5());
        holder.spice_villa_bookphn5.setText(spice_villa_cust5.getSpice_villa_bphone5());
    }

    @Override
    public int getItemCount() {
        return spice_villa_list5.size();

    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView
                spice_villa_booknm5,spice_villa_bookdy5,spice_villa_booktm5,spice_villa_bookphn5;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            spice_villa_booknm5=itemView.findViewById(R.id.spice_villa_txtname5);
            spice_villa_bookdy5=itemView.findViewById(R.id.spice_villa_txtday5);
            spice_villa_booktm5=itemView.findViewById(R.id.spice_villa_txttime5);
            spice_villa_bookphn5=itemView.findViewById(R.id.spice_villa_txtphone5);
        }
    }
}
