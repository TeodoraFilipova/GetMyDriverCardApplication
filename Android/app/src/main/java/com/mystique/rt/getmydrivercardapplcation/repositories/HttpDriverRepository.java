package com.mystique.rt.getmydrivercardapplcation.repositories;

import com.mystique.rt.getmydrivercardapplcation.http.HttpRequester;
import com.mystique.rt.getmydrivercardapplcation.models.Driver;
import com.mystique.rt.getmydrivercardapplcation.parsers.json.JsonParser;

import java.io.IOException;

public class HttpDriverRepository implements DriverRepository {
    private final HttpRequester mHttpRequester;
    private final String mServerUrl;
    private final JsonParser<Driver> mJsonParser;

    public HttpDriverRepository(String serverUrl, HttpRequester httpRequester,
                                JsonParser<Driver> jsonParser) {
        mServerUrl = serverUrl;
        mHttpRequester = httpRequester;
        mJsonParser = jsonParser;
    }

    @Override
    public Driver add(Driver driver) throws IOException {
        String requestBody = mJsonParser.toJson(driver);
        String responseBody = mHttpRequester.post(mServerUrl + "/new", requestBody);

        return mJsonParser.fromJson(responseBody);
    }

    @Override
    public Driver getById(int id) throws IOException {
        String url = mServerUrl + "/" + id;
        String json = mHttpRequester.get(url);
        return mJsonParser.fromJson(json);
    }

    @Override
    public Driver updateById(int id, Driver driver) throws IOException {
        String url = mServerUrl + "/" + id;
        String requestBody = mJsonParser.toJson(driver);
        String responseBody = mHttpRequester.put(url, requestBody);

        return mJsonParser.fromJson(responseBody);
    }
}
