package com.example.signuploginrealtime;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class amrutras_Myadapter4 extends RecyclerView.Adapter<amrutras_Myadapter4.MyViewHolder>{


    Context
            amrutras_context4;
    ArrayList<amrutras_customer4>
            amrutras_list4;

    public amrutras_Myadapter4(Context amrutras_context4, ArrayList<amrutras_customer4> amrutras_list4) {
        this.amrutras_context4 =
                amrutras_context4;
        this.amrutras_list4 =
                amrutras_list4;
    }

    @NonNull
    @Override
    public amrutras_Myadapter4.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View amrutras_v4= LayoutInflater.from(amrutras_context4).inflate(R.layout.amrutras_userentry4,parent,false);
        return new amrutras_Myadapter4.MyViewHolder(amrutras_v4);
    }

    @Override
    public void onBindViewHolder(@NonNull amrutras_Myadapter4.MyViewHolder holder, int position) {
        amrutras_customer4 amrutras_cust4 = amrutras_list4.get(position);
        holder.amrutras_booknm4.setText(amrutras_cust4.getAmrutras_bname4());
        holder.amrutras_bookdy4.setText(amrutras_cust4.getAmrutras_bday4());
        holder.amrutras_booktm4.setText(amrutras_cust4.getAmrutras_btime4());
        holder.amrutras_bookphn4.setText(amrutras_cust4.getAmrutras_bphone4());
    }

    @Override
    public int getItemCount() {
        return  amrutras_list4.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView
                amrutras_booknm4,amrutras_bookdy4,amrutras_booktm4,amrutras_bookphn4;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            amrutras_booknm4=itemView.findViewById(R.id.amrutras_txtname4);
            amrutras_bookdy4=itemView.findViewById(R.id.amrutras_txtday4);
            amrutras_booktm4=itemView.findViewById(R.id.amrutras_txttime4);
            amrutras_bookphn4=itemView.findViewById(R.id.amrutras_txtphone4);
        }
    }
}
