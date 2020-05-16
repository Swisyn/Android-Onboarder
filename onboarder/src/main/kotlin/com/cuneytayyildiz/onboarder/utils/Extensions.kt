package com.cuneytayyildiz.onboarder.utils

import android.app.Activity
import android.content.res.Resources
import android.view.View
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import androidx.viewpager.widget.PagerAdapter


fun Activity.color(@ColorRes colorResId: Int): Int = ContextCompat.getColor(this, colorResId)

inline val PagerAdapter?.lastPosition: Int
    get() {
        return if (this != null) {
            if (count >= 1) count - 1 else count
        } else 0
    }

fun View.gone() {
    if (visibility != View.GONE) visibility = View.GONE
}

fun View.visible() {
    if (visibility != View.VISIBLE) visibility = View.VISIBLE
}

fun View.visibleIf(condition: Boolean) {
    visibility = if (condition) View.GONE else View.VISIBLE
}

val Int.dp: Int
    get() = (this / Resources.getSystem().displayMetrics.density).toInt()

val Int.px: Int
    get() = (this * Resources.getSystem().displayMetrics.density).toInt()