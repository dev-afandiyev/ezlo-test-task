package com.ezlo.task.navigation

import androidx.navigation.NavController
import androidx.navigation.NavDirections
import androidx.navigation.NavOptions
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Navigator @Inject constructor() : INavigator {

    private var navController: NavController? = null
    private var navOptions: NavOptions? = null

    override fun setNavController(navController: NavController) {
        this.navController = navController
    }

    override fun getNavController(): NavController? = navController

    override fun open(screen: Int) {
        try {
            navController?.navigate(screen, null, navOptions)
        } catch (ex: IllegalArgumentException) {
            ex.printStackTrace()
        }
    }

    override fun open(screen: NavDirections) {
        try {
            navController?.navigate(screen)
        } catch (ex: IllegalArgumentException) {
            ex.printStackTrace()
        }
    }

    override fun popBackStack(screen: Int, inclusive: Boolean, saveState: Boolean) {
        try {
            navController?.popBackStack(screen, inclusive, saveState)
        } catch (ex: IllegalArgumentException) {
            ex.printStackTrace()
        }
    }

    override fun popBackStack(screen: Int, inclusive: Boolean) {
        try {
            navController?.let {
                if (!it.popBackStack(screen, inclusive)) it.navigate(screen)
            }
        } catch (ex: IllegalArgumentException) {
            ex.printStackTrace()
        }
    }

    override fun goBack() {
        if (navController?.previousBackStackEntry?.destination != null) {
            navController?.popBackStack()
        }
    }

    override fun clear() {
        navController?.graph?.clear()
        navController = null
        navOptions = null
    }

}