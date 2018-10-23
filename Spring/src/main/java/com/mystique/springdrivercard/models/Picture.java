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
    @Column(name = "Picture", columnDefinition = "BLOB", nullable = false)
    private byte[] drivingPic;

    public Picture() {
    }

    public Picture(byte[] drivingPic){
        this.drivingPic = drivingPic;
    }


    public int getPictureId() {
        return pictureId;
    }

    public void setPictureId(int pictureId) {
        this.pictureId = pictureId;
    }

    public byte[] getDrivingPic() {
        return drivingPic;
    }

    public void setDrivingPic(byte[] drivingPic) {
        this.drivingPic = drivingPic;
    }
}
