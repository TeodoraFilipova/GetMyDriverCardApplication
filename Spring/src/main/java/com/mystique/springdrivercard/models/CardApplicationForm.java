package com.mystique.springdrivercard.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "cardapplicationforms")
public class CardApplicationForm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ApplicationID")
    private int applicationId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DriverID")
    private Driver driver;

    @Column(name = "DateOfSubmission")
    private Date dateOfSubmission;

    @Column(name = "Status")
    private String status;

    @Column(name = "Type")
    private String type;

    @Column(name = "PaymentInformation")
    private String paymentInformation;

    @OneToOne
    @JoinColumn(name = "SignaturePicID")
    private Picture signaturePicture;

    // methods for changing status in Repository
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(int applicationId) {
        this.applicationId = applicationId;
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
}
