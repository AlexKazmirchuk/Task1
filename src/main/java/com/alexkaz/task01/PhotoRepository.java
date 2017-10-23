package com.alexkaz.task01;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PhotoRepository {

    public static final int SIZE = 10000;
    private Photo[] photos;

    public PhotoRepository(Photo[] photos) {
        this.photos = photos;
    }

    public Photo[] findPhotos(String date) throws ParseException {
        if (date == null) throw new IllegalArgumentException("String date is null");
        if (photos == null) return new Photo[0];

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        df.setLenient(false);
        Date parsedDate = df.parse(date);

        List<Photo> photoList = new ArrayList<>();

        for (Photo p : photos){
            if (p.getTakenAt() * 100000L == parsedDate.getTime()){
                photoList.add(p);
            }
        }

        Photo[] result = new Photo[photoList.size()];

        for (int i = 0; i < result.length; i++) {
            result[i] = photoList.get(i);
        }

        return result;
    }
}
