package com.example.signuploginrealtime;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class amiras_Myadapter4 extends RecyclerView.Adapter<amiras_Myadapter4.MyViewHolder>{

    Context
            amiras_context4;
    ArrayList<amiras_customer4>
            amiras_list4;

    public amiras_Myadapter4(Context amiras_context4, ArrayList<amiras_customer4> amiras_list4) {
        this.amiras_context4 =
                amiras_context4;
        this.amiras_list4 =
                amiras_list4;
    }

    @NonNull
    @Override
    public amiras_Myadapter4.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View amiras_v4= LayoutInflater.from(amiras_context4).inflate(R.layout.amiras_userentry4,parent,false);
        return new amiras_Myadapter4.MyViewHolder(amiras_v4);
    }

    @Override
    public void onBindViewHolder(@NonNull amiras_Myadapter4.MyViewHolder holder, int position) {
        amiras_customer4 amiras_cust4 = amiras_list4.get(position);
        holder.amiras_booknm4.setText(amiras_cust4.getAmiras_bname4());
        holder.amiras_bookdy4.setText(amiras_cust4.getAmiras_bday4());
        holder.amiras_booktm4.setText(amiras_cust4.getAmiras_btime4());
        holder.amiras_bookphn4.setText(amiras_cust4.getAmiras_bphone4());
    }

    @Override
    public int getItemCount()
    {
        return amiras_list4.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView amiras_booknm4,amiras_bookdy4,amiras_booktm4,amiras_bookphn4;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            amiras_booknm4=itemView.findViewById(R.id.amiras_txtname4);
            amiras_bookdy4=itemView.findViewById(R.id.amiras_txtday4);
            amiras_booktm4=itemView.findViewById(R.id.amiras_txttime4);
            amiras_bookphn4=itemView.findViewById(R.id.amiras_txtphone4);
        }
    }
}
