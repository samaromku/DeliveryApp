package ru.savchenko.andrey.deliveryapp.storage;

import org.joda.time.DateTime;

import ru.savchenko.andrey.deliveryapp.interfaces.OnSetTime;

/**
 * Created by Andrey on 09.09.2017.
 */

public class Utils {
    public static void getDifferenceString(DateTime created, DateTime deadLine, OnSetTime onSetTime){

        int minutes = deadLine.getMinuteOfDay() - created.getMinuteOfDay();

        if(minutes<60){
            onSetTime.setMinutes(minutes, "\nмин");
        }else {
            onSetTime.setMinutes( minutes/60, "\nчас");
        }
    }
}
