package com.mystique.rt.getmydrivercardapplcation.repositories;

import com.mystique.rt.getmydrivercardapplcation.http.HttpRequester;
import com.mystique.rt.getmydrivercardapplcation.models.CardApplicationForm;
import com.mystique.rt.getmydrivercardapplcation.parsers.json.JsonParser;
import com.mystique.rt.getmydrivercardapplcation.repositories.base.CardApplicationFormRepository;

import java.io.IOException;
import java.util.List;

public class HttpCardApplicationFormRepository implements CardApplicationFormRepository {
    private final HttpRequester mHttpRequester;
    private final String mServerUrl;
    private final JsonParser<CardApplicationForm> mJsonParser;

    public HttpCardApplicationFormRepository(String serverUrl, HttpRequester httpRequester,
                                JsonParser<CardApplicationForm> jsonParser) {
        mServerUrl = serverUrl;
        mHttpRequester = httpRequester;
        mJsonParser = jsonParser;
    }


    @Override
    public List<CardApplicationForm> getAll() throws IOException {
        String jsonArray = mHttpRequester.get(mServerUrl);
        return mJsonParser.fromJsonArray(jsonArray);
    }

    @Override
    public CardApplicationForm add(CardApplicationForm applicationForm) throws IOException {
        String requestBody = mJsonParser.toJson(applicationForm);
        String responseBody = mHttpRequester.post(mServerUrl + "/new", requestBody);

        return mJsonParser.fromJson(responseBody);
    }

    @Override
    public CardApplicationForm getById(int id) throws IOException {
        String url = mServerUrl + "/" + id;
        String json = mHttpRequester.get(url);
        return mJsonParser.fromJson(json);
    }

    @Override
    public CardApplicationForm updateById(int id, CardApplicationForm applicationForm) throws IOException {
        String url = mServerUrl + "/" + id;
        String requestBody = mJsonParser.toJson(applicationForm);
        String responseBody = mHttpRequester.put(url, requestBody);

        return mJsonParser.fromJson(responseBody);
    }
}
