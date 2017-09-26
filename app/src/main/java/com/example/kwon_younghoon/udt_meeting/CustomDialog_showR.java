package com.example.kwon_younghoon.udt_meeting;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomDialog_showR extends Dialog {

    private TextView mTitleView;
    private Button mCloseButton;
    private Button mNextButton;
    private Button mBackButton;
    private Button mConfButton;
    private String mTitle;
    ArrayList<FriendData> arrayList = new ArrayList<FriendData>();
    FriendAdapter friendAdapter;
    private ListView listView = null;
    private Context context;
    private LinearLayout linearLayout1;
    private LinearLayout linearLayout2;
    private View.OnClickListener mCloseClickListener;
    private View.OnClickListener mConfClickListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 다이얼로그 외부 화면 흐리게 표현
        WindowManager.LayoutParams lpWindow_inf = new WindowManager.LayoutParams();
        lpWindow_inf.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        lpWindow_inf.dimAmount = 0.8f;
        getWindow().setAttributes(lpWindow_inf);

        setContentView(R.layout.activity_custom_dialog_show_r);

        init();

        mTitleView = (TextView) findViewById(R.id.showR_F_txt);
        mCloseButton = (Button) findViewById(R.id.showR_F_close);
        mNextButton = (Button) findViewById(R.id.showR_F_next);
        mBackButton = (Button) findViewById(R.id.showR_S_back);
        mConfButton = (Button) findViewById(R.id.showR_S_conf);

        linearLayout1 = (LinearLayout) findViewById(R.id.showR_F_layout);
        linearLayout2 = (LinearLayout) findViewById(R.id.showR_S_layout);
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                linearLayout1.setVisibility(View.GONE);
                linearLayout2.setVisibility(View.VISIBLE);
                friendAdapter.add = true;
            }
        });
        mBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                linearLayout1.setVisibility(View.VISIBLE);
                linearLayout2.setVisibility(View.GONE);
                friendAdapter.add = false;
            }
        });

        // 제목과 내용을 생성자에서 셋팅한다.
        mTitleView.setText(mTitle);

        // 클릭 이벤트 셋팅
        if (mCloseClickListener != null && mConfClickListener != null) {
            mCloseButton.setOnClickListener(mCloseClickListener);
            mConfButton.setOnClickListener(mConfClickListener);
        } else if (mCloseClickListener != null
                && mConfClickListener == null) {
            mCloseButton.setOnClickListener(mCloseClickListener);
        } else {
        }
    }

    // 클릭버튼이 하나일때 생성자 함수로 클릭이벤트를 받는다.
    public CustomDialog_showR(Context context, String title,
                            View.OnClickListener closeListener_showR) {
        super(context, android.R.style.Theme_Translucent_NoTitleBar);
        this.mTitle = title;
        this.mCloseClickListener = closeListener_showR;
        this.context = context;
    }

    // 클릭버튼이 확인과 취소 두개일때 생성자 함수로 이벤트를 받는다
    public CustomDialog_showR(Context context, String title
            , View.OnClickListener closeListener_showR,
                            View.OnClickListener confListener) {
        super(context, android.R.style.Theme_Translucent_NoTitleBar);
        this.mTitle = title;
        this.mCloseClickListener = closeListener_showR;
        this.mConfClickListener = confListener;
        this.context = context;
    }

    void init(){
        listView = (ListView)findViewById(R.id.in_friends_list);
        friendAdapter = new FriendAdapter();
        friendAdapter.addItem(R.drawable.a, "gegnnjr", "geg", "15");
        friendAdapter.addItem(R.drawable.a, "herweqr", "영훈", "16");
        friendAdapter.addItem(R.drawable.a, "afsagnjr", "제웅", "15");
        friendAdapter.addItem(R.drawable.a, "vgaer", "제넌", "16");
        listView.setAdapter(friendAdapter);
    }
}