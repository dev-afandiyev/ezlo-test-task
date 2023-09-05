package com.ezlo.task.ui.screens.home.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.ezlo.task.databinding.ItemLayoutDevicesBinding
import com.ezlo.task.db.models.devices.DevicesModel
import com.ezlo.task.utils.setPlatformImage

class DevicesPagingAdapter(
    private var onClickListener: (DevicesModel) -> Unit = {},
    private var onLongClickListener: (DevicesModel) -> Unit = {}
) : PagingDataAdapter<DevicesModel, DevicesPagingAdapter.ViewHolder>(ItemCallback) {

    fun setOnClickListener(item: (DevicesModel) -> Unit) {
        onClickListener = item
    }

    fun setOnLongClickListener(item: (DevicesModel) -> Unit) {
        onLongClickListener = item
    }

    override fun getItemViewType(position: Int): Int = position

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        with(holder.binding) {
            root.tag = item

            tvPlatform.text = item?.platform
            tvPkDevice.text = item?.pkDevice.toString()

            setPlatformImage(ivPlatform, tvPlatform.text.toString())
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemLayoutDevicesBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        binding.root.setOnClickListener {
            onClickListener(it.tag as DevicesModel)
        }

        binding.root.setOnLongClickListener {
            onLongClickListener(it.tag as DevicesModel)
            true
        }

        return ViewHolder(binding)
    }

    inner class ViewHolder(val binding: ItemLayoutDevicesBinding) : RecyclerView.ViewHolder(binding.root)

    object ItemCallback : DiffUtil.ItemCallback<DevicesModel>() {
        override fun areItemsTheSame(
            oldItem: DevicesModel,
            newItem: DevicesModel
        ): Boolean = oldItem.pkDevice == newItem.pkDevice

        override fun areContentsTheSame(
            oldItem: DevicesModel,
            newItem: DevicesModel
        ): Boolean = oldItem == newItem
    }

}