package com.example.signuploginrealtime;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class pavillion_Myadapter5 extends RecyclerView.Adapter<pavillion_Myadapter5.MyViewHolder>{

    Context
            pavillion_context5;
    ArrayList<pavillion_customer5>
            pavillion_list5;

    public pavillion_Myadapter5(Context pavillion_context5, ArrayList<pavillion_customer5> pavillion_list5) {
        this.pavillion_context5 =
                pavillion_context5;
        this.pavillion_list5 =
                pavillion_list5;
    }

    @NonNull
    @Override
    public pavillion_Myadapter5.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View pavillion_v5= LayoutInflater.from(pavillion_context5).inflate(R.layout.pavillion_userentry5,parent,false);
        return new pavillion_Myadapter5.MyViewHolder(pavillion_v5);
    }

    @Override
    public void onBindViewHolder(@NonNull pavillion_Myadapter5.MyViewHolder holder, int position) {
        pavillion_customer5  pavillion_cust5 = pavillion_list5.get(position);
        holder.pavillion_booknm5.setText(pavillion_cust5.getPavillion_bname5());
        holder.pavillion_bookdy5.setText(pavillion_cust5.getPavillion_bday5());
        holder.pavillion_booktm5.setText(pavillion_cust5.getPavillion_btime5());
        holder.pavillion_bookphn5.setText(pavillion_cust5.getPavillion_bphone5());
    }

    @Override
    public int getItemCount() {
        return pavillion_list5.size();

    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView
                pavillion_booknm5,pavillion_bookdy5,pavillion_booktm5,pavillion_bookphn5;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            pavillion_booknm5=itemView.findViewById(R.id.pavillion_txtname5);
            pavillion_bookdy5=itemView.findViewById(R.id.pavillion_txtday5);
            pavillion_booktm5=itemView.findViewById(R.id.pavillion_txttime5);
            pavillion_bookphn5=itemView.findViewById(R.id.pavillion_txtphone5);
        }
    }
}
