package com.svetlana.dev.familyschedule_v2_0.ui.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.svetlana.dev.familyschedule_v2_0.R
import com.svetlana.dev.familyschedule_v2_0.databinding.FragmentHomeBinding

class HomeFragment : Fragment(R.layout.fragment_home) {

    private val viewModel: HomeViewModel by viewModels()
    private val binding by viewBinding(FragmentHomeBinding::bind)

}