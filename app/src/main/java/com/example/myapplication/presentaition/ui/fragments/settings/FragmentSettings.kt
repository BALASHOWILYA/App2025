package com.example.myapplication.presentaition.ui.fragments.settings

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import com.example.myapplication.R


class FragmentSettings: PreferenceFragmentCompat() {



    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
       addPreferencesFromResource(com.example.myapplication.R.xml.settings_preferences)
    }



    companion object {
        @JvmStatic
        fun newInstance() = FragmentSettings()
    }


}