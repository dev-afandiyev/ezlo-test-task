package com.ezlo.task.ui.activity

import android.os.Bundle
import com.ezlo.task.databinding.ActivityMainBinding
import com.ezlo.task.ui.activity.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {

    override fun getViewBinding(): ActivityMainBinding =
        ActivityMainBinding.inflate(layoutInflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding?.root)
        supportActionBar?.hide()
    }

}