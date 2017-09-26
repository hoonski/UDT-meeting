package com.example.kwon_younghoon.udt_meeting;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by kwon-younghoon on 2017. 9. 18..
 */

public class FriendAdapter extends BaseAdapter implements Filterable {

    // Adapter에 추가된 데이터를 저장하기 위한 ArrayList. (원본 데이터 리스트)
    private ArrayList<FriendData> friendDatalist = new ArrayList<FriendData>();
    // 필터링된 결과 데이터를 저장하기 위한 ArrayList. 최초에는 전체 리스트 보유.
    private ArrayList<FriendData> filteredDatalist = friendDatalist;
    Context context;
    boolean edit=false;
    boolean add=false;
    Filter listFilter;
    Button button;
    Button button1;
    View view1;

    public FriendAdapter() {

    }

    @Override
    public int getCount() {
        return filteredDatalist.size();
    }

    // 지정한 위치(position)에 있는 데이터 리턴 : 필수 구현
    @Override
    public Object getItem(int position) {
        return filteredDatalist.get(position);
    }

    // 지정한 위치(position)에 있는 데이터와 관계된 아이템(row)의 ID를 리턴. : 필수 구현
    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View view, ViewGroup viewGroup) {
        final int pos = position;
        final Context context = viewGroup.getContext();
        // listview_item Layout을 inflate하여 view 참조 획득.
        if (view==null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.friend_list, viewGroup, false);
        }
        ImageView i1 = (ImageView)view.findViewById(R.id.friends_gender);
        TextView t1 = (TextView)view.findViewById(R.id.friends_name);
        TextView t2 = (TextView)view.findViewById(R.id.friends_nikname);
        TextView t3 = (TextView)view.findViewById(R.id.friends_number);
        button = (Button)view.findViewById(R.id.btn_delete);
        button1 = (Button)view.findViewById(R.id.btn_add);
        view1 = (View)view.findViewById(R.id.margin);

        if(edit){
            button.setVisibility(View.VISIBLE);
            view1.setVisibility(View.GONE);
        }
        else{
            button.setVisibility(View.GONE);
            view1.setVisibility(View.INVISIBLE);
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                friendDatalist.remove(position);
                notifyDataSetChanged();
            }
        });

        if (add){
            button1.setVisibility(View.VISIBLE);
            view1.setVisibility(View.GONE);
        }
        else{
            button1.setVisibility(View.GONE);
        }
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        // Data Set(FriendData)에서 position에 위치한 데이터 참조 획득
        FriendData friendData = filteredDatalist.get(position);

        // 아이템 내 각 위젯에 데이터 반영
        i1.setImageResource(friendData.getImage());
        t1.setText(friendData.getName());
        t2.setText(friendData.getNikname());
        t3.setText(friendData.getNumber());

        return view;
    }

    public void addItem(int image, String nikname, String name, String number){
        FriendData data = new FriendData();

        data.setImage(image);
        data.setName(name);
        data.setNikname(nikname);
        data.setNumber(number);

        friendDatalist.add(data);
    }

    @Override
    public Filter getFilter() {
        if (listFilter == null) {
            listFilter = new ListFilter();
        }
        return listFilter;
    }


    private class ListFilter extends Filter {

        @Override
        protected FilterResults performFiltering(CharSequence constraint){
            FilterResults results = new FilterResults();

            if(constraint == null || constraint.length() == 0) {
                results.values = friendDatalist;
                results.count = friendDatalist.size();
            } else{
                ArrayList<FriendData> friendList = new ArrayList<FriendData>();

                for (FriendData data : friendDatalist) {
                    if (data.getName().toUpperCase().contains(constraint.toString().toLowerCase()) ||
                            data.getNumber().toUpperCase().contains(constraint.toString().toLowerCase()) ||
                            data.getNikname().toUpperCase().contains(constraint.toString().toLowerCase()))
                    {
//                    if (data.getNikname().toUpperCase().contains(constraint.toString().toLowerCase()))
//                    {
                        friendList.add(data);
                    }
                }
                results.values = friendList;
                results.count = friendList.size();
            }
            return results;
        }


        @Override
        public void publishResults(CharSequence constraint, FilterResults results) {
            filteredDatalist = (ArrayList<FriendData>) results.values ;
            if (results.count > 0) {
                notifyDataSetChanged();
            } else {
                notifyDataSetInvalidated();
            }
        }
    }
}