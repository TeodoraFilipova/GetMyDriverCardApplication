package com.mystique.rt.getmydrivercardapplcation.apputils;

import com.mystique.rt.getmydrivercardapplcation.apputils.idgenerators.CardApplicationFormIdGenerator;
import com.mystique.rt.getmydrivercardapplcation.apputils.idgenerators.DriverIdGenerator;
import com.mystique.rt.getmydrivercardapplcation.apputils.idgenerators.PictureIdGenerator;
import com.mystique.rt.getmydrivercardapplcation.models.CardApplicationForm;
import com.mystique.rt.getmydrivercardapplcation.models.Driver;
import com.mystique.rt.getmydrivercardapplcation.models.Picture;

import java.util.Date;

public class RememberAll {
    private static RememberAll instance;

    private CardApplicationForm mCardApplicationForm;
    private Driver mDriver;
    private Picture mSelfiePic;
    private Picture mDrivingLicensePic;
    private Picture mSignaturePic;
    private Picture mNewSelfiePic;
    private Picture mOldCardPic;

    private RandomCodeGenerator mRandomCodeGenerator;
//    private CardApplicationFormIdGenerator mCardApplicationFormIdGenerator;
//    private DriverIdGenerator mDriverIdGenerator;
//    private PictureIdGenerator mPictureIdGenerator;

    private RememberAll() {
        //  private constructor for singleton
        mRandomCodeGenerator = new RandomCodeGenerator();
//        mCardApplicationFormIdGenerator = CardApplicationFormIdGenerator.getInstance();
//        mDriverIdGenerator = DriverIdGenerator.getInstance();
//        mPictureIdGenerator = PictureIdGenerator.getInstance();
    }

    public static RememberAll getInstance() {
        if (instance == null) {
            instance = new RememberAll();
        }
        return instance;
    }

    public Driver getDriver() {
        if (mDriver.getSelfie() == null) {
            mDriver.setSelfie(mSelfiePic);
            mDriver.setDrivingPic(mDrivingLicensePic);
        }
        return mDriver;
    }

    public CardApplicationForm getCardApplicationForm() {
        if (mCardApplicationForm.getDriver() == null) {
            Driver currentDriver = getDriver();

            mCardApplicationForm.setDriver(currentDriver);
            mCardApplicationForm.setSignaturePicture(mSignaturePic);

            if (mNewSelfiePic.getPicture() != null) {
                mCardApplicationForm.setNewSelfie(mNewSelfiePic);
            }

            if (mOldCardPic.getPicture() != null) {
                mCardApplicationForm.setOldCardPicture(mOldCardPic);
            }
        }

        return mCardApplicationForm;
    }

    public Picture getDrivingLicensePic() {
        return mDrivingLicensePic;
    }

    public Picture getSelfiePic() {
        return mSelfiePic;
    }

    public Picture getNewSelfiePic() {
        return mNewSelfiePic;
    }

    public Picture getSignaturePic() {
        return mSignaturePic;
    }

    public Picture getOldCardPic() {
        return mOldCardPic;
    }

    public void resetRememberAll() {
        mCardApplicationForm = null;
        mDriver = null;
        mSelfiePic = null;
        mDrivingLicensePic = null;
        mSignaturePic = null;
        mNewSelfiePic = null;
        mOldCardPic = null;
    }

    public void startNewApplicationForm(String type, String renewalReason) {
        mCardApplicationForm = new CardApplicationForm();
        //  mCardApplicationForm.setCardApplicationFormId(mCardApplicationFormIdGenerator.getNextId());
        mCardApplicationForm.setStatus(Constants.STATUS_NEW);
        mCardApplicationForm.setType(type);
        mCardApplicationForm.setRenewalReason(renewalReason);
        mCardApplicationForm.setDateOfSubmission(new Date());
        mCardApplicationForm.setStatusCheckCode(mRandomCodeGenerator.randomString(Constants.STATUS_CHECK_CODE_LENGTH));

        mDriver = new Driver();
        //   mDriver.setDriverId(mDriverIdGenerator.getNextId());

        mSelfiePic = new Picture();
        //   mSelfiePic.setPictureId(mPictureIdGenerator.getNextId());

        mDrivingLicensePic = new Picture();
        //   mDrivingLicensePic.setPictureId(mPictureIdGenerator.getNextId());

        mSignaturePic = new Picture();
        //   mSignaturePic.setPictureId(mPictureIdGenerator.getNextId());

        mNewSelfiePic = new Picture();
        mOldCardPic = new Picture();

    }

    public void setPersonalNumber(String personalNumber) {
        mDriver.setPersonalNumber(personalNumber);
    }

    public void setFirstName(String firstName) {
        mDriver.setFirstName(firstName);
    }

    public void setLastName(String lastName) {
        mDriver.setLastName(lastName);
    }

    public void setDateOfBirth(Date dateOfBirth) {
        mDriver.setDateOfBirth(dateOfBirth);
    }

    public void setAddress(String address) {
        mDriver.setAddress(address);
    }

    public void setPhoneNumber(String phoneNumber) {
        mDriver.setPhoneNumber(phoneNumber);
    }

    public void setEmail(String email) {
        mDriver.setEmail(email);
    }

    public void setSelfiePicture(byte[] selfiePicture) {
        mSelfiePic.setPicture(selfiePicture);
    }

    public void setDrivingLicensePicture(byte[] drivingLicensePicture) {
        mDrivingLicensePic.setPicture(drivingLicensePicture);
    }

    public void setCollectionOffice(String collectionOffice) {
        mCardApplicationForm.setPaymentInformation(collectionOffice);
    }

    public void setDateOfEvent(Date dateOfEvent) {
        mCardApplicationForm.setDateOfEvent(dateOfEvent);
    }

    public void setPlaceOfEvent(String placeOfEvent) {
        mCardApplicationForm.setPlaceOfEvent(placeOfEvent);
    }

    public void setOldCardCountry(String oldCardCountry) {
        mCardApplicationForm.setOldCardCountry(oldCardCountry);
    }

    public void setOldCardAuthority(String oldCardAuthority) {
        mCardApplicationForm.setOldCardAuthority(oldCardAuthority);
    }

    public void setOldCardNumber(String oldCardNumber) {
        mCardApplicationForm.setOldCardNumber(oldCardNumber);
    }

    public void setOldCardDateOfExpiry(Date dateOfExpiry) {
        mCardApplicationForm.setOldCardDateOfExpiry(dateOfExpiry);
    }

    public void setNewFirstName(String newFirstName) {
        mCardApplicationForm.setNewFirstName(newFirstName);
    }

    public void setNewLastName(String newLastName) {
        mCardApplicationForm.setNewLastName(newLastName);
    }

    public void setNewAddress(String newAddress) {
        mCardApplicationForm.setNewAddress(newAddress);
    }

    public void setDrivingLicenseCountry(String drivingLicenseCountry) {
        mCardApplicationForm.setDrivingLicenseCountry(drivingLicenseCountry);
    }

    public void setDrivingLicenseNumber(String drivingLicenseNumber) {
        mCardApplicationForm.setDrivingLicenseNumber(drivingLicenseNumber);
    }

    public void addDetails(String details) {
        mCardApplicationForm.setDetails(mCardApplicationForm.getDetails() + ";   " + details);
    }

    public void setSignaturePicture(byte[] signaturePicture) {
        mSignaturePic.setPicture(signaturePicture);
    }

    public void setOldCardPic(byte[] oldCardPic) {
        //     mOldCardPic.setPictureId(mPictureIdGenerator.getNextId());
        mOldCardPic.setPicture(oldCardPic);
    }

    public void setNewSelfiePicture(byte[] newSelfiePicture) {
        //   mNewSelfiePic.setPictureId(mPictureIdGenerator.getNextId());
        mNewSelfiePic.setPicture(newSelfiePicture);
    }
}
