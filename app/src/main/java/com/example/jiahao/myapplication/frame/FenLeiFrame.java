package com.example.jiahao.myapplication.frame;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.jiahao.myapplication.R;

import java.util.ArrayList;
import java.util.List;


public class FenLeiFrame extends android.support.v4.app.Fragment {

    private String[] items = new String[]{"推荐分类", "潮流女装", "品牌男装", "个护化妆", "家用电器",
            "电脑办公", "手机数码", "母婴童装", "图书音像", "家居家纺", "居家生活"};
    private List<String> listItem = new ArrayList<String>();
    private ListView listView;
    private Context context;
    private static int startIndex = 0;

    private List<Fragment> fragmentList = new ArrayList<Fragment>();
    private FenLeiFrame_Item1 ffi1 = new FenLeiFrame_Item1();
    private FenLeiFrame_Item2 ffi2 = new FenLeiFrame_Item2();
    private FenLeiFrame_Item3 ffi3 = new FenLeiFrame_Item3();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initList();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frame_fenlei, null);
        context = view.getContext();

        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fl_jutifenlei,ffi1);
        ft.commit();

        listView = (ListView) view.findViewById(R.id.lv_fenlei);
        listView.setAdapter(new myListAdapter());

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                Log.d("setOnItemClickListener",position+"+++++++++++");
                listView.getChildAt(startIndex).setBackgroundColor(view.getResources().getColor(R.color.colorWhite));
                listView.getChildAt(position).setBackgroundColor(view.getResources().getColor(R.color.colorGray));
                switch (position) {
                    case 0:
                        ft.replace(R.id.fl_jutifenlei, ffi1);
                        ft.commit();
                        break;
                    case 1:
                        ft.replace(R.id.fl_jutifenlei, ffi2);
                        ft.commit();
                        break;
                    case 2:
                        ft.replace(R.id.fl_jutifenlei, ffi3);
                        ft.commit();
                        break;
                    default:
                        ft.replace(R.id.fl_jutifenlei, ffi3);
                        ft.commit();
                }
                startIndex =position;
            }
        });

        return view;

    }

    private void initList() {

        for (String s : items) {
            listItem.add(s);
        }
        fragmentList.add(ffi1);
        fragmentList.add(ffi2);
        fragmentList.add(ffi3);
    }

    class myListAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return listItem.size();
        }

        @Override
        public Object getItem(int position) {
            return listItem.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = LayoutInflater.from(context).inflate(R.layout.frame_fenlei_list, null);
            TextView item = (TextView) view.findViewById(R.id.tv_fenlei);
            item.setText(listItem.get(position));
            convertView = view;
            return view;
        }
    }
}

