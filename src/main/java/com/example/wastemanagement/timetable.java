package com.example.wastemanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CalendarView;

public class timetable extends AppCompatActivity {

    public CalendarView calendrier;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timetable);

        calendrier = (CalendarView) findViewById(R.id.calendarView);
    }
}