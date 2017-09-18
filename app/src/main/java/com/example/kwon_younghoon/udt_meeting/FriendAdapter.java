package com.example.kwon_younghoon.udt_meeting;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by kwon-younghoon on 2017. 9. 18..
 */

public class FriendAdapter extends BaseAdapter {
    ArrayList<FriendData> arrayList;
    Context context;

    public FriendAdapter(ArrayList<FriendData> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
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
        if (view==null) {
            view = inflater.inflate(R.layout.friend_list, null);
        }
        ImageView i1 = (ImageView)view.findViewById(R.id.friends_gender);
        TextView t1 = (TextView)view.findViewById(R.id.friends_name);
        TextView t2 = (TextView)view.findViewById(R.id.friends_nikname);
        TextView t3 = (TextView)view.findViewById(R.id.friends_number);

        FriendData one;
        one = arrayList.get(i);
        i1.setImageResource(one.getImage());
        t1.setText(one.getName());
        t2.setText(one.getNikname());
        t3.setText(one.getNumber());

        return view;
    }
}
