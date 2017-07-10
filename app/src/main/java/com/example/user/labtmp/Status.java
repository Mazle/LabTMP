package com.example.user.labtmp;

import android.renderscript.Sampler;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by user on 08.06.2017.
 */

public enum Status {
    BUSY(true) {
       // isIn = true;
       // public boolean checkSide() {return isIn;}
        @Override
        public String toString() {
            return "В работе";
        }
    }, // В РАБОТЕ
    FREE (true) {
       // boolean isIn = true;
        @Override
        public String toString() {
            return "Свободен";
        }
    }, //СВОБОДЕН
    ON_MUSTER(false) {
      //  boolean isIn = false;
        @Override
        public String toString() {
            return "На поверке";
        }
    }, // НА ПОВЕРКЕ
    ON_REPAIR(false) {
      //  boolean isIn = false;
        @Override
        public String toString() {
            return "В ремонте";
        }
    }, // В РЕМОНТЕ
    LEASING(false) {
       // boolean isIn = false;
        @Override
        public String toString() {
            return "Отдали в пользование";
        }
    }, //ОТДАЛИ В ПОЛЬЗОВАНИЕ
    BORROWED(true) {
       // boolean isIn = true;
        @Override
        public String toString() {
            return "Заимствованный";
        }
    }; //ЗАИМСТВОВАННЫЙ
    private static final List<Status> statusList = Collections.unmodifiableList(Arrays.asList(values()));
    private static final Random random = new Random();
    private static final int LISTSIZE = statusList.size();
    public static Status randomStatus(){
        return statusList.get(random.nextInt(LISTSIZE));

    }
    // хуй знает получится или нет
    Status(boolean isIn) {
        this.isIn = isIn;
    }
    boolean isIn;
    public boolean checkIn(){
        return isIn;
    }

}
