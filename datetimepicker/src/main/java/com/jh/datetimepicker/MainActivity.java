package com.jh.datetimepicker;

import java.util.Calendar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.DatePicker;
import android.widget.DatePicker.OnDateChangedListener;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.TimePicker.OnTimeChangedListener;

public class MainActivity extends AppCompatActivity {

    private DatePicker date_picker;
    private TimePicker time_picker;
    private TextView tv_date;
    private TextView tv_time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        //初始化
        date_picker = (DatePicker) findViewById(R.id.date);
        time_picker = (TimePicker) findViewById(R.id.time);
        tv_date = (TextView) findViewById(R.id.tv_date);
        tv_time = (TextView) findViewById(R.id.tv_time);
        //获取当前的年月日时分信息
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        tv_date.setText("现在日期：" + year + "-" + (month + 1) + "-" + day);
        tv_time.setText("现在时间：" + hour + ":" + minute);
        setTitle(year + "-" + (month + 1) + "-" + day + " " + hour + ":" + minute);
        //初始化日期
        date_picker.init(year, month, day, new OnDateChangedListener() {

            //监听日期的改变
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear,
                                      int dayOfMonth) {
                //Toast.makeText(MainActivity.this, "现在时间："+year+"-"+(monthOfYear+1)+"-"+dayOfMonth, 0).show();
                tv_date.setText("现在日期：" + year + "-" + (monthOfYear + 1) + "-" + dayOfMonth);
            }
        });

        //设置时间为24小时制
        time_picker.setIs24HourView(true);
        time_picker.setOnTimeChangedListener(new OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                tv_time.setText("现在时间：" + hourOfDay + ":" + minute);
            }
        });

    }


}

