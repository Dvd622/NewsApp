package com.example.newsapplication;

import android.graphics.drawable.Drawable;

public class TopStories {
    private int topStoryImageID;
    private int id;

    public TopStories(int id, int topStoryImageID) {
        this.id = id;
        this.topStoryImageID = topStoryImageID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTopStoryImageID() {
        return topStoryImageID;
    }

    public void setTopStoryImageID(int topStoryImageID) {
        this.topStoryImageID = topStoryImageID;
    }
}
