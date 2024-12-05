package com.example.signuploginrealtime;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class fruitadapter extends RecyclerView.Adapter<fruitadapter.MyViewHolder> {

    Context context;
    ArrayList<itemadapter> arrayList;
    LayoutInflater layoutInflater;

    public fruitadapter(Context context, ArrayList<itemadapter> arrayList) {
        this.context =
                context;
        this.arrayList =
                arrayList;
        layoutInflater=LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=layoutInflater.inflate(R.layout.item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull fruitadapter.MyViewHolder holder, int position) {
        holder.fruitname.setText(arrayList.get(position).getFruitname());
        holder.fruitnum.setText(arrayList.get(position).getFruitnum());
        holder.img.setImageResource(arrayList.get(position).getImg());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView fruitname,fruitnum;
        ImageView img;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            fruitname=itemView.findViewById(R.id.txt);
            fruitnum =itemView.findViewById(R.id.txt2);
            img=itemView.findViewById(R.id.img);
        }
    }
}
