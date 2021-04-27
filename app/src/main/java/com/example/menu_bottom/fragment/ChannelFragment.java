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
 * Use the {@link ChannelFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ChannelFragment extends Fragment {

    public static ChannelFragment newInstance(String name){
        ChannelFragment channelFragment = new ChannelFragment();
        Bundle bundle = new Bundle();
        bundle.putString("name",name);
        channelFragment.setArguments(bundle);
        return channelFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_channel, container, false);
        TextView tv_better = view.findViewById(R.id.tv_channel);
        tv_better.setText(getArguments().getString("name"));
        return view;
    }
}