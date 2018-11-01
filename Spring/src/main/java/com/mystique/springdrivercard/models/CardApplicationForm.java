package com.mystique.springdrivercard.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "cardapplicationforms")
public class CardApplicationForm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cardapplicationformID", nullable = false)
    private int cardApplicationFormId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "driverID", nullable = false)
  //  @JsonIgnore
    private Driver driver;

    @Column(name = "DateOfSubmission", nullable = false)
    private Date dateOfSubmission;

    @Column(name = "Status", nullable = false)
    private String status;

    @Column(name = "Type", nullable = false)
    private String type;

    @Column(name = "PaymentInformation", nullable = false)
    private String paymentInformation;

    @Column(name = "DrivingLicenseNumber")
    private String drivingLicenseNumber;

    @Column(name = "DrivingLicenseCountry")
    private String drivingLicenseCountry;

    @Column(name = "DateOfEvent")
    private Date dateOfEvent;

    @Column(name = "PlaceOfEvent")
    private String placeOfEvent;

    @OneToOne
    @JoinColumn(name = "OldCardPicID")
    private Picture oldCardPicture;

    @Column(name = "OldCardCountry")
    private String oldCardCountry;

    @Column(name = "OldCardAuthority")
    private String oldCardAuthority;

    @Column(name = "OldCardNumber")
    private String oldCardNumber;

    @Column(name = "OldCardDateOfExpiry")
    private Date oldCardDateOfExpiry;

    @Column(name = "NewAddress")
    private String newAddress;

    @Column(name = "NewFirstName")
    private String newFirstName;

    @Column(name = "NewLastName")
    private String newLastName;

    @OneToOne
    @JoinColumn(name = "NewSelfieID")
    private Picture newSelfie;

    @Column(name = "RenewalReason")
    private String renewalReason;

    @OneToOne
    @JoinColumn(name = "SignaturePicID", nullable = false)
    private Picture signaturePicture;

    @Column(name = "StatusCheckCode", nullable = false)
    private String statusCheckCode;

    @Column(name = "Details")
    private String details;


    // Constructors
    public CardApplicationForm() {
        //default empty for DB
    }

    // First application for a new card
    public CardApplicationForm(Driver driver, Date dateOfSubmission, String status, String type,
                               String paymentInformation, String drivingLicenseCountry,
                               String drivingLicenseNumber, Picture signaturePicture, String statusCheckCode) {
        this.driver = driver;
        this.dateOfSubmission = dateOfSubmission;
        this.status = status;
        this.type = type;
        this.paymentInformation = paymentInformation;
        this.drivingLicenseCountry = drivingLicenseCountry;
        this.drivingLicenseNumber = drivingLicenseNumber;
        this.signaturePicture = signaturePicture;
        this.statusCheckCode = statusCheckCode;
        this.details = "";
    }

    // Exchanging EU for BG card
    public CardApplicationForm(Driver driver, Date dateOfSubmission, String status, String type,
                               String paymentInformation, String oldCardCountry, String oldCardNumber,
                               String oldCardAuthority, String drivingLicenseCountry,
                               String drivingLicenseNumber, Date oldCardDateOfExpiry,
                               Picture oldCardPicture, Picture signaturePicture, String statusCheckCode) {
        this.driver = driver;
        this.dateOfSubmission = dateOfSubmission;
        this.status = status;
        this.type = type;
        this.paymentInformation = paymentInformation;
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
                               String paymentInformation, Date dateOfEvent, String placeOfEvent,
                               String oldCardCountry, String oldCardNumber, String oldCardAuthority,
                               String drivingLicenseCountry, String drivingLicenseNumber,
                               Date oldCardDateOfExpiry, String statusCheckCode,
                               String renewalReason, Picture signaturePicture) {
        this.driver = driver;
        this.dateOfSubmission = dateOfSubmission;
        this.status = status;
        this.type = type;
        this.paymentInformation = paymentInformation;
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
                               String paymentInformation, String oldCardCountry,
                               String oldCardNumber, String oldCardAuthority,
                               String drivingLicenseCountry, Date oldCardDateOfExpiry,
                               String drivingLicenseNumber, String renewalReason,
                               String newFirstName, String newLastName, String statusCheckCode,
                               Picture oldCardPicture, Picture signaturePicture) {
        this.driver = driver;
        this.dateOfSubmission = dateOfSubmission;
        this.status = status;
        this.type = type;
        this.paymentInformation = paymentInformation;
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
                               String paymentInformation, String oldCardCountry,
                               String oldCardNumber, String oldCardAuthority,
                               String drivingLicenseCountry, Date oldCardDateOfExpiry,
                               String drivingLicenseNumber, String renewalReason,
                               String newAddress, Picture oldCardPicture,
                               Picture signaturePicture, String statusCheckCode) {
        this.driver = driver;
        this.dateOfSubmission = dateOfSubmission;
        this.status = status;
        this.type = type;
        this.paymentInformation = paymentInformation;
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
                               String paymentInformation, String oldCardCountry,
                               String oldCardNumber, String oldCardAuthority,
                               String drivingLicenseCountry, Date oldCardDateOfExpiry,
                               String drivingLicenseNumber, String renewalReason,
                               Picture newSelfie, Picture oldCardPicture,
                               Picture signaturePicture, String statusCheckCode) {
        this.driver = driver;
        this.dateOfSubmission = dateOfSubmission;
        this.status = status;
        this.type = type;
        this.paymentInformation = paymentInformation;
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
                               String paymentInformation, String oldCardCountry,
                               String oldCardNumber, String oldCardAuthority,
                               String drivingLicenseCountry, Date oldCardDateOfExpiry,
                               String drivingLicenseNumber, String renewalReason,
                               Picture oldCardPicture, Picture signaturePicture, String statusCheckCode) {
        this.driver = driver;
        this.dateOfSubmission = dateOfSubmission;
        this.status = status;
        this.type = type;
        this.paymentInformation = paymentInformation;
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


    // Getter & Setters
    // methods for changing status in Repository
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPaymentInformation() {
        return paymentInformation;
    }

    public void setPaymentInformation(String paymentInformation) {
        this.paymentInformation = paymentInformation;
    }

    public Picture getSignaturePicture() {
        return signaturePicture;
    }

    public void setSignaturePicture(Picture signaturePicture) {
        this.signaturePicture = signaturePicture;
    }

    public int getCardApplicationFormId() {
        return cardApplicationFormId;
    }

    public void setCardApplicationFormId(int cardApplicationFormId) {
        this.cardApplicationFormId = cardApplicationFormId;
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
}
