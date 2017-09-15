package com.example.kwon_younghoon.udt_meeting;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class information extends AppCompatActivity {

    int i;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        final Button b1 = (Button) findViewById(R.id.btn_man);
        final Button b2 = (Button) findViewById(R.id.btn_woman);

        b1.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                b1.setBackgroundColor(Color.rgb(122,245,147));
                b2.setBackgroundColor(Color.rgb(223,223,223));
                i = 1;

            }
        });


        b2.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                b2.setBackgroundColor(Color.rgb(144,236,116));
                b1.setBackgroundColor(Color.rgb(223,223,223));
                i = 2;
            }
        });
    }
}
