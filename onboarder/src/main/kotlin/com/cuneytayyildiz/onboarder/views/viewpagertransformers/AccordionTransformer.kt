package com.cuneytayyildiz.onboarder.views.viewpagertransformers

import android.view.View
import com.cuneytayyildiz.onboarder.views.viewpagertransformers.base.BaseTransformer

class AccordionTransformer : BaseTransformer() {
    override fun onTransform(view: View, position: Float) {
        view.pivotX = if (position < 0) 0f else view.width.toFloat()
        view.scaleX = if (position < 0) 1f + position else 1f - position
    }
}