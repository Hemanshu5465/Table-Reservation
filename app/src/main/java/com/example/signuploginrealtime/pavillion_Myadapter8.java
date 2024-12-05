package com.example.signuploginrealtime;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class pavillion_Myadapter8 extends RecyclerView.Adapter<pavillion_Myadapter8.MyViewHolder>{
    Context
            pavillion_context8;
    ArrayList<pavillion_customer8>
            pavillion_list8;

    public pavillion_Myadapter8(Context pavillion_context8, ArrayList<pavillion_customer8> pavillion_list8) {
        this.pavillion_context8 =
                pavillion_context8;
        this.pavillion_list8 =
                pavillion_list8;
    }

    @NonNull
    @Override
    public pavillion_Myadapter8.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View pavillion_v8= LayoutInflater.from(pavillion_context8).inflate(R.layout.pavillion_userentry8,parent,false);
        return new pavillion_Myadapter8.MyViewHolder(pavillion_v8);
    }

    @Override
    public void onBindViewHolder(@NonNull pavillion_Myadapter8.MyViewHolder holder, int position) {
        pavillion_customer8  pavillion_cust8 = pavillion_list8.get(position);
        holder.pavillion_booknm8.setText(pavillion_cust8.getPavillion_bname8());
        holder.pavillion_bookdy8.setText(pavillion_cust8.getPavillion_bday8());
        holder.pavillion_booktm8.setText(pavillion_cust8.getPavillion_btime8());
        holder.pavillion_bookphn8.setText(pavillion_cust8.getPavillion_bphone8());
    }

    @Override
    public int getItemCount() {
        return pavillion_list8.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView
                pavillion_booknm8,pavillion_bookdy8,pavillion_booktm8,pavillion_bookphn8;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            pavillion_booknm8=itemView.findViewById(R.id.pavillion_txtname8);
            pavillion_bookdy8=itemView.findViewById(R.id.pavillion_txtday8);
            pavillion_booktm8=itemView.findViewById(R.id.pavillion_txttime8);
            pavillion_bookphn8=itemView.findViewById(R.id.pavillion_txtphone8);
        }
    }
}
