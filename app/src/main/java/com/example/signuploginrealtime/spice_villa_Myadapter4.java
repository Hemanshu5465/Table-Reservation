package com.example.signuploginrealtime;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class spice_villa_Myadapter4 extends RecyclerView.Adapter<spice_villa_Myadapter4.MyViewHolder>{

    Context
            spice_villa_context4;
    ArrayList<spice_villa_customer4>
            spice_villa_list4;

    public spice_villa_Myadapter4(Context spice_villa_context4, ArrayList<spice_villa_customer4> spice_villa_list4) {
        this.spice_villa_context4 =
                spice_villa_context4;
        this.spice_villa_list4 =
                spice_villa_list4;
    }

    @NonNull
    @Override
    public spice_villa_Myadapter4.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View spice_villa_v4= LayoutInflater.from(spice_villa_context4).inflate(R.layout.spice_villa_userentry4,parent,false);
        return new spice_villa_Myadapter4.MyViewHolder(spice_villa_v4);
    }

    @Override
    public void onBindViewHolder(@NonNull spice_villa_Myadapter4.MyViewHolder holder, int position) {
        spice_villa_customer4  spice_villa_cust4 = spice_villa_list4.get(position);
        holder.spice_villa_booknm4.setText(spice_villa_cust4.getSpice_villa_bname4());
        holder.spice_villa_bookdy4.setText(spice_villa_cust4.getSpice_villa_bday4());
        holder.spice_villa_booktm4.setText(spice_villa_cust4.getSpice_villa_btime4());
        holder.spice_villa_bookphn4.setText(spice_villa_cust4.getSpice_villa_bphone4());
    }

    @Override
    public int getItemCount() {
        return  spice_villa_list4.size();

    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView spice_villa_booknm4,spice_villa_bookdy4,spice_villa_booktm4,spice_villa_bookphn4;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            spice_villa_booknm4=itemView.findViewById(R.id.spice_villa_txtname4);
            spice_villa_bookdy4=itemView.findViewById(R.id.spice_villa_txtday4);
            spice_villa_booktm4=itemView.findViewById(R.id.spice_villa_txttime4);
            spice_villa_bookphn4=itemView.findViewById(R.id.spice_villa_txtphone4);
        }
    }
}
