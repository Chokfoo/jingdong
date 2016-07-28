package com.example.jiahao.myapplication.frame;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jiahao.myapplication.R;

/**
 * Created by Jiahao on 2016/7/22.
 */
public class GouWuCheFrame extends android.support.v4.app.Fragment {

    private View view;
    private int[] imageId;
    private String[] text;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frame_gouwuche, null);
        initCode();
        initUI();
        return view;

    }

    private void initCode() {
        imageId = new int[]{R.drawable.daluyouqi,R.drawable.shui,R.drawable.huayin,R.drawable.fengshan,
                R.drawable.daluyouqi,
                R.drawable.daluyouqi,R.drawable.daluyouqi,R.drawable.daluyouqi,
                R.drawable.daluyouqi,R.drawable.daluyouqi,R.drawable.daluyouqi};
        text = new String[]{"[京东超市]话音水淹素颜","[京东超市]话音水淹素颜","[京东超市]话音水淹素颜","[京东超市]话音水淹素颜","[京东超市]话音水淹素颜","[京东超市]话音水淹素颜","[京东超市]话音水淹素颜","[京东超市]话音水淹素颜","[京东超市]话音水淹素颜","[京东超市]话音水淹素颜","[京东超市]话音水淹素颜"};
    }

    private void initUI() {
        GridView gv_tuiJianShangPin = (GridView) view.findViewById(R.id.gv_tuijianshangpin);
        gv_tuiJianShangPin.setAdapter(new MyAdapter());
    }

    private class MyAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return imageId.length;
        }

        @Override
        public Object getItem(int position) {
            return imageId[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder=null;
            if(convertView==null) {
                viewHolder=new ViewHolder();
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_tuijianshangpin, null);
                viewHolder.imageView= (ImageView) convertView.findViewById(R.id.iv_shangpintu);
                viewHolder.tv_JieShao= (TextView) convertView.findViewById(R.id.tv_jieshao);
                viewHolder.tv_Price= (TextView) convertView.findViewById(R.id.tv_price);
                viewHolder.iv_GouWuChe= (ImageView) convertView.findViewById(R.id.iv_tubiao_gouwuche);
                convertView.setTag(viewHolder);
            }
            else{ viewHolder= (ViewHolder) convertView.getTag();}
            viewHolder.imageView.setImageResource(imageId[position]);
            viewHolder.tv_JieShao.setText(text[position]);
            viewHolder.tv_Price.setText("500");
            viewHolder.iv_GouWuChe.setImageResource(R.drawable.tupian_gouwuche);
            return convertView;
        }

        private class ViewHolder {
            ImageView imageView;
            TextView tv_JieShao;
            TextView tv_Price;
            ImageView iv_GouWuChe;

        }
    }
}
