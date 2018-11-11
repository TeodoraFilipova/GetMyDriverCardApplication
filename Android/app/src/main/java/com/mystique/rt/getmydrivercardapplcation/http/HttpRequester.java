
package com.mystique.rt.getmydrivercardapplcation.http;

import java.io.IOException;

/**
 * <h1>HttpRequester interface</h1>
 *
 * <b>Description: </b> This interface defines the actions/methods which can be
 * performed as a part of an HTTP request.
 *
 * @author  Mystique Team
 * @version 1.0
 * @since   2018-11-12
 */
public interface HttpRequester {
    String get(String url) throws IOException;

    String post(String url, String bodyString) throws IOException;

    String put(String url, String bodyString)throws IOException;
}
