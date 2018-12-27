package com.mshs.animdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class ViewAnimationActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvAlpha;
    private TextView tvAlpha2;
    private TextView tvStop;
    private TextView tvAll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_animation);

        initView();
    }

    private void initView() {
        tvAlpha = findViewById(R.id.tv_alpha);
        tvAlpha.setOnClickListener(this);
        tvAlpha2 = findViewById(R.id.tv_alpha2);
        tvAlpha2.setOnClickListener(this);
        tvStop = findViewById(R.id.tv_stop);
        tvStop.setOnClickListener(this);
        tvAll = findViewById(R.id.tv_all);
        tvAll.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_alpha:
                Animation alphaAnimation = AnimationUtils.loadAnimation(this, R.anim.alpha_test);
                alphaAnimation.setDuration(3000);
                alphaAnimation.setRepeatCount(-1);
                tvAlpha.startAnimation(alphaAnimation);
                break;
            case R.id.tv_alpha2:
                float from = 1, to = (float) 0.5;
                Animation a = new AlphaAnimation(from, to);
                a.setDuration(1000);
                a.setRepeatCount(-1);
                tvAlpha2.startAnimation(a);
                break;
            case R.id.tv_stop:
                tvAlpha.clearAnimation();
                tvAlpha2.clearAnimation();
                tvAll.clearAnimation();
                break;
            case R.id.tv_all:
                Animation b = AnimationUtils.loadAnimation(this, R.anim.test_set);
                b.setDuration(13000);
                b.setRepeatCount(10);
                tvAll.startAnimation(b);
                break;
        }
    }
}
