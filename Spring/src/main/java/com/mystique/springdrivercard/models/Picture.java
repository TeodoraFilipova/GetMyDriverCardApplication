package com.mystique.springdrivercard.models;


import javax.persistence.*;

@Entity
@Table(name = "pictures")
public class Picture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PictureID")
    private int pictureId;

    @OneToOne(mappedBy = "Picture")
    private byte[] drivingPic;

    public Picture() {
    }

    public Picture(byte[] drivingPic){
        this.drivingPic = drivingPic;
    }


}
