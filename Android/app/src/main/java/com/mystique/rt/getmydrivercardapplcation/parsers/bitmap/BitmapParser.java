package com.mystique.rt.getmydrivercardapplcation.parsers.bitmap;

import android.graphics.Bitmap;

public interface BitmapParser {
    Bitmap toBitmap(byte[] byteArrayPicture);

    byte[] fromBitmap(Bitmap bitmapPicture);
}
