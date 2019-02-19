package com.cuneytayyildiz.onboarder;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.appcompat.content.res.AppCompatResources;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


public class OnboarderPagerAdapter extends PagerAdapter {
    private Context context;
    private List<OnboarderPage> onboarderPages;

    public OnboarderPagerAdapter(Context context, List<OnboarderPage> onboarderPages) {
        this.context = context;
        this.onboarderPages = onboarderPages;
    }

    @Override
    public int getCount() {
        return onboarderPages.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        View itemView = LayoutInflater.from(context).inflate(R.layout.item_onboarder, container, false);

        OnboarderPage page = onboarderPages.get(position);

        ImageView onboarderImage = itemView.findViewById(R.id.image_top);
        TextView onboarderTitle = itemView.findViewById(R.id.textview_title);
        TextView onboarderDescription = itemView.findViewById(R.id.textview_description);

        if (page.getTitle() != null) {
            onboarderTitle.setText(page.getTitle());
        }

        if (page.getTitleResourceId() != 0) {
            onboarderTitle.setText(container.getResources().getString(page.getTitleResourceId()));
        }

        if (page.getDescription() != null) {
            onboarderDescription.setText(page.getDescription());
        }

        if (page.getDescriptionResourceId() != 0) {
            onboarderDescription.setText(context.getResources().getString(page.getDescriptionResourceId()));
        }

        if (page.getTitleColor() != 0) {
            onboarderTitle.setTextColor(page.getTitleColor());
        }

        if (page.getDescriptionColor() != 0) {
            onboarderDescription.setTextColor(page.getDescriptionColor());
        }

        if (page.getTitleColorId() != 0) {
            onboarderTitle.setTextColor(ContextCompat.getColor(context, page.getTitleColorId()));
        }

        if (page.getDescriptionColorId() != 0) {
            onboarderDescription.setTextColor(ContextCompat.getColor(context, page.getDescriptionColorId()));
        }

        if(page.getImageResource()!=null){
            onboarderImage.setImageDrawable(page.getImageResource());
        }

        if (page.getImageResourceId() != 0) {
            onboarderImage.setImageDrawable(AppCompatResources.getDrawable(context, page.getImageResourceId()));
        }

        if (page.getTitleTextSize() != 0f) {
            onboarderTitle.setTextSize(page.getTitleTextSize());
        }

        if (page.getDescriptionTextSize() != 0f) {
            onboarderDescription.setTextSize(page.getDescriptionTextSize());
        }

        if (page.isMultilineDescriptionCentered()) {
            onboarderDescription.setGravity(Gravity.CENTER);
        } else {
            onboarderDescription.setGravity(onboarderDescription.getLineCount() > 1 ? Gravity.START : Gravity.CENTER);
        }

        onboarderImage.getLayoutParams().height = page.getImageHeightPx();
        onboarderImage.getLayoutParams().width = page.getImageWidthPx();
        ((ConstraintLayout.LayoutParams)onboarderImage.getLayoutParams()).verticalBias = page.getImageBias();
        ((ConstraintLayout.LayoutParams)onboarderDescription.getLayoutParams()).bottomMargin = page.getTextPaddingBottomPx();

        container.addView(itemView);

        return itemView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

}