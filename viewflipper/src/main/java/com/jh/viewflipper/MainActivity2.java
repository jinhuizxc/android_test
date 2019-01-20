package com.jh.viewflipper;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewFlipper;

/**
 *
 * 支持手势滑动的ViewFlipper
 *
 */
public class MainActivity2 extends AppCompatActivity {

    private ViewFlipper flipper;
    private float startX;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        flipper = (ViewFlipper) findViewById(R.id.flipper);
        // 动态导入方法为ViewFlipper添加子View
        flipper.addView(getImageView(R.drawable.pic1));
        flipper.addView(getImageView(R.drawable.pic2));
        flipper.addView(getImageView(R.drawable.pic3));
        flipper.addView(getImageView(R.drawable.pic4));

        flipper.setBackgroundColor(Color.BLACK);
        // flipper.setFlipInterval(5000);
        // flipper.setInAnimation(this, R.anim.anim_in);
        // flipper.setOutAnimation(this, R.anim.anim_out);
        // flipper.startFlipping();
        // detector=new GestureDetector(this, this);
    }

    private View getImageView(int resId) {
        ImageView image = new ImageView(this);
        image.setBackgroundResource(resId);
        return image;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            // 手指落下
            case MotionEvent.ACTION_DOWN: {
                startX = event.getX();
                break;
            }
            // 手指滑动
            case  MotionEvent.ACTION_MOVE:{
                break;
            }
            //手指抬起, 不处理
            case MotionEvent.ACTION_UP: {
                // 向右滑动看前一页
                if (event.getX() - startX > 50) {
                    Toast.makeText(this, "向右滑动看前一页", Toast.LENGTH_SHORT).show();
                    flipper.setInAnimation(this, R.anim.left_in);
                    flipper.setOutAnimation(this, R.anim.left_out);
                    flipper.showPrevious();

                }
                // 向左滑动看后一页
                if (startX - event.getX() > 50) {
                    Toast.makeText(this, "向左滑动看后一页", Toast.LENGTH_SHORT).show();
                    flipper.setInAnimation(this, R.anim.right_in);
                    flipper.setOutAnimation(this, R.anim.right_out);
                    flipper.showNext();
                }
                break;
            }
        }

        return super.onTouchEvent(event);

    }

}
