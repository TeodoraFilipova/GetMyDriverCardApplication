package com.mystique.springdrivercard.models;


import javax.persistence.*;

@Entity
@Table(name = "pictures")
public class Picture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PictureID")
    private int pictureId;


    @Lob
    @Column(name = "Picture", columnDefinition = "BLOB")
    private byte[] picture;

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
}
