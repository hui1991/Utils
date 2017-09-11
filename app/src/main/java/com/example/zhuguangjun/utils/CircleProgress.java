package com.example.zhuguangjun.utils;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;

/**
 * Created by zhuguangjun on 2017/9/4.
 * 自定义圆形进度条
 */

public class CircleProgress extends View {
    private Paint paint;
    private Paint paintProgress;
    private RectF rectF;
    private Paint textPaint;
    private int width;
    private int height;
    private int strokeWidth;   //圆环的宽度
    private float sweepAngle;
    private int textSize;
    private float progress;

    public CircleProgress(Context context) {
        this(context, null);
    }

    public CircleProgress(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CircleProgress(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        width = getMeasuredWidth();
        height = getMeasuredHeight();
    }

    private void init() {
        textSize = sp2px(getContext(), 25);
        strokeWidth = dip2px(getContext(), 10);
        paint = new Paint();
        //抗锯齿
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(strokeWidth);
        paint.setColor(getResources().getColor(R.color.colorPrimary));

        paintProgress = new Paint();
        paintProgress.setAntiAlias(true);
        paintProgress.setStyle(Paint.Style.STROKE);
        paintProgress.setStrokeWidth(strokeWidth);
        paintProgress.setColor(getResources().getColor(R.color.colorAccent));
        paintProgress.setStrokeCap(Paint.Cap.ROUND);

        textPaint = new Paint();
        textPaint.setAntiAlias(true);
        textPaint.setColor(getResources().getColor(R.color.colorAccent));
        textPaint.setTextSize(textSize);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        rectF = new RectF(strokeWidth, strokeWidth, width - strokeWidth, height - strokeWidth);

        //画背景圆环
        canvas.drawArc(rectF, 0, 360, false, paint);
        //画进度圆环
        canvas.drawArc(rectF, -90, sweepAngle, false, paintProgress);
        //画字
        String text = String.valueOf((int) progress) + "%";
        float textHeight = textPaint.descent()+textPaint.ascent();
        canvas.drawText(text,(width-textPaint.measureText(text))/2, (height-textHeight)/2, textPaint);
    }

    public void setSweepAngle(float sweepAngle) {
        this.sweepAngle = sweepAngle;
        invalidate();
    }

    public float getSweepAngle() {
        return sweepAngle;
    }

    public float getProgress() {
        return progress;
    }

    public void setProgress(float progress) {
        this.progress = progress;
        //invalidate();
    }

    /**
     * 开始动画
     *
     * @param progress
     */
    public void startAnimator(float progress) {
        sweepAngle = (float) (progress * 3.6);
        ObjectAnimator animator = ObjectAnimator.ofFloat(this, "sweepAngle", 0, sweepAngle);
        animator.setDuration(1000);
        animator.setInterpolator(new AccelerateDecelerateInterpolator());
        animator.start();

        ObjectAnimator animatorText = ObjectAnimator.ofFloat(this, "progress", 0, progress);
        animatorText.setDuration(1000);
        animatorText.setInterpolator(new AccelerateDecelerateInterpolator());
        animatorText.start();

    }

    private int dip2px(Context context, float dipValue) {
        float density = context.getResources().getDisplayMetrics().density;
        return (int) (dipValue * density + 0.5f);
    }

    private int sp2px(Context context, float dipValue) {
        float scaledDensity = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (dipValue * scaledDensity + 0.5f);
    }
}
