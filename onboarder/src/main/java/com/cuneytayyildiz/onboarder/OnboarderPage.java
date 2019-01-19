package com.cuneytayyildiz.onboarder;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;

public class OnboarderPage {

    private String title;
    private String description;
    private Drawable imageResource;
    @StringRes
    private int titleResourceId = 0;
    @StringRes
    private int descriptionResourceId = 0;
    @DrawableRes
    private int imageResourceId = 0;
    @ColorRes
    private int titleColorId = 0;
    @ColorRes
    private int descriptionColorId = 0;
    @ColorRes
    private int backgroundColorId = 0;
    private int titleColor;
    private int descriptionColor;
    private int backgroundColor;
    private float titleTextSize = 0f;
    private float descriptionTextSize = 0f;
    private int imageWidthPx = ViewGroup.LayoutParams.WRAP_CONTENT;
    private int imageHeightPx = ViewGroup.LayoutParams.WRAP_CONTENT;
    private boolean multilineDescriptionCentered;

    private OnboarderPage(Builder builder) {
        title = builder.title;
        description = builder.description;
        imageResource = builder.imageResource;
        titleResourceId = builder.titleResourceId;
        descriptionResourceId = builder.descriptionResourceId;
        setImageResourceId(builder.imageResourceId);
        setTitleColor(builder.titleColor);
        setDescriptionColor(builder.descriptionColor);
        setBackgroundColor(builder.backgroundColor);
        setTitleColorId(builder.titleColorId);
        setDescriptionColorId(builder.descriptionColorId);
        setBackgroundColorId(builder.backgroundColorId);
        setTitleTextSize(builder.titleTextSize);
        setDescriptionTextSize(builder.descriptionTextSize);
        setMultilineDescriptionCentered(builder.multilineDescriptionCentered);
        setImageHeightPx(builder.imageHeightPx);
        setImageWidthPx(builder.imageWidthPx);
    }

    public String getTitle() {
        return title;
    }

    public int getTitleResourceId() {
        return titleResourceId;
    }

    public String getDescription() {
        return description;
    }

    public int getDescriptionResourceId() {
        return descriptionResourceId;
    }

    public int getTitleColor() {
        return titleColor;
    }

    public int getDescriptionColor() {
        return descriptionColor;
    }

    public int getBackgroundColor() {
        return backgroundColor;
    }

    public int getTitleColorId() {
        return titleColorId;
    }

    public int getDescriptionColorId() {
        return descriptionColorId;
    }

    public int getBackgroundColorId() {
        return backgroundColorId;
    }

    public void setTitleColor(int titleColor) {
        this.titleColor = titleColor;
    }

    public void setTitleColorId(@ColorRes int color) {
        this.titleColorId = color;
    }

    public void setDescriptionColorId(@ColorRes int color) {
        this.descriptionColorId = color;
    }

    public void setDescriptionColor(int descriptionColor) {
        this.descriptionColor = descriptionColor;
    }

    public void setImageResourceId(@DrawableRes int imageResourceId) {
        this.imageResourceId = imageResourceId;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public void setBackgroundColor(int backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public void setBackgroundColorId(@ColorRes int backgroundColor) {
        this.backgroundColorId = backgroundColor;
    }


    public float getTitleTextSize() {
        return titleTextSize;
    }

    public void setTitleTextSize(float titleTextSize) {
        this.titleTextSize = titleTextSize;
    }

    public float getDescriptionTextSize() {
        return descriptionTextSize;
    }

    public void setDescriptionTextSize(float descriptionTextSize) {
        this.descriptionTextSize = descriptionTextSize;
    }

    public boolean isMultilineDescriptionCentered() {
        return multilineDescriptionCentered;
    }

    public void setMultilineDescriptionCentered(boolean multilineDescriptionCentered) {
        this.multilineDescriptionCentered = multilineDescriptionCentered;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Drawable getImageResource() {
        return imageResource;
    }

    public void setImageResource(Drawable imageResource) {
        this.imageResource = imageResource;
    }

    public void setTitleResourceId(@StringRes int titleResourceId) {
        this.titleResourceId = titleResourceId;
    }

    public void setDescriptionResourceId(@StringRes int descriptionResourceId) {
        this.descriptionResourceId = descriptionResourceId;
    }

    public void setImageHeightPx(int imageHeightPx) {
        this.imageHeightPx = imageHeightPx;
    }

    public void setImageWidthPx(int imageWidthPx) {
        this.imageWidthPx = imageWidthPx;
    }

    public int getImageHeightPx() {
        return imageHeightPx;
    }

    public int getImageWidthPx() {
        return imageWidthPx;
    }

    public static final class Builder {
        private String title;
        private String description;
        private Drawable imageResource;
        @StringRes
        private int titleResourceId = 0;
        @StringRes
        private int descriptionResourceId = 0;
        @DrawableRes
        private int imageResourceId = 0;
        @ColorRes
        private int titleColorId = 0;
        @ColorRes
        private int descriptionColorId = 0;
        @ColorRes
        private int backgroundColorId = 0;
        private int titleColor;
        private int descriptionColor;
        private int backgroundColor;
        private float titleTextSize = 0f;
        private float descriptionTextSize = 0f;
        private boolean multilineDescriptionCentered;
        int imageWidthPx = ViewGroup.LayoutParams.WRAP_CONTENT;
        int imageHeightPx = ViewGroup.LayoutParams.WRAP_CONTENT;
        public Builder() {
        }

        public Builder title(String val) {
            title = val;
            return this;
        }

        public Builder description(String val) {
            description = val;
            return this;
        }

        public Builder imageResource(Drawable val) {
            imageResource = val;
            return this;
        }

        public Builder titleResourceId(@StringRes  int val) {
            titleResourceId = val;
            return this;
        }

        public Builder descriptionResourceId( @StringRes int val) {
            descriptionResourceId = val;
            return this;
        }

        public Builder imageResourceId(  @DrawableRes int val) {
            imageResourceId = val;
            return this;
        }

        public Builder titleColorId(  @ColorRes int val) {
            titleColorId = val;
            return this;
        }

        public Builder titleColor(int color){
            titleColor = color;
            return this;
        }

        public Builder descriptionColorId(  @ColorRes int val) {
            descriptionColorId = val;
            return this;
        }

        public Builder descriptionColor(int color){
            descriptionColor = color;
            return this;
        }

        public Builder backgroundColorId(  @ColorRes int val) {
            backgroundColorId = val;
            return this;
        }

        public Builder backgroundColor(int color){
            backgroundColor = color;
            return this;
        }

        public Builder titleTextSize(float val) {
            titleTextSize = val;
            return this;
        }

        public Builder descriptionTextSize(float val) {
            descriptionTextSize = val;
            return this;
        }

        public Builder multilineDescriptionCentered(boolean val) {
            multilineDescriptionCentered = val;
            return this;
        }

        public Builder imageSizePx(int width, int height){
            imageWidthPx = width;
            imageHeightPx = height;
            return this;
        }

        public Builder imageSizeDp(int width, int height){
            final float scale = Resources.getSystem().getDisplayMetrics().density;
            imageWidthPx = Math.round(width*scale);
            imageHeightPx = Math.round(height*scale);
            return this;
        }

        public OnboarderPage build() {
            return new OnboarderPage(this);
        }


    }
}
