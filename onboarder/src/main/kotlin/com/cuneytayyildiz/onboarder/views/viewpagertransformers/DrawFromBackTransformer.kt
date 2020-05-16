package com.cuneytayyildiz.onboarder.views.viewpagertransformers

import android.view.View
import androidx.viewpager.widget.ViewPager
import kotlin.math.abs

class DrawFromBackTransformer : ViewPager.PageTransformer {
    private val MIN_SCALE = 0.75f
    override fun transformPage(view: View, position: Float) {
        val pageWidth = view.width
        if (position < -1 || position > 1) { // [-Infinity,-1)
            // This page is way off-screen to the left.
            view.alpha = 0f
            return
        }
        if (position <= 0) { // [-1,0]
            // Use the default slide transition when moving to the left page
            // Fade the page out.
            view.alpha = 1 + position
            // Counteract the default slide transition
            view.translationX = pageWidth * -position

            // Scale the page down (between MIN_SCALE and 1)
            val scaleFactor = (MIN_SCALE
                    + (1 - MIN_SCALE) * (1 - abs(position)))
            view.scaleX = scaleFactor
            view.scaleY = scaleFactor
            return
        }
        if (position > 0.5 && position <= 1) { // (0,1]
            // Fade the page out.
            view.alpha = 0f

            // Counteract the default slide transition
            view.translationX = pageWidth * -position
            return
        }
        if (position > 0.3 && position <= 0.5) { // (0,1]
            // Fade the page out.
            view.alpha = 1f

            // Counteract the default slide transition
            view.translationX = pageWidth * position
            val scaleFactor = MIN_SCALE
            view.scaleX = scaleFactor
            view.scaleY = scaleFactor
            return
        }
        if (position <= 0.3) { // (0,1]
            // Fade the page out.
            view.alpha = 1f
            // Counteract the default slide transition
            view.translationX = pageWidth * position

            // Scale the page down (between MIN_SCALE and 1)
            var v = (0.3 - position).toFloat()
            v = if (v >= 0.25f) 0.25f else v
            val scaleFactor = MIN_SCALE + v
            view.scaleX = scaleFactor
            view.scaleY = scaleFactor
        }
    }

}