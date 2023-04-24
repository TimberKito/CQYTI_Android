package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public LinearLayout ly1,ly2,ly3,ly4;
    public ImageView IM1,IM2,IM3,IM4;
    //通过getSupportFragmentManager() 获Manager对象;
    FragmentManager fm=getSupportFragmentManager();
    //使用FragmentTransaction创建一个事务对象；
    FragmentTransaction ft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        图标实例化
        IM1=(ImageView)findViewById(R.id.TM_zhuye);
        IM2=(ImageView)findViewById(R.id.TM_news);
        IM3=(ImageView)findViewById(R.id.TM_xiaoxi);
        IM4=(ImageView)findViewById(R.id.TM_setting);
//        图标动态切换
        setUSelected();
//        图标选中后效果切换
        IM1.setImageResource(R.drawable.zhuye_pressed);

//        实例化碎片 1
        Frag1 frag1000=new Frag1();
//        默认动态加载初始化碎片 1
        ft=fm.beginTransaction();
        ft.replace(R.id.MyFragmentXML,frag1000);
        ft.commit();

//        4个条目的线型布局实例化
        ly1=(LinearLayout)findViewById(R.id.ly_tab_menu_zhuye);
        ly2=(LinearLayout)findViewById(R.id.ly_tab_menu_news);
        ly3=(LinearLayout)findViewById(R.id.ly_tab_menu_xiaoxi);
        ly4=(LinearLayout)findViewById(R.id.ly_tab_menu_setting);

//        注册监听
        ly1.setOnClickListener(this);
        ly2.setOnClickListener(this);
        ly3.setOnClickListener(this);
        ly4.setOnClickListener(this);
    }

    //    点击条目的单击响应事件
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ly_tab_menu_zhuye:
//                点击图标后加载frag1
                setUSelected();
                IM1.setImageResource(R.drawable.zhuye_pressed);
//                实例化碎片 1
                Frag1 frag1000=new Frag1();
//                动态加载碎片 1
                ft=fm.beginTransaction();
                ft.replace(R.id.MyFragmentXML,frag1000);
                ft.commit();
                break;
            case R.id.ly_tab_menu_news:
//                点击图标后加载frag2
                setUSelected();
                IM2.setImageResource(R.drawable.news_pressed);
//                实例化碎片 2
                Frag2 frag2000=new Frag2();
//                动态加载碎片 2
                ft=fm.beginTransaction();
                ft.replace(R.id.MyFragmentXML,frag2000);
                ft.commit();
                break;
            case R.id.ly_tab_menu_xiaoxi:
//                点击图标后加载frag3
                setUSelected();
                IM3.setImageResource(R.drawable.xiaoxi_pressed);
//                实例化碎片 3
                Frag3 frag3000=new Frag3();
//                动态加载碎片 3
                ft=fm.beginTransaction();
                ft.replace(R.id.MyFragmentXML,frag3000);
                ft.commit();
                break;
            case R.id.ly_tab_menu_setting:
//                点击图标后加载frag4
                setUSelected();
                IM4.setImageResource(R.drawable.me_pressed);
//                实例化碎片 4
                Frag4 frag4000=new Frag4();
//                动态加载碎片 4
                ft=fm.beginTransaction();
                ft.replace(R.id.MyFragmentXML,frag4000);
                ft.commit();
                break;
        }
    }

    //    4个条目的单击样式全部清空（灰色改成图标）
    public void setUSelected()
    {
        IM1.setImageResource(R.drawable.zhuye_normal);
        IM2.setImageResource(R.drawable.news_normal);
        IM3.setImageResource(R.drawable.xiaoxi_normal);
        IM4.setImageResource(R.drawable.me_normal);
    }
}