package com.example.signuploginrealtime;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class custombaseadapter extends BaseAdapter {
    Context context;
    String listfruit[];
    int listimages[];
    String listnum[];
    LayoutInflater inflater;


    public custombaseadapter(Context ctx, String[] listfruit, int[] listimages, String[] listnum) {
        this.context = ctx;
        this.listfruit = listfruit;
        this.listimages = listimages;
        this.listnum = listnum;
        inflater = LayoutInflater.from(ctx);
    }

    @Override
    public int getCount() {
        return listfruit.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view=inflater.inflate(R.layout.customlistview,null);
        TextView txtview=view.findViewById(R.id.txt);
        ImageView fruitimg=view.findViewById(R.id.img);
        TextView textView2=view.findViewById(R.id.txt2);
        txtview.setText(listfruit[i]);
        fruitimg.setImageResource(listimages[i]);
        textView2.setText(listnum[i]);

        return view;

    }
}

