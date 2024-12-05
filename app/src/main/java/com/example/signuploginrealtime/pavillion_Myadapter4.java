package com.example.signuploginrealtime;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class pavillion_Myadapter4 extends RecyclerView.Adapter<pavillion_Myadapter4.MyViewHolder>{

    Context
            pavillion_context4;
    ArrayList<pavillion_customer4>
            pavillion_list4;

    public pavillion_Myadapter4(Context pavillion_context4, ArrayList<pavillion_customer4> pavillion_list4) {
        this.pavillion_context4 =
                pavillion_context4;
        this.pavillion_list4 =
                pavillion_list4;
    }

    @NonNull
    @Override
    public pavillion_Myadapter4.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View pavillion_v4= LayoutInflater.from(pavillion_context4).inflate(R.layout.pavillion_userentry4,parent,false);
        return new pavillion_Myadapter4.MyViewHolder(pavillion_v4);
    }

    @Override
    public void onBindViewHolder(@NonNull pavillion_Myadapter4.MyViewHolder holder, int position) {
        pavillion_customer4  pavillion_cust4 = pavillion_list4.get(position);
        holder.pavillion_booknm4.setText(pavillion_cust4.getPavillion_bname4());
        holder.pavillion_bookdy4.setText(pavillion_cust4.getPavillion_bday4());
        holder.pavillion_booktm4.setText(pavillion_cust4.getPavillion_btime4());
        holder.pavillion_bookphn4.setText(pavillion_cust4.getPavillion_bphone4());
    }

    @Override
    public int getItemCount() {
        return pavillion_list4.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView pavillion_booknm4,pavillion_bookdy4,pavillion_booktm4,pavillion_bookphn4;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            pavillion_booknm4=itemView.findViewById(R.id.pavillion_txtname4);
            pavillion_bookdy4=itemView.findViewById(R.id.pavillion_txtday4);
            pavillion_booktm4=itemView.findViewById(R.id.pavillion_txttime4);
            pavillion_bookphn4=itemView.findViewById(R.id.pavillion_txtphone4);
        }
    }
}
