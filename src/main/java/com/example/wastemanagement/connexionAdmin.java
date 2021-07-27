package com.example.wastemanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class connexionAdmin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connexion_admin);
    }

    public void onClick(View view) {
        Toast.makeText(this, "Connexion ...", Toast.LENGTH_SHORT).show();
    }
}