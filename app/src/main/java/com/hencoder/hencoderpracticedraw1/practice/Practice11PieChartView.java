package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice11PieChartView extends View {

    private Paint mTextPaint;
    private Paint mLinePaint;
    private Paint mArcPaint;

    private RectF mRectRed;
    private RectF mRectOther;

    private Rect mRect;
    private Path mPath;

    private String[] mTitles = {"Froyo","Gingerbread","Ice Cream Sandwich","Jelly Bean","Kitkat","Lollipop","Marshmallow"};

    public Practice11PieChartView(Context context) {
        this(context,null);
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }

    private void initPaint() {
        mTextPaint = new Paint();
        mTextPaint.setAntiAlias(true);
        mTextPaint.setTextSize(28);
        mTextPaint.setColor(Color.WHITE);

        mLinePaint = new Paint();
        mLinePaint.setAntiAlias(true);
        mLinePaint.setColor(Color.GRAY);
        mLinePaint.setStrokeWidth(4);

        mArcPaint = new Paint();
        mArcPaint.setAntiAlias(true);
        mArcPaint.setColor(Color.WHITE);
        mArcPaint.setStyle(Paint.Style.FILL);

        mRect = new Rect();
        mPath = new Path();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画饼图

        // 没有考虑Rect在ondraw里面初始化的情况(有问题)
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        int radius;
        int widthRadius;
        int heightRadius;
        if (width>height) {
            radius = (height-200)/2;
        } else {
            radius = (width-200)/2;
        }
        widthRadius = width/2-50;
        heightRadius = height/2-50;
        mRectRed = new RectF(widthRadius-20-radius,heightRadius-20-radius,
                widthRadius-20+radius,heightRadius-20+radius);

        mRectOther = new RectF(widthRadius-radius,heightRadius-radius,
                widthRadius+radius,heightRadius+radius);

        canvas.drawText(mTitles[5],5,50,mTextPaint);
        mTextPaint.getTextBounds(mTitles[5],0,mTitles[5].length(),mRect);
        canvas.drawLine(mRect.width()+ 15,mRect.height()+30,mRect.width()+ 230,mRect.height()+30,mLinePaint);
        canvas.drawLine(mRect.width()+ 230,mRect.height()+30,mRect.width()+ 250,mRect.height()+50,mLinePaint);


        mArcPaint.setColor(Color.RED);
        canvas.drawArc(mRectRed,-180,120,true,mArcPaint);

        mArcPaint.setColor(Color.YELLOW);
        canvas.drawArc(mRectOther,-60,60,true,mArcPaint);

        mArcPaint.setColor(Color.GREEN);
        canvas.drawArc(mRectOther,0,5,true,mArcPaint);

        mArcPaint.setColor(Color.LTGRAY);
        canvas.drawArc(mRectOther,5,10,true,mArcPaint);

        mArcPaint.setColor(Color.YELLOW);
        canvas.drawArc(mRectOther,15,10,true,mArcPaint);

        mArcPaint.setColor(Color.CYAN);
        canvas.drawArc(mRectOther,25,45,true,mArcPaint);

        mArcPaint.setColor(Color.BLUE);
        canvas.drawArc(mRectOther,70,110,true,mArcPaint);
    }
}
