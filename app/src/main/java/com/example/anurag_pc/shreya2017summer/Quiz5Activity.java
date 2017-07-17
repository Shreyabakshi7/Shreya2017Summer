package com.example.anurag_pc.shreya2017summer;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.widget.TextView;

import com.example.anurag_pc.shreya2017summer.util.UtilDensity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Quiz5Activity extends BaseActivity implements View.OnTouchListener{
    private boolean isOpen = false;


    @BindView(R.id.activity_quiz5_bg)
    View view;
    private GestureDetector gestureDetector;

    @BindView(R.id.activity_quiz5_tv)
    TextView tv;
    private ValueAnimator openAnimator;
    private ValueAnimator closeAnimator;
    private com.example.anurag_pc.shreya2017summer.util.UtilDensity UtilDensity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz5);
        ButterKnife.bind(this);
        gestureDetector = new GestureDetector(this, new GestureListener());
        view.setOnTouchListener(this);
        view.setLongClickable(true);
        openAnimator = openAnimatorListener();
        closeAnimator = closeAnimatorListener();
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return gestureDetector.onTouchEvent(motionEvent);
    }

    private class GestureListener extends GestureDetector.SimpleOnGestureListener{

        private boolean isMove = false;
        private int sumX = 0;
        private boolean isSwap = false;
        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            float x = e1.getRawX();
            if (x<100){
                isSwap = true;
            }
            sumX+=distanceX;
            if (!isMove){
                if(sumX<0){
                    if(Math.abs(sumX)>500){
                        if(isSwap){
                            isMove = true;
                            shortToast("left to right");
                            if(!isOpen){
                                openAnimator.start();
                                isOpen=true;
                            }
                        }
                    }
                }
                if(sumX>0){
                    if(Math.abs(sumX)>500){
                        isMove = true;
                        shortToast("right to left");
                        if(isOpen){
                            closeAnimator.start();
                            isOpen=false;
                        }
                    }
                }

            }
            return super.onScroll(e1, e2, distanceX, distanceY);
        }

        @Override
        public boolean onDown(MotionEvent e) {
//            shortToast("onDown");
            isMove = false;
            sumX = 0;
            isSwap = false;
            return super.onDown(e);
        }
    }

    private ValueAnimator openAnimatorListener(){
        ValueAnimator animator = ValueAnimator.ofInt(UtilDensity.dip2px(this,-250), 0);

        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int curValue = (int)animation.getAnimatedValue();
//                tv.layout(tv.getLeft(),curValue,tv.getRight(),curValue+tv.getHeight());
                tv.layout(curValue,tv.getTop(),curValue+tv.getWidth(),tv.getHeight());
            }
        });
        animator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                tv.setVisibility(View.VISIBLE);
            }
            @Override
            public void onAnimationEnd(Animator animation) {
            }
            @Override
            public void onAnimationCancel(Animator animation) {
            }
            @Override
            public void onAnimationRepeat(Animator animation) {
            }
        });
        animator.setDuration(1000);
        return animator;
    }

    private ValueAnimator closeAnimatorListener(){
        ValueAnimator animator = ValueAnimator.ofInt(0,UtilDensity.dip2px(this,-250));

        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int curValue = (int)animation.getAnimatedValue();
//                tv.layout(tv.getLeft(),curValue,tv.getRight(),curValue+tv.getHeight());
                tv.layout(curValue,tv.getTop(),curValue+tv.getWidth(),tv.getHeight());
            }
        });
        animator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                tv.setVisibility(View.VISIBLE);
            }
            @Override
            public void onAnimationEnd(Animator animation) {
                tv.setVisibility(View.INVISIBLE);
            }
            @Override
            public void onAnimationCancel(Animator animation) {
            }
            @Override
            public void onAnimationRepeat(Animator animation) {
            }
        });
        animator.setDuration(1000);
        return animator;
    }


}
