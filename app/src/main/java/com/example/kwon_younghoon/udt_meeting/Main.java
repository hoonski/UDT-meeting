package com.example.kwon_younghoon.udt_meeting;

import android.content.Context;
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
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class Main extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;
    private CustomDialog mCustomDialog;
    private CustomDialog_inf mCustomDialoginf;
    private CustomDialog_set mCustomDialogset;
    private CustomDialog_join mCustomDialogjoin;
    private ArrayList<FriendData> arrayList = new ArrayList<FriendData>();
    private ArrayList<Ingrid_item> arrayListItem = new ArrayList<>();
    private ItemAdapter itemAdapter;
    private FriendAdapter friendAdapter;
    private Context context;
    private GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);
        actionBar.setDisplayHomeAsUpEnabled(true);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        init();

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
                        mCustomDialog = new CustomDialog(Main.this, "친구 목록", colseListener, rightListener);
                        mCustomDialog.show();
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
            mCustomDialog.dismiss();
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

    private View.OnClickListener rightListener = new View.OnClickListener() {
        public void onClick(View v) {
            Toast.makeText(getApplicationContext(), "오른쪽버튼 클릭",
                    Toast.LENGTH_SHORT).show();
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

