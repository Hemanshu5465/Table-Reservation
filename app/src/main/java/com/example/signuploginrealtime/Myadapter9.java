package com.example.signuploginrealtime;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Myadapter9 extends RecyclerView.Adapter<Myadapter9.MyViewHolder> {

    Context
            context9;
    ArrayList<customer9>
            list9;

    public Myadapter9(Context context9, ArrayList<customer9> list9) {
        this.context9 =
                context9;
        this.list9 =
                list9;
    }

    @NonNull
    @Override
    public Myadapter9.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v9= LayoutInflater.from(context9).inflate(R.layout.userentry9,parent,false);
        return new Myadapter9.MyViewHolder(v9);
    }

    @Override
    public void onBindViewHolder(@NonNull Myadapter9.MyViewHolder holder, int position) {
        customer9 cust9=list9.get(position);
        holder.booknm9.setText(cust9.getBname9());
        holder.bookdy9.setText(cust9.getBday9());
        holder.booktm9.setText(cust9.getBtime9());
        holder.bookphn9.setText(cust9.getBphone9());
    }

    @Override
    public int getItemCount() {
        return list9.size();

    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView
                booknm9,bookdy9,booktm9,bookphn9;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            booknm9=itemView.findViewById(R.id.txtname9);
            bookdy9=itemView.findViewById(R.id.txtday9);
            booktm9=itemView.findViewById(R.id.txttime9);
            bookphn9=itemView.findViewById(R.id.txtphone9);
        }
    }
}
