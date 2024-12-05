package com.example.signuploginrealtime;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Myadapter7 extends RecyclerView.Adapter<Myadapter7.MyViewholder> {

    Context context7;
    ArrayList<customer7> list7;

    public Myadapter7(Context context7, ArrayList<customer7> list7) {
        this.context7 = context7;
        this.list7 = list7;
    }

    @NonNull
    @Override
    public Myadapter7.MyViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v7= LayoutInflater.from(context7).inflate(R.layout.userentry7,parent,false);
        return new Myadapter7.MyViewholder(v7);
    }

    @Override
    public void onBindViewHolder(@NonNull Myadapter7.MyViewholder holder, int position) {
        customer7 cust7 = list7.get(position);
        holder.booknm7.setText(cust7.getBname7());
        holder.bookdy7.setText(cust7.getBday7());
        holder.booktm7.setText(cust7.getBtime7());
        holder.bookphn7.setText(cust7.getBphone7());
    }

    @Override
    public int getItemCount() {
        return list7.size();
    }

    public class MyViewholder extends RecyclerView.ViewHolder {

        TextView
                booknm7,bookdy7,booktm7,bookphn7;
        public MyViewholder(@NonNull View itemView) {
            super(itemView);
            booknm7=itemView.findViewById(R.id.txtname7);
            bookdy7=itemView.findViewById(R.id.txtday7);
            booktm7=itemView.findViewById(R.id.txttime7);
            bookphn7=itemView.findViewById(R.id.txtphone7);
        }
    }
}
