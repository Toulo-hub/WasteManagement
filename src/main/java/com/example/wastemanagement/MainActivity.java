package com.example.wastemanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public TextView connexion, timetable, city, sms; //Les boutons de redirection

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        connexion = (TextView) findViewById(R.id.connexion);
        timetable = (TextView) findViewById(R.id.timetable);
        city = (TextView) findViewById(R.id.city);
        sms = (TextView) findViewById(R.id.sms);

        connexion.setOnClickListener(this);
        timetable.setOnClickListener(this);
        city.setOnClickListener(this);
        sms.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;

        switch (v.getId()) {
            case R.id.connexion:
                intent = new Intent(this, connexionAdmin.class);
                startActivity(intent);
                break;

            case R.id.timetable:
                intent = new Intent(this, timetable.class);
                startActivity(intent);
                break;

            case R.id.city:
                intent = new Intent(this, mapcity.class);
                startActivity(intent);
                break;

            case R.id.sms:
                intent = new Intent(this, sms.class);
                startActivity(intent);
                break;
        }
    }
}