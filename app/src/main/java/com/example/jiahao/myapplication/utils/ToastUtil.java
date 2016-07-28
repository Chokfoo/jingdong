package com.example.jiahao.myapplication.utils;

import android.app.Activity;
import android.widget.Toast;

/**
 * Created by Jiahao on 2016/7/21.
 */
public class ToastUtil {
    public static void show(Activity a,String s){
        Toast.makeText(a, s, Toast.LENGTH_SHORT).show();
    }
}
