package com.example.hp.layzfragmentsdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.zip.Inflater;

/**
 * Created by hp on 2018/11/9.
 */

public class ListAdapter extends RecyclerView.Adapter {
    private Context context;
    private  String[] content;
    private View view;
    private MyViewHolder myViewHolder;

    public ListAdapter(Context context, String[] content) {
        this.context = context;
        this.content = content;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view = View.inflate(context, R.layout.item,null);
        myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        myViewHolder= (MyViewHolder) holder;
        myViewHolder.tv.setText(content[position]);

    }

    @Override
    public int getItemCount() {
        return content.length;
    }
    class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView tv;

        public MyViewHolder(View itemView) {
            super(itemView);
            tv=itemView.findViewById(R.id.tv);

        }
    }
}
