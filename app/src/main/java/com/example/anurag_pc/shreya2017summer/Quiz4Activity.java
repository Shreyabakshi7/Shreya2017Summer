package com.example.anurag_pc.shreya2017summer;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;

import com.example.anurag_pc.shreya2017summer.util.UtilLog;

import java.util.IllegalFormatWidthException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Quiz4Activity extends BaseActivity implements View.OnTouchListener {

    @BindView(R.id.quiz4_tv)
    TextView tv;


    private GestureDetector gestureDetector;
    public float sumX = 0;
    private int sumY = 0;
    private IllegalFormatWidthException view;
    private ValueAnimator repeatAnimator;
    private boolean isToast;
    // private float SumX;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz4);
        ButterKnife.bind(this);
        //repeatAnimator = doAnimatorListener();
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lefttoright();
                righttoleft();
            }
        });


        gestureDetector = new GestureDetector(this, new simpleGestureListener());
        tv.setOnTouchListener(this);
        tv.setFocusable(true);
        tv.setClickable(true);
        tv.setLongClickable(true);


//                TranslateAnimation animation2 = new TranslateAnimation(0, -100, 0, 0);//new TranslateAnimation(xFrom,xTo, yFrom,yTo)
//                // shortToast("Click");
//
//                animation2.setDuration(1000);
//
//                tv.startAnimation(animation2);
    }


    public void lefttoright() {
        TranslateAnimation animation1 = new TranslateAnimation(0, 200, 0, 0);//new TranslateAnimation(xFrom,xTo, yFrom,yTo)
        animation1.setDuration(1000);
        tv.startAnimation(animation1);
    }

    public void righttoleft() {
        TranslateAnimation animation2 = new TranslateAnimation(300, 0, 0, 0);//new TranslateAnimation(xFrom,xTo, yFrom,yTo)
        animation2.setDuration(1000);
        tv.startAnimation(animation2);
    }
    // doAnimatorListener();


    private ValueAnimator doAnimatorListener() {
        ValueAnimator animator = ValueAnimator.ofInt(-100, 0);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int curValue = (int) animation.getAnimatedValue();
                tv.layout(tv.getLeft(), curValue, tv.getRight(), curValue + tv.getHeight());
            }
        });
        animator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                shortToast("Started");
                UtilLog.d("shreya", "animation start");

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                shortToast("Ended");
                UtilLog.d("shreya", "animation Ended");

            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        animator.setRepeatMode(ValueAnimator.REVERSE);
        animator.setRepeatCount(1);
        //animator.setInterpolator(new CycleInterpolator(10));
        animator.setDuration(2000);
        return animator;
    }


    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return gestureDetector.onTouchEvent(event);
    }

    public class simpleGestureListener extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onDown(MotionEvent e) {
            isToast=false;
            return super.onDown(e);
        }

        public simpleGestureListener() {
            super();
        }

        @Override
        public boolean onSingleTapUp(MotionEvent e) {
            return super.onSingleTapUp(e);
        }

        @Override
        public void onLongPress(MotionEvent e) {
            super.onLongPress(e);
        }

        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
//            UtilLog.d("Gesture", "onScroll");
//            UtilLog.d("Gesture", "distanceX:" + distanceX);
//            UtilLog.d("Gesture", "distanceY: " + distanceY);
            sumX += distanceX;
            sumY += distanceY;

            if(isToast!= true) {

                if (sumX < 0) {
                    if (Math.abs(sumX) > 200) {
                        isToast = true;
                        shortToast("left to right");
                    }
                }
                if (sumX > 0) {
                    if (Math.abs(sumX) > 200) {
                        isToast = true;
                        shortToast("right to left");
                    }
                }
                // return super.onSroll(e1,e2,distanceX, distanceY);
            }
            return super.onScroll(e1, e2, distanceX, distanceY);
        }

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
//            if(sumX<0){
//                if(Math.abs(sumX)>200)	{  shortToast(" left to right");}
//            }
//            if(sumX>0){
//                if(Math.abs(sumX)>200)	{  shortToast("right to left");}
//            }
//            if(sumY<0){
//                if(Math.abs(sumX)>200)	{  shortToast("You scroll from top to bottom");}
//            }
//            if(sumY>0){
//                if(Math.abs(sumX)>200)	{  shortToast("You scroll from bottom to top");}
//            }

            return super.onFling(e1, e2, velocityX, velocityY);
        }
        @Override
        public void onShowPress(MotionEvent e) {
            UtilLog.d("Gesture","onShowPress");
            super.onShowPress(e);
        }

//        @Override
//        public boolean onDown(MotionEvent e) {
//            UtilLog.d("Gesture","onDown");
//            return super.onDown(e);
//        }

        @Override
        public boolean onDoubleTap(MotionEvent e) {
            UtilLog.d("Gesture","onDoubleTap");
            return super.onDoubleTap(e);
        }

        @Override
        public boolean onDoubleTapEvent(MotionEvent e) {
            UtilLog.d("Gesture","onDoubleTapEvent");
            return super.onDoubleTapEvent(e);
        }

        @Override
        public boolean onSingleTapConfirmed(MotionEvent e) {
            UtilLog.d("Gesture","onSingleTapConfirmed");
            return super.onSingleTapConfirmed(e);
        }


        }
    }











