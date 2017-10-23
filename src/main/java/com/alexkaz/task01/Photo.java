package com.alexkaz.task01;

public class Photo {

    private int id;
    private String filename;
    private int takenAt;

    public Photo() {
    }

    public Photo(int id, String filename, int takenAt) {
        this.id = id;
        this.filename = filename;
        this.takenAt = takenAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public int getTakenAt() {
        return takenAt;
    }

    public void setTakenAt(int takenAt) {
        this.takenAt = takenAt;
    }

    @Override
    public String toString() {
        return "Photo{" +
                "id=" + id +
                ", filename='" + filename + '\'' +
                ", takenAt=" + takenAt +
                '}';
    }
}
