package com.example.signuploginrealtime;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class pavillion_Myadapter6 extends RecyclerView.Adapter<pavillion_Myadapter6.MyViewHolder>{

    Context
            pavillion_context6;
    ArrayList<pavillion_customer6>
            pavillion_list6;

    public pavillion_Myadapter6(Context pavillion_context6, ArrayList<pavillion_customer6> pavillion_list6) {
        this.pavillion_context6 =
                pavillion_context6;
        this.pavillion_list6 =
                pavillion_list6;
    }

    @NonNull
    @Override
    public pavillion_Myadapter6.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View pavillion_v6= LayoutInflater.from(pavillion_context6).inflate(R.layout.pavillion_userentry6,parent,false);
        return new pavillion_Myadapter6.MyViewHolder(pavillion_v6);
    }

    @Override
    public void onBindViewHolder(@NonNull pavillion_Myadapter6.MyViewHolder holder, int position) {
        pavillion_customer6  pavillion_cust6 = pavillion_list6.get(position);
        holder.pavillion_booknm6.setText(pavillion_cust6.getPavillion_bname6());
        holder.pavillion_bookdy6.setText(pavillion_cust6.getPavillion_bday6());
        holder.pavillion_booktm6.setText(pavillion_cust6.getPavillion_btime6());
        holder.pavillion_bookphn6.setText(pavillion_cust6.getPavillion_bphone6());
    }

    @Override
    public int getItemCount() {
        return pavillion_list6.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView
                pavillion_booknm6,pavillion_bookdy6,pavillion_booktm6,pavillion_bookphn6;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            pavillion_booknm6=itemView.findViewById(R.id.pavillion_txtname6);
            pavillion_bookdy6=itemView.findViewById(R.id.pavillion_txtday6);
            pavillion_booktm6=itemView.findViewById(R.id.pavillion_txttime6);
            pavillion_bookphn6=itemView.findViewById(R.id.pavillion_txtphone6);
        }
    }
}
