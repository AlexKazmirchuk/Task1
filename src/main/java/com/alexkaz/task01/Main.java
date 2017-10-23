package com.alexkaz.task01;

import java.text.ParseException;

public class Main {

    public static void main(String[] args) throws ParseException {
        PhotoRepository repository = new PhotoRepository(Util.createRandomArr(PhotoRepository.SIZE));

        Photo[] found = repository.findPhotos("2017-02-12");
        System.out.println(found.length);


    }
}
