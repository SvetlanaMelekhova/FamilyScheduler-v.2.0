package com.svetlana.dev.familyschedule_v2_0

import android.content.Intent
import com.github.terrakok.cicerone.androidx.ActivityScreen
import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.svetlana.dev.familyschedule_v2_0.ui.main.MainActivity
import com.svetlana.dev.familyschedule_v2_0.ui.main.dashboard.DashboardFragment
import com.svetlana.dev.familyschedule_v2_0.ui.main.home.HomeFragment
import com.svetlana.dev.familyschedule_v2_0.ui.main.notifications.NotificationsFragment

object Screens {

    fun Main() = ActivityScreen {
        Intent(it, MainActivity::class.java)
    }

    fun Home() = FragmentScreen {
        HomeFragment()
    }

    fun Dashboard() = FragmentScreen {
        DashboardFragment()
    }

    fun Notifications() = FragmentScreen {
        NotificationsFragment()
    }
}