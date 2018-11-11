/**
 * <h1>Validator interface</h1>
 *
 * <b>Description: </b> This interface defines the method for checking that
 * an object is valid.
 *
 * @author  Mystique Team
 * @version 1.0
 * @since   2018-11-12
 */

package com.mystique.rt.getmydrivercardapplcation.validators.base;

public interface Validator<T> {

    boolean isValid(T object);
}
