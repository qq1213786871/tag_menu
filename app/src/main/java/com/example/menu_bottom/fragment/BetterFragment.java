package com.example.menu_bottom.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.menu_bottom.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BetterFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BetterFragment extends Fragment {

    public static BetterFragment newInstance(String name){
        BetterFragment betterFragment = new BetterFragment();
        Bundle bundle = new Bundle();
        bundle.putString("name",name);
        betterFragment.setArguments(bundle);
        return betterFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_better, container, false);
        TextView tv_better = view.findViewById(R.id.tv_better);
        tv_better.setText(getArguments().getString("name"));
        return view;
    }
}