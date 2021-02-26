package com.dicoding.picodiploma.covid19.alarm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dicoding.picodiploma.covid19.alarm.databinding.ActivityAlarmBinding
import com.dicoding.picodiploma.covid19.di.AlarmModuleDependencies
import dagger.hilt.android.EntryPointAccessors

class AlarmActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAlarmBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        DaggerAlarmComponent.builder()
            .context(this)
            .appDependencies(
                EntryPointAccessors.fromApplication(
                    applicationContext,
                    AlarmModuleDependencies::class.java
                )
            )
            .build()

        super.onCreate(savedInstanceState)
        binding = ActivityAlarmBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = "Covid19 Alarm"

        supportFragmentManager.beginTransaction()
                .add(R.id.setting_holder, AlarmPreferenceFragment())
                .commit()
    }
}