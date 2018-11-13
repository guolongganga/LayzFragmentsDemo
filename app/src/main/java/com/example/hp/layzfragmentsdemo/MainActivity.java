package com.example.hp.layzfragmentsdemo;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;



public class MainActivity extends AppCompatActivity {

    private TabLayout tableLayout;
    private ViewPager viewPager;
    private String[] titles={"1","2","3","4","5"};
   private Fragment[] fragments={new TestFragment(),new TestFragment(),new TestFragment(),new TestFragment(),new TestFragment()};
    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tableLayout=findViewById(R.id.tablayout);
        viewPager=findViewById(R.id.view_pager);
        adapter = new MyAdapter(getSupportFragmentManager(),MainActivity.this,titles,fragments);
        viewPager.setOffscreenPageLimit(4);
        viewPager.setAdapter(adapter);
        tableLayout.setupWithViewPager(viewPager);
    }
}
