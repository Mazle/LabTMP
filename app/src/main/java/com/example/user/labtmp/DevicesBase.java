package com.example.user.labtmp;

import android.content.Context;
import android.util.Log;


import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Random;
import java.util.UUID;

/**
 * Created by user on 14.06.2017.
 */

public class DevicesBase {
    private static DevicesBase devicesBase;
    private Context mAppContext;
    private ArrayList<LaboratoryDevice> deviceList;
  /*
    Код для теста
     */
  private int[] photoResourseArray = { R.drawable.mmappa62, R.drawable.genrssmb100a, R.drawable.geng4_107,R.drawable.tds2012c};
    /*
    Код для теста
     */




    private DevicesBase(Context mAppContext) {
        this.mAppContext = mAppContext;


         /*
    Код для теста
     */

        deviceList = new ArrayList<LaboratoryDevice>();
        for (int i = 0; i < 20; i++) {
            deviceList.add(new LaboratoryDevice(
                    "Device " + i,
                    DeviceType.randomDeviceType(),
                    getRandomPhotoResourse(),
                    new GregorianCalendar(),
                    Status.randomStatus(),
                    new Random().nextInt(999999)
            ));

        }


    /*
    Код для теста
     */
    }
    // Код для теста
    public int getRandomPhotoResourse (){
        return photoResourseArray[new Random().nextInt(photoResourseArray.length-1)];
    }
    // Код для теста

    public static DevicesBase getDevicesBase(Context c) {
       if (devicesBase==null)  devicesBase = new DevicesBase(c.getApplicationContext());
         return devicesBase;
    }

    public ArrayList<LaboratoryDevice> getDeviceArrayList() {
        return deviceList;
    }
    public LaboratoryDevice getDeviceFromList (UUID id){
        for (LaboratoryDevice device: deviceList) {
            Log.d("getDeviceFrom list","device.getId= "+device.getId()+": UUID id= "+id);
            if (device.getId().equals(id))
                return device;
        }
        return null;
    }

}
