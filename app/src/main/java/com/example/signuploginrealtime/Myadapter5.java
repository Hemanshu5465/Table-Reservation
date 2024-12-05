package com.example.signuploginrealtime;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Myadapter5  extends RecyclerView.Adapter<Myadapter5.MyViewHolder>{

    Context
            context5;
    ArrayList<customer5>
            list5;

    public Myadapter5(Context context5, ArrayList<customer5> list5) {
        this.context5 =
                context5;
        this.list5 =
                list5;
    }

    @NonNull
    @Override
    public Myadapter5.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v5= LayoutInflater.from(context5).inflate(R.layout.userentry5,parent,false);
        return new Myadapter5.MyViewHolder(v5);
    }

    @Override
    public void onBindViewHolder(@NonNull Myadapter5.MyViewHolder holder, int position) {
        customer5 cust5=list5.get(position);
        holder.booknm5.setText(cust5.getBname5());
        holder.bookdy5.setText(cust5.getBday5());
        holder.booktm5.setText(cust5.getBtime5());
        holder.bookphn5.setText(cust5.getBphone5());
    }

    @Override
    public int getItemCount() {
        return list5.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView
                booknm5,bookdy5,booktm5,bookphn5;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            booknm5=itemView.findViewById(R.id.txtname5);
            bookdy5=itemView.findViewById(R.id.txtday5);
            booktm5=itemView.findViewById(R.id.txttime5);
            bookphn5=itemView.findViewById(R.id.txtphone5);
        }
    }
}
