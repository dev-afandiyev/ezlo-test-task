package com.ezlo.task.navigation

import androidx.navigation.NavController
import androidx.navigation.NavDirections

interface INavigator {

    /**
     * Set navigation controller
     */
    fun setNavController(navController: NavController)

    /**
     * Get navigation controller
     */
    fun getNavController(): NavController?

    /**
     * Navigate using destination id
     */
    fun open(screen: Int)

    /**
     * Open destination using navigation action
     */
    fun open(screen: NavDirections)

    /**
     * Navigating the back stack
     */
    fun popBackStack(screen: Int, inclusive: Boolean, saveState: Boolean)

    /**
     * Navigating the back stack
     */
    fun popBackStack(screen: Int, inclusive: Boolean)

    /**
     * Back navigation
     */
    fun goBack()

    /**
     * Clear the navigation graph and Navigator arguments
     */
    fun clear()

}