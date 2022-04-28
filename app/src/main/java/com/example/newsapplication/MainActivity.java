package com.example.newsapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements TopStoriesRecyclerViewAdapter.OnTopStoriesClickListener,
        NewsRecyclerViewAdapter.OnNewsClickListener {
    RecyclerView topStoriesRecyclerView, newsRecyclerView;
    TopStoriesRecyclerViewAdapter topStoriesRecyclerViewAdapter;
    NewsRecyclerViewAdapter newsRecyclerViewAdapter;
    List<TopStories> topStoriesList = new ArrayList<>();
    List<News> newsList = new ArrayList<>();
    RecyclerView.LayoutManager recyclerViewLayoutManager;
    LinearLayoutManager HorizontalLayout;
    GridLayoutManager HorizontalGridLayout;

    private int[] topStoriesImageList = {R.drawable.abc_news,
            R.drawable.breaking_news,
            R.drawable.seven_news,
            R.drawable.nine_news_australia_national};

    private int[] newsImageList = {R.drawable.abc_news,
            R.drawable.breaking_news,
            R.drawable.seven_news,
            R.drawable.nine_news_australia_national,
            R.drawable.the_age};

    private String[] newsTitleList = {"ABC NEWS",
            "BREAKING NEWS",
            "7NEWS",
            "9NEWS",
            "THE AGE"};

    private String[] newsDescriptionList = {"The Reserve Bank hasn't raised its official cash rate target for more than a decade...",
            "Here are the latest developments in the war in Ukraine:",
            "The United Kingdom government says a UK citizen has been killed in Ukraine and another is missing.",
            "Russia's offensive in eastern Ukraine has gathered momentum as...",
            "Scientology accused of child trafficking, forced labour of Australians"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initialise top stories recycler view and fill with data
        topStoriesRecyclerView = findViewById(R.id.topStoriesRecyclerView);
        topStoriesRecyclerViewAdapter = new TopStoriesRecyclerViewAdapter(topStoriesList, MainActivity.this, this);
        topStoriesRecyclerView.setAdapter(topStoriesRecyclerViewAdapter);

        recyclerViewLayoutManager = new LinearLayoutManager(this);
        topStoriesRecyclerView.setLayoutManager(recyclerViewLayoutManager);

        for (int i=0; i<topStoriesImageList.length; i++) {
            TopStories topStories = new TopStories(i, topStoriesImageList[i]);
            topStoriesList.add(topStories);
        }

        HorizontalLayout = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        topStoriesRecyclerView.setLayoutManager(HorizontalLayout);

        // initialise news recycler view and fill with data
        newsRecyclerView = findViewById(R.id.newsRecyclerView);
        newsRecyclerViewAdapter = new NewsRecyclerViewAdapter(newsList,  MainActivity.this, this);
        newsRecyclerView.setAdapter(newsRecyclerViewAdapter);

        newsRecyclerView.setLayoutManager(recyclerViewLayoutManager);

        for (int i=0; i<newsImageList.length; i++) {
            News news = new News(i, newsImageList[i], newsTitleList[i], newsDescriptionList[i]);
            newsList.add(news);
        }

        HorizontalGridLayout = new GridLayoutManager(this, 2, RecyclerView.HORIZONTAL, false);
        newsRecyclerView.setLayoutManager(HorizontalGridLayout);

        for (Fragment fragment:getSupportFragmentManager().getFragments()) {
            getSupportFragmentManager().beginTransaction().remove(fragment).commit();
        }
    }

    @Override
    public void onTopStoriesClick(int position) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        switch (position) {
            case 0:
                fragmentTransaction.replace(R.id.newsArticleFragmentContainerView, AbcNewsFragment.class, null).commit();
                break;
            case 1:
                fragmentTransaction.replace(R.id.newsArticleFragmentContainerView, BreakingNewsFragment.class, null).commit();
                break;
            case 2:
                fragmentTransaction.replace(R.id.newsArticleFragmentContainerView, SevenNewsFragment.class, null).commit();
                break;
            case 3:
                fragmentTransaction.replace(R.id.newsArticleFragmentContainerView, NineNewsFragment.class, null).commit();
                break;
            case 4:
                fragmentTransaction.replace(R.id.newsArticleFragmentContainerView, TheAgeFragment.class, null).commit();
                break;
            default:
                break;
        }
    }

    @Override
    public void OnNewsClick(int position) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        switch (position) {
            case 0:
                fragmentTransaction.replace(R.id.newsArticleFragmentContainerView, AbcNewsFragment.class, null).commit();
                break;
            case 1:
                fragmentTransaction.replace(R.id.newsArticleFragmentContainerView, BreakingNewsFragment.class, null).commit();
                break;
            case 2:
                fragmentTransaction.replace(R.id.newsArticleFragmentContainerView, SevenNewsFragment.class, null).commit();
                break;
            case 3:
                fragmentTransaction.replace(R.id.newsArticleFragmentContainerView, NineNewsFragment.class, null).commit();
                break;
            case 4:
                fragmentTransaction.replace(R.id.newsArticleFragmentContainerView, TheAgeFragment.class, null).commit();
                break;
            default:
                break;
        }
    }

    public void replaceFragment(int position) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        switch (position) {
            case 0:
                fragmentTransaction.replace(R.id.newsArticleFragmentContainerView, AbcNewsFragment.class, null).commit();
                break;
            case 1:
                fragmentTransaction.replace(R.id.newsArticleFragmentContainerView, BreakingNewsFragment.class, null).commit();
                break;
            case 2:
                fragmentTransaction.replace(R.id.newsArticleFragmentContainerView, SevenNewsFragment.class, null).commit();
                break;
            case 3:
                fragmentTransaction.replace(R.id.newsArticleFragmentContainerView, NineNewsFragment.class, null).commit();
                break;
            case 4:
                fragmentTransaction.replace(R.id.newsArticleFragmentContainerView, TheAgeFragment.class, null).commit();
                break;
            default:
                break;
        }
    }
}