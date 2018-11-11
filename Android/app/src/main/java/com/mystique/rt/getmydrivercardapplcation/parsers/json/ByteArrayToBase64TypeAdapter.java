

package com.mystique.rt.getmydrivercardapplcation.parsers.json;

import android.util.Base64;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

/**
 * <h1>ByteArrayToBase64TypeAdapter class</h1>
 *
 * <b>Description: </b> This class defines the method for deserializing a
 * Json object to byte[]. It is used to pass objects from http requests.
 *
 * @author  Mystique Team
 * @version 1.0
 * @since   2018-11-12
 */
public class ByteArrayToBase64TypeAdapter implements JsonDeserializer<byte[]> {
    @Override
    public byte[] deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        return Base64.decode(json.getAsString(), Base64.NO_WRAP);
    }

//    @Override
//    public JsonElement serialize(byte[] src, Type typeOfSrc, JsonSerializationContext context) {
//        return new JsonPrimitive(Base64.encodeToString(src, Base64.NO_WRAP));    }
}