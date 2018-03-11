package com.example.zhaohuiyan.animationplay.attributeAnimator;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.FloatEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.zhaohuiyan.animationplay.BaseActivity;
import com.example.zhaohuiyan.animationplay.R;

public class AttributeActivity extends BaseActivity {
    ImageView iv_Y;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attribute);
        initView();
        findViewById(R.id.b_Y).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**
                 * 改变一个对象的translationY属性，将其沿着Y轴向上平移一段距离
                 */
                ObjectAnimator.ofFloat(iv_Y,"translationY",-200).setDuration(2000).start();
            }
        });
        findViewById(R.id.b_bounce).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**
                 * 让一个view进行弹跳
                 */
                ValueAnimator bounceAni = ObjectAnimator.ofFloat(iv_Y,"translationY",-200);
                bounceAni.setDuration(700);
                bounceAni.setEvaluator(new FloatEvaluator());
                bounceAni.setRepeatCount(ValueAnimator.INFINITE);
                bounceAni.setRepeatMode(ValueAnimator.REVERSE);
                bounceAni.start();

            }
        });
        findViewById(R.id.b_change_bg).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**
                 * 改变一个对象的背景色属性
                 */
                ValueAnimator colorAnim = ObjectAnimator.ofInt(v,"backgroundColor",
                        0xFFFF8080,0xFF8080FF);
                colorAnim.setDuration(3000);
                colorAnim.setEvaluator(new ArgbEvaluator());
                colorAnim.setRepeatCount(ValueAnimator.INFINITE);
                colorAnim.setRepeatMode(ValueAnimator.REVERSE);
                colorAnim.start();
            }
        });
        findViewById(R.id.b_set).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**
                 * 5秒内对view进行旋转、平移、缩放、透明度变化
                 */
                AnimatorSet set = new AnimatorSet();
                set.playTogether(ObjectAnimator.ofFloat(iv_Y,"rotationX",0,360),
                        ObjectAnimator.ofFloat(iv_Y,"rotationY",0,360),
                        ObjectAnimator.ofFloat(iv_Y,"translationX",0,90),
                        ObjectAnimator.ofFloat(iv_Y,"translationY",0,90),
                        ObjectAnimator.ofFloat(iv_Y,"scaleX",1,1.5f,1),
                        ObjectAnimator.ofFloat(iv_Y,"scaleY",1,0.5f,1),
                        ObjectAnimator.ofFloat(iv_Y,"alpha",1,0.25f,1));
                set.setDuration(5000).start();
            }
        });
        findViewById(R.id.b_xml).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AnimatorSet set = (AnimatorSet) AnimatorInflater.loadAnimator(AttributeActivity.this,
                        R.animator.anim_set);
                set.setTarget(iv_Y);
                set.setDuration(2000);
                set.start();
            }
        });
        findViewById(R.id.b_clear).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**
                 * 清空动画
                 */
                iv_Y.clearAnimation();
            }
        });
        
    }

    @Override
    public void initView() {
        iv_Y = findViewById(R.id.iv_Y);
    }
}
