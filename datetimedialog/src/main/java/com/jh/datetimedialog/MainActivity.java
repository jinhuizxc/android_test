package com.jh.datetimedialog;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements android.view.View.OnClickListener {

    private Button date_button;
    private Button time_button;
    private Calendar calendar;
    private TextView tv_date;
    private TextView tv_time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        date_button = (Button) findViewById(R.id.date_button);
        time_button = (Button) findViewById(R.id.time_button);
        tv_date = (TextView) findViewById(R.id.tv_date);
        tv_time = (TextView) findViewById(R.id.tv_time);
        date_button.setOnClickListener(this);
        time_button.setOnClickListener(this);
        //获取当前的年月日时分信息
        calendar = Calendar.getInstance();

    }


    private void showDateDialog() {
        DatePickerDialog date_dialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                tv_date.setText("现在日期：" + year + "-" + (monthOfYear + 1) + "-" + dayOfMonth);
            }
        }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));

        date_dialog.show();
    }

    private void showTimeDialog() {
        TimePickerDialog time_dialog = new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {

            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                tv_time.setText("现在时间：" + hourOfDay + ":" + minute);
            }
        }, calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), true);
        time_dialog.show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.date_button:
                showDateDialog();
                break;
            case R.id.time_button:
                showTimeDialog();
                break;
        }
    }


}
