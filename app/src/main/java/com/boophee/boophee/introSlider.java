package com.boophee.boophee;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Window;
import android.view.WindowManager;

import com.github.paolorotolo.appintro.AppIntro;
import com.github.paolorotolo.appintro.AppIntroFragment;

/**
 * Created by uday on 31/3/18.
 */

public class introSlider extends AppIntro {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        addSlide(AppIntroFragment.newInstance("Need Revision","You need Revisions for your Study Boophee Question cards is here to help you ",
                R.drawable.bopphee_1, Color.parseColor("#7CB342")));
        addSlide(AppIntroFragment.newInstance("Exercise you Mind ","Give your mind an Exercise with the help of Boophee Flip Function",
                R.drawable.bophee_2,Color.parseColor("#03A9F4") ));
        addSlide(AppIntroFragment.newInstance("Stand Out","Boophee helps you stand out of crowd",R.drawable.boophee_3,Color.parseColor("#FF9800")));
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        setFadeAnimation();
        setSeparatorColor(Color.parseColor("#2196F3"));

        // Hide Skip/Done button.
        showSkipButton(true);
        setProgressButtonEnabled(true);

    }

    @Override
    public void onSkipPressed(Fragment currentFragment) {
        super.onSkipPressed(currentFragment);
        // Do something when users tap on Skip button.
    }

    @Override
    public void onDonePressed(Fragment currentFragment) {
        super.onDonePressed(currentFragment);
        startActivity(new Intent(introSlider.this,CardSwipeActivity.class));
    }

    @Override
    public void onSlideChanged(@Nullable Fragment oldFragment, @Nullable Fragment newFragment) {
        super.onSlideChanged(oldFragment, newFragment);
        // Do something when the slide changes.
    }
}
