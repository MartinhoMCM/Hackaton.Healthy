package com.hackathon.healthy;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {


    private List<ListItem> listItems;
    private  Context context;

    public MyAdapter(List<ListItem> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view =LayoutInflater.from(parent.getContext()).
               inflate(R.layout.number_list_item, parent, false);

       return  new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        ListItem listItem =listItems.get(position);

        holder.Head.setText(listItem.getHead());
        holder.Desc.setText(listItem.getDesc());

    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends  RecyclerView.ViewHolder
    {

        public TextView Head;
        public TextView Desc;


        public ViewHolder(View itemView) {
            super(itemView);

            Head = (TextView)itemView.findViewById(R.id.headline);
            Desc=(TextView) itemView.findViewById(R.id.description);
        }
    }
}
