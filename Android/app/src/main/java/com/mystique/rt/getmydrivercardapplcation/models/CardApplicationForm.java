package com.mystique.rt.getmydrivercardapplcation.models;

import java.io.Serializable;
import java.util.Date;

public class CardApplicationForm implements Serializable {
    private int cardApplicationFormId;
    private Driver driver;
    private Date dateOfSubmission;
    private String status;
    private String type;
    private String receivingOffice;
    private String drivingLicenseNumber;
    private String drivingLicenseCountry;
    private Date dateOfEvent;
    private String placeOfEvent;
    private Picture oldCardPicture;
    private String oldCardCountry;
    private String oldCardAuthority;
    private String oldCardNumber;
    private Date oldCardDateOfExpiry;
    private String newAddress;
    private String newFirstName;
    private String newLastName;
    private Picture newSelfie;
    private String renewalReason;
    private Picture signaturePicture;
    private String statusCheckCode;
    private String details;
    private String lastSetID;


    // Constructors
    public CardApplicationForm() {
        //default empty
    }

    // First application for a new card
    public CardApplicationForm(Driver driver, Date dateOfSubmission, String status, String type,
                               String receivingOffice, String drivingLicenseCountry,
                               String drivingLicenseNumber, Picture signaturePicture, String statusCheckCode) {
        this.driver = driver;
        this.dateOfSubmission = dateOfSubmission;
        this.status = status;
        this.type = type;
        this.receivingOffice = receivingOffice;
        this.drivingLicenseCountry = drivingLicenseCountry;
        this.drivingLicenseNumber = drivingLicenseNumber;
        this.signaturePicture = signaturePicture;
        this.statusCheckCode = statusCheckCode;
        this.details = "";
    }

    // Exchanging EU for BG card
    public CardApplicationForm(Driver driver, Date dateOfSubmission, String status, String type,
                               String receivingOffice, String oldCardCountry, String oldCardNumber,
                               String oldCardAuthority, String drivingLicenseCountry,
                               String drivingLicenseNumber, Date oldCardDateOfExpiry,
                               Picture oldCardPicture, Picture signaturePicture, String statusCheckCode) {
        this.driver = driver;
        this.dateOfSubmission = dateOfSubmission;
        this.status = status;
        this.type = type;
        this.receivingOffice = receivingOffice;
        this.oldCardCountry = oldCardCountry;
        this.oldCardNumber = oldCardNumber;
        this.oldCardAuthority = oldCardAuthority;
        this.drivingLicenseCountry = drivingLicenseCountry;
        this.drivingLicenseNumber = drivingLicenseNumber;
        this.oldCardDateOfExpiry = oldCardDateOfExpiry;
        this.oldCardPicture = oldCardPicture;
        this.signaturePicture = signaturePicture;
        this.statusCheckCode = statusCheckCode;
        this.details = "";
    }

    // Replacement due to loss/theft
    public CardApplicationForm(Driver driver, Date dateOfSubmission, String status, String type,
                               String receivingOffice, Date dateOfEvent, String placeOfEvent,
                               String oldCardCountry, String oldCardNumber, String oldCardAuthority,
                               String drivingLicenseCountry, String drivingLicenseNumber,
                               Date oldCardDateOfExpiry, String statusCheckCode,
                               String renewalReason, Picture signaturePicture) {
        this.driver = driver;
        this.dateOfSubmission = dateOfSubmission;
        this.status = status;
        this.type = type;
        this.receivingOffice = receivingOffice;
        this.dateOfEvent = dateOfEvent;
        this.placeOfEvent = placeOfEvent;
        this.oldCardCountry = oldCardCountry;
        this.oldCardNumber = oldCardNumber;
        this.oldCardAuthority = oldCardAuthority;
        this.drivingLicenseCountry = drivingLicenseCountry;
        this.drivingLicenseNumber = drivingLicenseNumber;
        this.oldCardDateOfExpiry = oldCardDateOfExpiry;
        this.statusCheckCode = statusCheckCode;
        this.renewalReason = renewalReason;
        this.signaturePicture = signaturePicture;
        this.details = "";
    }

    // Replacement new name
    public CardApplicationForm(Driver driver, Date dateOfSubmission, String status, String type,
                               String receivingOffice, String oldCardCountry,
                               String oldCardNumber, String oldCardAuthority,
                               String drivingLicenseCountry, Date oldCardDateOfExpiry,
                               String drivingLicenseNumber, String renewalReason,
                               String newFirstName, String newLastName, String statusCheckCode,
                               Picture oldCardPicture, Picture signaturePicture) {
        this.driver = driver;
        this.dateOfSubmission = dateOfSubmission;
        this.status = status;
        this.type = type;
        this.receivingOffice = receivingOffice;
        this.oldCardCountry = oldCardCountry;
        this.oldCardNumber = oldCardNumber;
        this.oldCardAuthority = oldCardAuthority;
        this.drivingLicenseCountry = drivingLicenseCountry;
        this.oldCardDateOfExpiry = oldCardDateOfExpiry;
        this.drivingLicenseNumber = drivingLicenseNumber;
        this.renewalReason = renewalReason;
        this.newFirstName = newFirstName;
        this.newLastName = newLastName;
        this.statusCheckCode = statusCheckCode;
        this.oldCardPicture = oldCardPicture;
        this.signaturePicture = signaturePicture;
        this.details = "";
    }

    // Replacement new address
    public CardApplicationForm(Driver driver, Date dateOfSubmission, String status, String type,
                               String receivingOffice, String oldCardCountry,
                               String oldCardNumber, String oldCardAuthority,
                               String drivingLicenseCountry, Date oldCardDateOfExpiry,
                               String drivingLicenseNumber, String renewalReason,
                               String newAddress, Picture oldCardPicture,
                               Picture signaturePicture, String statusCheckCode) {
        this.driver = driver;
        this.dateOfSubmission = dateOfSubmission;
        this.status = status;
        this.type = type;
        this.receivingOffice = receivingOffice;
        this.oldCardCountry = oldCardCountry;
        this.oldCardNumber = oldCardNumber;
        this.oldCardAuthority = oldCardAuthority;
        this.drivingLicenseCountry = drivingLicenseCountry;
        this.oldCardDateOfExpiry = oldCardDateOfExpiry;
        this.drivingLicenseNumber = drivingLicenseNumber;
        this.renewalReason = renewalReason;
        this.newAddress = newAddress;
        this.oldCardPicture = oldCardPicture;
        this.signaturePicture = signaturePicture;
        this.statusCheckCode = statusCheckCode;
        this.details = "";
    }

    // Replacement new selfie
    public CardApplicationForm(Driver driver, Date dateOfSubmission, String status, String type,
                               String receivingOffice, String oldCardCountry,
                               String oldCardNumber, String oldCardAuthority,
                               String drivingLicenseCountry, Date oldCardDateOfExpiry,
                               String drivingLicenseNumber, String renewalReason,
                               Picture newSelfie, Picture oldCardPicture,
                               Picture signaturePicture, String statusCheckCode) {
        this.driver = driver;
        this.dateOfSubmission = dateOfSubmission;
        this.status = status;
        this.type = type;
        this.receivingOffice = receivingOffice;
        this.oldCardCountry = oldCardCountry;
        this.oldCardNumber = oldCardNumber;
        this.oldCardAuthority = oldCardAuthority;
        this.drivingLicenseCountry = drivingLicenseCountry;
        this.oldCardDateOfExpiry = oldCardDateOfExpiry;
        this.drivingLicenseNumber = drivingLicenseNumber;
        this.renewalReason = renewalReason;
        this.newSelfie = newSelfie;
        this.oldCardPicture = oldCardPicture;
        this.signaturePicture = signaturePicture;
        this.statusCheckCode = statusCheckCode;
        this.details = "";
    }

    // Renewal expired, suspended, damaged, malfunctioning
    public CardApplicationForm(Driver driver, Date dateOfSubmission, String status, String type,
                               String receivingOffice, String oldCardCountry,
                               String oldCardNumber, String oldCardAuthority,
                               String drivingLicenseCountry, Date oldCardDateOfExpiry,
                               String drivingLicenseNumber, String renewalReason,
                               Picture oldCardPicture, Picture signaturePicture, String statusCheckCode) {
        this.driver = driver;
        this.dateOfSubmission = dateOfSubmission;
        this.status = status;
        this.type = type;
        this.receivingOffice = receivingOffice;
        this.oldCardCountry = oldCardCountry;
        this.oldCardNumber = oldCardNumber;
        this.oldCardAuthority = oldCardAuthority;
        this.drivingLicenseCountry = drivingLicenseCountry;
        this.oldCardDateOfExpiry = oldCardDateOfExpiry;
        this.drivingLicenseNumber = drivingLicenseNumber;
        this.renewalReason = renewalReason;
        this.oldCardPicture = oldCardPicture;
        this.signaturePicture = signaturePicture;
        this.statusCheckCode = statusCheckCode;
        this.details = "";
    }

    public int getCardApplicationFormId() {
        return cardApplicationFormId;
    }

    public void setCardApplicationFormId(int cardApplicationFormId) {
        this.cardApplicationFormId = cardApplicationFormId;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Date getDateOfSubmission() {
        return dateOfSubmission;
    }

    public void setDateOfSubmission(Date dateOfSubmission) {
        this.dateOfSubmission = dateOfSubmission;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getReceivingOffice() {
        return receivingOffice;
    }

    public void setReceivingOffice(String receivingOffice) {
        this.receivingOffice = receivingOffice;
    }

    public String getDrivingLicenseNumber() {
        return drivingLicenseNumber;
    }

    public void setDrivingLicenseNumber(String drivingLicenseNumber) {
        this.drivingLicenseNumber = drivingLicenseNumber;
    }

    public String getDrivingLicenseCountry() {
        return drivingLicenseCountry;
    }

    public void setDrivingLicenseCountry(String drivingLicenseCountry) {
        this.drivingLicenseCountry = drivingLicenseCountry;
    }

    public Date getDateOfEvent() {
        return dateOfEvent;
    }

    public void setDateOfEvent(Date dateOfEvent) {
        this.dateOfEvent = dateOfEvent;
    }

    public String getPlaceOfEvent() {
        return placeOfEvent;
    }

    public void setPlaceOfEvent(String placeOfEvent) {
        this.placeOfEvent = placeOfEvent;
    }

    public Picture getOldCardPicture() {
        return oldCardPicture;
    }

    public void setOldCardPicture(Picture oldCardPicture) {
        this.oldCardPicture = oldCardPicture;
    }

    public String getOldCardCountry() {
        return oldCardCountry;
    }

    public void setOldCardCountry(String oldCardCountry) {
        this.oldCardCountry = oldCardCountry;
    }

    public String getOldCardAuthority() {
        return oldCardAuthority;
    }

    public void setOldCardAuthority(String oldCardAuthority) {
        this.oldCardAuthority = oldCardAuthority;
    }

    public String getOldCardNumber() {
        return oldCardNumber;
    }

    public void setOldCardNumber(String oldCardNumber) {
        this.oldCardNumber = oldCardNumber;
    }

    public Date getOldCardDateOfExpiry() {
        return oldCardDateOfExpiry;
    }

    public void setOldCardDateOfExpiry(Date oldCardDateOfExpiry) {
        this.oldCardDateOfExpiry = oldCardDateOfExpiry;
    }

    public String getNewAddress() {
        return newAddress;
    }

    public void setNewAddress(String newAddress) {
        this.newAddress = newAddress;
    }

    public String getNewFirstName() {
        return newFirstName;
    }

    public void setNewFirstName(String newFirstName) {
        this.newFirstName = newFirstName;
    }

    public String getNewLastName() {
        return newLastName;
    }

    public void setNewLastName(String newLastName) {
        this.newLastName = newLastName;
    }

    public Picture getNewSelfie() {
        return newSelfie;
    }

    public void setNewSelfie(Picture newSelfie) {
        this.newSelfie = newSelfie;
    }

    public String getRenewalReason() {
        return renewalReason;
    }

    public void setRenewalReason(String renewalReason) {
        this.renewalReason = renewalReason;
    }

    public Picture getSignaturePicture() {
        return signaturePicture;
    }

    public void setSignaturePicture(Picture signaturePicture) {
        this.signaturePicture = signaturePicture;
    }

    public String getStatusCheckCode() {
        return statusCheckCode;
    }

    public void setStatusCheckCode(String statusCheckCode) {
        this.statusCheckCode = statusCheckCode;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getLastSetID() {
        return lastSetID;
    }

    public void setLastSetID(String lastSetID) {
        this.lastSetID = lastSetID;
    }
}
