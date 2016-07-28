package com.example.jiahao.myapplication.frame;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jiahao.myapplication.R;

/**
 * Created by Jiahao on 2016/7/26.
 */
public class TopFrame extends android.support.v4.app.Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.top,container, false);
        return inflate;
    }
}
