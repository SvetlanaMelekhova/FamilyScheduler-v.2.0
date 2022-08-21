package com.svetlana.dev.familyschedule_v2_0

import android.content.Intent
import com.github.terrakok.cicerone.androidx.ActivityScreen
import com.svetlana.dev.familyschedule_v2_0.ui.main.MainActivity

object Screens {

    fun Main() = ActivityScreen {
        Intent(it, MainActivity::class.java)
    }
}