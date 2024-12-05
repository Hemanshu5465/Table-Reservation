package com.example.signuploginrealtime;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Myadapter extends RecyclerView.Adapter<Myadapter.MyViewHolder> {

    Context context;
    ArrayList<customer> list;

    public Myadapter(Context context, ArrayList<customer> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.userentry,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        customer cust=list.get(position);
        holder.booknm.setText(cust.getBname());
        holder.bookdy.setText(cust.getBday());
        holder.booktm.setText(cust.getBtime());
        holder.bookphn.setText(cust.getBphone());

    }

    @Override
    public int getItemCount() {

        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView booknm,bookdy,booktm,bookphn;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            booknm=itemView.findViewById(R.id.txtname);
            bookdy=itemView.findViewById(R.id.txtday);
            booktm=itemView.findViewById(R.id.txttime);
            bookphn=itemView.findViewById(R.id.txtphone);
        }
    }
}
