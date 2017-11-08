# Completed test Task 1

Please provide the Java code for the following:

* Create a `Photo` class that represents a photo. It should have the following properties:

```
id - int - auto incrementing unique id
filename - string - filename of the photo
taken_at - int - unix timestamp of when the photo was taken
```

* Create an array of 10k random `Photo` objects. 
Filename should be in the format of `IMG_xxxx.JPG` with `xxxx` incrementing from `0000` to `9999`. `taken_at` must correspond to some arbitrary value between January 1st, 2016 and December 31st, 2017. 
Remember that a photo can be taken at any second in time, so your data set must represent this.

* Write a function that searches through this array and finds photos that are taken on the give date. It will be called with date strings such as `2016-02-01`, `2017-12-21` etc. Function signature should be like this:

```
  public static Photo[] findPhotos(String date) {
    ...
  }
```
