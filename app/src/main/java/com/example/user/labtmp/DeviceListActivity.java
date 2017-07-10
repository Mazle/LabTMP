package com.example.user.labtmp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;

/**
 * Created by user on 22.06.2017.
 */

public class DeviceListActivity extends SingleFragmentActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("Begin", "starting DeviceListActivity");

    }

    @Override
    public Fragment createFragment() {
        return new DeviceListFragment();
    }
}
