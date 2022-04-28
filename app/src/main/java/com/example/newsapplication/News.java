package com.example.newsapplication;

public class News {
    private int id, newsImageID;
    private String newsTitle, newsDescription;

    public News(int id, int newsImageID, String newsTitle, String newsDescription) {
        this.id = id;
        this.newsImageID = newsImageID;
        this.newsTitle = newsTitle;
        this.newsDescription = newsDescription;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNewsImageID() {
        return newsImageID;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public void setNewsImageID(int newsImageID) {
        this.newsImageID = newsImageID;
    }

    public String getNewsDescription() {
        return newsDescription;
    }

    public void setNewsDescription(String newsDescription) {
        this.newsDescription = newsDescription;
    }
}
