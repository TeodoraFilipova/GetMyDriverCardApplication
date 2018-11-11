/**
 * <h1>DriverValidator class</h1>
 *
 * <b>Description: </b> This class implements the method for checking that
 * a Driver object is valid.
 *
 * @author  Mystique Team
 * @version 1.0
 * @since   2018-11-12
 */

package com.mystique.rt.getmydrivercardapplcation.validators;

import com.mystique.rt.getmydrivercardapplcation.apputils.Constants;
import com.mystique.rt.getmydrivercardapplcation.models.Driver;
import com.mystique.rt.getmydrivercardapplcation.validators.base.Validator;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DriverValidator implements Validator<Driver> {

    @Override
    public boolean isValid(Driver driver) {
        return driver != null;}
//                driver != null &&
//                isPersonalNumberValid(driver)&&
//                isFirstNameValid(driver) &&
//                isLastNameValid(driver) &&
//                isDateOfBirthValid(driver) &&
//                isAddressValid(driver) &&
//                isPhoneNumberValid(driver) &&
//                isEmailValid(driver) &&
//                driver.getSelfie() != null &&
//                driver.getDrivingPic() != null;
//    }
//
//    private boolean isDateOfBirthValid(Driver driver) {
//        Date firstDate = driver.getDateOfBirth();
//        Date secondDate = new Date();
//
//        long diffInMillies = Math.abs(secondDate.getTime() - firstDate.getTime());
//        long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
//
//        return diff >= Constants.EIGHTEEN_YEARS_IN_DAYS;
//    }
//
//    private boolean isEmailValid(Driver driver) {
//        return driver.getEmail().contains("@") &&
//                driver.getEmail().contains(".") &&
//                driver.getEmail().length() <= Constants.EMAIL_MAX_LENGTH &&
//                driver.getEmail().length() >= Constants.EMAIL_MIN_LENGTH;
//    }
//
//    private boolean isPhoneNumberValid(Driver driver) {
//        return driver.getPhoneNumber().length() >= Constants.PHONE_NUMBER_MIN_LENGTH &&
//                driver.getPhoneNumber().length() <= Constants.PHONE_NUMBER_MAX_LENGTH;
//    }
//
//    private boolean isAddressValid(Driver driver) {
//        return driver.getAddress().length() >= Constants.ADDRESS_MIN_LENGTH &&
//                driver.getAddress().length() <= Constants.ADDRESS_MAX_LENGTH;
//    }
//
//    private boolean isLastNameValid(Driver driver) {
//        return driver.getLastName().length() > 0 &&
//                driver.getLastName().length() <= Constants.LAST_NAME_MAX_LENGTH;
//    }
//
//    private boolean isFirstNameValid(Driver driver) {
//        return driver.getFirstName().length() > 0 &&
//                driver.getFirstName().length() <= Constants.FIRST_NAME_MAX_LENGTH;
//    }
//
//    private boolean isPersonalNumberValid(Driver driver) {
//        for (char ch : driver.getPersonalNumber().toCharArray()) {
//            if(!Character.isDigit(ch)){
//                return false;
//            }
//        }
//        return driver.getPersonalNumber().length() <= Constants.PERSONAL_NUMBER_MAX_LENGTH &&
//                driver.getPersonalNumber().length() > 0;
//    }

}
