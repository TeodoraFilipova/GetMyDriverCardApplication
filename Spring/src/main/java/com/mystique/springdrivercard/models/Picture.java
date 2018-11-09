package com.mystique.springdrivercard.models;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "pictures")
public class Picture {

    @Id
 //   @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PictureID", nullable = false)
    private int pictureId;

    @Lob
    @Column(name = "Picture", columnDefinition = "BLOB", nullable = false)
    private byte[] picture;

    @Column(name = "LastSetID", nullable = false)
    @NotNull
    private String lastSetID;

    public Picture() {
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

    public String getLastSetID() {
        return lastSetID;
    }

    public void setLastSetID(String lastSetID) {
        this.lastSetID = lastSetID;
    }
}
