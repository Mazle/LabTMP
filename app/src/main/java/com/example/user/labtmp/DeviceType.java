package com.example.user.labtmp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by user on 08.06.2017.
 */

public enum DeviceType {
    GEN {
        @Override
        public String toString() {
            return "Генератор";
        }
    },
    OSCILLOSCOPE {
        @Override
        public String toString() {
            return "Осциллограф";
        }
    },
    POWER {
        @Override
        public String toString() {
            return "Источник питания";
        }
    },
    MILTIMETER {
        @Override
        public String toString() {
            return "Мультиметр";
        }
    },
    TIMECOUNTER {
        @Override
        public String toString() {
            return "Частотомер";
        }
    },
    VOLTMETER {
        @Override
        public String toString() {
            return "Вольтметр";
        }
    },
    CONSOLE {
        @Override
        public String toString() {
            return "Стендовое оборудование";
        }
    },
    ANALYZER
            {
                @Override
                public String toString() {
                    return "Анализатор";
                }
            },
    OTHER {
        @Override
        public String toString() {
            return "Прибор";
        }
    };
    private static final List<DeviceType> deviceTypeList = Collections.unmodifiableList(Arrays.asList(values()));
    private static final Random random = new Random();
    private static final int LISTSIZE = deviceTypeList.size();
    public static DeviceType randomDeviceType(){
        return deviceTypeList.get(random.nextInt(LISTSIZE));
    }

}
