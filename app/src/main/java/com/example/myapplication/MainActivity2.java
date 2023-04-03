package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {

    /*
        定义对象及变量
     */ EditText result;
    Button bt_0;
    Button bt_1;
    Button bt_2;
    Button bt_3;
    Button bt_4;
    Button bt_5;
    Button bt_6;
    Button bt_7;
    Button bt_8;
    Button bt_9;
    Button bt_jia;
    Button bt_jian;
    Button bt_chen;
    Button bt_chu;
    Button bt_deng;
    Button bt_mc;
    Button bt_mr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        /*
            初始化变量及对象
         */
        result = findViewById(R.id.result); //EditText 1.getText()获取文本 2.setText()设置文本
        bt_0 = findViewById(R.id.bt_0); //Button 注册监听
        bt_1 = findViewById(R.id.bt_1);
        bt_2 = findViewById(R.id.bt_2);
        bt_3 = findViewById(R.id.bt_3);
        bt_4 = findViewById(R.id.bt_4);
        bt_5 = findViewById(R.id.bt_5);
        bt_6 = findViewById(R.id.bt_6);
        bt_7 = findViewById(R.id.bt_7);
        bt_8 = findViewById(R.id.bt_8);
        bt_9 = findViewById(R.id.bt_9);
        bt_jia = findViewById(R.id.bt_jia);
        bt_jian = findViewById(R.id.bt_jian);
        bt_chen = findViewById(R.id.bt_chen);
        bt_chu = findViewById(R.id.bt_chu);
        bt_deng = findViewById(R.id.bt_deng);
        bt_mc = findViewById(R.id.bt_mc);
        bt_mr = findViewById(R.id.bt_mr);

        /*
            操作使用变量
         */
        bt_0.setOnClickListener(this);
        bt_1.setOnClickListener(this);
        bt_2.setOnClickListener(this);
        bt_3.setOnClickListener(this);
        bt_4.setOnClickListener(this);
        bt_5.setOnClickListener(this);
        bt_6.setOnClickListener(this);
        bt_7.setOnClickListener(this);
        bt_8.setOnClickListener(this);
        bt_9.setOnClickListener(this);
        bt_jia.setOnClickListener(this);
        bt_jian.setOnClickListener(this);
        bt_chen.setOnClickListener(this);
        bt_chu.setOnClickListener(this);
        bt_deng.setOnClickListener(this);
        bt_mc.setOnClickListener(this);
        bt_mr.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        /*
            实现按钮监听
         */
        String srt = result.getText().toString();
        switch (view.getId()) {
            case R.id.bt_0:
            case R.id.bt_1:
            case R.id.bt_2:
            case R.id.bt_3:
            case R.id.bt_4:
            case R.id.bt_5:
            case R.id.bt_6:
            case R.id.bt_7:
            case R.id.bt_8:
            case R.id.bt_9:
                result.setText(srt + ((Button) (view)).getText().toString());
                break;
            case R.id.bt_jia:
            case R.id.bt_jian:
            case R.id.bt_chen:
            case R.id.bt_chu:
                // 添加空格，基于第一个空格字符索引位就可以快速找到运算符号以及两个数值
                result.setText(srt + " " + ((Button) (view)).getText().toString() + " ");
                break;
            case R.id.bt_deng:
                // 执行运算
                getResult();
                break;
            case R.id.bt_mc:
                result.setText("");
                break;
            case R.id.bt_mr:
                if (srt.length() == 0) {
                    break;
                }
                result.setText(srt.substring(0, srt.length() - 1));
        }
    }

    public void getResult() {
        String srt = result.getText().toString();
        // 判空
        if (srt.length() == 0) {
            Toast.makeText(MainActivity2.this, "请输入数值进行计算", Toast.LENGTH_SHORT).show();
        } else {
            // 基于第一个空格字符索引位indexOf(" ") 就可以快速找到运算符号以及两个数值
            // 拆分第一个数值 subString(a,b) [a,b) (a,b]
            String num1 = srt.substring(0, srt.indexOf(" "));
            // Toast.makeText(MainActivity2.this,num1,Toast.LENGTH_SHORT).show();
            // 拆分运算符
            String op = srt.substring(srt.indexOf(" ") + 1, srt.indexOf(" ") + 2);
            // Toast.makeText(MainActivity2.this,op,Toast.LENGTH_SHORT).show();
            // 拆分第二个数值
            String num2 = srt.substring(srt.indexOf(" ") + 3, srt.length());
            // Toast.makeText(MainActivity2.this, num2, Toast.LENGTH_SHORT).show();

            // 字符串格式转换数值进行计算
            Double n1 = Double.parseDouble(num1);
            Double n2 = Double.parseDouble(num2);
            double jsResult = 0;

            // 先判断运算符
            if ("+".equals(op)) {
                jsResult = n1 + n2;
            } else if ("-".equals(op)) {
                jsResult = n1 - n2;
            } else if ("*".equals(op)) {
                jsResult = n1 * n2;
            } else if ("/".equals(op)) {
                if (n2 == 0.0) {
                    Toast.makeText(MainActivity2.this, "除数不能为0！", Toast.LENGTH_SHORT).show();
                } else {
                    jsResult = n1 / n2;
                }
            }
            result.setText(jsResult + "");
        }
    }
}