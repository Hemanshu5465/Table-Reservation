package com.example.signuploginrealtime;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Myadapter2 extends RecyclerView.Adapter<Myadapter2.MyViewHolder>{
    Context context2;
    ArrayList<customer2> list2;

    public Myadapter2(Context context2, ArrayList<customer2> list2) {
        this.context2 =
                context2;
        this.list2 =
                list2;
    }

    @NonNull
    @Override
    public Myadapter2.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v2= LayoutInflater.from(context2).inflate(R.layout.userentry2,parent,false);
        return new Myadapter2.MyViewHolder(v2);
    }

    @Override
    public void onBindViewHolder(@NonNull Myadapter2.MyViewHolder holder, int position) {
        customer2 cust2=list2.get(position);
        holder.booknm2.setText(cust2.getBname2());
        holder.bookdy2.setText(cust2.getBday2());
        holder.booktm2.setText(cust2.getBtime2());
        holder.bookphn2.setText(cust2.getBphone2());
    }

    @Override
    public int getItemCount() {
        return list2.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView booknm2,bookdy2,booktm2,bookphn2;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            booknm2=itemView.findViewById(R.id.txtname2);
            bookdy2=itemView.findViewById(R.id.txtday2);
            booktm2=itemView.findViewById(R.id.txttime2);
            bookphn2=itemView.findViewById(R.id.txtphone2);
        }
    }
}
