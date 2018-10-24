package com.mystique.springdrivercard.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "drivers")
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "driverID", nullable = false)
    private int driverId;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "driver")
    @JsonIgnore
    private List<CardApplicationForm> cardApplicationForms;

    @Column(name = "PersonalNumber", nullable = false)
    private String personalNumber;

    @Column(name = "FirstName", nullable = false)
    private String firstName;

    @Column(name = "LastName", nullable = false)
    private String lastName;

    @Column(name = "DateOfBirth", nullable = false)
    private Date dateOfBirth;

    @Column(name = "Address", nullable = false)
    private String address;

    @Column(name = "PhoneNumber", nullable = false)
    private String phoneNumber;

    @Column(name = "Email", nullable = false)
    private String email;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "SelfieID", nullable = false)
    private Picture selfie;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "DrivingPicID", nullable = false)
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
