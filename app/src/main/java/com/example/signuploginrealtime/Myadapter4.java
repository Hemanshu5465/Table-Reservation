package com.example.signuploginrealtime;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Myadapter4 extends RecyclerView.Adapter<Myadapter4.MyViewHolder> {

    Context context4;
    ArrayList<customer4> list4;

    public Myadapter4(Context context4, ArrayList<customer4> list4) {
        this.context4 = context4;
        this.list4 = list4;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v4= LayoutInflater.from(context4).inflate(R.layout.userentry4,parent,false);
        return new Myadapter4.MyViewHolder(v4);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        customer4 cust4=list4.get(position);
        holder.booknm4.setText(cust4.getBname4());
        holder.bookdy4.setText(cust4.getBday4());
        holder.booktm4.setText(cust4.getBtime4());
        holder.bookphn4.setText(cust4.getBphone4());
    }

    @Override
    public int getItemCount() {

        return list4.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView booknm4,bookdy4,booktm4,bookphn4;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            booknm4=itemView.findViewById(R.id.txtname4);
            bookdy4=itemView.findViewById(R.id.txtday4);
            booktm4=itemView.findViewById(R.id.txttime4);
            bookphn4=itemView.findViewById(R.id.txtphone4);
        }
    }
}
