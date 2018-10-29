package com.mystique.rt.getmydrivercardapplcation.models;

public class Picture {
    private int pictureId;
    private byte[] picture;

    public Picture() {
        // empty constructor
    }

    public Picture(byte[] picture){
        this.picture = picture;
    }

    public int getPictureId() {
        return pictureId;
    }

    public void setPictureId(int pictureId) {
        this.pictureId = pictureId;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }
}
