package com.cuneytayyildiz.onboarder.views.viewpagertransformers

import android.view.View
import com.cuneytayyildiz.onboarder.views.viewpagertransformers.base.BaseTransformer

class RotateDownTransformer : BaseTransformer() {
    private val ROT_MOD = -15f

    override fun onTransform(view: View, position: Float) {
        val width = view.width.toFloat()
        val height = view.height.toFloat()
        val rotation = ROT_MOD * position * -1.25f
        view.pivotX = width * 0.5f
        view.pivotY = height
        view.rotation = rotation
    }

    override val isPagingEnabled: Boolean
        get() = true
}