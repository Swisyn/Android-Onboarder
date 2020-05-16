package com.cuneytayyildiz.onboarder.views.viewpagertransformers

import android.graphics.Camera
import android.graphics.Matrix
import android.view.View
import com.cuneytayyildiz.onboarder.views.viewpagertransformers.base.BaseTransformer
import kotlin.math.abs

class TabletTransformer : BaseTransformer() {
    private val OFFSET_MATRIX = Matrix()
    private val OFFSET_CAMERA = Camera()
    private val OFFSET_TEMP_FLOAT = FloatArray(2)

    override fun onTransform(view: View, position: Float) {
        val rotation = (if (position < 0) 30f else -30f) * Math.abs(position)
        view.translationX = getOffsetXForRotation(rotation, view.width, view.height)
        view.pivotX = view.width * 0.5f
        view.pivotY = 0f
        view.rotationY = rotation
    }

    private fun getOffsetXForRotation(degrees: Float, width: Int, height: Int): Float {
        OFFSET_MATRIX.reset()
        OFFSET_CAMERA.save()
        OFFSET_CAMERA.rotateY(abs(degrees))
        OFFSET_CAMERA.getMatrix(OFFSET_MATRIX)
        OFFSET_CAMERA.restore()
        OFFSET_MATRIX.preTranslate(-width * 0.5f, -height * 0.5f)
        OFFSET_MATRIX.postTranslate(width * 0.5f, height * 0.5f)
        OFFSET_TEMP_FLOAT[0] = width.toFloat()
        OFFSET_TEMP_FLOAT[1] = height.toFloat()
        OFFSET_MATRIX.mapPoints(OFFSET_TEMP_FLOAT)
        return (width - OFFSET_TEMP_FLOAT[0]) * if (degrees > 0.0f) 1.0f else -1.0f
    }
}