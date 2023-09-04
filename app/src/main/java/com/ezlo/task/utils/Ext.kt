package com.ezlo.task.utils

import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import com.ezlo.task.R
import com.ezlo.task.constants.Constants.MICASAVERDE_VERALITE
import com.ezlo.task.constants.Constants.SERCOMM_G450
import com.ezlo.task.constants.Constants.SERCOMM_G550
import com.ezlo.task.constants.Constants.SERCOMM_NA301
import com.ezlo.task.constants.Constants.SERCOMM_NA900
import com.ezlo.task.constants.Constants.SERCOMM_NA930

/**
 * Extension method to set Drawable
 */
fun ImageView.setDrawable(@DrawableRes resId: Int) {
    val drawable = ContextCompat.getDrawable(context, resId)
    setImageDrawable(drawable)
}

fun setPlatformImage(img: ImageView, platform: String?) {
    when (platform) {
        SERCOMM_G450 -> img.setDrawable(R.drawable.vera_plus_big)
        SERCOMM_G550 -> img.setDrawable(R.drawable.vera_secure_big)
        MICASAVERDE_VERALITE -> img.setDrawable(R.drawable.vera_edge_big)
        SERCOMM_NA900, SERCOMM_NA301, SERCOMM_NA930 -> img.setDrawable(R.drawable.vera_edge_big)
        else -> img.setDrawable(R.drawable.vera_edge_big)
    }
}

fun String.splitOnSpace(): Pair<String, String>? {
    val parts = this.split(" ")
    if (parts.size >= 2) {
        val firstPart = parts[0]
        val secondPart = parts[1]
        return Pair(firstPart, secondPart)
    }
    return null
}