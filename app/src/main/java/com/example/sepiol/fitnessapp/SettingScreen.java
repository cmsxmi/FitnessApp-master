package com.example.sepiol.fitnessapp;

import android.annotation.SuppressLint;
import android.app.Fragment;

import android.app.FragmentTransaction;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Fragment;


public class SettingScreen extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_screen);



        Fragment fragment = new SettingsScreen();
        FragmentTransaction fragmenttrancation = getFragmentManager().beginTransaction();
        if (savedInstanceState == null) {
            fragmenttrancation.add(R.id.relative, fragment, "settings_fragment");
            fragmenttrancation.commit();
        }
    }


    @SuppressLint("ValidFragment")
    public class SettingsScreen extends PreferenceFragment {
        @Override
        public void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.settings_screen);
            Preference preference = (Preference) findPreference("reset");
            preference.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
                @Override
                public boolean onPreferenceClick(Preference preference) {
                    final SharedPreferences sharedPref = getSharedPreferences("userProgress", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPref.edit();
                    sharedPref.edit().clear().commit();
                    return true;
                }
            });
        }
    }
}