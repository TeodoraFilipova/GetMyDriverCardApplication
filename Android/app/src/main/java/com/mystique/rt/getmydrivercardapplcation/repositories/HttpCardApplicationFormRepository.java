

package com.mystique.rt.getmydrivercardapplcation.repositories;

import com.google.gson.Gson;
import com.mystique.rt.getmydrivercardapplcation.http.HttpRequester;
import com.mystique.rt.getmydrivercardapplcation.models.CardApplicationForm;
import com.mystique.rt.getmydrivercardapplcation.parsers.json.JsonParser;
import com.mystique.rt.getmydrivercardapplcation.repositories.base.CardApplicationFormRepository;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * <h1>HttpCardApplicationFormRepository class</h1>
 *
 * <b>Description: </b> This class implements the methods for the
 * repository layer (get, add, update) of CardApplicationForm. It makes http
 * requests using an HttpRequester, a Gson parser, and the
 * server base url.
 *
 * @author  Mystique Team
 * @version 1.0
 * @since   2018-11-12
 */
public class HttpCardApplicationFormRepository implements CardApplicationFormRepository {
    private final HttpRequester mHttpRequester;
    private final String mServerUrl;
    private final Gson mJsonParser;

    public HttpCardApplicationFormRepository(String serverUrl, HttpRequester httpRequester,
                                Gson jsonParser) {
        mServerUrl = serverUrl;
        mHttpRequester = httpRequester;
        mJsonParser = jsonParser;
    }


    @Override
    public List<CardApplicationForm> getAll() throws IOException {
        String jsonArray = mHttpRequester.get(mServerUrl);
        return Arrays.asList(mJsonParser.fromJson(jsonArray, CardApplicationForm[].class));
    }

    @Override
    public CardApplicationForm add(CardApplicationForm applicationForm) throws IOException {
        String requestBody = mJsonParser.toJson(applicationForm);
        String responseBody = mHttpRequester.post(mServerUrl + "/new", requestBody);

        return mJsonParser.fromJson(responseBody, CardApplicationForm.class);
    }

    @Override
    public CardApplicationForm getById(int id) throws IOException {
        String url = mServerUrl + "/" + id;
        String json = mHttpRequester.get(url);
        return mJsonParser.fromJson(json, CardApplicationForm.class);
    }

    @Override
    public CardApplicationForm updateById(int id, CardApplicationForm applicationForm) throws IOException {
        String url = mServerUrl + "/" + id;
        String requestBody = mJsonParser.toJson(applicationForm);
        String responseBody = mHttpRequester.put(url, requestBody);

        return mJsonParser.fromJson(responseBody, CardApplicationForm.class);
    }
}
