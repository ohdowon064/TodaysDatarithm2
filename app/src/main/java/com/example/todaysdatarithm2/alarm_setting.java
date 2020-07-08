package com.example.todaysdatarithm2;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.todaysdatarithm2.R;

public class alarm_setting extends AppCompatActivity {
    TimePicker timePicker;
    AlarmManager alarmManager;
    int hour, minute;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm_setting);

        timePicker = findViewById(R.id.tp_timepicker);

    }// onCreate()..

    public void regist(View view) {
        Toast.makeText(getApplicationContext(), "regist", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(alarm_setting.this, Alarm.class);
        PendingIntent pIntent = PendingIntent.getBroadcast(alarm_setting.this, 0, intent, 0);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            hour = timePicker.getHour();
            minute = timePicker.getMinute();
        }

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, minute);
        calendar.set(Calendar.SECOND, 0);

        // 지정한 시간에 매일 알림
        alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        alarmManager.setInexactRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pIntent);
    }// regist()..

    public void unregist(View view) {
        Toast.makeText(getApplicationContext(), "unregist", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(alarm_setting.this, Alarm.class);
        PendingIntent pIntent = PendingIntent.getBroadcast(alarm_setting.this, 0, intent, 0);
        alarmManager.cancel(pIntent);
    }// unregist()..
}