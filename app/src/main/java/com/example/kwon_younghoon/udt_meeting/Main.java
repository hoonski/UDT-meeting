package com.example.kwon_younghoon.udt_meeting;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class Main extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;
    private CustomDialog_frie mCustomDialog_frie;
    private CustomDialog_inf mCustomDialoginf;
    private CustomDialog_set mCustomDialogset;
    private CustomDialog_join mCustomDialogjoin;
    private CustomDialog_addR mCustomDialogaddR;
    private CustomDialog_showR mCustomDialogshowR;
    private ArrayList<FriendData> arrayList = new ArrayList<FriendData>();
    private ArrayList<Ingrid_item> arrayListItem = new ArrayList<>();
    private ItemAdapter itemAdapter;
    private GridView gridView;
    private Button addButton;
    private Button upFrameButton;
    private Button downFrameButton;
    private LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);
        actionBar.setDisplayHomeAsUpEnabled(true);

        init();

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                mCustomDialogshowR = new CustomDialog_showR(Main.this, "방 입장" ,colseListener_showR, colseListener_showR1);
                mCustomDialogshowR.show();
            }
        });

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        addButton = (Button)findViewById(R.id.main_add_room);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCustomDialogaddR = new CustomDialog_addR(Main.this, "방 만들기", colseListener_addR, appListener);
                mCustomDialogaddR.show();
            }
        });
        linearLayout = (LinearLayout)findViewById(R.id.main_uped_layout);
        upFrameButton = (Button)findViewById(R.id.main_up_frame);
        upFrameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                linearLayout.setVisibility(View.VISIBLE);
            }
        });
        downFrameButton = (Button)findViewById(R.id.main_down_frame);
        downFrameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                linearLayout.setVisibility(View.INVISIBLE);
            }
        });


        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                menuItem.setChecked(true);
                mDrawerLayout.closeDrawers();


                int id = menuItem.getItemId();
                switch (id) {
                    case R.id.my_information:
                        mCustomDialoginf = new CustomDialog_inf(Main.this, "내정보", colseListener_info);
                        mCustomDialoginf.show();
                        break;

                    case R.id.friends_list:
                        mCustomDialog_frie = new CustomDialog_frie(Main.this, "친구 목록", colseListener);
                        mCustomDialog_frie.show();
                        break;

                    case R.id.setting:
                        mCustomDialogset = new CustomDialog_set(Main.this, "환경 설정", colseListener_set);
                        mCustomDialogset.show();
                        break;

                    case R.id.nav_sub_menu_item01:
                        Toast.makeText(Main.this, menuItem.getTitle(), Toast.LENGTH_LONG).show();
                        break;

                    case R.id.nav_sub_menu_item02:
                        Toast.makeText(Main.this, menuItem.getTitle(), Toast.LENGTH_LONG).show();
                        break;
                }
                return true;
            }
        });
    }


    private View.OnClickListener colseListener = new View.OnClickListener() {
        public void onClick(View v) {
            mCustomDialog_frie.dismiss();
        }
    };

    private View.OnClickListener colseListener_info = new View.OnClickListener() {
        public void onClick(View v) {
            mCustomDialoginf.dismiss();
        }
    };

    private View.OnClickListener colseListener_set = new View.OnClickListener() {
        public void onClick(View v) {
            mCustomDialogset.dismiss();
        }
    };

    private View.OnClickListener colseListener_join = new View.OnClickListener() {
        public void onClick(View v) {
            mCustomDialogjoin.dismiss();
        }
    };

    private View.OnClickListener colseListener_addR = new View.OnClickListener() {
        public void onClick(View view) {
            mCustomDialogaddR.dismiss();
        }
    };

    private View.OnClickListener appListener = new View.OnClickListener() {
        public void onClick(View v) {
            mCustomDialogaddR.dismiss();
        }
    };

    private View.OnClickListener colseListener_showR = new View.OnClickListener() {
        public void onClick(View view) {
            mCustomDialogshowR.dismiss();
        }
    };

    private View.OnClickListener colseListener_showR1 = new View.OnClickListener() {
        public void onClick(View view) {
            mCustomDialogshowR.dismiss();
        }
    };

    void init() {
        gridView = (GridView)findViewById(R.id.main_grid);
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
        itemAdapter = new ItemAdapter(arrayListItem, this);
        gridView.setAdapter(itemAdapter);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (id) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
            case R.id.action_settings:
                mCustomDialogjoin = new CustomDialog_join(Main.this, "방 목록", colseListener_join);
                mCustomDialogjoin.show();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

}

