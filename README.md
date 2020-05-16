
[![Android Arsenal]( https://img.shields.io/badge/Android%20Arsenal-Android%20Onboarder-green.svg?style=flat )]( https://android-arsenal.com/details/1/6598 )

# Android Onboarder
<p align="center"> 
Android Onboarder is a simple and lightweight library that helps you to create cool and beautiful introduction screens for your apps without writing dozens of lines of code.
</p>

* [Features](#features)
* [Getting Started](#getting-started)
   * [Adding dependency](#adding-dependency)
  * [Basic usage](#basic-usage)
       * [Activity functions](#activity-functions)
       * [Page Properties](#page-properties)
 * [Style Modifications](#style-modifications)
* [Localization](#localization)
* [License](#license)

![Sample image](https://media.giphy.com/media/WplHKZTuKyX7cKZGw7/giphy.gif)

## Features 

* **API >= 14** compatible.
* 100% Kotlin ❤️
* **AndroidX** compatible.
* Support for **runtime permissions**.
* Dependent only on AndroidX AppCompat/Annotations, ConstraintLayout and Kotlin JDK.


## Getting Started

#### Adding dependency

Add dependency in your build.gradle (app/build.gradle)

```groovy
implementation 'com.cuneytayyildiz:onboarder:2.0.0'
```

#### Basic usage
To use Onboarder, create an activity that extends from OnboarderActivity like the following:
```kotlin

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
```

#### Activity functions

```kotlin
/*********** Activity methods ***********/
fun initOnboardingPages(pages: MutableList<OnboarderPage>) // Set onboarding pages into adapter
fun setPageTransformer(pageTransformer: ViewPager.PageTransformer) // Animate your page transitions
fun setOnboarderPageChangeListener(onboarderPageChangeListener: OnboarderPageChangeListener?) // Get current position of the page
 
fun setInactiveIndicatorColor(color: Int) // Change dot's color for inactive status
fun setActiveIndicatorColor(color: Int) // Change dot's color for active status

fun setDividerColor(@ColorInt color: Int) // Set divider color
fun setDividerHeight(heightInDp: Int) // Set divider height
fun setDividerVisibility(dividerVisibility: Int) // Hide divider

fun shouldUseFloatingActionButton(shouldUseFloatingActionButton: Boolean) // Change skip and finish button as FloatingActionButton aka FAB

fun shouldDarkenButtonsLayout(shouldDarkenButtonsLayout: Boolean) // Make buttons layout darker on bottom

fun setSkipButtonHidden() // Hide skip button
fun setSkipButtonTitle(title: CharSequence?) // Set custom text for skip button
fun setSkipButtonTitle(@StringRes titleResId: Int)
fun setSkipButtonTextColor(@ColorRes colorResId: Int)
fun setSkipButtonBackgroundColor(@ColorRes colorResId: Int)

fun setFinishButtonTitle(title: CharSequence?) // Set custom text for finish button
fun setFinishButtonTitle(@StringRes titleResId: Int) 
fun setFinishButtonTextColor(@ColorRes colorResId: Int)
fun setFinishButtonBackgroundColor(@ColorRes colorResId: Int)

fun setNextButtonTitle(title: CharSequence?) // Set custom text for next button
fun setNextButtonTitle(@StringRes titleResId: Int)
fun setNextButtonTextColor(@ColorRes colorResId: Int)
fun setNextButtonBackgroundColor(@ColorRes colorResId: Int)
fun setNextButtonIcon(@DrawableRes drawableResId: Int)

fun NextButton() // Get Next button to change it's properties
fun SkipButton() // Get Skip button to change it's properties
fun FinishButton() // Get Finish button to change it's properties
fun FabButton() // Get Fab button to change it's properties
```

#### Page Properties
You can change most properties of the views on page such as background color, text size, text color, showing a button, setting a click listener to view etc.
```kotlin
data class OnboarderPage(  
backgroundColor // Background color of the page
image: OnboarderImage // Thumbnail image at top
title: OnboarderText // Title of the page
description: OnboarderText // Description text
miscellaneousButton: OnboarderMiscellaneousButton // A button where you can add any functionality that you want. Request a permission, show recent changes of your app, start your privacy policy url etc.
)

data class OnboarderImage(  
 imageResId // R.drawable.first_page_thumbnail
 drawable // ContextCompat.getDrawable(context, R.drawable.first_page_thumbnail)  
 imageWidthPx // ViewGroup.LayoutParams.WRAP_CONTENT, 100.dp, 100.px
 imageHeightPx // ViewGroup.LayoutParams.WRAP_CONTENT, 100.dp, 100.px
 imageBias // .5f (0 is top, 1 is bottom)
)

data class OnboarderText(  
text // "First Page Title" 
textResId // R.string.first_page_title
textColor // color(R.color.first_page_title_color)
backgroundColor // color(R.color.first_page_title_background_color)
widthPx // ViewGroup.LayoutParams.WRAP_CONTENT, 100.dp, 100.px
heightPx // ViewGroup.LayoutParams.WRAP_CONTENT, 100.dp, 100.px
typefacePath //  fonts/myfont.ttf
typefaceFontResId // R.font.my_font
textSize // 20f 
textPaddingBottomPx // 20
multilineCentered // true, false
clickListener // View.OnClickListener{ textView -> } 
)

data class OnboarderMiscellaneousButton(
visibility // default View.GONE,  
text // Button text  
textResId // R.string.button_text
textColor // color(R.color.button_text_color)
backgroundColor // color(R.color.button_background_color)
widthPx // ViewGroup.LayoutParams.WRAP_CONTENT, 100.dp, 100.px
heightPx // ViewGroup.LayoutParams.WRAP_CONTENT, 100.dp, 100.px
typefacePath //  fonts/myfont.ttf
typefaceFontResId // R.font.my_font
textSize // 20f
leftPadding // 16,  
rightPadding // 16,  
topPadding // 8,  
bottomPadding // 8
clickListener // View.OnClickListener{ button -> }  
)
```

#### Style modifications
If you would like to change style on the <b>OnboarderPage</b>, you can simple add these styles in your <b>app/res/values/styles.xml</b> and change the attributes.

```xml
<?xml version="1.0" encoding="utf-8"?>
<resources>
<style name="Onboarder_Image_Style">...</style>
<style name="Onboarder_Title_Style">...</style>
<style name="Onboarder_Description_Style">...</style>
<style name="Onboarder_Miscellaneous_Style">...</style>
</resources>
```

#### Localization
To localize buttons from the library to your language, add these strings into corresponding <b>app/res/values-XX/strings.xml</b>
```xml
<?xml version="1.0" encoding="utf-8"?>
<resources xmlns:tools="http://schemas.android.com/tools">
    <string name="onboarder_button.finish">...</string>
    <string name="onboarder_button.next">...</string>
    <string name="onboarder_button.skip">...</string>
</resources>
```
or
```kotlin
SkipButton().setText(R.string.onboarder_button_skip)
NextButton().setText(R.string.onboarder_button_next)
FinishButton().setText(R.string.onboarder_button_finish)
```


## License

```
MIT License

Copyright (c) 2017 Cuneyt AYYILDIZ

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.

```
