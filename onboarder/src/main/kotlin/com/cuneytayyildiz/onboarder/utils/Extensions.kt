package com.cuneytayyildiz.onboarder.utils

import android.app.Activity
import android.content.res.Resources
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat


fun Activity.color(@ColorRes colorResId: Int): Int = ContextCompat.getColor(this, colorResId)

val Int.dp: Int
    get() = (this / Resources.getSystem().displayMetrics.density).toInt()

val Int.px: Int
    get() = (this * Resources.getSystem().displayMetrics.density).toInt()