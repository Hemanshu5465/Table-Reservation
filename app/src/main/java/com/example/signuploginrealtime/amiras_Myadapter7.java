package com.example.signuploginrealtime;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class amiras_Myadapter7  extends RecyclerView.Adapter<amiras_Myadapter7.MyViewHolder>{

    Context amiras_context7;
    ArrayList<amiras_customer7>
            amiras_list7;

    public amiras_Myadapter7(Context amiras_context7, ArrayList<amiras_customer7> amiras_list7) {
        this.amiras_context7 =
                amiras_context7;
        this.amiras_list7 =
                amiras_list7;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View amiras_v7= LayoutInflater.from(amiras_context7).inflate(R.layout.amiras_userentry7,parent,false);
        return new amiras_Myadapter7.MyViewHolder(amiras_v7);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        amiras_customer7 amiras_cust7 = amiras_list7.get(position);
        holder.amiras_booknm7.setText(amiras_cust7.getAmiras_bname7());
        holder.amiras_bookdy7.setText(amiras_cust7.getAmiras_bday7());
        holder.amiras_booktm7.setText(amiras_cust7.getAmiras_btime7());
        holder.amiras_bookphn7.setText(amiras_cust7.getAmiras_bphone7());
    }

    @Override
    public int getItemCount() {
        return amiras_list7.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView amiras_booknm7,amiras_bookdy7,amiras_booktm7,amiras_bookphn7;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            amiras_booknm7=itemView.findViewById(R.id.amiras_txtname7);
            amiras_bookdy7=itemView.findViewById(R.id.amiras_txtday7);
            amiras_booktm7=itemView.findViewById(R.id.amiras_txttime7);
            amiras_bookphn7=itemView.findViewById(R.id.amiras_txtphone7);
        }
    }
}
