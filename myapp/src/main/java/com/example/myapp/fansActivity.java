package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;


public class fansActivity extends AppCompatActivity {

    private View prebutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fans);
        prebutton = findViewById(R.id.imageView64);
        prebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
