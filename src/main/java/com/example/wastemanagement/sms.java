package com.example.wastemanagement;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import android.os.Bundle;
import android.view.View;

public class sms extends AppCompatActivity {

    EditText txt_pNumber, txt_message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);

        txt_message = (EditText) findViewById(R.id.txt_message);
        txt_pNumber = (EditText) findViewById(R.id.txt_phone_number);
    }

    public void btn_send(View view) {

        int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS);

        if(permissionCheck== PackageManager.PERMISSION_GRANTED) {

            Mymessage();
        }

        else {

            ActivityCompat.requestPermissions(this,new String[] {Manifest.permission.SEND_SMS}, 0);
        }

    }

    private void Mymessage() {

        String phoneNumber = txt_pNumber.getText().toString().trim();
        String Message = txt_message.getText().toString().trim();

        if(!txt_pNumber.getText().toString().equals("")){
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(phoneNumber,null,Message,null,null);

            Toast.makeText(this, "Message envoyé", Toast.LENGTH_SHORT).show();

        }
        else {
            Toast.makeText(this, "Veuillez entrer un numéro", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode) {
            case 0:

                if(grantResults.length >= 0 && grantResults[0]==PackageManager.PERMISSION_GRANTED) {

                    Mymessage();
                }

                else {
                    Toast.makeText(this, "Vous n'avez pas permis l'autorisation aux sms", Toast.LENGTH_SHORT).show();
                }
        }
    }
}