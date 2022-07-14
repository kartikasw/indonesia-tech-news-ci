package com.example.indonesianews.settings

import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import androidx.preference.ListPreference
import androidx.preference.PreferenceFragmentCompat
import com.example.indonesianews.R

class SettingsFragment : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey)

        val listPreference = findPreference<ListPreference>(getString(R.string.pref_key_dark))
        listPreference?.setOnPreferenceChangeListener { _, newValue ->
            updateTheme(listPreference.findIndexOfValue(newValue.toString()))
        }
    }

    private fun updateTheme(nightMode: Int): Boolean {
        when(nightMode){
            0 ->  AppCompatDelegate.setDefaultNightMode(DarkMode.AUTO.value)
            1 ->  AppCompatDelegate.setDefaultNightMode(DarkMode.ON.value)
            2 ->  AppCompatDelegate.setDefaultNightMode(DarkMode.OFF.value)
        }
        requireActivity().recreate()
        return true
    }
}