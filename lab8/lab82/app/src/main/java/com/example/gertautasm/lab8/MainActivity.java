package com.example.gertautasm.lab8;


import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.RelativeLayout;
import android.widget.ViewFlipper;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements
        GestureDetector.OnGestureListener,
        GestureDetector.OnDoubleTapListener  {

    Shape v1;
    int i = 1;
    int ii = 1;
    Random r;
    private ViewFlipper mFlipper;
    RelativeLayout mLayout;
    RelativeLayout Apskritimas;
    GestureDetectorCompat mGestureDetector;
    Circle circle;
    private static final int SWIPE_MIN_DISTANCE = 120;
    private static final int SWIPE_MAX_OFF_PATH = 250;
    private static final int SWIPE_THRESHOLD_VELOCITY = 200;
    private boolean added;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mLayout = (RelativeLayout)findViewById(R.id.layoutas);
        Apskritimas = (RelativeLayout)findViewById(R.id.apskritimas);

        mFlipper = (ViewFlipper) findViewById(R.id.view_flipper);
        v1 = new Shape(this,2);
        mFlipper.addView(v1);

        mFlipper.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int pointerCount = motionEvent.getPointerCount();
                if(motionEvent.getAction()==MotionEvent.ACTION_DOWN)
                {
                    if (mFlipper.getVisibility() == View.VISIBLE) {
                        v1.setInitOrNah(false);
                        mFlipper.setVisibility(View.INVISIBLE);

                    }
                }
                else if(pointerCount==2){

                    if (mFlipper.getVisibility() == View.VISIBLE) {
                        v1.setInitOrNah(false);
                        mFlipper.setVisibility(View.INVISIBLE);

                    }

                    float x1,x2,y1,y2;
                    x1= motionEvent.getX(0);
                    x2=motionEvent.getX(1);
                    y1=motionEvent.getY(0);
                    y2=motionEvent.getY(1);
                    float r = (float) (Math.sqrt(Math.pow(x2 - x1, 2.0f) + Math.pow(y2 - y1, 2.0f)) / 2.0f);
                    circle = new Circle(getApplicationContext(),r);
                    Apskritimas.addView(circle);
                    added = true;

                }

                else if(motionEvent.getAction()==MotionEvent.ACTION_UP)
                {
                    if(added){
                        Apskritimas.removeAllViews();
                        circle.Calc(v1);
                        added = false;
                    }

                    if (mFlipper.getVisibility() == View.INVISIBLE) {
                        v1.setInitOrNah(false);
                        mFlipper.setVisibility(View.VISIBLE);
                    }
                }
                return true;
            }



        });

        this.mGestureDetector = new GestureDetectorCompat(this,this);
        mGestureDetector.setOnDoubleTapListener(this);

    }



    @Override
    public boolean onTouchEvent(MotionEvent event) {
        this.mGestureDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }


    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {


        return true;
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {

        if (mFlipper.getVisibility() == View.VISIBLE) {
            v1.setInitOrNah(false);
            mFlipper.setVisibility(View.INVISIBLE);
            return true;
        }

        if (mFlipper.getVisibility() == View.INVISIBLE) {
            v1.setInitOrNah(false);
            mFlipper.setVisibility(View.VISIBLE);
            return true;
        }

        return  true;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {return false;}

    @Override
    public boolean onDown(MotionEvent e) {
        return true;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {

        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        if (Math.abs(e1.getY() - e2.getY()) > SWIPE_MAX_OFF_PATH)
            return false;
        if (e1.getX() - e2.getX() > SWIPE_MIN_DISTANCE
                && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {

            mFlipper.setInAnimation(inFromRightAnimation());
            Random r = new Random();
            while (i == ii){
                ii = r.nextInt(3) + 1;
                Log.v("Shape ID"+ ii, "Last Shape" + i);
            }

            Log.v("Shape ID"+ ii, "Last Shape" + i);
            i = ii;
            v1 = new Shape(this,ii);

            mFlipper.addView(v1);
            mFlipper.setOutAnimation(outToLeftAnimation());
            mFlipper.showNext();
        } else if (e2.getX() - e1.getX() > SWIPE_MIN_DISTANCE
                && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
            mFlipper.setInAnimation(inFromLeftAnimation());
            mFlipper.setOutAnimation(outToRightAnimation());
            mFlipper.showPrevious();
        }
        return true;
    }


    private Animation inFromRightAnimation() {
        Animation inFromRight = new TranslateAnimation(
                Animation.RELATIVE_TO_PARENT, +1.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f);
        inFromRight.setDuration(200);
        inFromRight.setInterpolator(new AccelerateInterpolator());
        return inFromRight;
    }

    private Animation outToLeftAnimation() {
        Animation outtoLeft = new TranslateAnimation(
                Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, -1.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f);
        outtoLeft.setDuration(200);
        outtoLeft.setInterpolator(new AccelerateInterpolator());
        return outtoLeft;
    }

    private Animation inFromLeftAnimation() {
        Animation inFromLeft = new TranslateAnimation(
                Animation.RELATIVE_TO_PARENT, -1.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f);
        inFromLeft.setDuration(200);
        inFromLeft.setInterpolator(new AccelerateInterpolator());
        return inFromLeft;
    }

    private Animation outToRightAnimation() {
        Animation outtoRight = new TranslateAnimation(
                Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, +1.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f);
        outtoRight.setDuration(200);
        outtoRight.setInterpolator(new AccelerateInterpolator());
        return outtoRight;
    }



}
