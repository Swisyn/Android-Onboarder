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
implementation 'com.cuneytayyildiz:onboarder:1.0.0'
```

#### Implementation

<b>Create an activity which must extends from OnboarderActivity.</b>

```java


public class IntroActivity extends OnboarderActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        List<OnboarderPage> pages = Arrays.asList(
                new OnboarderPage.Builder()
                        .title("Donut")
                        .description("Android 1.6")
                        .imageResourceId( R.drawable.donut_circle)
                        .backgroundColor(R.color.color_donut)
                        .titleColor(R.color.primary_text)
                        .descriptionColor(R.color.secondary_text)
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

        initOnboardingPages(pages);
    }

    @Override
    public void onFinishButtonPressed() {
        // implement your logic, save induction has done to sharedPrefs
        Toast.makeText(this, "Finish button was pressed", Toast.LENGTH_SHORT).show();
    }
}

```

#### Here are some methods for customization

```java
setPageTransformer(ViewPager.PageTransformer); // Animate your page transitions
setActiveIndicatorColor(android.R.color.white); // Change dot's color for active status
setInactiveIndicatorColor(android.R.color.darker_gray); // Change dot's color for inactive status
shouldDarkenButtonsLayout(true); // Make buttons layout derker on bottom
setDividerColor(Color.WHITE); // Set divider color
setDividerHeight(2); // Set divider height
setDividerVisibility(View.GONE); // Hide divider
shouldUseFloatingActionButton(true); // Change skip and finish button  as FloatingActionButton aka FAB
setSkipButtonTitle("Skip"); // Set custom text for skip button
setFinishButton("Finish"); // Set custom text for finish button
setSkipButtonHidden(); // Hide skip button 
setTitleTextSize(12f); // Set title text size 
setDescriptionTextSize(12f); // Set description text size 
setMultilineDescriptionCentered(true); // Set description to be centered
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
