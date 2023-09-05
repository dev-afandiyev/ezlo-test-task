package com.ezlo.task.ui.screens.device

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.ezlo.task.databinding.FragmentDeviceBinding
import com.ezlo.task.db.models.devices.DevicesModel
import com.ezlo.task.ui.screens.base.BaseDialogFragment
import com.ezlo.task.utils.setPlatformImage
import com.ezlo.task.utils.splitOnSpace
import com.ezlo.task.viewmodels.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DeviceFragment : BaseDialogFragment<FragmentDeviceBinding>() {

    override fun getViewBinding(): FragmentDeviceBinding =
        FragmentDeviceBinding.inflate(layoutInflater)

    private val args: DeviceFragmentArgs by navArgs()
    private val viewModel: HomeViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListener()
        initDeviceInfo()
    }

    private fun initListener() {
        binding.ivEdit.setOnClickListener {
            binding.etPlatform.visibility = View.VISIBLE
            binding.ivEdit.visibility = View.GONE
            binding.tvPlatform.visibility =  View.GONE
            binding.btEdit.visibility = View.VISIBLE
        }

        binding.btEdit.setOnClickListener {
            viewModel.edit(DevicesModel(
                pkDevice = args.entity?.pkDevice,
                platform = binding.etPlatform.text.toString()
            ))

            tryGoBack()
        }
    }

    @SuppressLint("SetTextI18n")
    private fun initDeviceInfo() {
        args.entity.let {
            setPlatformImage(binding.ivPlatform, it?.platform)
            binding.tvPlatform.text = it?.platform?.splitOnSpace()?.first

            binding.tvPkDevice.text = "PK: " + it?.pkDevice.toString()
            binding.tvMacAddress.text = "MAC Address: " + it?.macAddress

            binding.tvFirmware.text = "Firmware: " + it?.firmware
            binding.tvModel.text = "Model: " + it?.platform?.splitOnSpace()?.second
        }
    }

}