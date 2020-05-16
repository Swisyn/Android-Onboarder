package com.cuneytayyildiz.onboarder.utils

import android.content.Context
import android.graphics.Typeface
import androidx.core.content.res.ResourcesCompat


/**
 * Custom Font Cache Implementation.
 * Prevent(s) memory leaks due to Typeface objects
 */
internal object TypefaceCacheManager {

    private val cache = hashMapOf<String, Typeface>()

    fun getFont(ctx: Context, path: String?, fontCallback: ResourcesCompat.FontCallback) {
        if (!path.isNullOrEmpty()) {
            cache[path]?.let {
                fontCallback.onFontRetrieved(it)
            } ?: run {
                val newTypeface = Typeface.createFromAsset(ctx.assets, path)
                cache[path] = newTypeface
                fontCallback.onFontRetrieved(newTypeface)
            }
        }
    }
}

