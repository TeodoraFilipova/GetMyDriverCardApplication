/**
 * <h1>Picture Model class</h1>
 *
 * <b>Description: </b> This class is a model which corresponds to the model
 * with the same name in the Spring application. It is a POJO class with
 * constructors, getters, and setters.
 *
 * @author  Mystique Team
 * @version 1.0
 * @since   2018-11-12
 */

package com.mystique.rt.getmydrivercardapplcation.models;

import java.io.Serializable;

public class Picture implements Serializable {
    private int pictureId;
    private byte[] picture;
    private String lastSetID;

    public Picture() {
        // empty constructor
    }

    // for unit testing
    public Picture(int pictureId, String lastSetID) {
        this.pictureId = pictureId;
        this.lastSetID = lastSetID;
    }

    public Picture(byte[] picture) {
        this.picture = picture;
    }

    public int getPictureId() {
        return pictureId;
    }

    public void setPictureId(int pictureId) {
        this.pictureId = pictureId;
    }

    // cast to bitmap
    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    public String getLastSetID() {
        return lastSetID;
    }

    public void setLastSetID(String lastSetID) {
        this.lastSetID = lastSetID;
    }
}
