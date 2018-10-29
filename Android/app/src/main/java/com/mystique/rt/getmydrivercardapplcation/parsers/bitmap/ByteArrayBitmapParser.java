package com.mystique.rt.getmydrivercardapplcation.parsers.bitmap;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.ByteArrayOutputStream;

public class ByteArrayBitmapParser implements BitmapParser {

    public ByteArrayBitmapParser() {
        // default constructor
    }

    @Override
    public Bitmap toBitmap(byte[] byteArrayPicture) {
        Bitmap bitmap = BitmapFactory.decodeByteArray(byteArrayPicture , 0, byteArrayPicture.length);
        return bitmap;
    }

    @Override
    public byte[] fromBitmap(Bitmap bitmapPicture) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmapPicture.compress(Bitmap.CompressFormat.JPEG, 100, stream);
        byte[] byteArray = stream.toByteArray();
        return byteArray;
    }
}
