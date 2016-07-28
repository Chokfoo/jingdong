package com.example.jiahao.myapplication.layout;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.jiahao.myapplication.R;

/**
 * Created by Jiahao on 2016/7/28.
 */
public class ShangPinLinerLayout extends LinearLayout {
    private static final String TAG ="what" ;
    private final String NAMESPACE="http://schemas.android.com/apk/res/com.example.jiahao.myapplication";
    public ShangPinLinerLayout(Context context) {
        super(context);
        View inflate = LayoutInflater.from(context).inflate(R.layout.layout_shangpin, null);
        addView(inflate);

    }

    public ShangPinLinerLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        View inflate = LayoutInflater.from(context).inflate(R.layout.layout_shangpin, null);
        TypedArray typedArray = context.
                obtainStyledAttributes( attrs,R.styleable.com_example_jiahao_myapplication_layout_ShangPinLinerLayout);
        int drawable = typedArray.getResourceId(R.styleable.com_example_jiahao_myapplication_layout_ShangPinLinerLayout_shangpintupian,0);
        String jiage = typedArray.getString(R.styleable.com_example_jiahao_myapplication_layout_ShangPinLinerLayout_shangpinjiage);
        String yuanjia = typedArray.getString(R.styleable.com_example_jiahao_myapplication_layout_ShangPinLinerLayout_shangpinyuanjia);
        ImageView im_shangpintu = (ImageView) inflate.findViewById(R.id.iv_shangpintu);
        TextView tv_shangpinyuanjia = (TextView) inflate.findViewById(R.id.tv_shangpinyuanjia);
        TextView tv_shangpinjiage = (TextView) inflate.findViewById(R.id.tv_shangpinjiage);
        im_shangpintu.setBackgroundResource(drawable);
        Log.d("dsf", drawable+"");
        tv_shangpinjiage.setText(jiage);
        tv_shangpinyuanjia.setText(yuanjia);
        addView(inflate);
    }


    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public ShangPinLinerLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }


    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public ShangPinLinerLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);


    }
}
