package com.example.user.labtmp;

import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.GregorianCalendar;
import java.util.UUID;

/**
 * A placeholder fragment containing a simple view.
 * Прикрутить перенос текста в текствью заголовка
 */
public class DetailDeviceFragment extends Fragment {
    public static final String EXTRA_DEVICE_ID = "com.example.user.labtmp.detailDeviceFragment.device_id";

    /*              Код для тестирования             */

    private LaboratoryDevice device00 = new LaboratoryDevice(
            "Г4-107",
            DeviceType.GEN,
            R.drawable.tds2012c,
            new GregorianCalendar(2016,5,20),
            Status.ON_MUSTER,
            3456677);
        /*              код для тестирования             */

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UUID device_id = (UUID)getArguments().getSerializable(EXTRA_DEVICE_ID);
        LaboratoryDevice debuggingValue = DevicesBase.getDevicesBase(getActivity()).getDeviceFromList(device_id);
        device00= debuggingValue;
    }

   public static DetailDeviceFragment newInstance(UUID deviceId){
        Bundle args = new Bundle();
        args.putSerializable(DetailDeviceFragment.EXTRA_DEVICE_ID, deviceId);
        DetailDeviceFragment fragment = new DetailDeviceFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public DetailDeviceFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_detail_device, container, false);



        // переписать говнокод
        ImageView imageViewPhoto = (ImageView) v.findViewById(R.id.DeviceView);
        imageViewPhoto.setImageResource(device00.getPicture());

        TextView headerNameView = (TextView) v.findViewById(R.id.headerName);
        headerNameView.setText(device00.getStringFullName());

        TextView date1View = (TextView) v.findViewById(R.id.date1);
        date1View.setText("Дата последней поверки: " + "\n" + LaboratoryDevice.dateToString(device00.getFirstDate()));

        TextView date2View = (TextView) v.findViewById(R.id.date2);
        date2View.setText("Дата следующей поверки: "+ "\n" + LaboratoryDevice.dateToString(device00.getSecondDate()));



        TextView statusView = (TextView) v.findViewById(R.id.status);
        statusView.setText(device00.getStatus().toString());
        setColorByStatus(statusView, device00);

        TextView fNumberView = (TextView) v.findViewById(R.id.fNumber);
        fNumberView.setText(("Заводской номер: " + device00.getfNumber()));

       showAlarmMessageIfNeeded(v,fNumberView);

       TextView regulatorsListView = (TextView) v.findViewById(R.id.regulatorList);
        regulatorsListView.setText(device00.getRegulatorListToString());
        return v;
    }
    private static void setColorByStatus (TextView tv, LaboratoryDevice ld) {
        tv.setBackgroundResource(ld.getStatus().checkIn()?R.color.statusIn:R.color.statusOut);
    }
    private void showAlarmMessageIfNeeded(View v, TextView fNumberView) {
        if (
                device00.isTimeComingOver()) {
            TextView alarmMessageView = new TextView(this.getActivity().getApplicationContext());
            alarmMessageView.setBackgroundResource(R.color.alarmBackground);
            alarmMessageView.setText(
                    new GregorianCalendar().after(device00.getSecondDate()) ?
                            "Поверка просрочена!":"Истекает срок поверки");
            ConstraintLayout.LayoutParams alarmTextViewParams = new ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.WRAP_CONTENT,ConstraintLayout.LayoutParams.WRAP_CONTENT);
            alarmTextViewParams.leftToRight = R.id.guideline6;
            alarmTextViewParams.topToBottom = R.id.status;
            alarmTextViewParams.topMargin = 8;
            alarmTextViewParams.leftMargin = 8;
           /*
           Здесь нужно было бы создать файл xml с новыми ресурсами и на него ссылаться, но рпиложение не об этом
           возможно потом перепишу
            */
            alarmMessageView.setId(999876);
            //    alarmMessageView.setLayoutParams(alarmTextViewParams);
            ConstraintLayout deviceDetailFragmentLayout = (ConstraintLayout) v.findViewById(R.id.deviceDetailFragmentLayout);
            deviceDetailFragmentLayout.addView(alarmMessageView, alarmTextViewParams);
            ConstraintLayout.LayoutParams fNumberParams = (ConstraintLayout.LayoutParams)fNumberView.getLayoutParams();
            fNumberParams.topToBottom = alarmMessageView.getId();
            fNumberView.requestLayout();
        }
    }
}
