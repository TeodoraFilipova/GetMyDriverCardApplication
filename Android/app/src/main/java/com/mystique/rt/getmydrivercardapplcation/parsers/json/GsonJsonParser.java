/**
 * <h1>GsonJsonParser class</h1>
 *
 * <b>Description: </b> This class implements the methods for parsing
 * to and from Json objects. It is used to pass objects to and from
 * http requests.
 *
 * @author  Mystique Team
 * @version 1.0
 * @since   2018-11-12
 */

package com.mystique.rt.getmydrivercardapplcation.parsers.json;

import android.util.Base64;

import com.google.gson.Gson;
import com.mystique.rt.getmydrivercardapplcation.models.Picture;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;
import java.util.List;

public class GsonJsonParser<T> implements JsonParser<T> {
    private final Class<T> mKlass;
    private final Class<T[]> mArrayKlass;
    private final Gson mGson;
 //   private final GsonJsonHelper mGsonHelper;

    public GsonJsonParser(Class<T> klass, Class<T[]> arrayKlass) {
        mKlass = klass;
        mArrayKlass = arrayKlass;
        mGson = new Gson();
 //       mGsonHelper = new GsonJsonHelper();
    }

    @Override
    public List<T> fromJsonArray(String jsonString) {


//            try {
//                JSONObject jsnobject = new JSONObject(jsonString);
//                JSONArray jsonArray = jsnobject.getJSONArray("");
//                for (int i = 0; i < jsonArray.length(); i++) {
//                    JSONObject explrObject = jsonArray.getJSONObject(i);
//                }
//
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
            T[] result = mGson.fromJson(jsonString, mArrayKlass);
            return Arrays.asList(result);
    }

    @Override
    public T fromJson(String jsonString) {
        if (mKlass == Picture.class) {
            try {
                JSONObject jsonObject = new JSONObject(jsonString);
                String pictureByteString = jsonObject.getString("picture");
                byte[] bytePicture = Base64.decode(pictureByteString, Base64.NO_WRAP);

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return mGson.fromJson(jsonString, mKlass);
    }

    @Override
    public String toJson(T object) {
        return mGson.toJson(object);
    }
}
