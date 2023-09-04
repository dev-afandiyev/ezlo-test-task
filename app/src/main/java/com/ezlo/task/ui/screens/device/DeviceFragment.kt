package com.ezlo.task.ui.screens.device

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.navArgs
import com.ezlo.task.databinding.FragmentDeviceBinding
import com.ezlo.task.ui.screens.base.BaseFragment
import com.ezlo.task.utils.setPlatformImage
import com.ezlo.task.utils.splitOnSpace
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DeviceFragment : BaseFragment<FragmentDeviceBinding>() {

    override fun getViewBinding(): FragmentDeviceBinding =
        FragmentDeviceBinding.inflate(layoutInflater)

    private val args: DeviceFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initDeviceInfo()
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