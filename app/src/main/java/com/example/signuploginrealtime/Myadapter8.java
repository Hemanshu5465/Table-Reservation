package com.example.signuploginrealtime;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Myadapter8 extends RecyclerView.Adapter<Myadapter8.MyViewHolder> {

    Context
            context8;
    ArrayList<customer8>
            list8;

    public Myadapter8(Context context8, ArrayList<customer8> list8) {
        this.context8 =
                context8;
        this.list8 =
                list8;
    }

    @NonNull
    @Override
    public Myadapter8.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v8= LayoutInflater.from(context8).inflate(R.layout.userentry8,parent,false);
        return new Myadapter8.MyViewHolder(v8);
    }

    @Override
    public void onBindViewHolder(@NonNull Myadapter8.MyViewHolder holder, int position) {
        customer8 cust8=list8.get(position);
        holder.booknm8.setText(cust8.getBname8());
        holder.bookdy8.setText(cust8.getBday8());
        holder.booktm8.setText(cust8.getBtime8());
        holder.bookphn8.setText(cust8.getBphone8());
    }

    @Override
    public int getItemCount() {
        return list8.size();

    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView
                booknm8,bookdy8,booktm8,bookphn8;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            booknm8=itemView.findViewById(R.id.txtname8);
            bookdy8=itemView.findViewById(R.id.txtday8);
            booktm8=itemView.findViewById(R.id.txttime8);
            bookphn8=itemView.findViewById(R.id.txtphone8);
        }
    }
}
