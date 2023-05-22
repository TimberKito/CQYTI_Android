package com.example.sqllitedemo;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    //使用构造函数创建 crud.db 数据库
    private static final int DATABASE_VERSION = 4;
    private static final String DATABASE_NAME = "crud.db";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //使用构造函数创建 crud.db 数据库
    @Override
    public void onCreate(SQLiteDatabase db) {
        //创建了一个名为person的表
        String sql = "create table person(id integer primary key autoincrement,name varchar(64),pass varchar(64))";
        //execSQL用于执行SQL语句
        //完成数据库的创建
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    //表添加数据
    public void adddata(SQLiteDatabase db, String user, String pass) {
        ContentValues context = new ContentValues();
        context.put("name", user);
        context.put("pass", pass);
        db.insert("person", null, context);
        db.close();
    }

    //全表信息查看
    public List<userInfo> querydata(SQLiteDatabase sqLiteDatabase) {
        Cursor cursor = sqLiteDatabase.query("person", null, null, null, null, null, "id ASC");
        List<userInfo> list = new ArrayList<userInfo>();
        while (cursor.moveToNext()) {
            @SuppressLint("Range") int id = cursor.getInt(cursor.getColumnIndex("id"));
            String username = cursor.getString(1);
            String paswd = cursor.getString(2);
            list.add(new userInfo(id, username, paswd));
        }
        cursor.close();
        sqLiteDatabase.close();
        return list;
    }

    public List<userInfo> querydatabyid(SQLiteDatabase sqLiteDatabase, int id) {
        String selectQuery = "SELECT * from person WHERE id =" + "=?";
        List<userInfo> list = new ArrayList<userInfo>();
        Cursor cursor = sqLiteDatabase.rawQuery(selectQuery, new String[]{String.valueOf(id)});
        if (cursor.moveToFirst()) {
            do {
                @SuppressLint("Range") int ids = cursor.getInt(cursor.getColumnIndex("id"));
                String username = cursor.getString(1);
                String paswd = cursor.getString(2);
                list.add(new userInfo(ids, username, paswd));
            } while (cursor.moveToNext());
        }
        cursor.close();
        sqLiteDatabase.close();
        return list;
    }

    //表数据删除
    public void delete(SQLiteDatabase sqLiteDatabase, int id) {
        //第一个参数：表名；第二个参数：需要删除的属性名，？代表占位符；第三个参数：属性名的属性值
        sqLiteDatabase.delete("person", "id=?", new String[]{id + ""});
        sqLiteDatabase.close();
    }

    //表数据更新
    //更新数据
    public void update(SQLiteDatabase sqLiteDatabase, int id, String username, String paswd) {
        //创建一个ContentValues对象
        ContentValues values = new ContentValues();
        //以键值对的形式插入
        values.put("name", username);
        values.put("pass", paswd);
        //执行修改的方法
        sqLiteDatabase.update("person", values, "id=?", new String[]{id + ""});
        sqLiteDatabase.close();
    }
}


