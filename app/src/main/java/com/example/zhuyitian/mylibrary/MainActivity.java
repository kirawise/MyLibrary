package com.example.zhuyitian.mylibrary;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

//    listview列表
    private List<Map<String, Object>> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        test toolbar
//        toolbar.setLogo(R.id.borrow);

//        Edittext 失去焦点
        ((EditText) findViewById(R.id.searchInput)).clearFocus();

//        设置主页的按钮
        ((ImageView) findViewById(R.id.retrival)).setOnClickListener(this);
        ((ImageView) findViewById(R.id.borrow)).setOnClickListener(this);
        ((ImageView) findViewById(R.id.bbs)).setOnClickListener(this);
        ((ImageView) findViewById(R.id.order)).setOnClickListener(this);
        ((ImageView) findViewById(R.id.renewal)).setOnClickListener(this);

//      搜索框,点击搜索按钮
        TextView search = (TextView) findViewById(R.id.searchBtn);
        search.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
//                TODO:
//                change null to SearchActivity.class
                i.setClass(MainActivity.this, null);
                EditText et = (EditText) findViewById(R.id.searchInput);
                i.putExtra("input", et.getText().toString());
                startActivity(i);
            }
        });


//        设置首页消息列表
        ListView lv = (ListView)findViewById(R.id.listView);
        data = getData();
        MyAdapter adapter = new MyAdapter(this);
        lv.setAdapter(adapter);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
//        Intent i = new Intent();

//        TODO
//        删除注释
        if (id == R.id.nav_borrow) {
//            i.setClass(MainActivity.this, MyBorrowActivity.class);
//            startActivity(i);
        } else if (id == R.id.nav_info) {
//            i.setClass(MainActivity.this, UserActivity.class);
//            startActivity(i);
        } else if (id == R.id.nav_bbs) {
//            i.setClass(MainActivity.this, BBSActivity.class);
//            startActivity(i);
        } else if (id == R.id.nav_manage) {
//            i.setClass(MainActivity.this, SettingsActivity.class);
//            startActivity(i);
        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        } else if (id == R.id.nav_feedback){

        } else if (id == R.id.nav_about){

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View v) {
//        TODO
//        去掉注释

        int id = v.getId();
        Intent i = new Intent();
        if (id == R.id.news) {

        } else if (id == R.id.category) {

        } else if (id == R.id.retrival) {
//            i.setClass(MainActivity.this, SearchActivity.class);
//            startActivity(i);
        } else if (id == R.id.lecture) {

        } else if (id == R.id.bbs) {
//            i.setClass(MainActivity.this, BBSActivity.class);
//            startActivity(i);
        } else if (id == R.id.borrow) {
//            i.setClass(MainActivity.this, MyBorrowActivity.class);
//            startActivity(i);
        } else if (id == R.id.renewal) {
//            i.setClass(MainActivity.this, MyBorrowActivity.class);
//            startActivity(i);
        } else if (id == R.id.order) {
//            i.setClass(MainActivity.this, SearchActivity.class);
//            startActivity(i);
        }
    }

    //    设置listview
    private List<Map<String, Object>> getData() {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<String, Object> map;
        map = new HashMap<String, Object>();
        map.put("img", R.drawable.ic_about_24dp);
        map.put("title", "借阅信息");
        map.put("info", "您有两本图书即将到期");
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("img", R.drawable.ic_about_24dp);
        map.put("title", "当前借阅");
        map.put("info", "xxxxx");
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("img", R.drawable.ic_about_24dp);
        map.put("title", "预约到书");
        map.put("info", "C语言从入门到放弃已经到啦");
        list.add(map);

        return list;
    }
    //ViewHolder静态类
    static class ViewHolder
    {
        public ImageView img;
        public TextView title;
        public TextView info;
    }
    public class MyAdapter extends BaseAdapter
    {
        private LayoutInflater mInflater = null;
        private MyAdapter(Context context)
        {
            //根据context上下文加载布局，这里的是Demo17Activity本身，即this
            this.mInflater = LayoutInflater.from(context);
        }
        @Override
        public int getCount() {
            //How many items are in the data set represented by this Adapter.
            //在此适配器中所代表的数据集中的条目数
            return data.size();
        }
        @Override
        public Object getItem(int position) {
            // Get the data item associated with the specified position in the data set.
            //获取数据集中与指定索引对应的数据项
            return position;
        }
        @Override
        public long getItemId(int position) {
            //Get the row id associated with the specified position in the list.
            //获取在列表中与指定索引对应的行id
            return position;
        }

        //Get a View that displays the data at the specified position in the data set.
        //获取一个在数据集中指定索引的视图来显示数据
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder = null;
            //如果缓存convertView为空，则需要创建View
            if(convertView == null)
            {
                holder = new ViewHolder();
                //根据自定义的Item布局加载布局
                convertView = mInflater.inflate(R.layout.list_item_main, null);
                holder.img = (ImageView)convertView.findViewById(R.id.img);
                holder.title = (TextView)convertView.findViewById(R.id.tv);
                holder.info = (TextView)convertView.findViewById(R.id.info);
                //将设置好的布局保存到缓存中，并将其设置在Tag里，以便后面方便取出Tag
                convertView.setTag(holder);
            }else
            {
                holder = (ViewHolder)convertView.getTag();
            }
            holder.img.setBackgroundResource((Integer)data.get(position).get("img"));
            holder.title.setText((String)data.get(position).get("title"));
            holder.info.setText((String)data.get(position).get("info"));

            return convertView;
        }

    }

}
