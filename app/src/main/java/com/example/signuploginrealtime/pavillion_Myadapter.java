package com.example.signuploginrealtime;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class pavillion_Myadapter extends RecyclerView.Adapter<pavillion_Myadapter.MyViewHolder>{

    Context
            pavillion_context;
    ArrayList<pavillion_customer>
            pavillion_list;

    public pavillion_Myadapter(Context pavillion_context, ArrayList<pavillion_customer> pavillion_list) {
        this.pavillion_context =
                pavillion_context;
        this.pavillion_list =
                pavillion_list;
    }

    @NonNull
    @Override
    public pavillion_Myadapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View pavillion_v= LayoutInflater.from(pavillion_context).inflate(R.layout.pavillion_userentry,parent,false);
        return new pavillion_Myadapter.MyViewHolder(pavillion_v);
    }

    @Override
    public void onBindViewHolder(@NonNull pavillion_Myadapter.MyViewHolder holder, int position) {
        pavillion_customer  pavillion_cust = pavillion_list.get(position);
        holder.pavillion_booknm.setText(pavillion_cust.getPavillion_bname());
        holder.pavillion_bookdy.setText(pavillion_cust.getPavillion_bday());
        holder.pavillion_booktm.setText(pavillion_cust.getPavillion_btime());
        holder.pavillion_bookphn.setText(pavillion_cust.getPavillion_bphone());
    }

    @Override
    public int getItemCount() {
        return pavillion_list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView pavillion_booknm,pavillion_bookdy,pavillion_booktm,pavillion_bookphn;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            pavillion_booknm=itemView.findViewById(R.id.pavillion_txtname);
            pavillion_bookdy=itemView.findViewById(R.id.pavillion_txtday);
            pavillion_booktm=itemView.findViewById(R.id.pavillion_txttime);
            pavillion_bookphn=itemView.findViewById(R.id.pavillion_txtphone);
        }
    }
}
