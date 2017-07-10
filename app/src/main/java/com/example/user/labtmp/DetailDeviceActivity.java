package com.example.user.labtmp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import java.util.UUID;

public class DetailDeviceActivity extends SingleFragmentActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("Begin", "starting DetailDeviceActivity");
    }

    @Override
    public Fragment createFragment() {
        UUID deviceId = (UUID)getIntent().getSerializableExtra(DetailDeviceFragment.EXTRA_DEVICE_ID);
        return DetailDeviceFragment.newInstance(deviceId);
    }
}

