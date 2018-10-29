package com.mystique.rt.getmydrivercardapplcation.validators;

import com.mystique.rt.getmydrivercardapplcation.models.Driver;
import com.mystique.rt.getmydrivercardapplcation.validators.base.Validator;

public class DriverValidator implements Validator<Driver> {

//    private String personalNumber;
//    private String firstName;
//    private String lastName;
//    private Date dateOfBirth;
//    private String address;
//    private String phoneNumber;
//    private String email;
//    private Picture selfie;
//    private Picture drivingPic;

    @Override
    public boolean isValid(Driver object) {
        return object != null  /*  &&
                isPersonalNumberValid(object)&&
                isFirstNameValid(object) &&
                isLastNameValid(object) &&
                isDateOfBirthValid(object) &&
                isAddressValid(object) &&
                isPhoneNumberValid(object) &&
                isEmailValid(object) &&
                isPhoneNumberValid(object) &&
                object.getSelfie() != null &&
                object.getDrivingPic() != null */ ;
    }

}
