package com.mystique.rt.getmydrivercardapplcation.validators;

import com.mystique.rt.getmydrivercardapplcation.models.CardApplicationForm;
import com.mystique.rt.getmydrivercardapplcation.validators.base.Validator;

public class CardApplicationFormValidator implements Validator<CardApplicationForm> {

//    private String drivingLicenseNumber;
//    private String drivingLicenseCountry;
//    private Date dateOfEvent;
//    private String placeOfEvent;
//    private Picture oldCardPicture;
//    private String oldCardCountry;
//    private String oldCardAuthority;
//    private String oldCardNumber;
//    private Date oldCardDateOfExpiry;
//    private String newAddress;
//    private String newFirstName;
//    private String newLastName;
//    private Picture newSelfie;
//    private String renewalReason;
//    private Picture signaturePicture;
//    private String statusCheckCode;
//    private String details;

    @Override
    public boolean isValid(CardApplicationForm cardApplicationForm) {
        return cardApplicationForm != null &&
                cardApplicationForm.getDriver() != null ;
                // &&
//                isDrivingLicenseNumberValid(cardApplicationForm) &&
//                isDrivingLicenseCountryValid(cardApplicationForm) &&
//                isDateOfEventValid(cardApplicationForm) &&
//                isPlaceOfEventValid(cardApplicationForm) &&
//                cardApplicationForm.getOldCardPicture() != null &&
//                isOldCardCountryValid(cardApplicationForm) &&
//                isOldCardAuthorityValid(cardApplicationForm) &&
//                isOldCardNumberValid(cardApplicationForm) &&
//                cardApplicationForm.getOldCardDateOfExpiry() != null &&
//                isNewAddressValid(cardApplicationForm) &&
//                isNewFirstNameValid(cardApplicationForm) &&
//                isNewLastNameValid(cardApplicationForm) &&
//                cardApplicationForm.getNewSelfie() != null &&
//                cardApplicationForm.getSignaturePicture() != null;
    }

//    private boolean isNewLastNameValid(CardApplicationForm cardApplicationForm) {
//
//    }
//
//    private boolean isNewFirstNameValid(CardApplicationForm cardApplicationForm) {
//
//    }
//
//    private boolean isNewAddressValid(CardApplicationForm cardApplicationForm) {
//
//    }
//
//    private boolean isOldCardNumberValid(CardApplicationForm cardApplicationForm) {
//
//    }
//
//    private boolean isOldCardAuthorityValid(CardApplicationForm cardApplicationForm) {
//
//    }
//
//    private boolean isOldCardCountryValid(CardApplicationForm cardApplicationForm) {
//
//    }
//
//    private boolean isPlaceOfEventValid(CardApplicationForm cardApplicationForm) {
//
//    }
//
//    private boolean isDateOfEventValid(CardApplicationForm cardApplicationForm) {
//
//    }
//
//    private boolean isDrivingLicenseCountryValid(CardApplicationForm cardApplicationForm) {
//
//    }
//
//    private boolean isDrivingLicenseNumberValid(CardApplicationForm cardApplicationForm) {
//
//    }
}
