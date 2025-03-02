package com.example.bookapp;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ChapterFragment extends Fragment {
    private static final String ARG_TITLE = "title";
    private static final String ARG_TEXT_ID = "textResId";

    public static ChapterFragment newInstance(String title, int textResId) {
        ChapterFragment fragment = new ChapterFragment();
        Bundle args = new Bundle();
        args.putString(ARG_TITLE, title);
        args.putInt(ARG_TEXT_ID, textResId);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chapter, container, false);

        TextView titleTextView = view.findViewById(R.id.chapterTitle);
        TextView contentTextView = view.findViewById(R.id.chapterContent);
        ImageView chapterImage = view.findViewById(R.id.chapterImage);

        Bundle args = getArguments();
        if (args != null) {
            String title = args.getString(ARG_TITLE);
            titleTextView.setText(title);
            contentTextView.setText(getString(args.getInt(ARG_TEXT_ID)));

            int imageResId = getImageResourceForTitle(title);
            chapterImage.setImageResource(imageResId);
        }

        return view;
    }

    private int getImageResourceForTitle(String title) {
        if (title != null) {
            switch (title) {
                case "Capitolul 1: Călătoria Începe":
                    return R.drawable.chapter1;
                case "Capitolul 2: Lecții din Natură":
                    return R.drawable.chapter2;
                case "Capitolul 3: Puterea Visurilor":
                    return R.drawable.chapter3;
                case "Capitolul 4: Curajul de a Eșua":
                    return R.drawable.chapter4;
                default:
                    return R.drawable.default_image;
            }
        }
        return R.drawable.default_image;
    }
}
