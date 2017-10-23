package com.alexkaz.task01;

import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class TestPhotoRepository {

    @Test
    public void test_findPhotos() throws ParseException {
        Photo[] allPhotos = new Photo[0];
        PhotoRepository repository = new PhotoRepository(allPhotos);

        Photo[] result = repository.findPhotos("2016-08-24");
        assertThat(result.length, is(0));

        allPhotos = new Photo[5];
        allPhotos[0] = new Photo(0, Util.generateFilename(0), getTestTimestamp("2016-01-03"));
        allPhotos[1] = new Photo(1, Util.generateFilename(1), getTestTimestamp("2016-06-13"));
        allPhotos[2] = new Photo(2, Util.generateFilename(2), getTestTimestamp("2017-10-25"));
        allPhotos[3] = new Photo(3, Util.generateFilename(3), getTestTimestamp("2016-11-17"));
        allPhotos[4] = new Photo(4, Util.generateFilename(4), getTestTimestamp("2016-01-03"));

        repository = new PhotoRepository(allPhotos);

        result = repository.findPhotos("2016-01-03");
        assertThat(result.length, is(2));
        assertThat(result[0].getId(), is(0));
        assertThat(result[1].getId(), is(4));

        result = repository.findPhotos("2017-10-25");
        assertThat(result.length, is(1));
        assertThat(result[0].getId(), is(2));
        assertThat(result[0].getFilename(), is("IMG_0002.JPG"));

        result = repository.findPhotos("2016-11-17");
        assertThat(result.length, is(1));
        assertThat(result[0].getId(), is(3));
        assertThat(result[0].getFilename(), is("IMG_0003.JPG"));

        result = repository.findPhotos("2017-08-02");
        assertThat(result.length, is(0));
    }

    @Test
    public void test_findPhotos_with_null_photo_array() throws ParseException {
        PhotoRepository repository = new PhotoRepository(null);

        Photo[] result = repository.findPhotos("2017-08-02");
        assertThat(result.length, is(0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_findPhotos_with_null_arg() throws ParseException {
        PhotoRepository repository = new PhotoRepository(null);
        repository.findPhotos(null);
    }

    @Test(expected = ParseException.class)
    public void test_findPhotos_with_invalid_arg_1() throws ParseException {
        Photo[] allPhotos = new Photo[0];

        PhotoRepository repository = new PhotoRepository(allPhotos);
        repository.findPhotos("2014-02-31");
    }

    @Test(expected = ParseException.class)
    public void test_findPhotos_with_invalid_arg_2() throws ParseException {
        Photo[] allPhotos = new Photo[0];

        PhotoRepository repository = new PhotoRepository(allPhotos);
        repository.findPhotos("2014.02-27");
    }

    @Test(expected = ParseException.class)
    public void test_findPhotos_with_invalid_arg_3() throws ParseException {
        Photo[] allPhotos = new Photo[0];

        PhotoRepository repository = new PhotoRepository(allPhotos);
        repository.findPhotos(".2014-02-27");
    }

    @Test(expected = ParseException.class)
    public void test_findPhotos_with_invalid_arg_4() throws ParseException {
        Photo[] allPhotos = new Photo[0];

        PhotoRepository repository = new PhotoRepository(allPhotos);
        repository.findPhotos(".4t t4y");
    }

    @Test(expected = ParseException.class)
    public void test_findPhotos_with_invalid_arg_5() throws ParseException {
        Photo[] allPhotos = new Photo[0];

        PhotoRepository repository = new PhotoRepository(allPhotos);
        repository.findPhotos("2018 - 02 - 27");
    }


    private int getTestTimestamp(String date){
        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date parsedDate = dateFormat.parse(date);
            return (int) (parsedDate.getTime() / 100000);
        } catch (ParseException e) {
            throw new IllegalArgumentException("Unparsable string: " + date);
        }
    }

}
