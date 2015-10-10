package com.example.xinyang.mytestdemo;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

/**
 * Created by xinyang on 2015/10/10.
 */
public class AutoTextView extends TextSwitcher implements
        ViewSwitcher.ViewFactory {
    private float mTextSize;
    private int mTextColor;
    private Context mContext;
    private Animation mInUp;
    private Animation mOutUp;
    private Animation mInDown;
    private Animation mOutDown;

    public AutoTextView(Context context) {
        this(context, null);
    }

    public AutoTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.auto3d);
        mTextSize = a.getDimension(R.styleable.auto3d_textSize, 20);
        mTextColor = a.getColor(R.styleable.auto3d_textColor, getContext().getResources().getColor(android.R.color.white));
        a.recycle();
        mContext = context;
        init();
    }

    private void init() {
        setFactory(this);
        mInUp = AnimationUtils.loadAnimation(getContext(), R.anim.inup);
        mOutUp = AnimationUtils.loadAnimation(getContext(), R.anim.inout);
        mInDown = AnimationUtils.loadAnimation(getContext(), R.anim.indown);
        mOutDown = AnimationUtils.loadAnimation(getContext(), R.anim.outdown);
        //setInAnimation(mInUp);
        //setOutAnimation(mOutUp);
    }

    //这里返回的TextView，就是我们看到的View
    @Override
    public View makeView() {
        TextView t = new TextView(mContext);
        t.setGravity(Gravity.CENTER);
        t.setTextSize(mTextSize);
        t.setTextColor(mTextColor);
        t.setMaxLines(1);
        return t;
    }

    //定义动作，向下滚动翻页
    public void previous() {
        if (getInAnimation() != mInDown) {
            setInAnimation(mInDown);
        }
        if (getOutAnimation() != mOutDown) {
            setOutAnimation(mOutDown);
        }
    }

    //定义动作，向上滚动翻页
    public void next() {
        if (getInAnimation() != mInUp) {
            setInAnimation(mInUp);
        }
        if (getOutAnimation() != mOutUp) {
            setOutAnimation(mOutUp);
        }
    }

}
