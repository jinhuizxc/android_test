package com.jh.gridview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.os.Build;
import android.widget.Toast;

public class MainActivity extends Activity implements AdapterView.OnItemClickListener {

    private GridView gridView;
    private SimpleAdapter adapter;
    private List<Map<String, Object>> dataList;

    private int[] drawable = {R.drawable.address_book, R.drawable.calendar,
            R.drawable.camera, R.drawable.clock, R.drawable.games_control,
            R.drawable.messenger, R.drawable.ringtone, R.drawable.settings,
            R.drawable.speech_balloon, R.drawable.weather,
            R.drawable.world, R.drawable.youtube};

    private String[] iconName = {"联系人", "日历", "照相机", "时钟", "游戏", "短信", "铃声", "设置",
            "语音", "天气", "浏览器", "Youtube"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.main);
        gridView = (GridView) findViewById(R.id.gridView);
        dataList = new ArrayList<Map<String, Object>>();
        adapter = new SimpleAdapter(this, getData(), R.layout.item, new String[]{"pic", "name"}, new int[]{R.id.pic, R.id.name});
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(this);
    }

    private List<Map<String, Object>> getData() {
        for (int i = 0; i < drawable.length; i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("pic", drawable[i]);
            map.put("name", iconName[i]);
            dataList.add(map);
        }
        Log.i("Main", "size=" + dataList.size());
        return dataList;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, "我是" + iconName[position], Toast.LENGTH_SHORT).show();
    }
}
