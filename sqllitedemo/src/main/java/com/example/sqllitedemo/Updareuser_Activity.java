package com.example.sqllitedemo;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class Updareuser_Activity extends AppCompatActivity {
    public ListView user_list;
    private List<userInfo> list;
    String tag = "id调试：";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updareuser);

        EditText update_name0 = (EditText) findViewById(R.id.update_name);
        EditText update_paswd0 = (EditText) findViewById(R.id.update_paswd);
        //获取需要修改的数据信息
        Intent intentGet = getIntent();
        int idUpdate = intentGet.getIntExtra("UpdateId", -1);
        //调用 DatabaseHelper 类对象
        DatabaseHelper databaseHelper = new DatabaseHelper(Updareuser_Activity.this);
        //只有调用 getReadableDatabase() 或者 getWritableDatabase() 函数才能真正返回一个 sqLiteDatabase对象
        SQLiteDatabase sqLiteDatabase = databaseHelper.getReadableDatabase();

        //获取从数据库查询到的数据
        list = databaseHelper.querydatabyid(sqLiteDatabase, idUpdate);

        Log.i(tag, tag + list + "list接收");

        Log.i(tag, tag + idUpdate + "接收");
        if (idUpdate == -1) {
            Toast.makeText(Updareuser_Activity.this, "未取到ID", Toast.LENGTH_LONG).show();
        } else {

            update_name0.setText(list.get(0).getUsername());
            update_paswd0.setText(list.get(0).getPaswd());

            Button update_usermes0 = (Button) findViewById(R.id.update_usermes);
            update_usermes0.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //提交数据并修改
                    //获取用户输入的用户名、密码、年纪
                    String name_str = update_name0.getText().toString();
//                    Toast.makeText(Updareuser_Activity.this,name_str, Toast.LENGTH_SHORT).show();
                    String paswd_str = update_paswd0.getText().toString();

                    //调用 DatabaseHelper 类对象
                    DatabaseHelper databaseHelper = new DatabaseHelper(Updareuser_Activity.this);
                    //只有调用 getReadableDatabase() 或者 getWritableDatabase() 函数才能真正返回一个 sqLiteDatabase对象
                    SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();
                    databaseHelper.update(sqLiteDatabase, idUpdate, name_str, paswd_str);
                    Intent intent = new Intent(Updareuser_Activity.this, MainActivity.class);
                    startActivity(intent);
                    Toast.makeText(Updareuser_Activity.this, "修改成功", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}



