package com.example.newsapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NewsRecyclerViewAdapter extends RecyclerView.Adapter<NewsRecyclerViewAdapter.ViewHolder> {

    private List<News> newsList;
    private Context context;
    private OnNewsClickListener listener;

    public NewsRecyclerViewAdapter(List<News> newsList, Context context, OnNewsClickListener clickListener) {
        this.newsList = newsList;
        this.context = context;
        this.listener = clickListener;
    }

    @NonNull
    @Override
    public NewsRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.news, parent, false);
        return new ViewHolder(itemView, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsRecyclerViewAdapter.ViewHolder holder, int position) {
        holder.newsCardImageView.setImageDrawable(AppCompatResources.getDrawable(context, newsList.get(position).getNewsImageID()));
        holder.newsTitleCardTextView.setText(newsList.get(position).getNewsTitle());
        holder.newsDescriptionCardTextView.setText(newsList.get(position).getNewsDescription());
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView newsCardImageView;
        TextView newsTitleCardTextView, newsDescriptionCardTextView;
        OnNewsClickListener onNewsClickListener;
        public ViewHolder(@NonNull View itemView, OnNewsClickListener onNewsClickListener) {
            super(itemView);
            newsCardImageView = itemView.findViewById(R.id.newsCardImageView);
            newsTitleCardTextView = itemView.findViewById(R.id.newsTitleCardTextView);
            newsDescriptionCardTextView = itemView.findViewById(R.id.newsDescriptionCardTextView);
            this.onNewsClickListener = onNewsClickListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onNewsClickListener.OnNewsClick(getAdapterPosition());
        }
    }

    public interface OnNewsClickListener {
        void OnNewsClick (int position);
    }
}
