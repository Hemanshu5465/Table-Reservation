package com.example.signuploginrealtime;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class pavillion_Myadapter9 extends RecyclerView.Adapter<pavillion_Myadapter9.MyViewHolder>{

    Context
            pavillion_context9;
    ArrayList<pavillion_customer9>
            pavillion_list9;

    public pavillion_Myadapter9(Context pavillion_context9, ArrayList<pavillion_customer9> pavillion_list9) {
        this.pavillion_context9 =
                pavillion_context9;
        this.pavillion_list9 =
                pavillion_list9;
    }

    @NonNull
    @Override
    public pavillion_Myadapter9.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View pavillion_v9= LayoutInflater.from(pavillion_context9).inflate(R.layout.pavillion_userentry9,parent,false);
        return new pavillion_Myadapter9.MyViewHolder(pavillion_v9);
    }

    @Override
    public void onBindViewHolder(@NonNull pavillion_Myadapter9.MyViewHolder holder, int position) {
        pavillion_customer9  pavillion_cust9 = pavillion_list9.get(position);
        holder.pavillion_booknm9.setText(pavillion_cust9.getPavillion_bname9());
        holder.pavillion_bookdy9.setText(pavillion_cust9.getPavillion_bday9());
        holder.pavillion_booktm9.setText(pavillion_cust9.getPavillion_btime9());
        holder.pavillion_bookphn9.setText(pavillion_cust9.getPavillion_bphone9());
    }

    @Override
    public int getItemCount() {
        return pavillion_list9.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView
                pavillion_booknm9,pavillion_bookdy9,pavillion_booktm9,pavillion_bookphn9;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            pavillion_booknm9=itemView.findViewById(R.id.pavillion_txtname9);
            pavillion_bookdy9=itemView.findViewById(R.id.pavillion_txtday9);
            pavillion_booktm9=itemView.findViewById(R.id.pavillion_txttime9);
            pavillion_bookphn9=itemView.findViewById(R.id.pavillion_txtphone9);
        }
    }
}
