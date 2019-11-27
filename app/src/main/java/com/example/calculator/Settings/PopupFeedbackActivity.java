package com.example.calculator.Settings;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.MediaCas;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.se.omapi.Session;
import android.telephony.SmsManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.calculator.MainActivity;
import com.example.calculator.R;

import java.net.PasswordAuthentication;
import java.security.Permission;
import java.util.Properties;

import javax.sql.DataSource;

public class PopupFeedbackActivity extends AppCompatActivity {
    private EditText getMessage;
    private Button submitBtn;

    private SmsManager smgr;

    private String PHONE = "8604223810";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_feedback);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int) (width * 0.8), (int)(height * 0.6));

        smgr = SmsManager.getDefault();
        submitBtn = findViewById(R.id.rating_btn);
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {
                getMessage = findViewById(R.id.feedback_message);
                String finalMessage = getMessage.getText().toString();
                String[] array = {Manifest.permission.SEND_SMS};
                if (ContextCompat.checkSelfPermission(SettingsActivity.getContextOfApplication(), Manifest.permission.SEND_SMS)
                        != PackageManager.PERMISSION_GRANTED) {
                    requestPermissions(array, 1);
                    Toast.makeText(PopupFeedbackActivity.this, "Permission Denied", Toast.LENGTH_SHORT).show();
                } else{
                    smgr.sendTextMessage(PHONE, null, finalMessage, null, null);
                    Toast.makeText(PopupFeedbackActivity.this, "Feedback Sent", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

}
