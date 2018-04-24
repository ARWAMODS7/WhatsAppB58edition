package com.B58works.settings.visualmods;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.EditTextPreference;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.TwoStatePreference;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import com.B58works.B58;
import com.whatsapp.architjn.store.ColorStore;
import com.whatsapp.nc;

import static com.B58works.B58.getResID;
import static com.B58works.settings.visualmods.Settings.sContext;

public class Themescreen extends nc   implements SharedPreferences.OnSharedPreferenceChangeListener,Preference.OnPreferenceClickListener{

    public SharedPreferences.Editor editor;

    public boolean onPreferenceClick(final Preference preference) {
        if (preference.getKey().equals("save_temp")) {
            B58.DialogSaveTheme( this);
        } else if (preference.getKey().equals("load_pref_file")) {
            B58.LoadTheme( this);
        } else if (preference.getKey().equals("clear_pref_file")) {
            B58.ClearTheme( this);
        } else if (preference.getKey().equals("download")) {
            B58.DownloadTheme( this);
        }
        return true;
    }

    public void onCreate(Bundle b) {
        super.onCreate(b);
        addPreferencesFromResource(B58.getResID("vtheme", "xml"));
        findPreference("save_temp").setOnPreferenceClickListener(this);
        findPreference("load_pref_file").setOnPreferenceClickListener(this);
        findPreference("clear_pref_file").setOnPreferenceClickListener(this);
        findPreference("download").setOnPreferenceClickListener(this);
        if (sContext == null)
            sContext = getBaseContext();
        this.editor = sContext.getSharedPreferences("B58", 0).edit();
    }

    protected void onPause() {
        super.onPause();
        getPreferenceScreen().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);
    }

    protected void onResume() {
        super.onResume();
        getPreferenceScreen().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);
    }

    public void onSharedPreferenceChanged(SharedPreferences paramSharedPreferences, String paramString)
    {
        updatePrefSummary(findPreference(paramString));
    }

    private void updatePrefSummary(final Preference preference) {
        if (preference != null) {
            final String key = preference.getKey();
            if (preference instanceof ListPreference) {
                this.editor.putString(key, ((ListPreference)preference).getValue());
                this.editor.commit();
            }
            else if (preference instanceof EditTextPreference) {
                preference.setSummary(((EditTextPreference)preference).getText());
            }
            else if (preference instanceof TwoStatePreference) {
                this.editor.putBoolean(key, ((TwoStatePreference)preference).isChecked());
                this.editor.commit();
            }
        }
    }
}