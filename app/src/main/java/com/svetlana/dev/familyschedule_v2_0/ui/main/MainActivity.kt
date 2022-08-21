package com.svetlana.dev.familyschedule_v2_0.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import by.kirich1409.viewbindingdelegate.viewBinding
import com.ashokvarma.bottomnavigation.BottomNavigationItem
import com.github.terrakok.cicerone.Navigator
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.AppNavigator
import com.svetlana.dev.familyschedule_v2_0.App
import com.svetlana.dev.familyschedule_v2_0.R
import com.svetlana.dev.familyschedule_v2_0.common.RouterProvider
import com.svetlana.dev.familyschedule_v2_0.databinding.ActivityMainBinding
import javax.inject.Inject

class MainActivity : AppCompatActivity(R.layout.activity_main), RouterProvider {

    @Inject
    override lateinit var router: Router

    @Inject
    lateinit var navigatorHolder: NavigatorHolder

    private val navigator: Navigator = AppNavigator(this, -1)
    private val binding by viewBinding(ActivityMainBinding::bind)

    override fun onCreate(savedInstanceState: Bundle?) {
        App.INSTANCE.appComponent.inject(this)
        super.onCreate(savedInstanceState)

        initViews()
        if (savedInstanceState == null) {
            binding.bottomNavigation.selectTab(0, true)
        }
    }

    private fun initViews() {
        binding.bottomNavigation
            .addItem(BottomNavigationItem(R.drawable.ic_home_black_24dp, R.string.title_home))
            .addItem(BottomNavigationItem(R.drawable.ic_dashboard_black_24dp, R.string.title_dashboard))
            .addItem(BottomNavigationItem(R.drawable.ic_notifications_black_24dp, R.string.title_notifications))
            .initialise()
    }

    override fun onResume() {
        super.onResume()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }

    override fun onBackPressed() {
        router.exit()
    }
}