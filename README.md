[![Android Arsenal]( https://img.shields.io/badge/Android%20Arsenal-Android%20Onboarder-green.svg?style=flat )]( https://android-arsenal.com/details/1/6598 )

# Android Onboarder
<p align="center"> 
Android Onboarder is a simple and lightweight library that helps you to create cool and beautiful introduction screens for your apps without writing dozens of lines of code.
</p>

![Sample image](https://media.giphy.com/media/3oFzm1BGCJzKM5iuIw/giphy.gif)

## Usage

#### Gradle

Add dependency in your build.gradle (app/build.gradle)

```groovy
implementation 'com.cuneytayyildiz:onboarder:2.0.0'
```

#### Implementation

<b>To use Onboarder, create an activity that extends from OnboarderActivity like the following:</b>

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
                }, // no need to add all
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

#### Here are some methods for customization

```kotlin
/***********Activity methods***********/
setPageTransformer(ViewPager.PageTransformer); // Animate your page transitions
setActiveIndicatorColor(android.R.color.white); // Change dot's color for active status
setInactiveIndicatorColor(android.R.color.darker_gray); // Change dot's color for inactive status
shouldDarkenButtonsLayout(true); // Make buttons layout derker on bottom
setDividerColor(Color.WHITE); // Set divider color
setDividerHeight(2); // Set divider height
setDividerVisibility(View.GONE); // Hide divider
shouldUseFloatingActionButton(true); // Change skip and finish button as FloatingActionButton aka FAB
setSkipButtonTitle("Skip"); // Set custom text for skip button
setFinishButton("Finish"); // Set custom text for finish button
setSkipButtonHidden(); // Hide skip button
setOnboarderPageChangeListener(OnboarderPageChangeListener); // Get current position of the page
setFinishButtonTextColor(@ColorRes int color);
setNextButtonTextColor(@ColorRes int color);
setSkipButtonTextColor(@ColorRes int color);
setFinishButtonBackgroundColor(@ColorRes int color);
setSkipButtonBackgroundColor(@ColorRes int color);
setNextButtonBackgroundColor(@ColorRes int color);
setNextButtonTitle(CharSequence title);
setNextButtonTitle(@StringRes int titleResId);
setNextButtonIcon(@DrawableRes int drawableResId);

/*************Page methods*************/
title("Title")//Set title
titleResourceId(@StringRes int string)//Set title resource
description("Description")//Set description
stringResourceId(@StringRes int string)//Set string resource
imageResource(Drawable drawable)//Set image drawable
imageResourceId(int id)//Set image drawable resource
titleColor(int color)//Set title color
titleColorId(@ColorRes int color)//Set title color resource
descriptionColor(int color)//Set description color
descriptionColorId(@ColorRes int color)//Set description color resource
backgroundColor(int color)//Set background color
backgroundColorId(@ColorRes int color)//Set background color resource
setTitleTextSize(12f) // Set title text size
setDescriptionTextSize(12f) // Set description text size
setImageSizeDp(int width, int height)//set image size in dp
setImageSizePx(int width, int height)//set image size in px
imageBias(float bias) //Set image bias (0 is top, 1 is bottom)
textPaddingBottomDp(int padding) //Sets bottom padding for description (this and imageBias() can be combined to make most layouts possible)
setMultilineDescriptionCentered(true) // Set description to be centered
```


#### Style modifications 🎨
<b>If you would like to change style on the OnboarderPage, you can simple add these styles in your styles.xml and change the attributes.</b>

```xml
<style name="Onboarder_Image_Style">...</style>
<style name="Onboarder_Title_Style">...</style>
<style name="Onboarder_Description_Style">...</style>
<style name="Onboarder_Miscellaneous_Style">...</style>
```

#### Localization 🌍
<b>To localize buttons from the library to your language, add these strings into corresponding strings.xml</b>
```xml
<?xml version="1.0" encoding="utf-8"?>
<resources xmlns:tools="http://schemas.android.com/tools">
    <string name="onboarder_button.finish">...</string>
    <string name="onboarder_button.next">...</string>
    <string name="onboarder_button.skip">...</string>
</resources>
```
<b>or</b>
```kotlin
     SkipButton().setText(R.string.onboarder_button_skip)
     NextButton().setText(R.string.onboarder_button_next)
     FinishButton().setText(R.string.onboarder_button_finish)
```

## ViewPager Transformers
[A collection of view pager transformers used in the library](https://github.com/geftimov/android-viewpager-transformers)

```kotlin
* DefaultTransformer
* AccordionTransformer
* BackgroundToForegroundTransformer
* CubeInTransformer
* CubeOutTransformer
* DepthPageTransformer
* DrawFromBackTransformer
* FlipHorizontalTransformer
* FlipVerticalTransformer
* ForegroundToBackgroundTransformer
* ParallaxPageTransformer
* RotateDownTransformer
* RotateUpTransformer
* StackTransformer
* TabletTransformer
* ZoomInTransformer
* ZoomOutSlideTransformer
* ZoomOutTransformer
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
