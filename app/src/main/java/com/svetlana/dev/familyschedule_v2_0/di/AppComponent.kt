package com.svetlana.dev.familyschedule_v2_0.di

import com.svetlana.dev.familyschedule_v2_0.di.module.NavigationModule
import com.svetlana.dev.familyschedule_v2_0.ui.login.LoginActivity
import com.svetlana.dev.familyschedule_v2_0.ui.main.MainActivity
import com.svetlana.dev.familyschedule_v2_0.ui.main.home.HomeFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NavigationModule::class])
interface AppComponent {

    fun inject(activity: LoginActivity)

    fun inject(activity: MainActivity)

    fun inject(fragment: HomeFragment)
}