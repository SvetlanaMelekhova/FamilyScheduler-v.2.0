package com.svetlana.dev.familyschedule_v2_0.ui.main.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.github.terrakok.cicerone.Router
import com.svetlana.dev.familyschedule_v2_0.App
import com.svetlana.dev.familyschedule_v2_0.R
import com.svetlana.dev.familyschedule_v2_0.Screens.Notifications
import com.svetlana.dev.familyschedule_v2_0.databinding.FragmentHomeBinding
import javax.inject.Inject

class HomeFragment : Fragment(R.layout.fragment_home) {

    @Inject
    lateinit var router: Router

    private val viewModel: HomeViewModel by viewModels()
    private val binding by viewBinding(FragmentHomeBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        App.INSTANCE.appComponent.inject(this)
        super.onViewCreated(view, savedInstanceState)
        binding.button.setOnClickListener {
            router.navigateTo(Notifications())
        }
    }
}