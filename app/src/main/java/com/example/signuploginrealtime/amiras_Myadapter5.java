package com.example.signuploginrealtime;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class amiras_Myadapter5 extends RecyclerView.Adapter<amiras_Myadapter5.MyViewHolder> {

    Context
            amiras_context5;
    ArrayList<amiras_customer5>
            amiras_list5;

    public amiras_Myadapter5(Context amiras_context5, ArrayList<amiras_customer5> amiras_list5) {
        this.amiras_context5 =
                amiras_context5;
        this.amiras_list5 =
                amiras_list5;
    }

    @NonNull
    @Override
    public amiras_Myadapter5.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View amiras_v5= LayoutInflater.from(amiras_context5).inflate(R.layout.amiras_userentry5,parent,false);
        return new amiras_Myadapter5.MyViewHolder(amiras_v5);
    }

    @Override
    public void onBindViewHolder(@NonNull amiras_Myadapter5.MyViewHolder holder, int position) {
        amiras_customer5 amiras_cust5 = amiras_list5.get(position);
        holder.amiras_booknm5.setText(amiras_cust5.getAmiras_bname5());
        holder.amiras_bookdy5.setText(amiras_cust5.getAmiras_bday5());
        holder.amiras_booktm5.setText(amiras_cust5.getAmiras_btime5());
        holder.amiras_bookphn5.setText(amiras_cust5.getAmiras_bphone5());
    }

    @Override
    public int getItemCount() {
        return amiras_list5.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView
                amiras_booknm5,amiras_bookdy5,amiras_booktm5,amiras_bookphn5;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            amiras_booknm5=itemView.findViewById(R.id.amiras_txtname5);
            amiras_bookdy5=itemView.findViewById(R.id.amiras_txtday5);
            amiras_booktm5=itemView.findViewById(R.id.amiras_txttime5);
            amiras_bookphn5=itemView.findViewById(R.id.amiras_txtphone5);
        }
    }
}
