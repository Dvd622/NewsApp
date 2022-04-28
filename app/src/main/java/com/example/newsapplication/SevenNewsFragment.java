package com.example.newsapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SevenNewsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SevenNewsFragment extends Fragment implements RelatedNewsRecyclerViewAdapter.OnNewsFragmentClickListener {

    RecyclerView recyclerView;
    RelatedNewsRecyclerViewAdapter recyclerViewAdapter;
    List<News> newsList = new ArrayList<>();

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

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SevenNewsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SevenNewsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SevenNewsFragment newInstance(String param1, String param2) {
        SevenNewsFragment fragment = new SevenNewsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_seven_news, null);
        recyclerView = root.findViewById(R.id.sevenNewsRelatedRecyclerView);
        recyclerViewAdapter = new RelatedNewsRecyclerViewAdapter(newsList, getActivity(), this);
        recyclerView.setAdapter(recyclerViewAdapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        for (int i=0; i<newsImageList.length; i++) {
            News news = new News(i, newsImageList[i], newsTitleList[i], newsDescriptionList[i]);
            newsList.add(news);
        }
        return root;
    }

    @Override
    public void onNewsFragmentClickListener(int position) {
        ((MainActivity)getActivity()).replaceFragment(position);
    }
}