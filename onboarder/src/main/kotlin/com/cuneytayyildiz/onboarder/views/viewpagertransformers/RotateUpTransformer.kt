package com.cuneytayyildiz.onboarder.views.viewpagertransformers

import android.view.View
import com.cuneytayyildiz.onboarder.views.viewpagertransformers.base.BaseTransformer

class RotateUpTransformer : BaseTransformer() {
    private val ROT_MOD = -15f

    override fun onTransform(view: View, position: Float) {
        val width = view.width.toFloat()
        val rotation = ROT_MOD * position
        view.pivotX = width * 0.5f
        view.pivotY = 0f
        view.translationX = 0f
        view.rotation = rotation
    }

    override val isPagingEnabled: Boolean
        get() = true
}