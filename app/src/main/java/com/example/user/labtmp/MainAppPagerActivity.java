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
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 11.07.2017.
 */

public class MainAppPagerActivity extends AppCompatActivity {
    private ViewPager mainActivityPager;
    private ArrayList<LaboratoryDevice> deviceArrayList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainActivityPager = new ViewPager(this);
        setContentView(R.layout.main_pager_activity);
        deviceArrayList = DevicesBase.getDevicesBase(this).getDeviceArrayList();
        FragmentManager fm = getSupportFragmentManager();
        mainActivityPager.setAdapter(new FragmentStatePagerAdapter(fm) {
            @Override
            public Fragment getItem(int position) {
                Fragment fragment = PagesForMainActivity.getPagesForMainActivity((getApplicationContext()).(position);
                return fragment;
            }

            @Override
            public int getCount() {
                return deviceArrayList.size();
            }
        });
    }

}

