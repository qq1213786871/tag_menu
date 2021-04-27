package com.example.menu_bottom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.menu_bottom.fragment.BetterFragment;
import com.example.menu_bottom.fragment.ChannelFragment;
import com.example.menu_bottom.fragment.MessageFragment;
import com.example.menu_bottom.fragment.MyFragment;

public class MainActivity extends AppCompatActivity {
    BetterFragment betterFragment;
    ChannelFragment channelFragment;
    MessageFragment messageFragment;
    MyFragment myFragment;
    Fragment nowFragment;
    FragmentManager fm;

    RadioGroup rg;
    RadioButton rb_better,rb_my,rb_channel,rb_message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        loadDefaultFragment();

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Fragment fragment=null;
                switch (checkedId){
                    case R.id.rb_1:
                        fragment = channelFragment;
                        break;
                    case R.id.rb_2:
                        if(betterFragment == null){
                            betterFragment = BetterFragment.newInstance("2");
                        }
                        fragment = betterFragment;
                        break;
                    case R.id.rb_3:
                        if(messageFragment == null){
                            messageFragment = MessageFragment.newInstance("3");
                        }
                        fragment = messageFragment;
                        break;
                    case R.id.rb_4:
                        if(myFragment == null){
                            myFragment = MyFragment.newInstance("4");
                        }
                        fragment = myFragment;
                        break;
                }
                replaceFragment(fragment);
            }
        });
    }

    void  init(){
        fm = getSupportFragmentManager();
        rg = findViewById(R.id.rg_bottom);
        rb_channel = findViewById(R.id.rb_1);
        rb_better = findViewById(R.id.rb_2);
        rb_message = findViewById(R.id.rb_3);
        rb_my = findViewById(R.id.rb_4);
    }

    void loadDefaultFragment(){
        channelFragment= ChannelFragment.newInstance("1");
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.frameContent,channelFragment);
        ft.addToBackStack(null);
        ft.commit();
        nowFragment = channelFragment;
    }

    void replaceFragment(Fragment fragment){
        FragmentTransaction ft = fm.beginTransaction();
        if(fragment.isAdded()){
            ft.hide(nowFragment).show(fragment);
        }else {
            ft.hide(nowFragment).add(R.id.frameContent,fragment);
            ft.addToBackStack(null);
        }
        ft.commit();
        nowFragment = fragment;
    }
}