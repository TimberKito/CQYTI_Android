package com.example.sqllitedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;


import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    public ListView user_list;
    private List<userInfo> list;
    private String[] user_mes;
    EditText userget;
    EditText passget;
    Button btn;
    Button see;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userget = (EditText) findViewById(R.id.user);
        passget = (EditText) findViewById(R.id.pass);
        btn = (Button) findViewById(R.id.button);
        see = (Button) findViewById(R.id.button2);
        user_list = findViewById(R.id.mes);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = userget.getText().toString();
                String pass = passget.getText().toString();
                //调用 DatabaseHelper 类对象
                DatabaseHelper databaseHelper = new DatabaseHelper(MainActivity.this);
                //只有调用 getReadableDatabase() 或者 getWritableDatabase() 函数才能真正返回一个 sqLiteDatabase对象
                SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();
                //表添加数据
                databaseHelper.adddata(sqLiteDatabase, user, pass);
                Toast.makeText(MainActivity.this,
                        user + ":" + pass + "用户信息已注册！",
                        Toast.LENGTH_SHORT).show();
            }
        });
        see.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //调用 DatabaseHelper 类对象
                DatabaseHelper databaseHelper = new DatabaseHelper(MainActivity.this);
                //只有调用 getReadableDatabase() 或者 getWritableDatabase() 函数才能真正返回一个 sqLiteDatabase对象
                SQLiteDatabase sqLiteDatabase = databaseHelper.getReadableDatabase();
                //获取从数据库查询到的数据
                list = databaseHelper.querydata(sqLiteDatabase);
                //把获取到的信息添加到用户名数组中
                user_mes = new String[list.size()];
                for (int i = 0; i < list.size(); i++) {
                    user_mes[i] = list.get(i).getUsername() + "   " +
                            list.get(i).getPaswd();
                }
                //把用户名显示在ListView上
                final ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, user_mes);
                user_list.setAdapter(adapter);
                user_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        int id = list.get(i).getId();
                        String tag = "id调试：";
                        Log.i(tag, tag + id + "测试");
                        //弹出一个对话框
                        new AlertDialog.Builder(MainActivity.this).setTitle("系统提示")
                                .setNegativeButton("删除", new DialogInterface.OnClickListener() {//添加返回按钮
                                    // @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        //调用 DatabaseHelper 类对象
                                        DatabaseHelper databaseHelper = new DatabaseHelper(MainActivity.this);
                                        //只有调用 getReadableDatabase() 或者 getWritableDatabase() 函数才能真正返回一个 sqLiteDatabase对象
                                        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();
                                        databaseHelper.delete(sqLiteDatabase, id);
                                        refresh();
                                        Toast.makeText(MainActivity.this, "删除成功", Toast.LENGTH_SHORT).show();
                                    }
                                })
                                .setPositiveButton("修改", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        //调用 DatabaseHelper 类对象
                                        DatabaseHelper databaseHelper = new DatabaseHelper(MainActivity.this);
                                        //只有调用 getReadableDatabase() 或者 getWritableDatabase() 函数才能真正返回一个 sqLiteDatabase对象
                                        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();
                                        //获取新的用户名和密码
                                        Intent intentToUpdate = new Intent(MainActivity.this, Updareuser_Activity.class);
                                        intentToUpdate.putExtra("UpdateId", id);
                                        startActivity(intentToUpdate);
                                    }
                                })
                                .show();//在按键响应事件中显示此对话框
                    }
                });
            }
        });
    }

    //刷新页面方法
    private void refresh() {
        finish();
        Intent intent = new Intent(MainActivity.this, MainActivity.class);
        startActivity(intent);
    }
}

