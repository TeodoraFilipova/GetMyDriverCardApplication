

package com.mystique.rt.getmydrivercardapplcation.parsers.json;

import java.util.List;

/**
 * <h1>JsonParser interface</h1>
 *
 * <b>Description: </b> This interface defines the methods for parsing
 * to and from Json objects.
 *
 * @author  Mystique Team
 * @version 1.0
 * @since   2018-11-12
 */
public interface JsonParser<T> {
    List<T> fromJsonArray(String jsonString);

    T fromJson(String jsonString);

    String toJson(T object);
}
