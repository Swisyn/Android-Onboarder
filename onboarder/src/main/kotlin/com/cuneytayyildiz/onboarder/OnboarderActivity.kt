package com.cuneytayyildiz.onboarder

import android.animation.ArgbEvaluator
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.util.TypedValue
import android.view.View
import android.widget.Button
import android.widget.FrameLayout
import androidx.annotation.ColorInt
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.viewpager.widget.ViewPager
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import com.cuneytayyildiz.onboarder.model.OnboarderPage
import com.cuneytayyildiz.onboarder.utils.OnboarderPageChangeListener
import com.cuneytayyildiz.onboarder.views.CircleIndicatorView
import com.google.android.material.floatingactionbutton.FloatingActionButton


abstract class OnboarderActivity : AppCompatActivity(R.layout.activity_onboarder), View.OnClickListener, OnPageChangeListener {
    private lateinit var circleIndicatorView: CircleIndicatorView
    private lateinit var viewPagerOnboarder: ViewPager
    private lateinit var btnSkip: Button
    private lateinit var btnFinish: Button
    private lateinit var btnNext: Button
    private lateinit var buttonsLayout: FrameLayout
    private lateinit var fab: FloatingActionButton
    private lateinit var divider: View

    private var backgroundColors: Array<Int>? = null
    private var onboarderAdapter: OnboarderPagerAdapter? = null

    private var evaluator: ArgbEvaluator = ArgbEvaluator()
    private var shouldDarkenButtonsLayout = false
    private var shouldUseFloatingActionButton = false
    private var onboarderPageChangeListener: OnboarderPageChangeListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initViews()
    }

    private fun initViews() {
        supportActionBar?.hide()

        setStatusBackgroundColor()

        circleIndicatorView = findViewById(R.id.indicator_circle)
        btnNext = findViewById(R.id.button_next)
        btnSkip = findViewById(R.id.button_skip)
        btnFinish = findViewById(R.id.button_finish)
        buttonsLayout = findViewById(R.id.layout_buttons)
        fab = findViewById(R.id.fab)
        divider = findViewById(R.id.divider)
        viewPagerOnboarder = findViewById(R.id.viewpager_onboarder)

        viewPagerOnboarder.addOnPageChangeListener(this)
        btnNext.setOnClickListener(this)
        btnSkip.setOnClickListener(this)
        btnFinish.setOnClickListener(this)
        fab.setOnClickListener(this)
    }

    fun initOnboardingPages(pages: MutableList<OnboarderPage>) {
        backgroundColors = getPageBackgroundColors(pages)

        onboarderAdapter = OnboarderPagerAdapter(this, pages)
        viewPagerOnboarder.adapter = onboarderAdapter
        circleIndicatorView.setPageIndicatorCount(pages.size)
    }

    fun setInactiveIndicatorColor(color: Int) {
        circleIndicatorView.setInactiveIndicatorColor(color)
    }

    fun setActiveIndicatorColor(color: Int) {
        circleIndicatorView.setActiveIndicatorColor(color)
    }

    fun shouldDarkenButtonsLayout(shouldDarkenButtonsLayout: Boolean) {
        this.shouldDarkenButtonsLayout = shouldDarkenButtonsLayout
    }

    fun setDividerColor(@ColorInt color: Int) {
        if (!shouldDarkenButtonsLayout) divider.setBackgroundColor(color)
    }

    fun setDividerHeight(heightInDp: Int) {
        if (!shouldDarkenButtonsLayout) divider.layoutParams.height = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, heightInDp.toFloat(),
                resources.displayMetrics).toInt()
    }

    fun setDividerVisibility(dividerVisibility: Int) {
        divider.visibility = dividerVisibility
    }

    private fun darkenColor(@ColorInt color: Int): Int {
        val hsv = FloatArray(3)
        Color.colorToHSV(color, hsv)
        hsv[2] *= 0.9f
        return Color.HSVToColor(hsv)
    }

    fun setStatusBackgroundColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.decorView.systemUiVisibility = (
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN)
            window.statusBarColor = ContextCompat.getColor(this, R.color.black_transparent)
        }
    }

    override fun onClick(view: View) {
        val viewId = view.id

        if (onboarderAdapter != null) {
            val isInLastPage = viewPagerOnboarder.currentItem == onboarderAdapter!!.count - 1

            when {
                viewId == R.id.button_next || viewId == R.id.fab && !isInLastPage -> {
                    viewPagerOnboarder.currentItem = viewPagerOnboarder.currentItem + 1
                }
                viewId == R.id.button_skip -> {
                    onSkipButtonPressed()
                }
                viewId == R.id.button_finish || viewId == R.id.fab && isInLastPage -> {
                    onFinishButtonPressed()
                }
            }
        }
    }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

        if (onboarderAdapter != null && backgroundColors != null) {
            val colors = backgroundColors!!

            if (position < onboarderAdapter!!.count - 1 && position < colors.size - 1) {
                viewPagerOnboarder.setBackgroundColor((evaluator.evaluate(positionOffset, colors[position], colors[position + 1]) as Int))

                if (shouldDarkenButtonsLayout) {
                    buttonsLayout.setBackgroundColor(darkenColor(evaluator.evaluate(positionOffset, colors[position], colors[position + 1]) as Int))
                    divider.visibility = View.GONE
                }
            } else {
                viewPagerOnboarder.setBackgroundColor(colors[colors.size - 1])

                if (shouldDarkenButtonsLayout) {
                    buttonsLayout.setBackgroundColor(darkenColor(colors[colors.size - 1]))
                    divider.visibility = View.GONE
                }
            }
        }
    }

    override fun onPageSelected(position: Int) {
        if (onboarderAdapter != null) {
            circleIndicatorView.setCurrentPage(position)

            val isLastPage = (position == onboarderAdapter!!.count - 1)

            if (shouldUseFloatingActionButton) {
                fab.setImageResource(if (isLastPage) R.drawable.ic_done_white_24dp else R.drawable.ic_arrow_forward_white_24dp)
            } else {
                btnNext.visibility = if (isLastPage) View.GONE else View.VISIBLE
                btnFinish.visibility = if (isLastPage) View.VISIBLE else View.GONE
            }

            onboarderPageChangeListener?.onPageChanged(position)
        }
    }

    override fun onPageScrollStateChanged(state: Int) {}

    fun setOnboarderPageChangeListener(onboarderPageChangeListener: OnboarderPageChangeListener?) {
        this.onboarderPageChangeListener = onboarderPageChangeListener
    }

    //<editor-fold desc="Buttons">


    fun shouldUseFloatingActionButton(shouldUseFloatingActionButton: Boolean) {
        this.shouldUseFloatingActionButton = shouldUseFloatingActionButton

        if (shouldUseFloatingActionButton) {
            fab.visibility = View.VISIBLE
            setDividerVisibility(View.GONE)
            shouldDarkenButtonsLayout(false)
            btnFinish.visibility = View.GONE
            btnSkip.visibility = View.GONE
            btnNext.visibility = View.GONE
            btnNext.isFocusable = false
            buttonsLayout.layoutParams.height = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 96f,
                    resources.displayMetrics).toInt()
        }
    }

    fun setPageTransformer(pageTransformer: ViewPager.PageTransformer) {
        viewPagerOnboarder.setPageTransformer(true, pageTransformer)
    }

    fun setSkipButtonTitle(title: CharSequence?) {
        btnSkip.text = title
    }

    fun setSkipButtonHidden() {
        btnSkip.visibility = View.GONE
    }

    fun setSkipButtonTitle(@StringRes titleResId: Int) {
        btnSkip.setText(titleResId)
    }

    fun setFinishButtonTitle(title: CharSequence?) {
        btnFinish.text = title
    }

    fun setFinishButtonTitle(@StringRes titleResId: Int) {
        btnFinish.setText(titleResId)
    }

//    fun setFinishButtonTextColor(@ColorRes color: Int) {
//        btnFinish.setTextColor(ContextCompat.getColor(this, color))
//    }
//
//    fun setNextButtonTextColor(@ColorRes color: Int) {
//        btnNext.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0)
//        btnNext.setTextColor(ContextCompat.getColor(this, color))
//    }
//
//    fun setSkipButtonTextColor(@ColorRes color: Int) {
//        btnSkip.setTextColor(ContextCompat.getColor(this, color))
//    }
//
//    fun setFinishButtonBackgroundColor(@ColorRes color: Int) {
//        btnFinish.setBackgroundColor(ContextCompat.getColor(this, color))
//    }
//
//    fun setSkipButtonBackgroundColor(@ColorRes color: Int) {
//        btnSkip.setBackgroundColor(ContextCompat.getColor(this, color))
//    }
//
//    fun setNextButtonBackgroundColor(@ColorRes color: Int) {
//        btnNext.setBackgroundColor(ContextCompat.getColor(this, color))
//    }
//
//    fun setNextButtonTitle(title: CharSequence?) {
//        btnNext.text = title
//        btnNext.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0)
//    }
//
//    fun setNextButtonTitle(@StringRes titleResId: Int) {
//        btnNext.setText(titleResId)
//        btnNext.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0)
//    }
//
//    fun setNextButtonIcon(@DrawableRes drawableResId: Int) {
//        btnNext.text = null
//        btnNext.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, drawableResId)
//    }

    fun NextButton(): Button = btnNext
    fun Fab(): FloatingActionButton = fab
    fun FinishButton(): Button = btnFinish
    fun SkipButton(): Button = btnSkip

    protected open fun onSkipButtonPressed() {
        if (onboarderAdapter != null) {
            viewPagerOnboarder.currentItem = onboarderAdapter!!.count
        }
    }

    abstract fun onFinishButtonPressed()

    protected fun setPage(position: Int) {
        viewPagerOnboarder.currentItem = position
    } //</editor-fold>

    private fun getPageBackgroundColors(pages: MutableList<OnboarderPage>): Array<Int> {
        return pages.map { page -> page.backgroundColor }.toTypedArray()
    }
}