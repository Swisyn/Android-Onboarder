package com.cuneytayyildiz.onboarder;

import android.graphics.drawable.Drawable;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;

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
    private int titleColor = 0;
    @ColorRes
    private int descriptionColor = 0;
    @ColorRes
    private int backgroundColor = 0;
    private float titleTextSize = 0f;
    private float descriptionTextSize = 0f;
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
        setTitleTextSize(builder.titleTextSize);
        setDescriptionTextSize(builder.descriptionTextSize);
        setMultilineDescriptionCentered(builder.multilineDescriptionCentered);
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

    public void setTitleColor(@ColorRes int color) {
        this.titleColor = color;
    }

    public void setDescriptionColor(@ColorRes int color) {
        this.descriptionColor = color;
    }

    public void setImageResourceId(@DrawableRes int imageResourceId) {
        this.imageResourceId = imageResourceId;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public void setBackgroundColor(@ColorRes int backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public int getBackgroundColor() {
        return backgroundColor;
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
        private int titleColor = 0;
        @ColorRes
        private int descriptionColor = 0;
        @ColorRes
        private int backgroundColor = 0;
        private float titleTextSize = 0f;
        private float descriptionTextSize = 0f;
        private boolean multilineDescriptionCentered;
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

        public Builder titleColor(  @ColorRes int val) {
            titleColor = val;
            return this;
        }

        public Builder descriptionColor(  @ColorRes int val) {
            descriptionColor = val;
            return this;
        }

        public Builder backgroundColor(  @ColorRes int val) {
            backgroundColor = val;
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

        public OnboarderPage build() {
            return new OnboarderPage(this);
        }
    }
}
