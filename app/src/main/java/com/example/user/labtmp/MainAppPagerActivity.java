package com.example.user.labtmp;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;


import java.util.ArrayList;


/**
 * Created by user on 11.07.2017.
 */

public class MainAppPagerActivity extends AppCompatActivity {
    private ViewPager mainActivityPager;
    private ArrayList<LaboratoryDevice> deviceArrayList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_pager_activity);
        mainActivityPager = (ViewPager) findViewById(R.id.main_pager_for_activity);
        deviceArrayList = DevicesBase.getDevicesBase(this).getDeviceArrayList();
        FragmentManager fm = getSupportFragmentManager();
        mainActivityPager.setAdapter(new FragmentStatePagerAdapter(fm) {
            @Override
            public Fragment getItem(int position) {
                Fragment fragment = PagesForMainActivity.getPagesForMainActivity(getApplicationContext()).getPagesArrayList().get(position);
                return fragment;
            }

            @Override
            public int getCount() {
                return PagesForMainActivity.getPagesForMainActivity(getApplicationContext()).getPagesArrayList().size();
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return "Page " + position ;
            }
        });
    }

}

