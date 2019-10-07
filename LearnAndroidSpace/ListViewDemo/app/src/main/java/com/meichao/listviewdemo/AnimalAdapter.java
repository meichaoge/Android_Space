package com.meichao.listviewdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.LinkedList;

public class AnimalAdapter extends BaseAdapter {

    private LinkedList<AnimalInfor> mAnimalData;
    private Context mContext;

    public AnimalAdapter(Context context, LinkedList<AnimalInfor> animalInfors) {
        mAnimalData = animalInfors;
        mContext = context;
    }


    @Override
    public int getCount() {
        return mAnimalData.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
       view= LayoutInflater.from(mContext).inflate(R.layout.animallistitem,viewGroup,false);

        ImageView icon=view.findViewById(R.id.icon01);



        return null;
    }
}
