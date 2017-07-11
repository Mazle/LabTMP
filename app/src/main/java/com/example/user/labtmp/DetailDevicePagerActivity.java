package com.example.user.labtmp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by user on 10.07.2017.
 */

public class DetailDevicePagerActivity extends AppCompatActivity {
    private ViewPager detailDevicePager;
    private ArrayList<LaboratoryDevice> deviceArrayList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        detailDevicePager = new ViewPager(this);
        detailDevicePager.setId(R.id.detailDeviceViewPager);
        setContentView(detailDevicePager);
        deviceArrayList = DevicesBase.getDevicesBase(this).getDeviceArrayList();
        FragmentManager fm = getSupportFragmentManager();
        detailDevicePager.setAdapter(new FragmentStatePagerAdapter(fm) {
            @Override
            public Fragment getItem(int position) {
                LaboratoryDevice device = deviceArrayList.get(position);
                return DetailDeviceFragment.newInstance(device.getId());
            }

            @Override
            public int getCount() {
                return deviceArrayList.size();
            }
        });
        UUID deviceId = (UUID) getIntent().getSerializableExtra(DetailDeviceFragment.EXTRA_DEVICE_ID);
        for (int i=1;i<deviceArrayList.size();i++) {
            if (deviceId.equals(deviceArrayList.get(i).getId())) {
                detailDevicePager.setCurrentItem(i);
                break;
            }

        }
    }
}
