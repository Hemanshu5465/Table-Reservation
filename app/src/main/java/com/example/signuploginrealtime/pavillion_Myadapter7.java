package com.example.signuploginrealtime;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class pavillion_Myadapter7 extends RecyclerView.Adapter<pavillion_Myadapter7.MyViewHolder>{

    Context
            pavillion_context7 ;
    ArrayList<pavillion_customer7>
            pavillion_list7 ;

    public pavillion_Myadapter7(Context pavillion_context7, ArrayList<pavillion_customer7> pavillion_list7) {
        this.pavillion_context7 =
                pavillion_context7;
        this.pavillion_list7 =
                pavillion_list7;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View pavillion_v7= LayoutInflater.from(pavillion_context7).inflate(R.layout.pavillion_userentry7,parent,false);
        return new pavillion_Myadapter7.MyViewHolder(pavillion_v7);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        pavillion_customer7  pavillion_cust7 = pavillion_list7.get(position);
        holder.pavillion_booknm7.setText(pavillion_cust7.getPavillion_bname7());
        holder.pavillion_bookdy7.setText(pavillion_cust7.getPavillion_bday7());
        holder.pavillion_booktm7.setText(pavillion_cust7.getPavillion_btime7());
        holder.pavillion_bookphn7.setText(pavillion_cust7.getPavillion_bphone7());
    }

    @Override
    public int getItemCount() {
        return pavillion_list7.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView
                pavillion_booknm7,pavillion_bookdy7,pavillion_booktm7,pavillion_bookphn7;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            pavillion_booknm7=itemView.findViewById(R.id.pavillion_txtname7);
            pavillion_bookdy7=itemView.findViewById(R.id.pavillion_txtday7);
            pavillion_booktm7=itemView.findViewById(R.id.pavillion_txttime7);
            pavillion_bookphn7=itemView.findViewById(R.id.pavillion_txtphone7);
        }
    }
}
