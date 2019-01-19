package com.cuneytayyildiz.androidonboarder;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.cuneytayyildiz.onboarder.OnboarderActivity;
import com.cuneytayyildiz.onboarder.OnboarderPage;
import com.cuneytayyildiz.onboarder.utils.OnboarderPageChangeListener;

import java.util.Arrays;
import java.util.List;

public class IntroActivity extends OnboarderActivity implements OnboarderPageChangeListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        List<OnboarderPage> pages = Arrays.asList(
                new OnboarderPage.Builder()
                        .title("Donut")
                        .description("Android 1.6")
                        .imageResourceId(R.drawable.donut_circle)
                        .backgroundColorId(R.color.color_donut)
                        .titleColorId(R.color.primary_text)
                        .descriptionColorId(R.color.secondary_text)
                        .multilineDescriptionCentered(true)
                        .build(),

                new OnboarderPage.Builder()
                        .title("Eclair")
                        .description("Android 2.1")
                        .imageResourceId(R.drawable.eclair_circle)
                        .backgroundColorId(R.color.color_eclair)
                        .titleColorId(R.color.primary_text)
                        .descriptionColorId(R.color.secondary_text)
                        .multilineDescriptionCentered(true)
                        .build(),

                new OnboarderPage.Builder()
                        .title("Froyo")
                        .description("Android 2.2")
                        .imageResourceId(R.drawable.froyo_circle)
                        .backgroundColorId(R.color.color_froyo)
                        .titleColorId(R.color.primary_text)
                        .descriptionColorId(R.color.secondary_text)
                        .multilineDescriptionCentered(true)
                        .build(),

                new OnboarderPage.Builder()
                        .title("Gingerbread")
                        .description("Android 2.3")
                        .imageResourceId(R.drawable.gingerbread_circle)
                        .backgroundColorId(R.color.color_gingerbread)
                        .titleColorId(R.color.primary_text)
                        .descriptionColorId(R.color.secondary_text)
                        .multilineDescriptionCentered(true)
                        .build(),

                new OnboarderPage.Builder()
                        .title("Honeycomb")
                        .description("Android 3.0")
                        .imageResourceId(R.drawable.honeycomb_circle)
                        .backgroundColorId(R.color.color_honeycomb)
                        .titleColorId(R.color.primary_text)
                        .descriptionColorId(R.color.secondary_text)
                        .multilineDescriptionCentered(true)
                        .build(),

                new OnboarderPage.Builder()
                        .title("Ice Cream Sandwich")
                        .description("Android 4.0")
                        .imageResourceId(R.drawable.icecream_circle)
                        .backgroundColorId(R.color.color_ice_cream_sandwich)
                        .titleColorId(R.color.primary_text)
                        .descriptionColorId(R.color.secondary_text)
                        .multilineDescriptionCentered(true)
                        .build(),

                new OnboarderPage.Builder()
                        .title("Jellybean")
                        .description("Android 4.1")
                        .imageResourceId(R.drawable.jellybean_circle)
                        .backgroundColorId(R.color.color_jellybean)
                        .titleColorId(R.color.primary_text)
                        .descriptionColorId(R.color.secondary_text)
                        .multilineDescriptionCentered(true)
                        .build(),

                new OnboarderPage.Builder()
                        .title("KitKat")
                        .description("Android 4.4")
                        .imageResourceId(R.drawable.kitkat_circle)
                        .backgroundColorId(R.color.color_kitkat)
                        .titleColorId(R.color.primary_text)
                        .descriptionColorId(R.color.secondary_text)
                        .multilineDescriptionCentered(true)
                        .build(),

                new OnboarderPage.Builder()
                        .title("Lollipop")
                        .description("Android 5.0")
                        .imageResourceId(R.drawable.lollipop_circle)
                        .backgroundColorId(R.color.color_lollipop)
                        .titleColorId(R.color.primary_text)
                        .descriptionColorId(R.color.secondary_text)
                        .multilineDescriptionCentered(true)
                        .build(),

                new OnboarderPage.Builder()
                        .title("Marshmallow")
                        .description("Android 6.0")
                        .imageResourceId(R.drawable.marshmallow_circle)
                        .backgroundColorId(R.color.color_marshmallow)
                        .titleColorId(R.color.primary_text)
                        .descriptionColorId(R.color.secondary_text)
                        .multilineDescriptionCentered(true)
                        .build(),

                new OnboarderPage.Builder()
                        .title("Oreo")
                        .description("Android 8.0")
                        .imageResourceId(R.drawable.oreo_circle)
                        .backgroundColorId(R.color.color_oreo)
                        .titleColorId(R.color.color_android_green)
                        .descriptionColorId(R.color.secondary_text)
                        .multilineDescriptionCentered(true)
                        .build()
        );

        setSkipButtonTitle(R.string.button_skip);
        setFinishButtonTitle(R.string.button_finish);

        setOnboarderPageChangeListener(this);
        initOnboardingPages(pages);
    }

    @Override
    public void onSkipButtonPressed() {
        super.onSkipButtonPressed();
        Toast.makeText(this, "Skip button was pressed!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFinishButtonPressed() {
        // implement your logic, save induction has done to sharedPrefs
        Toast.makeText(this, "Finish button was pressed", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPageChanged(int position) {
        Log.d(getClass().getSimpleName(), "onPageChanged: " + position);
    }
}


