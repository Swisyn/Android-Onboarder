package com.cuneytayyildiz.onboarder.views.viewpagertransformers

import android.view.View
import com.cuneytayyildiz.onboarder.views.viewpagertransformers.base.BaseTransformer

class DefaultTransformer : BaseTransformer() {
    override fun onTransform(view: View, position: Float) {}
    override val isPagingEnabled: Boolean
        get() = true
}