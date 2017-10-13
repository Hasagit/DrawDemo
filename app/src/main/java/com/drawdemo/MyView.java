package com.drawdemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by DengJf on 2017/10/13.
 */

public class MyView extends View {
    private float touch_x=0,touch_y=0;
    private Canvas canvas;


    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                touch_x=event.getX();
                touch_y=event.getY();
                invalidate();
                break;
            case MotionEvent.ACTION_MOVE:
                touch_x=event.getX();
                touch_y=event.getY();
                invalidate();
                break;
            case MotionEvent.ACTION_UP:
                touch_x=0;
                touch_y=0;
                postInvalidate();
                break;
        }
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Paint paint_g=new Paint();
        //透明度为50的绿色画笔
        paint_g.setARGB(50,0,0xff,0);

        //在画板上画一个铺满整个View的绿色矩形
        canvas.drawRect(0,0,getWidth(),getHeight(),paint_g);


        if (touch_x!=0&touch_y!=0){
            Paint paint_r=new Paint();
            paint_r.setARGB(50,0xff,0,0);
            canvas.drawCircle(touch_x,touch_y,getWidth()/4,paint_r);
        }
    }



}
