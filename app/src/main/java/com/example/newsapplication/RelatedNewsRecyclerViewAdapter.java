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

public class RelatedNewsRecyclerViewAdapter extends RecyclerView.Adapter<RelatedNewsRecyclerViewAdapter.ViewHolder> {

    private List<News> newsList;
    private Context context;
    private OnNewsFragmentClickListener listener;

    public RelatedNewsRecyclerViewAdapter(List<News> newsList, Context context, OnNewsFragmentClickListener clickListener) {
        this.newsList = newsList;
        this.context = context;
        this.listener = clickListener;
    }

    @NonNull
    @Override
    public RelatedNewsRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.related_stories, parent, false);
        return new ViewHolder(itemView, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull RelatedNewsRecyclerViewAdapter.ViewHolder holder, int position) {
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
        OnNewsFragmentClickListener onNewsFragmentClickListener;
        public ViewHolder(@NonNull View itemView, OnNewsFragmentClickListener onNewsFragmentClickListener) {
            super(itemView);
            newsCardImageView = itemView.findViewById(R.id.relatedStoriesImageView);
            newsTitleCardTextView = itemView.findViewById(R.id.relatedStoriesTitleTextView);
            newsDescriptionCardTextView = itemView.findViewById(R.id.relatedStoriesDescriptionTextView);
            this.onNewsFragmentClickListener = onNewsFragmentClickListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onNewsFragmentClickListener.onNewsFragmentClickListener(getAdapterPosition());
        }
    }

    public interface OnNewsFragmentClickListener {
        void onNewsFragmentClickListener (int position);
    }
}
