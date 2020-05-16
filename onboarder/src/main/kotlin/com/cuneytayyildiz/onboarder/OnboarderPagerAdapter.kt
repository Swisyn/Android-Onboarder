package com.cuneytayyildiz.onboarder

import android.content.Context
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.viewpager.widget.PagerAdapter
import com.cuneytayyildiz.onboarder.model.OnboarderImage
import com.cuneytayyildiz.onboarder.model.OnboarderMiscellaneousButton
import com.cuneytayyildiz.onboarder.model.OnboarderPage
import com.cuneytayyildiz.onboarder.model.OnboarderText
import com.cuneytayyildiz.onboarder.utils.TypefaceManager
import com.cuneytayyildiz.onboarder.utils.px

class OnboarderPagerAdapter(private val context: Context, private val onboarderPages: MutableList<OnboarderPage>) : PagerAdapter() {

    override fun getCount(): Int = onboarderPages.size

    override fun isViewFromObject(view: View, obj: Any): Boolean = view == obj

    fun getItem(position: Int) = onboarderPages[position]

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val itemView = LayoutInflater.from(context).inflate(R.layout.item_onboarder, container, false)

        val onboarderImageView = itemView.findViewById<ImageView>(R.id.image_top)
        val onboarderTitleTextView = itemView.findViewById<TextView>(R.id.textview_title)
        val onboarderDescriptionTextView = itemView.findViewById<TextView>(R.id.textview_description)
        val onboarderMiscellaneousButton = itemView.findViewById<Button>(R.id.button_miscellaneous)

        val page = getItem(position)

        page.image?.let { onboarderImage ->
            setImageViewProperties(onboarderImageView, onboarderImage)
        }

        page.title?.let { onboarderTitle ->
            setTextViewProperties(view = onboarderTitleTextView, attributes = onboarderTitle)
        }

        page.description?.let { onboarderDescription ->
            setTextViewProperties(view = onboarderDescriptionTextView, attributes = onboarderDescription)
        }

        page.miscellaneousButton?.let { miscellaneousButton ->
            setButtonProperties(view = onboarderMiscellaneousButton, attributes = miscellaneousButton)
        }


        container.addView(itemView)
        return itemView
    }

    private fun setImageViewProperties(onboarderImageView: ImageView, onboarderImage: OnboarderImage) {
        with(onboarderImageView) {
            if (onboarderImage.drawable != null) {
                setImageDrawable(onboarderImage.drawable)
            }
            if (onboarderImage.imageResId != 0) {
                setImageResource(onboarderImage.imageResId)
            }

            layoutParams.height = onboarderImage.imageHeightPx
            layoutParams.width = onboarderImage.imageWidthPx
            (layoutParams as ConstraintLayout.LayoutParams).verticalBias = onboarderImage.imageBias
        }
    }

    private fun setTextViewProperties(view: TextView, attributes: OnboarderText) {
        with(view) {
            if (attributes.text != null) {
                text = attributes.text
            }
            if (attributes.textResId != 0) {
                setText(attributes.textResId)
            }
            if (attributes.textColor != 0) {
                setTextColor(attributes.textColor)
            }
            if (!attributes.typefacePath.isNullOrEmpty()) {
                TypefaceManager(path = attributes.typefacePath).applyTo(this)
            }
            if (attributes.typefaceFontResId != 0) {
                TypefaceManager(resource = attributes.typefaceFontResId).applyTo(this)
            }
            if (attributes.textSize != 0f) {
                textSize = attributes.textSize
            }
            gravity = if (attributes.multilineCentered) {
                Gravity.CENTER
            } else {
                if (lineCount > 1) Gravity.START else Gravity.CENTER
            }
            if (attributes.textPaddingBottomPx != 0) {
                (layoutParams as ConstraintLayout.LayoutParams).bottomMargin = attributes.textPaddingBottomPx
            }
        }
    }

    private fun setButtonProperties(view: Button, attributes: OnboarderMiscellaneousButton) {
        with(view) {
            visibility = attributes.visibility
            setOnClickListener(attributes.clickListener)

            if (!attributes.text.isNullOrEmpty()) {
                text = attributes.text
            }

            if (attributes.textResId != 0) {
                setText(attributes.textResId)
            }

            if (attributes.textColor != 0) {
                setTextColor(attributes.textColor)
            }

            if (attributes.textSize != 0f) {
                textSize = (attributes.textSize)
            }

            if (attributes.backgroundColor != 0) {
                setBackgroundColor(attributes.backgroundColor)
            }

            if (!attributes.typefacePath.isNullOrEmpty()) {
                TypefaceManager(path = attributes.typefacePath).applyTo(this)
            }
            if (attributes.typefaceFontResId != 0) {
                TypefaceManager(resource = attributes.typefaceFontResId).applyTo(this)
            }


            layoutParams.height = attributes.heightPx
            layoutParams.width = attributes.widthPx

            setPadding(attributes.leftPadding.px, attributes.topPadding.px, attributes.rightPadding.px, attributes.bottomPadding.px)
        }
    }

    override fun destroyItem(container: ViewGroup, position: Int, obj: Any) {
        container.removeView(obj as View)
    }

}