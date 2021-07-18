package com.example.wastemanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public TextView connexion, timetable, city; //Les boutons de redirection

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        connexion = (TextView) findViewById(R.id.connexion);
        timetable = (TextView) findViewById(R.id.timetable);
        city = (TextView) findViewById(R.id.city);

        connexion.setOnClickListener(this);
        timetable.setOnClickListener(this);
        city.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent i;

        switch (v.getId()) {
            case R.id.connexion:
                i = new Intent(this, connexionAdmin.class);
                startActivity(i);
                break;

            case R.id.timetable:
                i = new Intent(this, timetable.class);
                startActivity(i);
                break;

            case R.id.city:
                i = new Intent(this, mapcity.class);
                startActivity(i);
                break;
        }
    }
}