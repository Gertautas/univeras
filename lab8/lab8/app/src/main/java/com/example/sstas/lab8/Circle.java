package com.example.sstas.lab8;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.media.MediaPlayer;
import android.view.View;
import android.widget.Toast;

/**
 * Created by sstas on 11/20/2017.
 */
public class Circle extends View {
    Paint paint = new Paint();
    float r,Sktest;
    float lenght,height;
    MediaPlayer mPlayer1;
    MediaPlayer mPlayer2;
    public Circle(Context context, float r) {
        super(context);
        this.r = r;
        mPlayer1 = MediaPlayer.create(context, R.raw.correct); // in 2nd param u have to pass your desire ringtone
        mPlayer2 = MediaPlayer.create(context, R.raw.incorrect);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        //canvas.scale(scaleFactor, scaleFactor);
        paint.setColor(Color.parseColor("#CD5C5C"));
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, r , paint);
        canvas.restore();

    }

    public void Calc(Shape view){
        lenght = Math.abs(view.getRightx()-view.getLeftx());
        height= Math.abs(view.getBottomY()-view.getTopY());
        float skers=r*2;
        switch (view.getII()){
            case 1:
                if(r>=view.getRadius()) {
                    Toast.makeText(getContext(), "Telpa.Liko vietos; " + Float.toString(r - view.getRadius()), Toast.LENGTH_LONG).show();
                    mPlayer1.start();
                } else {
                    Toast.makeText(getContext(), "Netilpa.Truksta vietos; " + Float.toString(view.getRadius() - r), Toast.LENGTH_LONG).show();
                    mPlayer2.start();
                }
                break;
            case 2:
                Sktest = (float) Math.hypot(lenght,height);
                if(skers>Sktest){
                    Toast.makeText(getContext(), "Telpa.Liko vietos; " + Float.toString(skers - Sktest), Toast.LENGTH_LONG).show();
                    mPlayer1.start();
                }else {
                    Toast.makeText(getContext(), "Netilpa.Truksta vietos; " + Float.toString(Sktest - skers), Toast.LENGTH_LONG).show();
                    mPlayer2.start();
                }
                break;
            case 3:
                Sktest = (float) Math.hypot(lenght,height);
                if(skers>Sktest){
                    Toast.makeText(getContext(), "Telpa.Liko vietos; " + Float.toString(skers - Sktest), Toast.LENGTH_LONG).show();
                    mPlayer1.start();
                }else {
                    Toast.makeText(getContext(), "Netilpa.Truksta vietos; " + Float.toString(Sktest - skers), Toast.LENGTH_LONG).show();
                    mPlayer2.start();
                }
                break;
            default:
                break;
        }


    }
}