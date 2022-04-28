package com.example.newsapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TopStoriesRecyclerViewAdapter extends RecyclerView.Adapter<TopStoriesRecyclerViewAdapter.ViewHolder> {

    private List<TopStories> topStoriesList;
    private Context context;
    private OnTopStoriesClickListener listener;

    public TopStoriesRecyclerViewAdapter(List<TopStories> topStoriesList, Context context, OnTopStoriesClickListener clickListener) {
        this.topStoriesList = topStoriesList;
        this.context = context;
        this.listener = clickListener;
    }

    @NonNull
    @Override
    public TopStoriesRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.top_stories, parent, false);
        return new ViewHolder(itemView, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull TopStoriesRecyclerViewAdapter.ViewHolder holder, int position) {
        holder.topStoriesImageView.setImageDrawable(AppCompatResources.getDrawable(context, topStoriesList.get(position).getTopStoryImageID()));
    }

    @Override
    public int getItemCount() {
        return topStoriesList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView topStoriesImageView;
        OnTopStoriesClickListener onTopStoriesClickListener;
        public ViewHolder(@NonNull View itemView, OnTopStoriesClickListener onTopStoriesClickListener) {
            super(itemView);
            topStoriesImageView = itemView.findViewById(R.id.topStoriesImageView);
            this.onTopStoriesClickListener = onTopStoriesClickListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onTopStoriesClickListener.onTopStoriesClick(getAdapterPosition());
        }
    }

    public interface OnTopStoriesClickListener {
        void onTopStoriesClick (int position);
    }
}
