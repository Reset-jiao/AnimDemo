package com.mshs.animdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvViewAnimation;
    private TextView tvDrawableAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        /**
         * 动画分类:
         * 1.View Animation :视图动画，只能被用来设置View动画；
         * 2.Drawable Animation:(Frame动画，帧动画)可以划分为视图动画的类别，
         *   专门显示一个个Drawable的Resource,就像播放幻灯片一样；
         * 3.Property Animation:属性动画，只对Android 3.0（API 11）以上版本
         *   系统有效，这种动画可以设置给任何Object,包括那些没有渲染到屏幕上的
         *   对象。这种动画是可扩展的，可以让你自定义任何类型和属性的动画；
         */

        /**
         * View Animation: 视图动画
         * 也叫补间动画(Tween),可以实现一系列简单变换(位置，大小，旋转，透明)。
         * 补间动画可以通过xml或Android代码定义，建议使用xml定义，因为具有可读性，可重用性。
         */

        /**
         * AlphaAnimation: <alpha>放置在res/anim/目录下，渐变透明动画效果；
         * RotateAnimation: <rotate>放置在res/anim/目录下，画面转移转动动画效果；
         * ScaleAnimation: <scale> 放置在res/anim/目录下, 渐变尺寸伸缩动画效果;
         * TranslateAnimation: <translate> 放置在res/anim/目录下, 画面转换位置移动动画效果;
         * AnimationSet: <set> 放置在res/anim/目录下, 一个持有其它动画元素alpha、scale、translate、rotate或者其它set元素的容器;
         */

        /**
         * Animation:抽象类是所有补间动画类的基类:
         * android:detachWallpaper: setDetachWallpaper(boolean):是否在壁纸上运行;
         * android:duration: setDuration(long): 动画持续时间，毫秒为单位;
         * android:fillAfter： setFillAfter(boolean)：控件动画结束时是否保持动画最后的状态；
         * android:fillBefore：setFillBefore(boolean)：控件动画结束时是否还原到开始动画前的状态；
         * android:fillEnabled：setFillEnabled(boolean)：与android:fillBefore效果相同；
         * android:interpolator： setInterpolator(Interpolator)：设定插值器（指定的动画效果，譬如回弹等）；
         * android:repeatCount： setRepeatCount(int)： 重复次数；
         * android:repeatMode： setRepeatMode(int)：重复类型有两个值，reverse表示倒序回放，restart表示从头播放；
         * android:startOffset：setStartOffset(long)：调用start函数之后等待开始运行的时间，单位为毫秒；
         * android:zAdjustment：setZAdjustment(int)：表示被设置动画的内容运行时在Z轴上的位置（top/bottom/normal），默认为normal；
         */

        /**
         * Alpha:
         * android:fromAlpha: AlphaAnimation(float fromAlpha, …) 动画开始的透明度（0.0到1.0，0.0是全透明，1.0是不透明）;
         * android:toAlpha: AlphaAnimation(…, float toAlpha) 动画结束的透明度，同上;
         */

        /**
         * Rotate:
         * android:fromDegrees: RotateAnimation(float fromDegrees, …): 旋转开始角度，正代表顺时针度数，负代表逆时针度数;
         * android:toDegrees: RotateAnimation(…, float toDegrees, …):旋转结束角度，正代表顺时针度数，负代表逆时针度数;
         * android:pivotX: RotateAnimation(…, float pivotX, …): 缩放起点X坐标（数值、百分数、百分数p，
         *                                                      譬如50表示以当前View左上角坐标加50px为初始点、50%表示以当前View的左上角加上当前View宽高的50%做为初始点、50%p表示以当前View的左上角加上父控件宽高的50%做为初始点）;
         * android:pivotY: RotateAnimation(…, float pivotY): 缩放起点Y坐标，同上规律;
         */

        /**
         * Scale:
         * android:fromXScale: ScaleAnimation(float fromX, …): 初始X轴缩放比例，1.0表示无变化;
         * android:toXScale: ScaleAnimation(…, float toX, …): 结束X轴缩放比例;
         * android:fromYScale: ScaleAnimation(…, float fromY, …): 初始Y轴缩放比例;
         * android:toYScale: ScaleAnimation(…, float toY, …): 结束Y轴缩放比例;
         * android:pivotX: ScaleAnimation(…, float pivotX, …): 缩放起点X轴坐标（数值、百分数、百分数p，譬如50表示以当前View左上角坐标加50px为初始点、50%表示以当前View的左上角加上当前View宽高的50%做为初始点、
         *                                                     50%p表示以当前View的左上角加上父控件宽高的50%做为初始点）;
         * android:pivotY: ScaleAnimation(…, float pivotY): 缩放起点Y轴坐标，同上规律
         */

        /**
         *  Translate:
         * android:fromXDelta: TranslateAnimation(float fromXDelta, …): 起始点X轴坐标（数值、百分数、百分数p，譬如50表示以当前View左上角坐标加50px为初始点、
         *                                                              50%表示以当前View的左上角加上当前View宽高的50%做为初始点、50%p表示以当前View的左上角加上父控件宽高的50%做为初始点）
         * android:fromYDelta: TranslateAnimation(…, float fromYDelta, …): 起始点Y轴从标，同上规律;
         * android:toXDelta: TranslateAnimation(…, float toXDelta, …): 结束点X轴坐标，同上规律;
         * android:toYDelta: TranslateAnimation(…, float toYDelta): 结束点Y轴坐标，同上规律;
         * /


         /**
         *  AnimationSet:
         *  AnimationSet继承自Animation，是上面四种的组合容器管理类，没有自己特有的属性，他的属性继承自Animation，所以特别注意，
         *  当我们对set标签使用Animation的属性时会对该标签下的所有子控件都产生影响。
         *
         */

        /**
         * 特别特别注意：补间动画执行之后并未改变View的真实布局属性值。
         * 切记这一点，譬如我们在Activity中有一个 Button在屏幕上方，我们设置了平移动画移动到屏幕下方然后保持动画最后执行状态呆在屏幕下方，
         * 这时如果点击屏幕下方动画执行之后的Button是没 有任何反应的，而点击原来屏幕上方没有Button的地方却响应的是点击Button的事件。
         */


    }

    private void initView() {
        tvViewAnimation = findViewById(R.id.tv_view_Animation);
        tvViewAnimation.setOnClickListener(this);
        tvDrawableAnimation = findViewById(R.id.tv_Drawable_Animation);
        tvDrawableAnimation.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_view_Animation:
                Intent intent = new Intent(this, ViewAnimationActivity.class);
                startActivity(intent);
                break;
            case R.id.tv_Drawable_Animation:
                startActivity(new Intent(this, DrawableAnimationActivity.class));
                break;
        }
    }
}
