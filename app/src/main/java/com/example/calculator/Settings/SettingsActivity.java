package com.example.calculator.Settings;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.ContentResolver;
import android.content.Context;
import android.os.Bundle;
import android.view.Window;

import com.example.calculator.R;
import com.example.calculator.RecyclerViewActivities.PhysicsActivity;

public class SettingsActivity extends AppCompatActivity {

    public static Context contextOfApplication;
    public static int bright = 50;
    private static ContentResolver contentResolver;
    private static Window window;
    private FragmentManager manager;
    private FragmentTransaction transaction;
    private Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if(AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES){
            SettingsActivity.this.setTheme(R.style.darkTheme);
        }
        super.onCreate(savedInstanceState);
        setTitle("Settings");
        setContentView(R.layout.activity_settings);
        contextOfApplication = this;
        contentResolver = getContentResolver();
        window = getWindow();

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.settings_layout, new MyPreferenceFragment())
                .commit();
    }


    public static Context getContextOfApplication() {
        return contextOfApplication;
    }

}
