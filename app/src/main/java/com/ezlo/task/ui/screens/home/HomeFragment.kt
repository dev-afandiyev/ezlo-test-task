package com.ezlo.task.ui.screens.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.coroutineScope
import androidx.lifecycle.flowWithLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.ezlo.task.databinding.FragmentHomeBinding
import com.ezlo.task.models.DeviceEntity
import com.ezlo.task.ui.screens.base.BaseFragment
import com.ezlo.task.ui.screens.home.adapter.DevicesPagingAdapter
import com.ezlo.task.ui.screens.home.dialog.CustomAlertDialog
import com.ezlo.task.viewmodels.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    override fun getViewBinding(): FragmentHomeBinding =
        FragmentHomeBinding.inflate(layoutInflater)

    private val viewModel: HomeViewModel by viewModels()
    private var adapter: DevicesPagingAdapter? = null
    private var customAlertDialog: CustomAlertDialog? = null

    private var stopEvent = true

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getDevices()

        initAdapter()
        observeViewModel()

        initListeners()
        initAlertDialog()
    }

    private fun initListeners() {
        adapter?.setOnClickListener {
            navigator.open(
                HomeFragmentDirections.actionToDeviceFragment(
                    DeviceEntity(it.pkDevice, it.macAddress, it.firmware, it.platform)
                )
            )
        }

        adapter?.setOnLongClickListener { item ->
            customAlertDialog?.showAlertDialog {
                item.pkDevice?.toLong()?.let { viewModel.deleteItem(it) }
            }
        }

        binding.tvResetData.setOnClickListener {
            viewModel.resetData()
            viewModel.getDevices()
        }
    }

    private fun observeViewModel() {
        viewLifecycleOwner.lifecycle.coroutineScope.launch  {
            viewModel.devicesFlow.flowWithLifecycle(viewLifecycleOwner.lifecycle, Lifecycle.State.STARTED)
                .collect { adapter?.submitData(it) }
        }
    }

    private fun initAdapter() {
        adapter = DevicesPagingAdapter()

        binding.listDevices.layoutManager = LinearLayoutManager(requireContext())
        binding.listDevices.adapter = adapter
    }

    private fun initAlertDialog() {
        customAlertDialog = CustomAlertDialog(requireContext())
    }

}