package com.example.jiahao.myapplication.frame;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.jiahao.myapplication.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jiahao on 2016/7/22.
 */
public class FaXianFrame extends Fragment {
    private static int startID = 0;

    List<Class> list = new ArrayList<Class>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    HorizontalScrollView horizontalScrollView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frame_faxian, container, false);

        horizontalScrollView = (HorizontalScrollView) view.findViewById(R.id.hsv_faxian_2);
        Display d = getActivity().getWindowManager().getDefaultDisplay();
        DisplayMetrics dm = new DisplayMetrics();
        d.getMetrics(dm);

        final  int screanHalf = d.getWidth()/2;



        final RadioGroup radioGroup = (RadioGroup) view.findViewById(R.id.rg_fenlei_menue);
        final RadioButton rb = (RadioButton) radioGroup.getChildAt(0);
        rb.setTextColor(radioGroup.getResources().getColor(R.color.color_bt_checked));

        final ViewPager vp = (ViewPager) view.findViewById(R.id.vp_faxian);


        vp.setAdapter(new MyvpAdapter(getActivity().getSupportFragmentManager()));
        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        ((RadioButton) radioGroup.getChildAt(0)).setChecked(true);

                        break;
                    case 1:
                        ((RadioButton) radioGroup.getChildAt(1)).setChecked(true);
                        break;
                    case 2:
                        ((RadioButton) radioGroup.getChildAt(2)).setChecked(true);
                        break;
                    case 3:
                        ((RadioButton) radioGroup.getChildAt(3)).setChecked(true);
                        break;
                    case 4:
                        ((RadioButton) radioGroup.getChildAt(4)).setChecked(true);
                        break;
                    case 5:
                        ((RadioButton) radioGroup.getChildAt(5)).setChecked(true);
                        break;
                    case 6:
                        ((RadioButton) radioGroup.getChildAt(6)).setChecked(true);
                        break;


                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        startID = rb.getId();
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int scrollX = horizontalScrollView.getScrollX();
                RadioButton rb = (RadioButton) group.findViewById(checkedId);
                int left = rb.getLeft();
                int leftScreen = left - scrollX;
                horizontalScrollView.smoothScrollBy(leftScreen-screanHalf,0);
                rbChecked(group, checkedId);
                switch (checkedId) {
                    case R.id.rb_faxian_jinxuan:
                        vp.setCurrentItem(0);
                        break;

                    case R.id.rb_faxian_chuanda:
                        vp.setCurrentItem(1);
                        break;
                    case R.id.rb_faxian_zhineng:
                        vp.setCurrentItem(2);
                        break;
                    case R.id.rb_faxian_shj:
                        vp.setCurrentItem(3);
                        break;
                    case R.id.rb_faxian_mz:
                        vp.setCurrentItem(4);
                        break;
                    case R.id.rb_faxian_my:
                        vp.setCurrentItem(5);
                        break;
                    case R.id.rb_faxian_shm:
                        vp.setCurrentItem(6);
                        break;


                }
                startID = checkedId;
            }
        });

        return view;
    }

    private void rbChecked(RadioGroup group, int checkedId) {
        RadioButton rb = (RadioButton) group.findViewById(startID);
        rb.setTextColor(group.getResources().getColor(R.color.color_text_default));
        RadioButton rb2 = (RadioButton) group.findViewById(checkedId);
        rb2.setTextColor(group.getResources().getColor(R.color.color_bt_checked));
    }

    private void init() {
        list.add(FaxianFrame_item1.class);
        list.add(FaxianFrame_item2.class);
        list.add(FaxianFrame_item3.class);
        list.add(FaxianFrame_item4.class);
        list.add(FaxianFrame_item5.class);
        list.add(FaxianFrame_item6.class);
        list.add(FaxianFrame_item6.class);

    }

    private class MyvpAdapter extends FragmentPagerAdapter {

        public MyvpAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            try {
                return (Fragment) list.get(position).newInstance();
            } catch (java.lang.InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            return null;
        }


        @Override
        public int getCount() {
            return list.size();
        }
    }
}
