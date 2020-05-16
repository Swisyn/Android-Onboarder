package com.cuneytayyildiz.onboarder.views.viewpagertransformers

import android.view.View
import com.cuneytayyildiz.onboarder.views.viewpagertransformers.base.BaseTransformer

class StackTransformer : BaseTransformer() {
    override fun onTransform(view: View, position: Float) {
        view.translationX = if (position < 0) 0f else -view.width * position
    }
}