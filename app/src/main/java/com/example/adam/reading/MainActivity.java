package com.example.adam.reading;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;


public class MainActivity extends AppCompatActivity {
    private BottomNavigationBar bottomNavigationBar;
    private HomeFragment homeFragment;
    private MeFragment meFragment;
    private BookFragment bookFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationBar = findViewById(R.id.bnb);
        bottomNavigationBar.setMode(BottomNavigationBar.MODE_FIXED);
        bottomNavigationBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_RIPPLE);
        bottomNavigationBar
                .addItem(new BottomNavigationItem(R.drawable.ic_home_white_24dp, "首页")).setActiveColor(R.color.home)
                .addItem(new BottomNavigationItem(R.drawable.ic_book_white_24dp, "书城")).setActiveColor(R.color.books)
                .addItem(new BottomNavigationItem(R.drawable.ic_github_circle_white_24dp, "我的")).setActiveColor(R.color.me)
                .setFirstSelectedPosition(0)
                .initialise();
        bottomNavigationBar.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position) {
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                switch (position) {
                    case 0:
                        if (homeFragment == null) {
                            homeFragment = HomeFragment.newInstance("首页");
                        }
                        fragmentTransaction.replace(R.id.fmlayout, homeFragment);
                        break;
                    case 1:
                        if (bookFragment == null) {
                            bookFragment = BookFragment.newInstance("书城");
                        }
                        fragmentTransaction.replace(R.id.fmlayout, bookFragment);
                        break;
                    case 2:
                        if (meFragment == null) {
                            meFragment = MeFragment.newInstance("我的");
                        }
                        fragmentTransaction.replace(R.id.fmlayout, meFragment);
                        break;
                }
                fragmentTransaction.commit();
            }

            @Override
            public void onTabUnselected(int position) {

            }

            @Override
            public void onTabReselected(int position) {

            }
        });
        setDefaultFragment();
    }

    private void setDefaultFragment() {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        homeFragment = HomeFragment.newInstance("首页");
        fragmentTransaction.replace(R.id.fmlayout,homeFragment);
        fragmentTransaction.commit();
    }


}
