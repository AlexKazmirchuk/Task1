package com.alexkaz.task01;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

public class Util {

    public static String generateFilename(int number){
        if (number < 0)
            throw new IllegalArgumentException("Argument musts be greater than -1");
        if (number < 10)
            return "IMG_000" + number + ".JPG";
        if (number < 100)
            return "IMG_00" + number + ".JPG";
        if (number < 1000)
            return "IMG_0" + number + ".JPG";
        if (number < 10000)
            return "IMG_" + number + ".JPG";
        throw new IllegalArgumentException("Argument musts be less than 10000");
    }

    public static int getRandomTimestamp(){
        Calendar cal = Calendar.getInstance();

        cal.set(2016, 0, 1);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);

        // 2016.01.01
        Date before = cal.getTime();

        cal.set(2017, 11, 31);

        // 2017.12.31
        Date after = cal.getTime();

        Date randomDate = new Date(ThreadLocalRandom.current().nextLong(before.getTime(), after.getTime()));

        //  return value is divided on 100,000 to remove hours, minutes, seconds and milliseconds
        return (int) (randomDate.getTime() / 100000);
    }

    public static Photo[] createRandomArr(int size){
        if (size < 0) throw new IllegalArgumentException("Size must be greater than 0");

        Photo[] photos = new Photo[size];

        for (int i = 0; i < size; i++) {
            photos[i] = new Photo(i, generateFilename(i), getRandomTimestamp());
        }

        return photos;
    }

}
