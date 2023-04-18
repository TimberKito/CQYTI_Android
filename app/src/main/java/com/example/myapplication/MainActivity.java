package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    // 声明变量及对象
    String userSetId;
    String userSetPass;
    String userId, userPass;

    Button nextButton;
    EditText userGetId;
    EditText userGetPass;
    RadioButton tiaokuan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 变量及对象初始化赋值
        userSetId = "2022231870";
        userSetPass = "123456";
        nextButton = (Button) findViewById(R.id.buttonNext);
        userGetId = (EditText) findViewById(R.id.userId);
        userGetPass = (EditText) findViewById(R.id.userPass);
        tiaokuan = (RadioButton) findViewById(R.id.tiaokuan);
        // 变量及对象的操作

        /*
        按钮三步骤实现点击效果：
        1.注册监听 setOnClickListener()
        2.调用监听接口 OnClickListener()
        3.实现接口函数 onClick(View view)
         */
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 点击执行的操作实现
                // 目前主要实现登录判断
                userId = userGetId.getText().toString();
                userPass = userGetPass.getText().toString();
                // 先判断条款是否勾选
                if (tiaokuan.isChecked()) {
                    // 判断账号是否正确
                    if (userSetId.equals(userId)) {
                        // 判断密码是否正确
                        if (userSetPass.equals(userPass)) {
                            // 登陆成功
                            Toast.makeText(MainActivity.this, "登录成功！", Toast.LENGTH_SHORT).show(); // 消息展示结果(位置，内容，时间)
                            // 跳转页面
                            Intent it = new Intent(MainActivity.this,IndexActivity.class);
                            startActivity(it);
                        } else {
                            // 密码错误
                            Toast.makeText(MainActivity.this, "密码错误！", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        // 账号错误
                        Toast.makeText(MainActivity.this, "账号错误！", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    // 未勾选条款
                    Toast.makeText(MainActivity.this, "请阅读条款！", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}