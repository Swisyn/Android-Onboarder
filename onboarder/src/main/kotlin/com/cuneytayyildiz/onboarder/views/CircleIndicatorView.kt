package com.cuneytayyildiz.onboarder.views

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import com.cuneytayyildiz.onboarder.R
import kotlin.math.min

class CircleIndicatorView : View {
    private var activeIndicatorPaint: Paint? = null
    private var inactiveIndicatorPaint: Paint? = null
    private var radius = 0
    private var size = 0
    private var position = 0
    private var indicatorsCount = 0

    constructor(context: Context) : super(context) {
        init(context)
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        init(context)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyle: Int) : super(context, attrs, defStyle) {
        init(context)
    }

    private fun init(context: Context) {
        this.activeIndicatorPaint = Paint().apply {
            color = ContextCompat.getColor(context, R.color.active_indicator)
            isAntiAlias = true
        }

        this.inactiveIndicatorPaint = Paint().apply {
            color = ContextCompat.getColor(context, R.color.inactive_indicator)
            isAntiAlias = true
        }

        this.radius = this.resources.getDimensionPixelSize(R.dimen.indicator_size)
        this.size = radius * 2
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        inactiveIndicatorPaint?.let {
            for (i in 0 until indicatorsCount) {
                canvas.drawCircle(radius + (size * i).toFloat(), radius.toFloat(), radius / 2.toFloat(), it)
            }
        }

        activeIndicatorPaint?.let {
            canvas.drawCircle(radius + (size * position).toFloat(), radius.toFloat(), radius / 2.toFloat(), it)
        }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        setMeasuredDimension(measureWidth(widthMeasureSpec), measureHeight(heightMeasureSpec))
    }

    private fun measureWidth(measureSpec: Int): Int {
        var result: Int
        val specMode = MeasureSpec.getMode(measureSpec)
        val specSize = MeasureSpec.getSize(measureSpec)
        if (specMode == MeasureSpec.EXACTLY) {
            result = specSize
        } else {
            result = size * indicatorsCount
            if (specMode == MeasureSpec.AT_MOST) {
                result = min(result, specSize)
            }
        }
        return result
    }

    private fun measureHeight(measureSpec: Int): Int {
        var result: Int
        val specMode = MeasureSpec.getMode(measureSpec)
        val specSize = MeasureSpec.getSize(measureSpec)
        if (specMode == MeasureSpec.EXACTLY) {
            result = specSize
        } else {
            result = 2 * radius + paddingTop + paddingBottom
            if (specMode == MeasureSpec.AT_MOST) {
                result = min(result, specSize)
            }
        }
        return result
    }


    fun setCurrentPage(position: Int) {
        this.position = position
        invalidate()
    }

    fun setPageIndicatorCount(size: Int) {
        this.indicatorsCount = size
        invalidate()
    }

    fun setInactiveIndicatorColor(@ColorRes color: Int) {
        this.inactiveIndicatorPaint?.color = ContextCompat.getColor(context, color)
        invalidate()
    }

    fun setActiveIndicatorColor(@ColorRes color: Int) {
        this.activeIndicatorPaint?.color = ContextCompat.getColor(context, color)
        invalidate()
    }
}