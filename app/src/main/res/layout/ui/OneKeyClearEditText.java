/**
 * Copyright (c) 2016. LPMAS All rights reserved.
 */
package com.lpmas.njb.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;

import com.lpmas.njb.R;

/**
 * 一键删除功能的EditText
 *
 * @author ${Simple}
 * @date ${2016/7/1}
 */
public class OneKeyClearEditText extends EditText implements View.OnFocusChangeListener,
        TextWatcher {

    private Drawable clearDrawable; // 一键删除的按钮
    private int colorAccent;    // 获得主题的颜色
    private int DrawableColor = 0;
    private boolean hasFocus;   // 控件是否有焦点

    public OneKeyClearEditText(Context context) {
        this(context, null);
    }

    public OneKeyClearEditText(Context context, AttributeSet attrs) {
        this(context, attrs, R.attr.editTextStyle);
    }

    @SuppressLint("InlinedApi")
    public OneKeyClearEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray array = context.getTheme().obtainStyledAttributes(new int[]{android.R.attr
                .colorAccent});
        colorAccent = array.getColor(0, 0xFF00FF);
        array.recycle();
        TypedArray array2 = context.obtainStyledAttributes(attrs, R.styleable.OneKeyClearEditText);
        DrawableColor = array2.getColor(R.styleable.OneKeyClearEditText_deletecolor, colorAccent);
        array2.recycle();
        initClearDrawable(context);
    }

    @SuppressLint("NewApi")
    private void initClearDrawable(Context context) {
        clearDrawable = getCompoundDrawables()[2];
        if (clearDrawable == null) {
            clearDrawable = getResources().getDrawable(R.drawable.ic_delete, context.getTheme());
        }
        DrawableCompat.setTint(clearDrawable, DrawableColor);
        clearDrawable.setBounds(0, 0, (int) getTextSize(), (int) getTextSize());
        // 设置Drawable的宽高和TextSize的大小一致
        setClearIconVisible(true);
        // 设置焦点改变的监听
        setOnFocusChangeListener(this);
        // 设置输入框里面内容发生改变的监听
        addTextChangedListener(this);

    }

    /**
     * 设置清除图标的显示与隐藏
     *
     * @param visible
     */
    private void setClearIconVisible(boolean visible) {
        Drawable right = visible ? clearDrawable : null;
        setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], right,
                getCompoundDrawables()[3]);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        if (clearDrawable != null && event.getAction() == MotionEvent.ACTION_UP) {
            int x = (int) event.getX();
            // 判断触摸点是否在水平范围内
            boolean isInnerWidth = (x > (getWidth() - getTotalPaddingRight()))
                    && (x < (getWidth() - getPaddingRight()));
            // 获取删除图标的边界，返回一个Rect对象
            Rect rect = clearDrawable.getBounds();
            // 获取删除图标的高度
            int height = rect.height();
            int y = (int) event.getY();
            // 计算图标底部到控件底部的距离
            int distance = (getHeight() - height) / 2;
            // 判断触摸点是否在竖直范围内
            boolean isInnerHeight = (y > distance) && (y < (distance + height));
            if (isInnerHeight && isInnerWidth) {
                this.setText("");
            }
        }
        return super.onTouchEvent(event);
    }

    @Override
    public void onTextChanged(CharSequence text, int start, int lengthBefore, int lengthAfter) {
        if (hasFocus) {
            setClearIconVisible(text.length() > 0);
        }
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void afterTextChanged(Editable s) {

    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        this.hasFocus = hasFocus;
        if (hasFocus) {
            setClearIconVisible(getText().length() > 0);
        } else {
            setClearIconVisible(false);
        }

    }

}
