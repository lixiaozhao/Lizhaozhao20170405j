package com.bwie.test;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import fragment.Fragment1;
import fragment.Fragment2;
import fragment.Fragment3;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button bu_01;
    private Button bu_02;
    private Button bu_03;
    private ViewPager vp;
    private List<Fragment> list_f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        getFragment();
    }

    private void getFragment() {
        //得到管理类
        FragmentManager manager = getSupportFragmentManager();
        list_f = new ArrayList<>();
        list_f.add(new Fragment1());
        list_f.add(new Fragment2());
        list_f.add(new Fragment3());
        //适配器vp
        vp.setAdapter(new Myadapter(manager));
    }

    //找到控件
    private void initView() {
        bu_01 = (Button) findViewById(R.id.bu_01);
        bu_02 = (Button) findViewById(R.id.bu_02);
        bu_03 = (Button) findViewById(R.id.bu_03);
        vp = (ViewPager) findViewById(R.id.vp);


        bu_01.setOnClickListener((View.OnClickListener) this);
        bu_02.setOnClickListener((View.OnClickListener) this);
        bu_03.setOnClickListener((View.OnClickListener) this);

    }

    @Override
    //做监听
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bu_01:
                vp.setCurrentItem(0);
                break;
            case R.id.bu_02:
                vp.setCurrentItem(1);
                break;
            case R.id.bu_03:
                vp.setCurrentItem(2);
                break;
        }
    }

    class Myadapter extends FragmentPagerAdapter {

        public Myadapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return list_f.get(position);
        }

        @Override
        public int getCount() {
            return list_f.size();
        }
    }
}
