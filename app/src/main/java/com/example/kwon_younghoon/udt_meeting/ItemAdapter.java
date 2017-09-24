package com.example.kwon_younghoon.udt_meeting;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by kwon-younghoon on 2017. 9. 24..
 */

public class ItemAdapter extends BaseAdapter {
    private ArrayList<Ingrid_item> arrayList = new ArrayList<Ingrid_item>();
    Context context;

    public ItemAdapter(ArrayList<Ingrid_item> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    public ItemAdapter() {
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return arrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = LayoutInflater.from(context);
        if(view==null) {
            view = inflater.inflate(R.layout.maingird_item, null);
        }
        ImageView i2 = (ImageView)view.findViewById(R.id.maingrid_image);

        Ingrid_item one;
        one = arrayList.get(i);
        i2.setImageResource(one.getImage());
        return view;
    }
}
