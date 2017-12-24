package com.cuneytayyildiz.androidonboarder;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Toast;

import com.cuneytayyildiz.onboarder.OnboarderActivity;
import com.cuneytayyildiz.onboarder.OnboarderPage;

import java.util.Arrays;
import java.util.List;

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

                new OnboarderPage.Builder()
                        .title("Eclair")
                        .description("Android 2.1")
                        .imageResourceId( R.drawable.eclair_circle)
                        .backgroundColor(R.color.color_eclair)
                        .titleColor(R.color.primary_text)
                        .descriptionColor(R.color.secondary_text)
                        .multilineDescriptionCentered(true)
                        .build(),

                new OnboarderPage.Builder()
                        .title("Froyo")
                        .description("Android 2.2")
                        .imageResourceId( R.drawable.froyo_circle)
                        .backgroundColor(R.color.color_froyo)
                        .titleColor(R.color.primary_text)
                        .descriptionColor(R.color.secondary_text)
                        .multilineDescriptionCentered(true)
                        .build(),

                new OnboarderPage.Builder()
                        .title("Gingerbread")
                        .description("Android 2.3")
                        .imageResourceId( R.drawable.gingerbread_circle)
                        .backgroundColor(R.color.color_gingerbread)
                        .titleColor(R.color.primary_text)
                        .descriptionColor(R.color.secondary_text)
                        .multilineDescriptionCentered(true)
                        .build(),

                new OnboarderPage.Builder()
                        .title("Honeycomb")
                        .description("Android 3.0")
                        .imageResourceId( R.drawable.honeycomb_circle)
                        .backgroundColor(R.color.color_honeycomb)
                        .titleColor(R.color.primary_text)
                        .descriptionColor(R.color.secondary_text)
                        .multilineDescriptionCentered(true)
                        .build(),

                new OnboarderPage.Builder()
                        .title("Ice Cream Sandwich")
                        .description("Android 4.0")
                        .imageResourceId( R.drawable.icecream_circle)
                        .backgroundColor(R.color.color_ice_cream_sandwich)
                        .titleColor(R.color.primary_text)
                        .descriptionColor(R.color.secondary_text)
                        .multilineDescriptionCentered(true)
                        .build(),

                new OnboarderPage.Builder()
                        .title("Jellybean")
                        .description("Android 4.1")
                        .imageResourceId( R.drawable.jellybean_circle)
                        .backgroundColor(R.color.color_jellybean)
                        .titleColor(R.color.primary_text)
                        .descriptionColor(R.color.secondary_text)
                        .multilineDescriptionCentered(true)
                        .build(),

                new OnboarderPage.Builder()
                        .title("KitKat")
                        .description("Android 4.4")
                        .imageResourceId( R.drawable.kitkat_circle)
                        .backgroundColor(R.color.color_kitkat)
                        .titleColor(R.color.primary_text)
                        .descriptionColor(R.color.secondary_text)
                        .multilineDescriptionCentered(true)
                        .build(),

                new OnboarderPage.Builder()
                        .title("Lollipop")
                        .description("Android 5.0")
                        .imageResourceId( R.drawable.lollipop_circle)
                        .backgroundColor(R.color.color_lollipop)
                        .titleColor(R.color.primary_text)
                        .descriptionColor(R.color.secondary_text)
                        .multilineDescriptionCentered(true)
                        .build(),

                new OnboarderPage.Builder()
                        .title("Marshmallow")
                        .description("Android 6.0")
                        .imageResourceId( R.drawable.marshmallow_circle)
                        .backgroundColor(R.color.color_marshmallow)
                        .titleColor(R.color.primary_text)
                        .descriptionColor(R.color.secondary_text)
                        .multilineDescriptionCentered(true)
                        .build(),

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

        setSkipButtonTitle(getString(R.string.button_skip));
        setFinishButtonTitle(getString(R.string.button_finish));

        initOnboardingPages(pages);
    }

    @Override
    public void onSkipButtonPressed() {
        super.onSkipButtonPressed();
        Toast.makeText(this, "Skip button was pressed!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFinishButtonPressed() {
        Toast.makeText(this, "Finish button was pressed", Toast.LENGTH_SHORT).show();
    }
}


