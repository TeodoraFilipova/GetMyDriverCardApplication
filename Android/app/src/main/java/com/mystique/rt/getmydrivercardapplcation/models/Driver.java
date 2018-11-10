package com.mystique.rt.getmydrivercardapplcation.models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Driver implements Serializable {
    private int driverId;
    private List<CardApplicationForm> cardApplicationForms;
    private String personalNumber;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String address;
    private String phoneNumber;
    private String email;
    private Picture selfie;
    private Picture drivingPic;
    private String lastSetID;

    public Driver(){
        // empty constructor
    }

    public Driver(String personalNumber, String firstName, String lastName, Date dateOfBirth, String address,
                  String phoneNumber, String email, Picture selfie, Picture drivingPic){
        this.personalNumber = personalNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.selfie = selfie;
        this.drivingPic = drivingPic;
    }

    // for unit testing
    public Driver(int driverId, String personalNumber, String firstName, String lastName, String lastSetID) {
        this.driverId = driverId;
        this.personalNumber = personalNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.lastSetID = lastSetID;
    }

    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }

    public List<CardApplicationForm> getCardApplicationForms() {
        return cardApplicationForms;
    }

    public void setCardApplicationForms(List<CardApplicationForm> cardApplicationForms) {
        this.cardApplicationForms = cardApplicationForms;
    }

    public String getPersonalNumber() {
        return personalNumber;
    }

    public void setPersonalNumber(String personalNumber) {
        this.personalNumber = personalNumber;
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

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getLastSetID() {
        return lastSetID;
    }

    public void setLastSetID(String lastSetID) {
        this.lastSetID = lastSetID;
    }
}
