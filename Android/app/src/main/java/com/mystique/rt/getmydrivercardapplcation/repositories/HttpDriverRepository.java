package com.mystique.rt.getmydrivercardapplcation.repositories;

import com.google.gson.Gson;
import com.mystique.rt.getmydrivercardapplcation.http.HttpRequester;
import com.mystique.rt.getmydrivercardapplcation.models.Driver;
import com.mystique.rt.getmydrivercardapplcation.parsers.json.JsonParser;
import com.mystique.rt.getmydrivercardapplcation.repositories.base.DriverRepository;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class HttpDriverRepository implements DriverRepository {
    private final HttpRequester mHttpRequester;
    private final String mServerUrl;
    private final Gson mJsonParser;

    public HttpDriverRepository(String serverUrl, HttpRequester httpRequester,
                                Gson jsonParser) {
        mServerUrl = serverUrl;
        mHttpRequester = httpRequester;
        mJsonParser = jsonParser;
    }

    @Override
    public Driver add(Driver driver) throws IOException {
        String requestBody = mJsonParser.toJson(driver);
        String responseBody = mHttpRequester.post(mServerUrl + "/new", requestBody);

        return mJsonParser.fromJson(responseBody, Driver.class);
    }

    @Override
    public Driver getById(int id) throws IOException {
        String url = mServerUrl + "/" + id;
        String json = mHttpRequester.get(url);
        return mJsonParser.fromJson(json, Driver.class);
    }

    @Override
    public List<Driver> getAllDrivers() throws IOException {
        String jsonArray = mHttpRequester.get(mServerUrl);
        return Arrays.asList(mJsonParser.fromJson(jsonArray, Driver[].class));
    }

    @Override
    public Driver updateById(int id, Driver driver) throws IOException {
        String url = mServerUrl + "/" + id;
        String requestBody = mJsonParser.toJson(driver);
        String responseBody = mHttpRequester.put(url, requestBody);

        return mJsonParser.fromJson(responseBody, Driver.class);
    }
}
