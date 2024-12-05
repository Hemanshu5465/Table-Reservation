package com.example.signuploginrealtime;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Myadapter6 extends RecyclerView.Adapter<Myadapter6.MyViewHolder> {

    Context
            context6;
    ArrayList<customer6>
            list6;

    public Myadapter6(Context context6, ArrayList<customer6> list6) {
        this.context6 =
                context6;
        this.list6 =
                list6;
    }

    @NonNull
    @Override
    public Myadapter6.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v6= LayoutInflater.from(context6).inflate(R.layout.userentry6,parent,false);
        return new Myadapter6.MyViewHolder(v6);
    }

    @Override
    public void onBindViewHolder(@NonNull Myadapter6.MyViewHolder holder, int position) {
        customer6 cust6=list6.get(position);
        holder.booknm6.setText(cust6.getBname6());
        holder.bookdy6.setText(cust6.getBday6());
        holder.booktm6.setText(cust6.getBtime6());
        holder.bookphn6.setText(cust6.getBphone6());
    }

    @Override
    public int getItemCount() {
        return list6.size();

    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView
                booknm6,bookdy6,booktm6,bookphn6;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            booknm6=itemView.findViewById(R.id.txtname6);
            bookdy6=itemView.findViewById(R.id.txtday6);
            booktm6=itemView.findViewById(R.id.txttime6);
            bookphn6=itemView.findViewById(R.id.txtphone6);
        }
    }
}
