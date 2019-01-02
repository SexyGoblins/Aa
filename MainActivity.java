package com.jiyun.aa;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;

import adapter.MyAdapter;

public class MainActivity extends AppCompatActivity {

    private ExpandableListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        //1.找到吗控件
        lv = (ExpandableListView) findViewById(R.id.lv);

        //2.创建数据源（组数据源）
        ArrayList<String> groupList = new ArrayList<>();
        groupList.add("我的好友");
        groupList.add("我的亲人");
        groupList.add("我的同学");

        //2.创建数据源（自数据源）
        final ArrayList<ArrayList<String>> childList = new ArrayList<>();

        //创建子类①
        ArrayList<String> c1 = new ArrayList<>();
        c1.add("小米");
        c1.add("小李");
        childList.add(c1);

        //创建子类②
        ArrayList<String> c2 = new ArrayList<>();
        c2.add("小丽");
        c2.add("小小");
        c2.add("小可");
        childList.add(c2);

        //创建子类③
        ArrayList<String> c3 = new ArrayList<>();
        c3.add("小南");
        c3.add("小飞");
        c3.add("小丁");
        c3.add("小美");
        childList.add(c3);

        //3.创建适配器
        MyAdapter adapter = new MyAdapter(this, groupList, childList);

        //4.绑定适配器
        lv.setAdapter(adapter);

        //5.设置子列表项点击监听事件
        lv.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Toast.makeText(MainActivity.this, childList.get(groupPosition).get(childPosition), Toast.LENGTH_SHORT).show();
                return true;
            }
        });

    }
}
