

package com.mystique.rt.getmydrivercardapplcation.apputils;

/**
 * <h1>Navigator interface</h1>
 *
 * <b>Description: </b> This interface handles navigation from one activity to
 * the next. It is implemented by activities throughout the application which
 * do not have a package-specific Navigator interface defined in Contracts.
 *
 * @author  Mystique Team
 * @version 1.0
 * @since   2018-11-12
 */
public interface Navigator {
    void navigateToActivity(Class activityClass);
}
