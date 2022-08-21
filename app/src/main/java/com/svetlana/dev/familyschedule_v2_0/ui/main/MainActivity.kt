package com.svetlana.dev.familyschedule_v2_0.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.ashokvarma.bottomnavigation.BottomNavigationBar
import com.ashokvarma.bottomnavigation.BottomNavigationItem
import com.github.terrakok.cicerone.Navigator
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.AppNavigator
import com.github.terrakok.cicerone.sample.ui.common.BackButtonListener
import com.svetlana.dev.familyschedule_v2_0.App
import com.svetlana.dev.familyschedule_v2_0.R
import com.svetlana.dev.familyschedule_v2_0.common.RouterProvider
import com.svetlana.dev.familyschedule_v2_0.databinding.ActivityMainBinding
import com.svetlana.dev.familyschedule_v2_0.ui.main.dashboard.DashboardFragment
import com.svetlana.dev.familyschedule_v2_0.ui.main.home.HomeFragment
import com.svetlana.dev.familyschedule_v2_0.ui.main.notifications.NotificationsFragment
import javax.inject.Inject

class MainActivity : AppCompatActivity(R.layout.activity_main), RouterProvider {

    @Inject
    override lateinit var router: Router

    @Inject
    lateinit var navigatorHolder: NavigatorHolder

    private val navigator: Navigator = AppNavigator(this, R.id.container)
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
            .addItem(
                BottomNavigationItem(
                    R.drawable.ic_dashboard_black_24dp,
                    R.string.title_dashboard
                )
            )
            .addItem(
                BottomNavigationItem(
                    R.drawable.ic_notifications_black_24dp,
                    R.string.title_notifications
                )
            )
            .initialise()
        binding.bottomNavigation.setTabSelectedListener(object :
            BottomNavigationBar.OnTabSelectedListener {
            override fun onTabSelected(position: Int) {
                when (position) {
                    0 -> selectTab(1, "home")
                    1 -> selectTab(2, "dashboard")
                    2 -> selectTab(3, "notifications")
                }
                binding.bottomNavigation.selectTab(position, false)
            }

            override fun onTabUnselected(position: Int) {}

            override fun onTabReselected(position: Int) {
                onTabSelected(position)
            }
        })
    }

    private fun selectTab(number: Int, tab: String) {

        val frag = when (number) {
            1 -> HomeFragment()
            2 -> DashboardFragment()
            3 -> NotificationsFragment()
            else -> HomeFragment()
        }

        supportFragmentManager.beginTransaction()
            .replace(R.id.container, frag)
            .commit()
    }

    override fun onBackPressed() {
        val fm = supportFragmentManager
        var fragment: Fragment? = null
        val fragments = fm.fragments
        for (f in fragments) {
            if (f.isVisible) {
                fragment = f
                break
            }
        }
        if (fragment != null && fragment is BackButtonListener
            && (fragment as BackButtonListener).onBackPressed()
        ) {
            return
        } else {
            router.exit()
        }
    }

    override fun onResume() {
        super.onResume()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }
}