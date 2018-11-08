package com.mystique.rt.getmydrivercardapplcation.repositories;

import com.google.gson.Gson;
import com.mystique.rt.getmydrivercardapplcation.http.HttpRequester;
import com.mystique.rt.getmydrivercardapplcation.models.Picture;
import com.mystique.rt.getmydrivercardapplcation.parsers.json.JsonParser;
import com.mystique.rt.getmydrivercardapplcation.repositories.base.PictureRepository;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class HttpPictureRepository implements PictureRepository {
    private final HttpRequester mHttpRequester;
    private final String mServerUrl;
    private final Gson mJsonParser;
//    private final JsonParser<Picture> mJsonParser;

    public HttpPictureRepository(String serverUrl, HttpRequester httpRequester,
                                Gson jsonParser) {
        mServerUrl = serverUrl;
        mHttpRequester = httpRequester;
        mJsonParser = jsonParser;
    }


    @Override
    public Picture add(Picture picture) throws IOException {
        String requestBody = mJsonParser.toJson(picture);
        String responseBody = mHttpRequester.post(mServerUrl + "/new", requestBody);

        return mJsonParser.fromJson(responseBody, Picture.class);
    }

    @Override
    public Picture getById(int id) throws IOException {
        String url = mServerUrl + "/" + id;
        String json = mHttpRequester.get(url);
        return mJsonParser.fromJson(json, Picture.class);
    }

    @Override
    public List<Picture> getAllPictures() throws IOException {
        String jsonArray = mHttpRequester.get(mServerUrl);
        return Arrays.asList(mJsonParser.fromJson(jsonArray, Picture[].class));
    }

    @Override
    public Picture updateById(int id, Picture picture) throws IOException {
        String url = mServerUrl + "/" + id;
        String requestBody = mJsonParser.toJson(picture);
        String responseBody = mHttpRequester.put(url, requestBody);

        return mJsonParser.fromJson(responseBody, Picture.class);
    }
}
