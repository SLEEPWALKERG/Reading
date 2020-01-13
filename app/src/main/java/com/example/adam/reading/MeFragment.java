package com.example.adam.reading;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class MeFragment extends Fragment {

    public MeFragment() {
        // Required empty public constructor
    }

    public static MeFragment newInstance(String param1) {
        MeFragment fragment = new MeFragment();
        Bundle args = new Bundle();
        args.putString("args1", param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_me, container, false);
        Bundle bundle = getArguments();
        String args1 = bundle.getString("args1");
        return view;
    }


}
