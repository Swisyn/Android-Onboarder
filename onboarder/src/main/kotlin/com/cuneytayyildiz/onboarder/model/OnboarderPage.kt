package com.cuneytayyildiz.onboarder.model

import android.graphics.drawable.Drawable
import android.view.View
import android.view.ViewGroup
import androidx.annotation.*
import com.cuneytayyildiz.onboarder.utils.dp

fun onboarderPage(block: OnboarderPage.() -> Unit): OnboarderPage = OnboarderPage().apply(block)

fun OnboarderPage.image(block: OnboarderImage.() -> Unit) {
    image = OnboarderImage().apply(block)
}

fun OnboarderPage.title(block: OnboarderText.() -> Unit) {
    title = OnboarderText().apply(block)
}

fun OnboarderPage.description(block: OnboarderText.() -> Unit) {
    description = OnboarderText().apply(block)
}

fun OnboarderPage.miscellaneousButton(block: OnboarderMiscellaneousButton.() -> Unit) {
    miscellaneousButton = OnboarderMiscellaneousButton().apply(block)
}

data class OnboarderPage(
        @ColorInt var backgroundColor: Int = 0,
        var image: OnboarderImage? = null,
        var title: OnboarderText? = null,
        var description: OnboarderText? = null,
        var miscellaneousButton: OnboarderMiscellaneousButton? = null
)

data class OnboarderImage(
        @DrawableRes
        var imageResId: Int = 0,
        var drawable: Drawable? = null,
        var imageWidthPx: Int = ViewGroup.LayoutParams.WRAP_CONTENT,
        var imageHeightPx: Int = ViewGroup.LayoutParams.WRAP_CONTENT,
        var imageBias: Float = .5f)

data class OnboarderText(
        var text: String? = null,
        @StringRes var textResId: Int = 0,

        @ColorInt
        var textColor: Int = 0,
        var typefacePath: String? = null,
        @ColorInt var backgroundColor: Int = 0,
        var widthPx: Int = ViewGroup.LayoutParams.WRAP_CONTENT,
        var heightPx: Int = ViewGroup.LayoutParams.WRAP_CONTENT,
        @FontRes
        var typefaceFontResId: Int = 0,
        var textSize: Float = 0f,
        var textPaddingBottomPx: Int = 0,
        var multilineCentered: Boolean = false,
        var clickListener: View.OnClickListener? = null
)


data class OnboarderMiscellaneousButton(var visibility: Int = View.GONE,
                                        var text: String? = null,
                                        @StringRes var textResId: Int = 0,
                                        @ColorInt var textColor: Int = 0,
                                        @ColorInt var backgroundColor: Int = 0,
                                        var widthPx: Int = ViewGroup.LayoutParams.WRAP_CONTENT,
                                        var heightPx: Int = ViewGroup.LayoutParams.WRAP_CONTENT,
                                        var textSize: Float = 0f,
                                        var typefacePath: String? = null,
                                        @FontRes
                                        var typefaceFontResId: Int = 0,
                                        var leftPadding: Int = 16,
                                        var rightPadding: Int = 16,
                                        var topPadding: Int = 8,
                                        var bottomPadding: Int = 8,
                                        var clickListener: View.OnClickListener? = null
)