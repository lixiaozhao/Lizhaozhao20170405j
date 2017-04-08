package com.bwie.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private TextView text_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        text_view = (TextView) findViewById(R.id.text_view);
        //得到传过来的值
        Intent intent = getIntent();
        String user = intent.getStringExtra("user");
       // 赋值
        text_view.setText(user);
    }
}
