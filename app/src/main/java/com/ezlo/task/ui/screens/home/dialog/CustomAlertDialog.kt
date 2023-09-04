package com.ezlo.task.ui.screens.home.dialog

import android.content.Context
import androidx.appcompat.app.AlertDialog

class CustomAlertDialog(private val context: Context) {

    fun showAlertDialog(
        positiveClickListener: () -> Unit,
    ) {
        val alertDialog = AlertDialog.Builder(context)
            .setTitle("Delete Window")
            .setMessage("Are you sure you want to delete this item?")
            .setPositiveButton("OK") { _, _ ->
                positiveClickListener.invoke()
            }
            .setNegativeButton("Cancel") { _, _ -> }
            .setCancelable(false)
            .create()

        alertDialog.show()
    }
}