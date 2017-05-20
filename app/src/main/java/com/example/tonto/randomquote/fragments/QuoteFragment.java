package com.example.tonto.randomquote.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tonto.randomquote.R;
import com.example.tonto.randomquote.networks.ImageLoader;
import com.example.tonto.randomquote.networks.QuoteLoader;

/**
 * A simple {@link Fragment} subclass.
 */
public class QuoteFragment extends Fragment {
    private TextView tvQuote;
    private ImageView ivBackground;

    public QuoteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_quote, container, false);
        tvQuote = (TextView) view.findViewById(R.id.tv_quote);
        ivBackground = (ImageView) view.findViewById(R.id.iv_background);
        new QuoteLoader(tvQuote).execute();
        new ImageLoader(ivBackground).execute();

        return view;
    }

}
