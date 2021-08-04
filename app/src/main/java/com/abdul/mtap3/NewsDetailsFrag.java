package com.abdul.mtap3;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import org.jetbrains.annotations.NotNull;

public class NewsDetailsFrag extends Fragment {
    TextView headlineTextView;
    String headline = "";

    public NewsDetailsFrag() {
    }

    @Override
    public void onAttach(@NonNull @NotNull Context context) {
        super.onAttach(context);
    }


    @Override
    public void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       headline = getArguments().getString("hl");
        //headline = savedInstanceState.getString("hl");
    }

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater,
                             @Nullable @org.jetbrains.annotations.Nullable
                                     ViewGroup container,
                             @Nullable @org.jetbrains.annotations.Nullable Bundle arguments) {
        View view =inflater.inflate(R.layout.frag_news_details,container,false);
        headlineTextView = view.findViewById(R.id.tvNewsDetails);
        headlineTextView.setText(headline);
        return  view;
    }



    void setHeadlineTv(String headline){
        headlineTextView.setText(headline);
    }
}
