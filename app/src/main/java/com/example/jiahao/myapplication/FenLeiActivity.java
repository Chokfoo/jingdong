package com.example.jiahao.myapplication;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.jiahao.myapplication.Bean.ShangPin;
import com.example.jiahao.myapplication.frame.CommandFrame;
import com.example.jiahao.myapplication.frame.PlayFrame;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jiahao on 2016/7/21.
 */
public class FenLeiActivity extends Activity {

    private List<String> list;
    private List<ShangPin> shangpinList ;
    private FragmentManager fragmentManager;
    private CommandFrame commandFrame;
    private PlayFrame playFrame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fenlei);
        ListView lvFenlei = (ListView) findViewById(R.id.lv_fenlei);
        list = new ArrayList<String>();
        shangpinList=new ArrayList<ShangPin>();
        fullshangpindata(shangpinList);
        String[] strings={"推荐分类","玩具乐器","内衣配饰","汽车用品","医药保健","及申请去","京东金融","生活旅行","宠物投资","运动户外","酒水饮料","家居建材","居家生活","汽车用品","中标手表","不知道了",
                "不知道了","不知道了","不知道了","不知道了","不知道了","不知道了","不知道了","不知道了"};
        stringToList(strings);

        lvFenlei.setAdapter(new MyAdater(list,FenLeiActivity.this));
       // lvFenlei.setAdapter(new MyShangPinAdater(shangpinList,FenLeiActivity.this));
        fragmentManager = getFragmentManager();
        commandFrame = new CommandFrame();
        playFrame = new PlayFrame();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fl_jutifenlei, commandFrame);
        fragmentTransaction.commit();
        lvFenlei.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                switch (position) {
                    case 0:
                        if(!commandFrame.isAdded())
                        fragmentTransaction.replace(R.id.fl_jutifenlei, commandFrame);

                    case 1:
                        if(!playFrame.isAdded())
                        fragmentTransaction.replace(R.id.fl_jutifenlei, playFrame);

                        break;
                }
                fragmentTransaction.commit();
            }
        });
    }

    public void fullshangpindata(List<ShangPin> list) {
        for(int i=0;i<50;i++) {
            list.add(new ShangPin("商品", "商家", "价格", "备注"));
        }
    }

    private void stringToList(String[] strings) {
        for(String s:strings){
            list.add(s);
        }
    }

    private class MyAdater extends BaseAdapter {
        List<String> strings;
        Context context;
        MyAdater(List<String> s,Context c){
            strings=s;
            context=c;
        }
        @Override
        public int getCount() {
            return strings.size();
        }

        @Override
        public Object getItem(int position) {
            return strings.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder=null;
            if(convertView==null){
                viewHolder=new ViewHolder();
                convertView = LayoutInflater.from(context).inflate(R.layout.list,null);
               viewHolder.textView = (TextView)convertView.findViewById(R.id.tv_fenlei);
                convertView.setTag(viewHolder);

            }else {
                viewHolder= (ViewHolder) convertView.getTag();
            }
            viewHolder.textView.setText(strings.get(position));
            return convertView;

        }
    }
    static class ViewHolder{
        TextView textView;
    }

    private class MyShangPinAdater extends BaseAdapter {
        private List<ShangPin> list;
        private Context context;
        public MyShangPinAdater(List<ShangPin> shangpinList, FenLeiActivity fenLeiActivity) {
            list=shangpinList;
            context=fenLeiActivity;
        }

        @Override
        public int getCount() {
            return shangpinList.size();
        }

        @Override
        public Object getItem(int position) {
            return shangpinList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

                View view = LayoutInflater.from(context).inflate(R.layout.lv_shangpin,null);
                TextView name =(TextView) view.findViewById(R.id.tv_shangpinmingcheng);
                TextView shangjia = (TextView)view.findViewById(R.id.tv_shangjia);
                TextView price = (TextView)view.findViewById(R.id.tv_price);
                TextView beizhu = (TextView)view.findViewById(R.id.tv_beizhu);
                name.setText(list.get(position).getName());
                shangjia.setText(list.get(position).getShangjia());
                price.setText(list.get(position).getPrice());
                beizhu.setText(list.get(position).getBeizhu());



            /*else {
                TextView name =(TextView) convertView.findViewById(R.id.tv_shangpinmingcheng);
                TextView shangjia = (TextView)convertView.findViewById(R.id.tv_shangjia);
                TextView price = (TextView)convertView.findViewById(R.id.tv_price);
                TextView beizhu = (TextView)convertView.findViewById(R.id.tv_beizhu);
                name.setText(list.get(position).getName());
                shangjia.setText(list.get(position).getShangjia());
                price.setText(list.get(position).getPrice());
                beizhu.setText(list.get(position).getBeizhu());
            }*/
            return view;
        }
    }
}
