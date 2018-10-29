package com.mystique.rt.getmydrivercardapplcation.http;

import java.io.IOException;

public interface HttpRequester {
    String get(String url) throws IOException;

    String post(String url, String bodyString) throws IOException;

    String put(String url, String bodyString)throws IOException;
}
