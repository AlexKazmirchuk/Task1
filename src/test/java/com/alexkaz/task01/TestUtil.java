package com.alexkaz.task01;

import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TestUtil {

    private Date before;
    private Date after;

    @Before
    public void prepare(){
        Calendar cal = Calendar.getInstance();

        cal.set(2016, 0, 1);

        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);

        before = cal.getTime();

        cal.set(2017, 11, 31);

        after = cal.getTime();
    }

    @Test
    public void test_generateFilename(){
        String result = Util.generateFilename(0);
        assertThat(result, is("IMG_0000.JPG"));

        result = Util.generateFilename(1);
        assertThat(result , is("IMG_0001.JPG"));

        result = Util.generateFilename(34);
        assertThat(result, is("IMG_0034.JPG"));

        result = Util.generateFilename(754);
        assertThat(result, is("IMG_0754.JPG"));

        result = Util.generateFilename(999);
        assertThat(result, is("IMG_0999.JPG"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_generateFilename_with_invalid_arg_1(){
        Util.generateFilename(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_generateFilename_with_invalid_arg_2(){
        Util.generateFilename(-100030303);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_generateFilename_with_invalid_arg_3(){
        Util.generateFilename(10000);
    }

    @Test
    public void test_getRandomTimeStamp(){
        long result;

        for (int i = 0; i < 10000; i++) {
            result = Util.getRandomTimestamp() * 100000L;
            assertThat(result, greaterThanOrEqualTo(before.getTime()));
            assertThat(result, lessThanOrEqualTo(after.getTime()));
        }
    }

    @Test
    public void test_createRandomArr(){
        Photo[] result = Util.createRandomArr(0);
        assertThat(result.length, equalTo(0));

        result = Util.createRandomArr(1);
        assertThat(result.length, is(1));
        assertThat(result[0].getId(), is(0));
        assertThat(result[0].getFilename(), is("IMG_0000.JPG"));
        assertThat(result[0].getTakenAt() * 100000L, greaterThanOrEqualTo(before.getTime()));
        assertThat(result[0].getTakenAt() * 100000L, lessThanOrEqualTo(after.getTime()));

        result = Util.createRandomArr(340);
        assertThat(result.length, is(340));
        assertThat(result[245].getId(), is(245));
        assertThat(result[51].getFilename(), is("IMG_0051.JPG"));
        assertThat(result[213].getTakenAt() * 100000L, greaterThanOrEqualTo(before.getTime()));
        assertThat(result[213].getTakenAt() * 100000L, lessThanOrEqualTo(after.getTime()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_createRandomArr_with_invalid_arg_1(){
        Util.createRandomArr(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_createRandomArr_with_invalid_arg_2(){
        Util.createRandomArr(-3467);
    }
}
