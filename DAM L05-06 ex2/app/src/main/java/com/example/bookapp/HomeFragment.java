package com.example.bookapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class HomeFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        Button btnIntro = view.findViewById(R.id.btnIntro);
        Button btnChapter1 = view.findViewById(R.id.btnChapter1);
        Button btnChapter2 = view.findViewById(R.id.btnChapter2);
        Button btnChapter3 = view.findViewById(R.id.btnChapter3);
        Button btnChapter4 = view.findViewById(R.id.btnChapter4);

        btnIntro.setOnClickListener(v -> openChapter("Introducere", R.string.intro_text));
        btnChapter1.setOnClickListener(v -> openChapter("Capitolul 1: Călătoria Începe", R.string.chapter1_text));
        btnChapter2.setOnClickListener(v -> openChapter("Capitolul 2: Lecții din Natură", R.string.chapter2_text));
        btnChapter3.setOnClickListener(v -> openChapter("Capitolul 3: Puterea Visurilor", R.string.chapter3_text));
        btnChapter4.setOnClickListener(v -> openChapter("Capitolul 4: Curajul de a Eșua", R.string.chapter4_text));

        return view;
    }

    private void openChapter(String title, int textResId) {
        ChapterFragment fragment = ChapterFragment.newInstance(title, textResId);
        ((MainActivity) requireActivity()).openFragment(fragment);
    }
}