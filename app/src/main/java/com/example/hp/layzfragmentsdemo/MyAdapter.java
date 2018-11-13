package com.example.hp.layzfragmentsdemo;

import android.content.Context;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by hp on 2018/11/9.
 */

public class MyAdapter extends FragmentPagerAdapter {
    private Context context;
    private  String[] titles;
    private Fragment[] fragments;


    public MyAdapter(FragmentManager fm, Context context, String[] titles, Fragment[] fragments) {
        super(fm);
        this.context = context;
        this.titles = titles;
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments[position];
    }

    @Override
    public int getCount() {
        return fragments.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
