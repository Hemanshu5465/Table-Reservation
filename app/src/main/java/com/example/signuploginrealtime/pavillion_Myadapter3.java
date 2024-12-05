package com.example.signuploginrealtime;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class pavillion_Myadapter3 extends RecyclerView.Adapter<pavillion_Myadapter3.MyViewHolder> {

    Context
            pavillion_context3;
    ArrayList<pavillion_customer3>
            pavillion_list3;

    public pavillion_Myadapter3(Context pavillion_context3, ArrayList<pavillion_customer3> pavillion_list3) {
        this.pavillion_context3 =
                pavillion_context3;
        this.pavillion_list3 =
                pavillion_list3;
    }

    @NonNull
    @Override
    public pavillion_Myadapter3.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View pavillion_v3= LayoutInflater.from(pavillion_context3).inflate(R.layout.pavillion_userentry3,parent,false);
        return new pavillion_Myadapter3.MyViewHolder(pavillion_v3);
    }

    @Override
    public void onBindViewHolder(@NonNull pavillion_Myadapter3.MyViewHolder holder, int position) {
        pavillion_customer3  pavillion_cust3 = pavillion_list3.get(position);
        holder.pavillion_booknm3.setText(pavillion_cust3.getPavillion_bname3());
        holder.pavillion_bookdy3.setText(pavillion_cust3.getPavillion_bday3());
        holder.pavillion_booktm3.setText(pavillion_cust3.getPavillion_btime3());
        holder.pavillion_bookphn3.setText(pavillion_cust3.getPavillion_bphone3());
    }

    @Override
    public int getItemCount() {
        return pavillion_list3.size();    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView
                pavillion_booknm3,pavillion_bookdy3,pavillion_booktm3,pavillion_bookphn3;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            pavillion_booknm3=itemView.findViewById(R.id.pavillion_txtname3);
            pavillion_bookdy3=itemView.findViewById(R.id.pavillion_txtday3);
            pavillion_booktm3=itemView.findViewById(R.id.pavillion_txttime3);
            pavillion_bookphn3=itemView.findViewById(R.id.pavillion_txtphone3);
        }
    }
}
