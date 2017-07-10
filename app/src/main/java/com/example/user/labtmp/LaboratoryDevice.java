package com.example.user.labtmp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.media.Image;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.UUID;

/**
 * Created by user on 08.06.2017.
 * Дописать getStringDeviceType
 * Дописать конструктор с двумя датами
 */

public class LaboratoryDevice {

    UUID id;
    GregorianCalendar firstDate;
    GregorianCalendar  secondDate;
    int fNumber;
    ArrayList<Regulator> regulatorsList;
    Status status;
    String name;
    DeviceType type;
    int picture; // адрес картинки из ресурсов

    public int getPicture() {
        return picture;
    }

    public LaboratoryDevice(String name, DeviceType type, int pictureName, GregorianCalendar  firstDate, Status status,int fNumber) {
       this.picture = pictureName;
       this.name = name;
       this.type = type;
       this.firstDate = firstDate;
       this.secondDate = new GregorianCalendar(firstDate.get(Calendar.YEAR)+1,firstDate.get(Calendar.MONTH),firstDate.get(Calendar.DAY_OF_MONTH));
       this.status = status;
        this.fNumber = fNumber;
        this.id = UUID.randomUUID();
        /*
        Код для тестирования
         */
        regulatorsList = new ArrayList<Regulator>();
        regulatorsList.add(new Regulator("Палибин","Алексей","Андреевич"));
        regulatorsList.add(new Regulator("Оларь","Алексей","Батькович"));
        regulatorsList.add(new Regulator("Зюзин","Андрей","Олегович"));

        /*
        Код для тестирования
         */

  }


    public static String dateToString(GregorianCalendar date) {

        return ( date.get(Calendar.DAY_OF_MONTH) + "." +
                (date.get(Calendar.MONTH)+1)  + "." +
                date.get(Calendar.YEAR));
    }
    public int getfNumber() {
        return fNumber;
    }
    public GregorianCalendar getSecondDate() {
        return secondDate;
    }
    public GregorianCalendar getFirstDate() {
        return firstDate;
    }
    public String getRegulatorListToString(){
        StringBuilder result = new StringBuilder();
        for (Regulator unit: regulatorsList) {
            result.append(unit.getSurname() + " " + unit.getFirstName() + " " + unit.getMidleName() + "\n");
        }

        return result.toString();
    }
    public String getStringFullName(){
       String result;
         /*if (this.type==null) {
             result = this.name.toUpperCase();
         }
         else
             result = (this.type.toString().toUpperCase()+" "+this.name.toUpperCase());
        */
        result = this.type == null ?
                 this.name.toUpperCase() :
                 (this.type.toString().toUpperCase()+" "+this.name.toUpperCase());

        return result;
    }
    public Status getStatus() {
        return status;
    }
    public UUID getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public boolean isTimeComingOver() {
        if (
                this.getSecondDate().getTimeInMillis() - new GregorianCalendar().getTimeInMillis() < 1209600000
                        |
                        new GregorianCalendar().after(this.getSecondDate()) )
            return true;
        else return false;
    }
    @Override
    public String toString() {
        return getStringFullName();
    }
}
