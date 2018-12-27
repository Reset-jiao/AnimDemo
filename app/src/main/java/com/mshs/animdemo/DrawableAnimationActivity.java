package com.mshs.animdemo;

import android.graphics.drawable.AnimationDrawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DrawableAnimationActivity extends AppCompatActivity {

    private ImageView ivDrawableAnimation;
    private AnimationDrawable animationDrawable;
    private TextView tvVersion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawable_animation);

        ivDrawableAnimation = findViewById(R.id.iv_drawable_animation);
        tvVersion = findViewById(R.id.tv_version);

        ivDrawableAnimation.setImageResource(R.drawable.list_drawable_anim);

        animationDrawable = (AnimationDrawable) ivDrawableAnimation.getDrawable();
        animationDrawable.start();

//        animationDrawable = (AnimationDrawable) getResources().getDrawable(R.drawable.list_drawable_anim);
//        ivDrawableAnimation.setBackground(animationDrawable);
//        animationDrawable.start();
//
//        tvVersion.setText(Build.VERSION.SDK_INT + "");


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        animationDrawable.stop();
    }
}
