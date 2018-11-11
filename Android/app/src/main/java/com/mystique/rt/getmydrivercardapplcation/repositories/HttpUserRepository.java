

package com.mystique.rt.getmydrivercardapplcation.repositories;

import com.mystique.rt.getmydrivercardapplcation.http.HttpRequester;
import com.mystique.rt.getmydrivercardapplcation.models.User;
import com.mystique.rt.getmydrivercardapplcation.parsers.json.JsonParser;
import com.mystique.rt.getmydrivercardapplcation.repositories.base.UserRepository;

import java.io.IOException;
import java.util.List;

/**
 * <h1>HttpUserRepository class</h1>
 *
 * <b>Description: </b> This class implements the methods for the
 * repository layer (get, add, update) of User. It makes http
 * requests using an HttpRequester, a Gson parser, and the
 * server base url.
 *
 * @author  Mystique Team
 * @version 1.0
 * @since   2018-11-12
 */
public class HttpUserRepository implements UserRepository {
    private final HttpRequester mHttpRequester;
    private final String mServerUrl;
    private final JsonParser<User> mJsonParser;

    public HttpUserRepository(String serverUrl, HttpRequester httpRequester,
                                 JsonParser<User> jsonParser) {
        mServerUrl = serverUrl;
        mHttpRequester = httpRequester;
        mJsonParser = jsonParser;
    }

    @Override
    public List<User> getAll() throws IOException {
        String jsonArray = mHttpRequester.get(mServerUrl);
        return mJsonParser.fromJsonArray(jsonArray);
    }
}
