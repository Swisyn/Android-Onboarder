package com.cuneytayyildiz.onboarder.views.viewpagertransformers

import android.view.View
import com.cuneytayyildiz.onboarder.views.viewpagertransformers.base.BaseTransformer

class FlipVerticalTransformer : BaseTransformer() {
    override fun onTransform(view: View, position: Float) {
        val rotation = -180f * position
        view.visibility = if (rotation > 90f || rotation < -90f) View.INVISIBLE else View.VISIBLE
        view.pivotX = view.width * 0.5f
        view.pivotY = view.height * 0.5f
        view.rotationX = rotation
    }
}