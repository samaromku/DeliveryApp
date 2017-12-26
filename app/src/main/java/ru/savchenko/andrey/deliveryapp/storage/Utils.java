package ru.savchenko.andrey.deliveryapp.storage;

import org.joda.time.DateTime;

import java.util.Date;

import ru.savchenko.andrey.deliveryapp.interfaces.OnSetTime;

/**
 * Created by Andrey on 09.09.2017.
 */

public class Utils {
    public static void getDifferenceString(Date created, Date deadLine, OnSetTime onSetTime){

//        int minutes = deadLine.getMinuteOfDay() - created.getMinuteOfDay();
        int minutes = (int) (Math.random()*60);
        if(minutes<60){
            onSetTime.setMinutes(minutes, "\nмин");
        }else {
            onSetTime.setMinutes( minutes/60, "\nчас");
        }
    }
}
