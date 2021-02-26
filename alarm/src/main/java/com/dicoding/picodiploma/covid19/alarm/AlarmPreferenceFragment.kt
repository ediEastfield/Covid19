package com.dicoding.picodiploma.covid19.alarm

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import androidx.preference.SwitchPreference

class AlarmPreferenceFragment : PreferenceFragmentCompat() {

    private lateinit var TIME: String

    private lateinit var timeSetting: SwitchPreference
    private lateinit var alarmReceiver: AlarmReceiver

    override fun onCreatePreferences(savedInstanceState: Bundle?, s: String?) {

        addPreferencesFromResource(R.xml.preference)

        alarmReceiver = AlarmReceiver()

        TIME = resources.getString(R.string.time_setting)

        timeSetting = findPreference<SwitchPreference>(TIME) as SwitchPreference
        timeSetting.setOnPreferenceChangeListener { preference, newValue ->
            if (newValue == true) {
                val repeatMessage = "Tetap Patuhi Protokol Kesehatan"
                alarmReceiver.setRepeatingAlarm(
                        requireContext(),
                        AlarmReceiver.TYPE_REPEATING,
                        repeatMessage
                )
            } else {
                alarmReceiver.cancelAlarm(requireContext())
            }
            true
        }
    }
}