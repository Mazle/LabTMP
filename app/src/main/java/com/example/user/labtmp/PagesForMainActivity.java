package com.example.user.labtmp;

import android.content.Context;
import android.support.v4.app.Fragment;

import java.util.ArrayList;

/**
 * Created by user on 11.07.2017.
 */

public class PagesForMainActivity {
    private static PagesForMainActivity pagesForMainActivity;
    private Context pagesContext;
    private ArrayList<Fragment> pagesArray;

    private PagesForMainActivity(Context c) {
        this.pagesContext=c;
        pagesArray = new ArrayList<>();
        pagesArray.set(0,new DeviceListFragment());
        pagesArray.set(1, new DetailDeviceFragment());
        pagesArray.set(2,new DetailDeviceFragment());
        pagesArray.set(3,new DetailDeviceFragment());
    }
    public static PagesForMainActivity getPagesForMainActivity (Context c) {
        if (pagesForMainActivity==null)  pagesForMainActivity = new PagesForMainActivity(c.getApplicationContext());
        return pagesForMainActivity;
    }
    public ArrayList<Fragment> getPagesArrayList (){
        return pagesArray;
    }
}
