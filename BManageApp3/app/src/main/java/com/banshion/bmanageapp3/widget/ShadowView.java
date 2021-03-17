package com.banshion.bmanageapp3.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class ShadowView extends View {
    private Paint mPaint;
    public ShadowView(Context context) {
        super(context);
        mPaint = new Paint();
        mPaint.setColor(Color.BLACK);
        this.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
    }

    public ShadowView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ShadowView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public ShadowView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);


    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //绘制阴影，param1：模糊半径；param2：x轴大小：param3：y轴大小；param4：阴影颜色
        mPaint.setShadowLayer(10F, 15F, 15F, Color.GRAY);
        RectF rect = new RectF(0 , 0, 200, 200);
        canvas.drawRoundRect(rect, (float)75, (float)75, mPaint);
    }

}
