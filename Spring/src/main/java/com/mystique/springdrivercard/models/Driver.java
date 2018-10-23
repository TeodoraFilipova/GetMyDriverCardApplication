package com.mystique.springdrivercard.models;

import com.mystique.springdrivercard.models.Picture;
import com.mystique.springdrivercard.models.CardApplicationForm;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "drivers")
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "driverID")
    private int driverId;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "driver")
    private List<CardApplicationForm> cardApplicationForms;

    @Column(name = "PersonalNumber")
    private String personalNumber;

    @Column(name = "FirstName")
    private String firstName;

    @Column(name = "LastName")
    private String lastName;

    @Column(name = "DateOfBirth")
    private Date dateOfBirth;

    @Column(name = "Address")
    private String address;

    @Column(name = "PhoneNumber")
    private String phoneNumber;

    @Column(name = "Email")
    private String email;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SelfieID")
    private Picture selfie;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DrivingPicID")
    private Picture drivingPic;


    public Driver(){
    }

    public Driver(String firstName, String lastName, Date dateOfBirth, String address,
                  String phoneNumber, String email, Picture selfie, Picture drivingPic){
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.selfie = selfie;
        this.drivingPic = drivingPic;

    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }

    public String getPersonalNumber() {
        return personalNumber;
    }

    public void setPersonalNumber(String personalNumber) {
        this.personalNumber = personalNumber;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Picture getSelfie() {
        return selfie;
    }

    public void setSelfie(Picture selfie) {
        this.selfie = selfie;
    }

    public Picture getDrivingPic() {
        return drivingPic;
    }

    public void setDrivingPic(Picture drivingPic) {
        this.drivingPic = drivingPic;
    }

    public List<CardApplicationForm> getCardApplicationForms() {
        return cardApplicationForms;
    }

    public void setCardApplicationForms(List<CardApplicationForm> cardApplicationForms) {
        this.cardApplicationForms = cardApplicationForms;
    }
}
