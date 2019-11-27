package com.example.calculator.Settings;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;

import android.widget.PopupWindow;

import com.example.calculator.R;

public class MyPreferenceFragment extends PreferenceFragmentCompat
    implements SharedPreferences.OnSharedPreferenceChangeListener {
    private PopupWindow pop;
    private Preference rating;
    private Preference feedback;

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.preferences, rootKey);
        rating = findPreference("SayThanks");
        rating.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                startActivity(new Intent(SettingsActivity.getContextOfApplication(), PopupRatingActivity.class));
                return false;
            }
        });

        feedback = findPreference("feedback");
        feedback.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                startActivity(new Intent(SettingsActivity.getContextOfApplication(), PopupFeedbackActivity.class));
                return false;
            }
        });



    }


    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key)
    {

    }



}
