package com.example.jiahao.myapplication;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;

import com.example.jiahao.myapplication.frame.FaXianFrame;
import com.example.jiahao.myapplication.frame.FenLeiFrame;
import com.example.jiahao.myapplication.frame.GouWuCheFrame;
import com.example.jiahao.myapplication.frame.HomeFrame;
import com.example.jiahao.myapplication.frame.MeFrame;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jiahao on 2016/7/22.
 */
public class ShouYeActivity extends FragmentActivity {

    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private HomeFrame homeFrame;
    private FenLeiFrame fenLeiFrame;
    private GouWuCheFrame gouWuCheFrame;
    private FaXianFrame faXianFrame;
    private MeFrame meFrame;
    private int[] buttoId = {R.id.bt_home,R.id.bt_fenlei,R.id.bt_gouwuche,R.id.bt_faxian,R.id.bt_me};
    private android.support.v4.app.FragmentManager supportFragmentManager;
    private List<Class> fragmentList;
    private List<Button> buttonList = new ArrayList<Button>();
    private int[] houPicture = {R.drawable.shouyehou,R.drawable.fenleihou,R.drawable.gouwuchehou,R.drawable.faxianhou,R.drawable.mehou};
    private int[] qianPicture = {R.drawable.shouye,R.drawable.fenlei,R.drawable.gouwuche,R.drawable.faxian,R.drawable.me};
    private int mPosition=0;
    private ViewPager vp_context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shouye);
        initCode();
        initUI();
    }

    private void initCode() {

        supportFragmentManager = getSupportFragmentManager();
        fragmentList = new ArrayList<Class>();
        fragmentList.add(HomeFrame.class);
        fragmentList.add(FenLeiFrame.class);
        fragmentList.add(GouWuCheFrame.class);
        fragmentList.add(FaXianFrame.class);
        fragmentList.add(MeFrame.class);

    }

    private void initUI() {
        for (final int i : buttoId) {
            Button button = (Button) findViewById(i);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    switch (i) {
                        case R.id.bt_home:
                            vp_context.setCurrentItem(0);
                            break;
                        case R.id.bt_fenlei:
                            vp_context.setCurrentItem(1);
                            break;
                        case R.id.bt_gouwuche:
                            vp_context.setCurrentItem(2);
                            break;
                        case R.id.bt_faxian:
                            vp_context.setCurrentItem(3);
                            break;
                        case R.id.bt_me:
                            vp_context.setCurrentItem(4);
                            break;

                    }
                }
            });
            buttonList.add(button);
        }
        vp_context = (ViewPager) findViewById(R.id.vp_content);
        vp_context.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                buttonList.get(mPosition).setBackgroundResource(qianPicture[mPosition]);
                mPosition=position;
                buttonList.get(position).setBackgroundResource(houPicture[position]);
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        vp_context.setAdapter(new FragmentPagerAdapter(supportFragmentManager) {
            @Override
            public Fragment getItem(int position) {
                try {
                    return (Fragment) fragmentList.get(position).newInstance();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                return  null;
            }

            @Override
            public int getCount() {
                return fragmentList.size();
            }
        });

    }


    /*public void onClick(View v) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        switch (v.getId()) {
            case R.id.bt_home:
                fragmentTransaction.replace(R.id.fl_content,homeFrame);
                fragmentTransaction.commit();
                break;
            case R.id.bt_fenlei:
                fragmentTransaction.replace(R.id.fl_content,fenLeiFrame);
                fragmentTransaction.commit();
                break;
            case R.id.bt_gouwuche:
                fragmentTransaction.replace(R.id.fl_content,gouWuCheFrame);
                fragmentTransaction.commit();
                break;
            case R.id.bt_faxian:
                fragmentTransaction.replace(R.id.fl_content,faXianFrame);
                fragmentTransaction.commit();
                break;
            case R.id.bt_me:
                fragmentTransaction.replace(R.id.fl_content,meFrame);
                fragmentTransaction.commit();
                break;
        }

    }*/
}

