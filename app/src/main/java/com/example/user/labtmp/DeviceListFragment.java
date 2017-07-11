package com.example.user.labtmp;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by user on 20.06.2017.
 * Написать аларм меседж
 */

public class DeviceListFragment extends ListFragment {

    private ArrayList<LaboratoryDevice>  deviceArrayList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.v("Begin",new Date()+ "starting createView for DeviceListFragment");
      //  return inflater.inflate(R.layout.content_activity_fragment,container,false);

        return super.onCreateView(inflater, container, savedInstanceState);

           }

       @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        Log.d("click", "decice_item was clicked in deviceListFragment");
        LaboratoryDevice clickedDevice = ((LaboratoryDeviceAdapter)getListAdapter()).getItem(position);
        Intent detailIntent = new Intent(getActivity(), DetailDevicePagerActivity.class);
        detailIntent.putExtra(DetailDeviceFragment.EXTRA_DEVICE_ID,clickedDevice.getId());
        startActivity(detailIntent);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("Begin","starting DeviceListFragment");
        deviceArrayList = DevicesBase.getDevicesBase(getActivity()).getDeviceArrayList();
        Log.d("Begin"," creating Adapter");
        LaboratoryDeviceAdapter adapter = new LaboratoryDeviceAdapter(deviceArrayList);
        setListAdapter(adapter);
        Log.d("end", " DeviceListFragment");
    }
// пока не работает.
    private ViewGroup setNeededHeightOfInclude (ViewGroup container){
        container.setTop(getActivity().findViewById(R.id.toolBarContainer).getHeight());
        return container;
    }

    private class LaboratoryDeviceAdapter extends ArrayAdapter<LaboratoryDevice> {

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            Log.d("Adapter Creating","begin Creating View of Adapter");
            if (convertView==null)
                convertView = getActivity().getLayoutInflater().inflate(R.layout.list_item_device, null);
            Log.d("Adapter Creating","checked if");
            LaboratoryDevice choosenDevice = getItem(position);
            Log.d("Adapter Creating","specifyed device");
            TextView deviceName = (TextView) convertView.findViewById(R.id.name_list_item_device);
            deviceName.setText(choosenDevice.getStringFullName());
            Log.d("Adapter Creating","set device name");
            ImageView devicePicture = (ImageView) convertView.findViewById(R.id.devicePicture_list_item_device);
            devicePicture.setImageResource(choosenDevice.getPicture());
            Log.d("Adapter Creating","set imageView");
            // Переписать с нормальным форматом даты
            TextView musterDate = (TextView) convertView.findViewById(R.id.dateOfMuster_list_item_device);
            musterDate.setText(choosenDevice.dateToString(choosenDevice.getSecondDate()));
            if (
                    choosenDevice.isTimeComingOver())
                musterDate.setTextColor(Color.RED);
            Log.d("Adapter Creating","set date of next muster");
            TextView deviceStatus = (TextView) convertView.findViewById(R.id.status_list_item_device);
            deviceStatus.setText(choosenDevice.getStatus().toString());
            Log.d("Adapter Creating","set Status");
            return convertView;
        }

        public LaboratoryDeviceAdapter(@NonNull List<LaboratoryDevice> objects) {
            super(getActivity(), 0, objects);

        }
    }
}
