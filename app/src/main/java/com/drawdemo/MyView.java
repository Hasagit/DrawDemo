package com.drawdemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by DengJf on 2017/10/13.
 */

public class MyView extends View {
    //测试20180403
    //测试2018040302
    private int touch_x=0,touch_y=0;
    private Canvas canvas;
    private List<List<Map<String,Integer>>>dian=new ArrayList<>();

    public MyView(Context context) {
        super(context);
        List<Map<String,Integer>>item=new ArrayList<>();
        dian.add(item);
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        List<Map<String,Integer>>item=new ArrayList<>();
        dian.add(item);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                Map<String,Integer>item_down=new HashMap<>();
                item_down.put("x", (int) event.getX());
                item_down.put("y", (int) event.getY());
                dian.get(dian.size()-1).add(item_down);
                invalidate();
                break;
            case MotionEvent.ACTION_MOVE:
                Map<String,Integer>item_move=new HashMap<>();
                item_move.put("x", (int) event.getX());
                item_move.put("y", (int) event.getY());
                dian.get(dian.size()-1).add(item_move);
                invalidate();
                break;
            case MotionEvent.ACTION_UP:
                List<Map<String,Integer>>item=new ArrayList<>();
                dian.add(item);
                break;
        }
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        /*Paint paint_g=new Paint();
        //透明度为50的绿色画笔
        paint_g.setARGB(50,0,0xff,0);
        canvas.drawRect(0,0,getWidth(),getHeight(),paint_g);
        //在画板上画一个铺满整个View的绿色矩形*/
        Paint paint_r=new Paint();
        paint_r.setStrokeWidth(24);
        paint_r.setARGB(1000,0xff,0,0);
        for (int i=0;i<dian.size();i++){
            List<Map<String,Integer>>item=dian.get(i);
            for (int j=0;j<item.size();j++){
                if (j>0){
                    canvas.drawLine(item.get(j-1).get("x"),item.get(j-1).get("y"),item.get(j).get("x"),item.get(j).get("y"),paint_r);
                    canvas.drawCircle(item.get(j).get("x"),item.get(j).get("y"),12,paint_r);
                }else {
                    canvas.drawLine(item.get(j).get("x"),item.get(j).get("y"),item.get(j).get("x"),item.get(j).get("y"),paint_r);
                    canvas.drawCircle(item.get(j).get("x"),item.get(j).get("y"),12,paint_r);
                }
            }
        }


        /*if (touch_x!=0&touch_y!=0){
            Paint paint_r=new Paint();
            paint_r.setARGB(50,0xff,0,0);
            canvas.drawCircle(touch_x,touch_y,getWidth()/4,paint_r);
        }*/
    }



}
