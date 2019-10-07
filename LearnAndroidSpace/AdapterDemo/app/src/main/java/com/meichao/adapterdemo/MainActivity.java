package com.meichao.adapterdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


//        //ArrayAdapter ***
//        setContentView(R.layout.arrayadapter001);
//        String[] strings = new String[]{"苹果", "香蕉", "橘子", "葡萄"};
//
//        //创建ArrayAdapter
//        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, strings);
//
//        ListView testlistView001 = findViewById(R.id.ArrayAdapter_ListView001);
//        testlistView001.setAdapter(arrayAdapter); //设置要显示的数据


        //simpleArray **
        setContentView(R.layout.simpleadapter);
        String[] names = new String[]{"苹果", "香蕉", "橘子", "葡萄"};
        String[] descriptions = new String[]{"苹果001", "香蕉002", "橘子003", "葡萄004"};
        int[] icons = new int[]{R.drawable.thumb, R.drawable.track, R.drawable.ic_launcher_background, R.drawable.ic_launcher_foreground};

        List<Map<String, Object>> listItems = new ArrayList<Map<String, Object>>();
        for (int dex = 0; dex < 4; ++dex) {
            Map<String, Object> showItems = new HashMap<String, Object>();
            showItems.put("name", names[dex]);
            showItems.put("description", descriptions[dex]);
            showItems.put("icon", icons[dex]);

            listItems.add(showItems);
        }

        SimpleAdapter myAdapter = new SimpleAdapter(getApplicationContext(), listItems, R.layout.simpleadapteritem, new String[]{
                "name", "description", "icon"
        }, new int[]{R.id.name001, R.id.description001, R.id.icon001});

        ListView listView = findViewById(R.id.SimpleAdapter001);
        listView.setAdapter(myAdapter);
    }

}










