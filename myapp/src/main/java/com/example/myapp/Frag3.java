package com.example.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Frag3 extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout3, container, false);
        return view;
    }
    @Override
    public void onStart() {
        super.onStart();
        ImageView txt = (ImageView) getActivity().findViewById(R.id.imageView42);
        ImageView txt2 = (ImageView) getActivity().findViewById(R.id.imageView45);
        ImageView txt3 = (ImageView) getActivity().findViewById(R.id.imageView47);
        ImageView txt4 = (ImageView) getActivity().findViewById(R.id.imageView46);
        txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getActivity(), likeActivity.class);
                startActivity(it);
                txt2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent it = new Intent(getActivity(), commentsActivity.class);
                        startActivity(it);
                        txt3.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent it = new Intent(getActivity(), likeActivity.class);
                                startActivity(it);
                                txt4.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        Intent it = new Intent(getActivity(), NoticeActivity.class);
                                        startActivity(it);
                                    }
                                });
                            }
                        });
                    }
                });
            }
        });
    }
}

