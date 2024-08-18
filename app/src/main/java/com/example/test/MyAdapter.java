package com.example.test;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/**
 * @Author: Guanam
 * @Date: 19/8/2024 - 08 - 19 -上午12:31
 * @Version: 1.0
 */
public class MyAdapter extends RecyclerView.Adapter {

    private final LayoutInflater inflater;
    private Context context;
    //数据
    private List<Body> bodyList;

    RecyclerView.ViewHolder holder;

    public MyAdapter(Context context, List<Body> bodyList) {
        this.context = context;
        this.bodyList = bodyList;
        this.inflater = LayoutInflater.from(context);
    }

    public static final int TYPE_BODY = 1;
    public static final int TYPE_FOOT = 2;

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        switch (viewType){
            case TYPE_BODY:
                holder = new BodyViewHolder(inflater.inflate(R.layout.item_body,parent,false));
                break;
            case TYPE_FOOT:
                holder = new FootViewHolder(inflater.inflate(R.layout.item_body,parent,false));
                break;
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof BodyViewHolder){
            BodyViewHolder view = (BodyViewHolder) holder;
            Body body = bodyList.get(position);
            view.tvBody.setText(body.getName() +" hello" + body.getAge());
        }else{

        }
    }

    @Override
    public int getItemCount() {
        return bodyList.size() + 1;
    }
    //采用一种设计模式去做到我们的转换（装饰）


    @Override
    public int getItemViewType(int position) {
        int viewType = -1;

        if (position == bodyList.size() ) {
            viewType = TYPE_FOOT;
        } else {
            viewType = TYPE_BODY;
        }
        return viewType;
    }

    class FootViewHolder extends RecyclerView.ViewHolder {
        //加自己的功能

        public FootViewHolder(View itemView) {
            super(itemView);

        }
    }
    class BodyViewHolder extends RecyclerView.ViewHolder {
        public TextView tvBody;

        public BodyViewHolder(View itemView) {
            super(itemView);
            tvBody = itemView.findViewById(R.id.tv_body);
        }
    }

}
