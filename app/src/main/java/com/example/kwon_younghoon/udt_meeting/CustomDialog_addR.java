package com.example.kwon_younghoon.udt_meeting;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomDialog_addR extends Dialog {

    private TextView mTitleView;
    private Button mCloseButton;
    private Button mCloseButton1;
    private Button mConfButton;
    private Button mAddButton;
    private Button mAppButton;
    private String mTitle;
    ListView listView = null ;
    ArrayList<FriendData> arrayList = new ArrayList<FriendData>();
    FriendAdapter friendAdapter;
    private Context context;
    private View.OnClickListener mCloseClickListener;
    private View.OnClickListener mAppClickListener;
    private LinearLayout linearLayout;
    private LinearLayout linearLayout1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 다이얼로그 외부 화면 흐리게 표현
        WindowManager.LayoutParams lpWindow = new WindowManager.LayoutParams();
        lpWindow.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        lpWindow.dimAmount = 0.8f;
        getWindow().setAttributes(lpWindow);

        setContentView(R.layout.activity_custom_dialog_add_r);

        init();

        EditText editTextFilter = (EditText)findViewById(R.id.addR_F_search) ;
        editTextFilter.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable edit) {
                String filterText = edit.toString();
                ((FriendAdapter)listView.getAdapter()).getFilter().filter(filterText);
            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        }) ;


        mTitleView = (TextView) findViewById(R.id.addR_F_title);
        mCloseButton = (Button) findViewById(R.id.addR_F_close);
        mCloseButton1 = (Button) findViewById(R.id.addR_S_close);
        mConfButton = (Button) findViewById(R.id.addR_F_conf);
        mAddButton = (Button) findViewById(R.id.add_in_friend);
        mAppButton = (Button) findViewById(R.id.addR_S_app);

        linearLayout = (LinearLayout)findViewById(R.id.addR_S_layout);
        linearLayout1 = (LinearLayout)findViewById(R.id.addR_F_layout);

        mConfButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                linearLayout.setVisibility(View.VISIBLE);
                linearLayout1.setVisibility(View.INVISIBLE);

            }
        });
        mCloseButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                linearLayout1.setVisibility(View.VISIBLE);
                linearLayout.setVisibility(View.INVISIBLE);
            }
        });
        mAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (friendAdapter.add == true){
                    friendAdapter.add = false;
                }else{
                    friendAdapter.add = true;
                }
                friendAdapter.notifyDataSetChanged();
            }
        });

        // 제목과 내용을 생성자에서 셋팅한다.
        mTitleView.setText(mTitle);

        // 클릭 이벤트 셋팅
        if (mCloseClickListener != null && mAppClickListener != null) {
            mCloseButton.setOnClickListener(mCloseClickListener);
            mAppButton.setOnClickListener(mAppClickListener);
        } else if (mCloseClickListener != null
                && mAppClickListener == null) {
            mCloseButton.setOnClickListener(mCloseClickListener);
        } else {

        }
    }

    // 클릭버튼이 하나일때 생성자 함수로 클릭이벤트를 받는다.
    public CustomDialog_addR(Context context, String title,
                        View.OnClickListener singleListener) {
        super(context, android.R.style.Theme_Translucent_NoTitleBar);
        this.mTitle = title;
        this.mCloseClickListener = singleListener;

    }

    // 클릭버튼이 확인과 취소 두개일때 생성자 함수로 이벤트를 받는다
    public CustomDialog_addR(Context context, String title
            , View.OnClickListener closeListener,
                        View.OnClickListener appListener) {
        super(context, android.R.style.Theme_Translucent_NoTitleBar);
        this.mTitle = title;
        this.mCloseClickListener = closeListener;
        this.mAppClickListener = appListener;
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