package com.example.signuploginrealtime;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Myadapter3 extends RecyclerView.Adapter<Myadapter3.MyViewHolder>{

    Context
            context3;
    ArrayList<customer3>
            list3;

    public Myadapter3(Context context3, ArrayList<customer3> list3) {
        this.context3 =
                context3;
        this.list3 =
                list3;
    }

    @NonNull
    @Override
    public Myadapter3.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v3= LayoutInflater.from(context3).inflate(R.layout.userentry3,parent,false);
        return new Myadapter3.MyViewHolder(v3);
    }

    @Override
    public void onBindViewHolder(@NonNull Myadapter3.MyViewHolder holder, int position) {
        customer3 cust3=list3.get(position);
        holder.booknm3.setText(cust3.getBname3());
        holder.bookdy3.setText(cust3.getBday3());
        holder.booktm3.setText(cust3.getBtime3());
        holder.bookphn3.setText(cust3.getBphone3());
    }

    @Override
    public int getItemCount() {
        return list3.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView
                booknm3,bookdy3,booktm3,bookphn3;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            booknm3=itemView.findViewById(R.id.txtname3);
            bookdy3=itemView.findViewById(R.id.txtday3);
            booktm3=itemView.findViewById(R.id.txttime3);
            bookphn3=itemView.findViewById(R.id.txtphone3);
        }
    }
}
