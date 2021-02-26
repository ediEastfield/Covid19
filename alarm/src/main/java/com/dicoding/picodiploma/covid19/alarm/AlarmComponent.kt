package com.dicoding.picodiploma.covid19.alarm

import android.content.Context
import com.dicoding.picodiploma.covid19.di.AlarmModuleDependencies
import dagger.BindsInstance
import dagger.Component

@Component(dependencies = [AlarmModuleDependencies::class])
interface AlarmComponent {

    @Component.Builder
    interface Builder {
        fun context(@BindsInstance context: Context): Builder
        fun appDependencies(alarmModuleDependencies: AlarmModuleDependencies): Builder
        fun build(): AlarmComponent
    }
}