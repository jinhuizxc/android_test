package com.jh.viewflipper;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.ViewFlipper;

/**
 * ViewFlipper
 *
 * ViewFlipper常用方法：
 *
 * 1.setInAnimation:设置View进入屏幕时候使用动画
 * 2.setOutAnimation：设置View退出屏幕时候使用的动画
 * 3.showNext：调用该函数来显示ViewFlipper里面的上一个View
 * 4.showPrevious：调用该函数来显示ViewFlipper里面的上一个View
 * 5.setFlipInterval：设置View之间切换的时间间隔
 * 6.startFlipping：使用上面设置的时间间隔来开始切换所有的View，切换会循环进行
 * 7.stopFlipping:停止View切换
 */
public class MainActivity extends AppCompatActivity {

    private ViewFlipper flipper;
    private float startX;

    private int [] resId = new int[]{R.drawable.pic1, R.drawable.pic2,
            R.drawable.pic3, R.drawable.pic4};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        flipper = (ViewFlipper) findViewById(R.id.flipper);
        // 动态导入方法为ViewFlipper添加子View
        for (int i = 0; i < resId.length; i++) {
            flipper.addView(getImageView(resId[i]));
        }

         flipper.setBackgroundColor(Color.BLACK);
        // 设置ViewFlipper切换的时间间隔
         flipper.setFlipInterval(3000);
         // 为ViewFlipper添加动画
         flipper.setInAnimation(this, R.anim.left_in);
         flipper.setOutAnimation(this, R.anim.left_out);
         // 开始播放
         flipper.startFlipping();
    }

    private ImageView getImageView(int resId) {
        ImageView image = new ImageView(this);
        image.setBackgroundResource(resId);
        return image;
    }


}
