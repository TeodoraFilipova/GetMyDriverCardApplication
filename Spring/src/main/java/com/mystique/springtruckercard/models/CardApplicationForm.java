package com.mystique.springtruckercard.models;

import java.util.Date;

public class CardApplicationForm {
    //table "applications"
    private int applicationId;
    //table "trucker"
    private int truckerId;
    private String personalNumber;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String truckerAddress;
    private String phoneNumber;
    private String truckerEmail;
    private int truckerSelfieId;
    private int drivingPicId;
    //table "applications"
    private Date dateOfSubmission;
    private String status;
    private String type;
    private String paymentInformation;
    private int signaturePicId;
    //table "pictures"
    private byte[] truckerSelfie;
    private byte[] drivingPic;
    private byte[] signaturePic;
}
