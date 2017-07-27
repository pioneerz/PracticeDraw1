package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice10HistogramView extends View {

    private Paint mLinePaint;
    private Paint mColumnarLinePaint;
    private Paint mTextPaint;
    private Rect mRect;

    private int width = 100;
    private int space = 20;

    private String[] mTitles = {"Froyo","GB","ICS","JB","Kitkat","L","M"};

    private float[] mPts = {100,100,100,600, 100,600,1000,600};
    private float[] mStarts = {170,290,410,530,650,770,890};

    private float[] mPts2 = {mStarts[0],595,mStarts[0],600,
            mStarts[1],580,mStarts[1],600,
            mStarts[2],580,mStarts[2],600,
            mStarts[3],450,mStarts[3],600,
            mStarts[4],320,mStarts[4],600,
            mStarts[5],240,mStarts[5],600,
            mStarts[6],470,mStarts[6],600};


    public Practice10HistogramView(Context context) {
        this(context,null);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }

    private void initPaint() {
        mLinePaint = new Paint();
        mLinePaint.setAntiAlias(true);
        mLinePaint.setColor(Color.WHITE);

        mTextPaint = new Paint();
        mTextPaint.setAntiAlias(true);
        mTextPaint.setColor(Color.WHITE);
        mTextPaint.setTextSize(24);

        mColumnarLinePaint = new Paint();
        mColumnarLinePaint.setColor(Color.GREEN);
        mColumnarLinePaint.setAntiAlias(true);
        mColumnarLinePaint.setStrokeWidth(100);

        mRect = new Rect();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画直方图

        canvas.drawLines(mPts,mLinePaint);

        canvas.drawLines(mPts2,mColumnarLinePaint);

        int count = mTitles.length;
        for (int i=0; i < count; i++) {
            String title = mTitles[i];
            mTextPaint.getTextBounds(title,0,title.length(),mRect);
            canvas.drawText(title,mStarts[i]-mRect.width()/2,630,mTextPaint);
        }
    }
}
