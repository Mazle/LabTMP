package com.example.user.labtmp;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by user on 11.07.2017.
 */

public class PagesForMainActivity {
    private static PagesForMainActivity pagesForMainActivity;
    private Context pagesContext;
    private ArrayList<Fragment> pagesArray;

    private PagesForMainActivity(Context c) {
       Log.d("crashPager","starting Constructor");
        this.pagesContext=c;
        // <код для теста
        pagesArray = new ArrayList<>();
        pagesArray.add(new DeviceListFragment());
        pagesArray.add(DetailDeviceFragment.newInstance(DevicesBase.getDevicesBase(c).getDeviceArrayList().get(1).getId()));
        pagesArray.add(DetailDeviceFragment.newInstance(DevicesBase.getDevicesBase(c).getDeviceArrayList().get(2).getId()));
        pagesArray.add(DetailDeviceFragment.newInstance(DevicesBase.getDevicesBase(c).getDeviceArrayList().get(3).getId()));
        // код для теста/>
        Log.d("crashPager","finish constructing");
    }
    public static PagesForMainActivity getPagesForMainActivity (Context c) {
        if (pagesForMainActivity==null)  pagesForMainActivity = new PagesForMainActivity(c.getApplicationContext());
        return pagesForMainActivity;
    }
    public ArrayList<Fragment> getPagesArrayList (){
        return pagesArray;
    }
}
