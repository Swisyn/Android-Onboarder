package com.cuneytayyildiz.onboarder.utils;

import android.content.Context;
import androidx.core.content.ContextCompat;

import com.cuneytayyildiz.onboarder.OnboarderPage;

import java.util.ArrayList;
import java.util.List;

public class ColorsArrayBuilder {

    public static Integer[] getPageBackgroundColors(Context context, List<OnboarderPage> pages) {
        List<Integer> colorsList = new ArrayList<>();
        for (OnboarderPage page : pages) {
            if (page.getBackgroundColor() != 0) {
                colorsList.add(page.getBackgroundColor());
            }else {
                colorsList.add(ContextCompat.getColor(context, page.getBackgroundColorId()));
            }
        }
        return colorsList.toArray(new Integer[pages.size()]);
    }
}
