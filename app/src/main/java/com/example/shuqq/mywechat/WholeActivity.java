package com.example.shuqq.mywechat;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class WholeActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private ViewPager viewPager;
    private BottomNavigationView navigation;
    private MenuItem menuItem;
    private FragmentPagerAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_whole);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        mTextMessage = (TextView) findViewById(R.id.message);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if (menuItem != null) {
                    menuItem.setChecked(false);
                } else {
                    navigation.getMenu().getItem(0).setChecked(false);
                }
                menuItem = navigation.getMenu().getItem(position);
                menuItem.setChecked(true);
            }

            @Override
            public void onPageSelected(int position) {
                if (menuItem != null) {
                    menuItem.setChecked(false);
                } else {
                    navigation.getMenu().getItem(0).setChecked(false);
                }
                menuItem = navigation.getMenu().getItem(position);
                menuItem.setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }

        });

        navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_notifications:
                        mTextMessage.setText(R.string.title_notifications);
                        viewPager.setCurrentItem(0);
                        return true;
                    case R.id.navigation_home:
                        mTextMessage.setText(R.string.title_home);
                        viewPager.setCurrentItem(1);
                        return true;
                    case R.id.navigation_dashboard:
                        mTextMessage.setText(R.string.title_dashboard);
                        viewPager.setCurrentItem(2);
                        return true;

                }
                return false;
            }
        });

        setupViewPager(viewPager);

    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        Tab1 tab1 = new Tab1();
        Tab2 tab2 = new Tab2();
        Tab3 tab3 = new Tab3();
        adapter.addFragment(tab1);
        adapter.addFragment(tab2);
        adapter.addFragment(tab3);

        viewPager.setAdapter(adapter);
    }



}


