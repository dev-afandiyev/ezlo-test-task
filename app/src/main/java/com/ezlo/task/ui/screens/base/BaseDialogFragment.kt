package com.ezlo.task.ui.screens.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.findNavController
import androidx.viewbinding.ViewBinding
import com.ezlo.task.R
import com.ezlo.task.navigation.Navigator
import javax.inject.Inject

abstract class BaseDialogFragment<VB : ViewBinding> : DialogFragment() {

    @Inject
    lateinit var navigator: Navigator

    private var _binding: VB? = null
    val binding get() = _binding!!

    override fun onStart() {
        super.onStart()
        navigator.setNavController(findNavController())
    }

    override fun getTheme(): Int = R.style.DialogFragmentTheme

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = getViewBinding()
        return binding.root
    }

    abstract fun getViewBinding(): VB

    open fun tryGoBack() {
        navigator.goBack()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}