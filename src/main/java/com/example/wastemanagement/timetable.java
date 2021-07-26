package com.example.wastemanagement;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CalendarView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.auth.User;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class timetable extends AppCompatActivity {

    private static final String TAG = "timetable";
    public CalendarView calender;
    //public SimpleDateFormat dateFormat = new SimpleDateFormat("JJJ-DD-MM-YYYY", Locale.getDefault());

    FirebaseFirestore db = FirebaseFirestore.getInstance(); // Access a Cloud Firestore instance from your Activity

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timetable);

        // Create a new user
        Map<String, Object> user = new HashMap<>();
        user.put("nom", "Bouba"); user.put("prenom", "Stéphane"); user.put("lieu", "Shell Anguissa"); user.put("jour", "Mercredi"); user.put("heure", "11h");

        // Add a new document with a generated ID
        db.collection("users")
                .add(user)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
                    }
                 })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error adding document", e);
                    }
                });

        // Receive all documents
        // Pour la selection on ajoute aprèes avant le .get() : ".whereEqualTo("field", "value")"
        db.collection("users")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d(TAG, document.getId() + " => " + document.getData());
                            }
                        } else {
                            Log.w(TAG, "Error getting documents.", task.getException());
                        }
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(timetable.this, "Error getting data !!", Toast.LENGTH_SHORT).show();
                    }
                });


        calender = (CalendarView) findViewById(R.id.calendarView);
        calender.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {

                Toast.makeText(timetable.this, "Le jour choisi est le: " + dayOfMonth + "/" + month + "/" + year, Toast.LENGTH_SHORT).show();
            }
        });
    }
}