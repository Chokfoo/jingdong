package com.example.jiahao.myapplication.frame;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jiahao.myapplication.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jiahao on 2016/7/22.
 */
public class HomeFrame extends android.support.v4.app.Fragment {

    private GridView shouye2;
    private View mView;
    private String[] text;
    private int[] id;
    private String[] money;
    private int[] shouye4ID;
    private GridView gv_shouye4;
    private List<ImageView> list;
    private DrawerLayout.LayoutParams layoutParamsVp = new DrawerLayout.LayoutParams(ViewPager.LayoutParams.MATCH_PARENT, ViewPager.LayoutParams.WRAP_CONTENT);
    ;
    private DrawerLayout.LayoutParams layoutParamsDian = new DrawerLayout.LayoutParams(ViewPager.LayoutParams.WRAP_CONTENT, ViewPager.LayoutParams.WRAP_CONTENT);
    ;
    private int[] vpImage = {R.drawable.viewpage, R.drawable.pic2, R.drawable.pic3, R.drawable.pic4};
    private int[] dian = {R.id.iv_dian1, R.id.iv_dian2, R.id.iv_dian3, R.id.iv_dian4};
    private List<ImageView> mList = new ArrayList<ImageView>();
    private ViewPager vp_context;





    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.frame_home,container, false);
        list = new ArrayList<ImageView>();
        FragmentManager fm=getFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.add(R.id.ll_top,new TopFrame());
        ft.commit();
        fullList(vpImage, layoutParamsVp);
        fullList(dian, layoutParamsDian);
        initCode();
        initUI();
        return mView;
    }

    private void initCode() {
        text = new String[]{"京东超市", "全球购", "服装城", "京东生鲜", "京东到家", "充值中心", "领金豆", "领券", "京东金融", "全部"};
        id = new int[]{R.drawable.jingdongchaoshi, R.drawable.quanqiugou,R.drawable.shangxin, R.drawable.shengxian, R.drawable.daojia, R.drawable.chongzhi, R.drawable.jingdou, R.drawable.jingquan, R.drawable.jinrong, R.drawable.quanbu, R.drawable.shangxin};
        money = new String[]{"500", "500", "500", "500", "500", "500", "500", "500", "500", "500", "500"};
        shouye4ID = new int[]{R.drawable.a_y, R.drawable.a_y, R.drawable.a_y, R.drawable.a_y, R.drawable.a_y, R.drawable.a_y, R.drawable.a_y, R.drawable.a_y, R.drawable.a_y, R.drawable.a_y};
    }

    private void initUI() {
        shouye2 = (GridView) mView.findViewById(R.id.gv_shouye2);
        shouye2.setAdapter(new ShouYe2Adapter());

        vp_context = (ViewPager) mView.findViewById(R.id.vp_context);
        vp_context.setAdapter(new VpAdapter());
        vp_context.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                deleteAll();
                mList.get(position).setImageResource(R.drawable.dianhou);
            }

            private void deleteAll() {
                for (ImageView rb : mList) {
                    rb.setImageResource(R.drawable.dian);
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private class ShouYe2Adapter extends BaseAdapter {


        @Override
        public int getCount() {
            return text.length;
        }

        @Override
        public Object getItem(int position) {
            return text[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View itemShouYe2 = View.inflate(getContext(), R.layout.item_shouye2, null);
            ImageView ib_shouye2 = (ImageButton) itemShouYe2.findViewById(R.id.ib_shouye2);
            TextView tv_shouye2 = (TextView) itemShouYe2.findViewById(R.id.tv_shouye2);
            ib_shouye2.setImageResource(id[position]);
            tv_shouye2.setText(text[position]);


            return itemShouYe2;
        }
    }

    private class ShouYe4Adapter extends BaseAdapter {
        @Override
        public int getCount() {
            return money.length;
        }

        @Override
        public Object getItem(int position) {
            return money[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View inflate = View.inflate(getContext(), R.layout.item_shouye4, null);
            ImageView ib_shouye4 = (ImageView) inflate.findViewById(R.id.ib_shouye2);
            TextView tv_shouye4 = (TextView) inflate.findViewById(R.id.tv_shouye2);
            ib_shouye4.setImageResource(shouye4ID[position]);
            tv_shouye4.setText(money[position]);

            return inflate;
        }
    }

    private void fullList(int[] Image, DrawerLayout.LayoutParams layoutParams) {
        if (layoutParams == layoutParamsDian) {
            for (final int i : Image) {
                ImageView dian = (ImageView) mView.findViewById(i);
                dian.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        switch (i) {
                            case R.id.iv_dian1:
                                vp_context.setCurrentItem(0);
                                break;
                            case R.id.iv_dian2:
                                vp_context.setCurrentItem(1);
                                break;
                            case R.id.iv_dian3:
                                vp_context.setCurrentItem(2);
                                break;
                            case R.id.iv_dian4:
                                vp_context.setCurrentItem(3);
                                break;
                        }
                    }
                });
                mList.add(dian);
            }
        } else {
            for (int i : Image) {
                ImageView imageView = new ImageView(getContext());
                imageView.setLayoutParams(layoutParams);
                imageView.setImageResource(i);
                list.add(imageView);
            }
        }
    }
    private class VpAdapter extends PagerAdapter {
        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            ImageView imageView = list.get(position);
            container.addView(imageView);
            return imageView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {

            container.removeView(list.get(position));
        }
    }
}
