

package com.mystique.rt.getmydrivercardapplcation.parsers.bitmap;

import android.graphics.Bitmap;

/**
 * <h1>BitmapParser interface</h1>
 *
 * <b>Description: </b> This interface defines the methods for parsing
 * between byte[] and Bitmap.
 *
 * @author  Mystique Team
 * @version 1.0
 * @since   2018-11-12
 */
public interface BitmapParser {
    Bitmap toBitmap(byte[] byteArrayPicture);

    byte[] fromBitmap(Bitmap bitmapPicture);
}
