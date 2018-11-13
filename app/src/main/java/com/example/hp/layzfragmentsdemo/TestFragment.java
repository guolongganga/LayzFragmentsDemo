package com.example.hp.layzfragmentsdemo;

import android.app.ListActivity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterViewAnimator;

/**
 * Created by hp on 2018/11/9.
 */

public class TestFragment extends AbstrctFragment {
    private static final String TAG ="TestFragment" ;
    private SwipeRefreshLayout swipeRefreshLayout;
    private RecyclerView recyclerView;
   private  String[] content =new String[5];

    private ListAdapter adapter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment;
    }

    @Override
    protected void initData() {
        Log.e(TAG, "initData: "+"初始化内容" );
        swipeRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                swipeRefreshLayout.setRefreshing(true);
                loadData(content);

            }
        });


    }




//    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//       // view = inflater.inflate(getLayoutId(), container, false);
////
//
//    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         super.onCreateView(inflater, container, savedInstanceState);
        swipeRefreshLayout=view.findViewById(R.id.swipe);
        recyclerView=view.findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new ListAdapter(getActivity(),content);
        recyclerView.setAdapter(adapter);
        return  view;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //adapter.notifyDataSetChanged();
    }
    /**
     * 模拟访问网络耗时
     */
    private  void  loadData(final String[] content)
    {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    for (int i = 0; i <content.length ; i++) {
                        content[i]="内容"+i;
                    }
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            adapter.notifyDataSetChanged();
                            swipeRefreshLayout.setRefreshing(false);
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
