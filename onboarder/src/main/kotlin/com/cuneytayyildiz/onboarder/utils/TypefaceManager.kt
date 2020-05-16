package com.cuneytayyildiz.onboarder.utils

import android.graphics.Typeface
import android.widget.TextView
import androidx.annotation.FontRes
import androidx.core.content.res.ResourcesCompat

/**
 * Class for containing the Typefaces that can be used with AppIntro.
 * Provide either a URL or a Resource. If you provide both, the URL will be ignored.
 *
 * @property path A [String] which is an URL of a font found at in the /assets folder
 * @property resource An [Int] which is a @FontRes
 */
internal data class TypefaceManager(
        var path: String? = null,
        @FontRes var resource: Int = 0
) {


    /**
     * Applies typeface to a given TextView object.
     * If there is no typeface (either URL or resource) set, this method is a no-op.
     *
     * @param textView The [TextView] where the Typeface will be applied
     */
    fun applyTo(textView: TextView?) {
        if (textView == null || textView.context == null) {
            return
        }
        if (path == null && resource == 0) {
            return
        }

        val callback = object : ResourcesCompat.FontCallback() {
            override fun onFontRetrievalFailed(reason: Int) {}
            override fun onFontRetrieved(typeface: Typeface) {
                textView.typeface = typeface
            }
        }

        if (resource != 0) {
            ResourcesCompat.getFont(textView.context, resource, callback, null)
        } else {
            TypefaceCacheManager.getFont(textView.context, path, callback)
        }
    }
}