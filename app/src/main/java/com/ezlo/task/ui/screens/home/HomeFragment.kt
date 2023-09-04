package com.ezlo.task.ui.screens.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.ezlo.task.databinding.FragmentHomeBinding
import com.ezlo.task.ui.screens.base.BaseFragment
import com.ezlo.task.viewmodels.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    override fun getViewBinding(): FragmentHomeBinding =
        FragmentHomeBinding.inflate(layoutInflater)

    private val viewModel: HomeViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getItems()
    }

}