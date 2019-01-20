package com.jh.spinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity  {

    private List<String> list = new ArrayList<String>();
    private TextView myTextView;
    private Spinner mySpinner;
    private ArrayAdapter<String> adapter;
    private Animation myAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        // 第一步：添加一个下拉列表项的list，这里添加的项就是下拉列表的菜单项
        list.add("北京");
        list.add("上海");
        list.add("广州");
        list.add("深圳");
        myTextView = (TextView) findViewById(R.id.textView);
        mySpinner = (Spinner) findViewById(R.id.spinner);
        // 第二步：为下拉列表定义一个适配器，这里就用到里前面定义的list。
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        // 第三步：为适配器设置下拉列表下拉时的菜单样式。
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // 第四步：将适配器添加到下拉列表上
        mySpinner.setAdapter(adapter);
        // 第五步：为下拉列表设置各种事件的响应，这个事响应菜单被选中
        mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                /* 将所选mySpinner 的值带入myTextView 中 */
//                myTextView.setText("您选择的是: " + adapter.getItem(position));
                myTextView.setText("您选择的是: " + list.get(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                myTextView.setText("NONE");
            }
        });


    }



}
