package com.wd.master_of_arts_app.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;

import androidx.appcompat.widget.AppCompatImageView;

public class Img extends AppCompatImageView {
    float x = 1, y = 1;
    double now = 0;
 
    public Img(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
 
    @Override
    protected void onDraw(Canvas canvas) {
        canvas.scale(x, y, getWidth() / 2, getHeight() / 2);
        canvas.save();
        super.onDraw(canvas);
    }
 
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getPointerCount() > 1) {
            double an = Math.sqrt(Math.pow(event.getX(0) - event.getX(1), 2))
                    + Math.sqrt(Math.pow(event.getY(0) - event.getY(1), 2));
            if (now != 0) {
                if (an > now) {
                    if (x < 3) {
                        x += 0.05;
                        y += 0.05;
                        invalidate();
                    }
                } else {
                    if (x > 0.1) {
                        x -= 0.05;
                        y -= 0.05;
                        invalidate();
                    }
                }
            }
 
            now = an;
        }
        return true;
    }
}