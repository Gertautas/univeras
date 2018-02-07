package com.example.gertautasm.lab8;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

import java.util.Random;

/**
 * Created by gertautasm on 2017-12-12.
 */

public class Shape extends View {
    int ii;
    float left,right,bottom,top,radius;
    boolean InitOrNah;

    Paint paint = new Paint();
    Random r = new Random();



    public Shape(Context context, int sk) {
        super(context);
        this.ii = sk;
        paint.setColor( Color.argb(255, r.nextInt(256), r.nextInt(256), r.nextInt(256)));
        paint.setStyle(Paint.Style.FILL);
        InitOrNah = true;

    }

    public void Init(){
        left =  getLeft()+((getRight()-getLeft())/(r.nextInt(6 - 2) + 2));
        top=    getTop()+((getBottom()-getTop())/(r.nextInt(6 - 2) + 2));
        right = getRight()-((getRight()-getLeft())/(r.nextInt(6 - 2) + 2));
        bottom =  getBottom()-((getBottom()-getTop())/(r.nextInt(6 - 2) + 2));
        radius = r.nextInt(200-20)+20;
    }


    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        if(ii==1){
            if(InitOrNah){
                Init();
            }
            canvas.drawCircle(left, top, radius, paint);
        }
        else if(ii==2)
        {

            if(InitOrNah){
                Init();
            }
            canvas.drawRect(left,top,right,bottom,paint);
        }
        else if(ii==3){

            if(InitOrNah){
                paint.setStyle(Paint.Style.STROKE);
                paint.setStrokeWidth(8);
                Init();
            }
            canvas.drawLine(left,top,right,bottom,paint);

        }

    }
    public float getLeftx() {
        return left;
    }

    public float getTopY() {
        return top;
    }

    public float getRightx() {
        return right;
    }

    public float getBottomY() {
        return bottom;
    }


    public float getRadius() {
        return radius;
    }

    public void  setInitOrNah(boolean nah) {
        this.InitOrNah = nah;
    }
    public int getII() {
        return ii;
    }
}