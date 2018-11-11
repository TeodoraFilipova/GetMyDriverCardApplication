

package com.mystique.rt.getmydrivercardapplcation.apputils;

import java.security.SecureRandom;

/**
 * <h1>RandomCodeGenerator class</h1>
 *
 * <b>Description: </b> This class handles the functionality for generating
 * a random code of digits, lowercase and uppercase latin alphabet letters
 * with a specified length. It is used to generate the Status Check Code
 * for Application Forms.
 *
 * @author  Mystique Team
 * @version 1.0
 * @since   2018-11-12
 */
public class RandomCodeGenerator {
        private static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        private static SecureRandom rnd = new SecureRandom();

        String randomString(int len) {
            StringBuilder sb = new StringBuilder(len);
            for (int i = 0; i < len; i++)
                sb.append(AB.charAt(rnd.nextInt(AB.length())));
            return sb.toString();
        }
    }
