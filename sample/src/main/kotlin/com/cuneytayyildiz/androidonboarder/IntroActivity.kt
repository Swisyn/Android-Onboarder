package com.cuneytayyildiz.androidonboarder

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.cuneytayyildiz.onboarder.OnboarderActivity
import com.cuneytayyildiz.onboarder.model.*
import com.cuneytayyildiz.onboarder.utils.OnboarderPageChangeListener
import com.cuneytayyildiz.onboarder.utils.color

class IntroActivity : OnboarderActivity(), OnboarderPageChangeListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setOnboarderPageChangeListener(this)

        val pages: MutableList<OnboarderPage> = createOnboarderPages()

        initOnboardingPages(pages)
    }

    public override fun onSkipButtonPressed() {
        super.onSkipButtonPressed()
        Toast.makeText(this, "Skip button was pressed!", Toast.LENGTH_SHORT).show()
    }

    override fun onFinishButtonPressed() {
        // implement your logic, save induction has done to sharedPrefs
        Toast.makeText(this, "Finish button was pressed", Toast.LENGTH_SHORT).show()
    }

    override fun onPageChanged(position: Int) {
        Log.d(javaClass.simpleName, "onPageChanged: $position")
    }

    private fun createOnboarderPages(): MutableList<OnboarderPage> {
        return mutableListOf(
                onboarderPage {
                    backgroundColor = color(R.color.color_donut)

                    image {
                        imageResId = R.drawable.donut_circle
                    }

                    title {
                        text = "Donut"
                        textColor = color(R.color.primary_text)
                    }

                    description {
                        text = "Version 1.6 Donut was given the name Donut. "
                        textColor = color(R.color.secondary_text)
                        multilineCentered = true
                    }
                },
                onboarderPage {
                    backgroundColor = color(R.color.color_eclair)

                    image {
                        imageResId = R.drawable.eclair_circle
                    }

                    title {
                        text = "Eclair"
                        textColor = color(R.color.primary_text)
                    }

                    description {
                        text = "Android-Version 2 Eclair and 2.1 Eclair share the same name, Eclair. Eclairs are longly biscuits overdrawn with chocolate. "
                        textColor = color(R.color.secondary_text)
                        multilineCentered = true
                    }
                },
                onboarderPage {
                    backgroundColor = color(R.color.color_froyo)

                    image {
                        imageResId = R.drawable.froyo_circle
                    }

                    title {
                        text = "Froyo"
                        textColor = color(R.color.primary_text)
                    }

                    description {
                        text = "Frozen Yogurt is a ice-like dessert made with milk and yogurt and is also the name of the Android version 2.2 Froyo. "
                        textColor = color(R.color.secondary_text)
                        multilineCentered = true
                    }
                },
                onboarderPage {
                    backgroundColor = color(R.color.color_gingerbread)

                    image {
                        imageResId = R.drawable.gingerbread_circle
                    }

                    title {
                        text = "Gingerbread"
                        textColor = color(R.color.primary_text)
                    }

                    description {
                        text = "The name of Android version 2.3 🥯 \"Gingerbread\" is Gingerbread, which are cake-like biscuits mostly eaten around christmas time. "
                        textColor = color(R.color.secondary_text)
                        multilineCentered = true
                    }
                },
                onboarderPage {
                    backgroundColor = color(R.color.color_honeycomb)

                    image {
                        imageResId = R.drawable.honeycomb_circle
                    }

                    title {
                        text = "Honeycomb"
                        textColor = color(R.color.primary_text)
                    }

                    description {
                        text = "The android version mostly made for tablets, Android 3.0 Honeycomb, is called Honeycomb. The bootanimation of this android version is also made like a honeycomb."
                        textColor = color(R.color.secondary_text)
                        multilineCentered = true
                    }
                },
                onboarderPage {
                    backgroundColor = color(R.color.color_ice_cream_sandwich)

                    image {
                        imageResId = R.drawable.icecream_circle
                    }

                    title {
                        text = "Ice Cream Sandwich"
                        textColor = color(R.color.primary_text)
                    }

                    description {
                        text = "Android 4.0 is called after a sweet, which is made of delicious ice cream bewtween two biscuits: an Ice Cream Sandwhich. "
                        textColor = color(R.color.secondary_text)
                        multilineCentered = true
                    }
                },
                onboarderPage {
                    backgroundColor = color(R.color.color_jellybean)

                    image {
                        imageResId = R.drawable.jellybean_circle
                    }

                    title {
                        text = "Jellybean"
                        textColor = color(R.color.primary_text)
                    }

                    description {
                        text = "Jelly beans are colorful, mostly made out of sugar, sweets, which have a hard shell and are filled with jelly. The following android versions share this name:\n" +
                                "> 4.1\n" +
                                "> 4.2\n" +
                                "> 4.3"
                        textColor = color(R.color.secondary_text)
                        multilineCentered = true
                    }
                },
                onboarderPage {
                    backgroundColor = color(R.color.color_kitkat)

                    image {
                        imageResId = R.drawable.kitkat_circle
                    }

                    title {
                        text = "KitKat"
                        textColor = color(R.color.primary_text)
                    }

                    description {
                        text = "KitKat is a brand from Nestle, and is a chocolate bar filled with waffles. Android 4.4 is named after this sweet: 4.4 \"KitKat\"."
                        textColor = color(R.color.secondary_text)
                        multilineCentered = true
                    }
                },
                onboarderPage {
                    backgroundColor = color(R.color.color_lollipop)

                    image {
                        imageResId = R.drawable.lollipop_circle
                    }

                    title {
                        text = "Lollipop"
                        textColor = color(R.color.primary_text)
                    }

                    description {
                        text = "Lollipops are sweets in different flavors on a stalk and is also the name of the following android versions:\n" +
                                "> 5.0\n" +
                                "> 5.1\n" +
                                "> 5.1.1"
                        textColor = color(R.color.secondary_text)
                        multilineCentered = true
                    }
                },
                onboarderPage {
                    backgroundColor = color(R.color.color_marshmallow)

                    image {
                        imageResId = R.drawable.marshmallow_circle
                    }

                    title {
                        text = "Marshmallow"
                        textColor = color(R.color.primary_text)
                    }

                    description {
                        text = "The android version 6.0, announced at 17th of august in 2015 is called after the sweet Marshmallow. "
                        textColor = color(R.color.secondary_text)
                        multilineCentered = true
                    }
                },
                onboarderPage {
                    backgroundColor = color(R.color.color_nougat)

                    image {
                        imageResId = R.drawable.nougat_circle
                    }

                    title {
                        text = "Nougat"
                        textColor = color(R.color.primary_text)
                    }

                    description {
                        text = "Android 7, also called Android N, officially got the name Nougat."
                        textColor = color(R.color.secondary_text)
                        multilineCentered = true
                    }
                },
                onboarderPage {
                    backgroundColor = color(R.color.color_oreo)

                    image {
                        imageResId = R.drawable.oreo_circle
                    }

                    title {
                        text = "Oreo"
                        textColor = color(R.color.primary_text)
                    }

                    description {
                        text = "Android 8, also called Android O, carries the name Oreo, which are two crispy chocolate cookies with a vanilla cream center."
                        textColor = color(R.color.secondary_text)
                        multilineCentered = true
                    }
                },
                onboarderPage {
                    backgroundColor = color(R.color.color_android_green)

                    image {
                        imageResId = R.drawable.pie_circle
                    }

                    title {
                        text = "Pie"
                        textColor = color(R.color.primary_text)
                    }

                    description {
                        text = "Android 9, also called Android Pie, carries the name Pie, which is the name of different sweet dishes. " +
                                "\n\nThe version 9 was the last Android version which got a codename assigned. "
                        textColor = color(R.color.secondary_text)
                        multilineCentered = true
                    }
                },
                onboarderPage {
                    backgroundColor = color(R.color.color_android_green)

                    image {
                        imageResId = R.drawable.q_circle
                    }

                    title {
                        text = "Q"
                        textColor = color(R.color.primary_text)
                    }

                    description {
                        text = "Android 10 was officially released on September 3, 2019 for supported Google Pixel devices.\n" +
                                "\nGoogle announced that a new Android Version will be officially known as Android 10."
                        textColor = color(R.color.secondary_text)
                        multilineCentered = true
                    }

                    miscellaneousButton {
                        visibility = View.VISIBLE
                        text = "What's Next?"
                        backgroundColor = Color.WHITE
                        textColor = color(R.color.color_android_green)
                        clickListener = View.OnClickListener {
                            Toast.makeText(this@IntroActivity, "Hello World", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
        )
    }

}