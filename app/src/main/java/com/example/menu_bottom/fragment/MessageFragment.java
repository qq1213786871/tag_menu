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
 * Use the {@link MessageFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MessageFragment extends Fragment {


    public static MessageFragment newInstance(String name){
        MessageFragment MessageFragment = new MessageFragment();
        Bundle bundle = new Bundle();
        bundle.putString("name",name);
        MessageFragment.setArguments(bundle);
        return MessageFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_message, container, false);
        TextView tv_message = view.findViewById(R.id.tv_message);
        tv_message.setText(getArguments().getString("name"));
        return view;
    }
}