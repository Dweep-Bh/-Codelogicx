package com.example.tab_demo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.Switch;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    ViewPager viewPager;
    TabLayout tablayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager=findViewById(R.id.viewpager);
        tablayout=findViewById(R.id.tablayout);

        Dweep obj=new Dweep(getSupportFragmentManager());
        viewPager.setAdapter(obj);
        tablayout.setupWithViewPager(viewPager);

    }
    class Dweep extends FragmentPagerAdapter
    {


        public Dweep(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            if(position==0)
            {
                return new Chats();
            }
            if(position==1)
            {
                return new Status();
            }
            if(position==2)
            {
                return new  Calls();
            }
            return null;
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            switch (position)
            {
                case 0:
                    return "Chats";
                case 1:
                    return "Status";
                case 2:
                    return "Calls";

            }

            return null;

        }
    }
}