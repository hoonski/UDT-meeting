package com.example.kwon_younghoon.udt_meeting;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class udt_meeting extends AppCompatActivity {
    Button fakeKakao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_udt_meeting);

        fakeKakao = (Button)findViewById(R.id.fake_kakao);
        fakeKakao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(udt_meeting.this, Main.class);
                startActivity(intent);
            }
        });

    }
}



