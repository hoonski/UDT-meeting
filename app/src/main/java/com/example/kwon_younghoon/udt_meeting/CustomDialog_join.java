package com.example.kwon_younghoon.udt_meeting;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by kwon-younghoon on 2017. 9. 24..
 */
public class CustomDialog_join extends Dialog {

    private TextView mTitleView;
    private Button mCloseButton;
    private String mTitle;
    private GridView gridView;
    private ArrayList<Ingrid_item> arrayListItem;
    private ItemAdapter itemAdapter;
    private Context context;
    private View.OnClickListener mCloseClickListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 다이얼로그 외부 화면 흐리게 표현
        WindowManager.LayoutParams lpWindow_inf = new WindowManager.LayoutParams();
        lpWindow_inf.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        lpWindow_inf.dimAmount = 0.8f;
        getWindow().setAttributes(lpWindow_inf);

        setContentView(R.layout.activity_custom_dialog_join);

        arrayListItem = new ArrayList<Ingrid_item>();
        init();
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(context, ChattingRoom.class);
                context.startActivity(intent);
            }
        });

        mTitleView = (TextView) findViewById(R.id.join_text);
        mCloseButton = (Button) findViewById(R.id.join_close);

        // 제목과 내용을 생성자에서 셋팅한다.
        mTitleView.setText(mTitle);

        // 클릭 이벤트 셋팅
        if (mCloseClickListener != null) {
            mCloseButton.setOnClickListener(mCloseClickListener);
        } else {
        }
    }

    // 클릭버튼이 하나일때 생성자 함수로 클릭이벤트를 받는다.
    public CustomDialog_join(Context context, String title,
                            View.OnClickListener closeListener_join) {
        super(context, android.R.style.Theme_Translucent_NoTitleBar);
        this.mTitle = title;
        this.mCloseClickListener = closeListener_join;
        this.context = context;
    }

    void init() {
        gridView = (GridView)findViewById(R.id.join_view);
        arrayListItem.add(new Ingrid_item(R.drawable.a));
        arrayListItem.add(new Ingrid_item(R.drawable.a));
        arrayListItem.add(new Ingrid_item(R.drawable.a));
        arrayListItem.add(new Ingrid_item(R.drawable.a));
        arrayListItem.add(new Ingrid_item(R.drawable.a));
        arrayListItem.add(new Ingrid_item(R.drawable.a));
        arrayListItem.add(new Ingrid_item(R.drawable.a));
        arrayListItem.add(new Ingrid_item(R.drawable.a));
        arrayListItem.add(new Ingrid_item(R.drawable.a));
        arrayListItem.add(new Ingrid_item(R.drawable.a));
        arrayListItem.add(new Ingrid_item(R.drawable.a));
        arrayListItem.add(new Ingrid_item(R.drawable.a));
        itemAdapter = new ItemAdapter(arrayListItem, context);
        gridView.setAdapter(itemAdapter);
    }
}