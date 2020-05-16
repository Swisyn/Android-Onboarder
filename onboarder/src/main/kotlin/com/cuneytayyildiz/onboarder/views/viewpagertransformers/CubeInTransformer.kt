package com.cuneytayyildiz.onboarder.views.viewpagertransformers

import android.view.View
import com.cuneytayyildiz.onboarder.views.viewpagertransformers.base.BaseTransformer

class CubeInTransformer : BaseTransformer() {
    override fun onTransform(view: View, position: Float) {
        // Rotate the fragment on the left or right edge
        view.pivotX = if (position > 0) 0f else view.width.toFloat()
        view.pivotY = 0f
        view.rotationY = -90f * position
    }

    override val isPagingEnabled: Boolean
        get() = true
}