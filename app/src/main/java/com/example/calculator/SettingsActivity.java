package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.ContentResolver;
import android.content.Context;
import android.media.audiofx.Equalizer;
import android.os.Bundle;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

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

    public static void setAppBrightness(int x){
        bright = x;
        Settings.System.putInt(contentResolver, Settings.System.SCREEN_BRIGHTNESS, bright);
    }


}
