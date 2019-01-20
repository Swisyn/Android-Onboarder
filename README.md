[![Android Arsenal]( https://img.shields.io/badge/Android%20Arsenal-Android%20Onboarder-green.svg?style=flat )]( https://android-arsenal.com/details/1/6598 )

# Android Onboarder
<p align="center"> 
Android Onboarder is a simple and lightweight library that helps you to create cool and beautiful introduction screens for your apps without writing dozens of lines of code.
</p>

![Sample image](https://media.giphy.com/media/3oFzm1BGCJzKM5iuIw/giphy.gif)

## Usage

#### Gradle

Add dependency in your build.gradle

```groovy
implementation 'com.cuneytayyildiz:onboarder:1.0.3'
```

#### Implementation

<b>Create an activity which must extends from OnboarderActivity.</b>

```java


public class IntroActivity extends OnboarderActivity implements OnboarderPageChangeListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        List<OnboarderPage> pages = Arrays.asList(
                new OnboarderPage.Builder()
                        .title("Donut")
                        .description("Android 1.6")
                        .imageResourceId( R.drawable.donut_circle)
                        .backgroundColorId(R.color.color_donut)
                        .titleColorId(R.color.primary_text)
                        .descriptionColorId(R.color.secondary_text)
                        .multilineDescriptionCentered(true)
                        .build(),
                        
                // No need to write all of them :P
                
                new OnboarderPage.Builder()
                        .title("Oreo")
                        .description("Android 8.0")
                        .imageResourceId( R.drawable.oreo_circle)
                        .backgroundColor(R.color.color_oreo)
                        .titleColor(R.color.color_android_green)
                        .descriptionColor(R.color.secondary_text)
                        .multilineDescriptionCentered(true)
                        .build()
                );
        setOnboarderPageChangeListener(this);
        initOnboardingPages(pages);
    }

    @Override
    public void onFinishButtonPressed() {
        // implement your logic, save induction has done to sharedPrefs
        Toast.makeText(this, "Finish button was pressed", Toast.LENGTH_SHORT).show();
    }
    
    @Override
    public void onPageChanged(int position) {
         Toast.makeText(this, "onPageChanged: " + position, Toast.LENGTH_SHORT).show();
    }
}

```

#### Here are some methods for customization

```java
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

## Additional Links
[A collection of view pager transformers](https://github.com/geftimov/android-viewpager-transformers)

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
