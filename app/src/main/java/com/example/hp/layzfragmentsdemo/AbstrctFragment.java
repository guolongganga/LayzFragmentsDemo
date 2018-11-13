package com.example.hp.layzfragmentsdemo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.zip.Inflater;

/**
 * Created by hp on 2018/11/9.
 */

public abstract class AbstrctFragment  extends Fragment{

    private static final String TAG = "AbstrctFragment";
    //数据是否初始化
    private boolean isInitData=false;

    //判断fragment是否可见
    private boolean isVisbleToUser=false;

    //判断view 是否完成
    private boolean isPrepareView=false;
    protected View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(getLayoutId(), container, false);
        Log.e(TAG, "onCreateView: "+"调用onCreateView" );
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.e(TAG, "onViewCreated: "+"调用onViewCreated" );
        //加载view完成
        isPrepareView=true;
    }
    /**
     * fragment生命周期中onViewCreated之后的方法 在这里调用一次懒加载 避免第一次可见不加载数据
     */
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.e(TAG, "onActivityCreated: "+"调用onActivityCreated" );
        lazyInitData();
    }

    /**
     * 懒加载数据
     */
    private void lazyInitData() {
        if(!isInitData&&isVisbleToUser&&isPrepareView)
        {
            isInitData=true;
            initData();
        }
    }
    /**
     * 当fragment有可见变为不可见或者有不可见变为可见时，会调用该方法
     * @param isVisibleToUser
     */
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
       // super.setUserVisibleHint(isVisibleToUser);
        this.isVisbleToUser = isVisibleToUser;
        Log.e(TAG, "setUserVisibleHint: "+"setUserVisibleHint" );
        //调用懒加载数据
        lazyInitData();
    }





    //子类需要实现的方法
    protected  abstract int getLayoutId();//获取布局Id;
    protected  abstract  void initData();// 加载数据
}
