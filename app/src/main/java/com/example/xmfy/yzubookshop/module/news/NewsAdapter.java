package com.example.xmfy.yzubookshop.module.news;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.xmfy.yzubookshop.R;
import com.example.xmfy.yzubookshop.model.News;
import com.example.xmfy.yzubookshop.utils.ImageLoader;

import java.util.List;

/**
 * Created by xmfy on 2018/1/9.
 */
public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    private List<News> newsList;
    private ImageLoader imageLoader;

    public NewsAdapter(List<News> newsList, RecyclerView recyclerView) {
        imageLoader = new ImageLoader(recyclerView, ImageLoader.TYPE_NEWS);
        this.newsList = newsList;
    }

    @Override
    public NewsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(NewsAdapter.ViewHolder holder, int position) {
        holder.view.setTag(newsList.get(position).getWebUrl());
        holder.news_title.setText(newsList.get(position).getTitle());
        holder.news_content.setText(newsList.get(position).getDescription());
        imageLoader.loadImage(holder.news_icon, newsList.get(position).getIconAddress());
    }

    @Override
    public int getItemCount() {
        return newsList == null ? 0 : newsList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        View view;
        ImageView news_icon;
        TextView news_title;
        TextView news_content;

        public ViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            news_icon = itemView.findViewById(R.id.news_icon);
            news_title = itemView.findViewById(R.id.news_title);
            news_content = itemView.findViewById(R.id.news_content);
        }
    }
}