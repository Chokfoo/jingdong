package com.example.jiahao.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private Button denglu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        initUI();
    }

    private void initUI() {
        denglu = (Button) findViewById(R.id.bt_denglu);
        final EditText zhanghao = (EditText) findViewById(R.id.et_zhanghao);
        final EditText mima = (EditText) findViewById(R.id.et_mima);
        Button closeButton = (Button) findViewById(R.id.bt_closebutton);
        Button qq = (Button) findViewById(R.id.bt_qq);
        Button weixin = (Button) findViewById(R.id.bt_weixin);
        TextView qitadenglu = (TextView) findViewById(R.id.tv_qitadenglu);
        TextView wangjimima = (TextView) findViewById(R.id.tv_wangjimima);
        qitadenglu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LoginActivity.this, "有待开发", Toast.LENGTH_LONG).show();

            }
        });
        wangjimima.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LoginActivity.this, "有待开发", Toast.LENGTH_LONG).show();
            }
        });
        qq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LoginActivity.this, "有待测试", Toast.LENGTH_LONG).show();
            }
        });
        weixin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LoginActivity.this, "有待测试", Toast.LENGTH_LONG).show();
            }
        });
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginActivity.this.finish();
            }
        });
        if (denglu != null) {
            denglu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String sZhangHao = zhanghao.getText().toString();
                    String sMiMa = mima.getText().toString();
                    if (TextUtils.isEmpty(sZhangHao) || TextUtils.isEmpty(sMiMa)) {
                        Toast.makeText(LoginActivity.this, "请输入账号密码", Toast.LENGTH_LONG).show();
                    }else {

                        Intent intent = new Intent(LoginActivity.this, ShouYeActivity.class);
                        startActivity(intent);
                    }

                }
            });
        }
    }
}
