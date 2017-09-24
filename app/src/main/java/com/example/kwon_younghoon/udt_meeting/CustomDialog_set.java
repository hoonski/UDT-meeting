package com.example.kwon_younghoon.udt_meeting;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by kwon-younghoon on 2017. 9. 24..
 */
public class CustomDialog_set extends Dialog {

    private TextView mTitleView;
    private Button mCloseButton;
    private Button mRightButton;
    private String mTitle;
    ArrayList<FriendData> arrayList = new ArrayList<FriendData>();
    FriendAdapter friendAdapter;
    private Context context;
    private View.OnClickListener mCloseClickListener;
    private View.OnClickListener mRightClickListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 다이얼로그 외부 화면 흐리게 표현
        WindowManager.LayoutParams lpWindow_inf = new WindowManager.LayoutParams();
        lpWindow_inf.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        lpWindow_inf.dimAmount = 0.8f;
        getWindow().setAttributes(lpWindow_inf);

        setContentView(R.layout.activity_custom_dialog_set);

        mTitleView = (TextView) findViewById(R.id.set_text);
        mCloseButton = (Button) findViewById(R.id.set_close);
        mRightButton = (Button) findViewById(R.id.set_btn);

        // 제목과 내용을 생성자에서 셋팅한다.
        mTitleView.setText(mTitle);

        // 클릭 이벤트 셋팅
        if (mCloseClickListener != null && mRightClickListener != null) {
            mCloseButton.setOnClickListener(mCloseClickListener);
            mRightButton.setOnClickListener(mRightClickListener);
        } else if (mCloseClickListener != null
                && mRightClickListener == null) {
            mCloseButton.setOnClickListener(mCloseClickListener);
        } else {
        }
    }

    // 클릭버튼이 하나일때 생성자 함수로 클릭이벤트를 받는다.
    public CustomDialog_set(Context context, String title,
                            View.OnClickListener closeListener_set) {
        super(context, android.R.style.Theme_Translucent_NoTitleBar);
        this.mTitle = title;
        this.mCloseClickListener = closeListener_set;
        this.context = context;
    }

    // 클릭버튼이 확인과 취소 두개일때 생성자 함수로 이벤트를 받는다
    public CustomDialog_set(Context context, String title
            , View.OnClickListener closeListener_set,
                            View.OnClickListener rightListener) {
        super(context, android.R.style.Theme_Translucent_NoTitleBar);
        this.mTitle = title;
        this.mCloseClickListener = closeListener_set;
        this.mRightClickListener = rightListener;
        this.context = context;
    }
}