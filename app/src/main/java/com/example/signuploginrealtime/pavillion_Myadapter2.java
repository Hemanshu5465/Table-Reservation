package com.example.signuploginrealtime;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class pavillion_Myadapter2 extends RecyclerView.Adapter<pavillion_Myadapter2.MyViewHolder>{

    Context
            pavillion_context2;
    ArrayList<pavillion_customer2>
            pavillion_list2;

    public pavillion_Myadapter2(Context pavillion_context2, ArrayList<pavillion_customer2> pavillion_list2) {
        this.pavillion_context2 =
                pavillion_context2;
        this.pavillion_list2 =
                pavillion_list2;
    }

    @NonNull
    @Override
    public pavillion_Myadapter2.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View pavillion_v2= LayoutInflater.from(pavillion_context2).inflate(R.layout.pavillion_userentry2,parent,false);
        return new pavillion_Myadapter2.MyViewHolder(pavillion_v2);
    }

    @Override
    public void onBindViewHolder(@NonNull pavillion_Myadapter2.MyViewHolder holder, int position) {
        pavillion_customer2  pavillion_cust2 = pavillion_list2.get(position);
        holder.pavillion_booknm2.setText(pavillion_cust2.getPavillion_bname2());
        holder.pavillion_bookdy2.setText(pavillion_cust2.getPavillion_bday2());
        holder.pavillion_booktm2.setText(pavillion_cust2.getPavillion_btime2());
        holder.pavillion_bookphn2.setText(pavillion_cust2.getPavillion_bphone2());
    }

    @Override
    public int getItemCount() {
        return pavillion_list2.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView
                pavillion_booknm2,pavillion_bookdy2,pavillion_booktm2,pavillion_bookphn2;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            pavillion_booknm2=itemView.findViewById(R.id.pavillion_txtname2);
            pavillion_bookdy2=itemView.findViewById(R.id.pavillion_txtday2);
            pavillion_booktm2=itemView.findViewById(R.id.pavillion_txttime2);
            pavillion_bookphn2=itemView.findViewById(R.id.pavillion_txtphone2);
        }
    }
}
