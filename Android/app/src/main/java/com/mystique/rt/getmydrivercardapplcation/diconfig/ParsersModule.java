package com.mystique.rt.getmydrivercardapplcation.diconfig;

import com.mystique.rt.getmydrivercardapplcation.models.CardApplicationForm;
import com.mystique.rt.getmydrivercardapplcation.models.Driver;
import com.mystique.rt.getmydrivercardapplcation.models.Picture;
import com.mystique.rt.getmydrivercardapplcation.models.User;
import com.mystique.rt.getmydrivercardapplcation.parsers.json.GsonJsonParser;
import com.mystique.rt.getmydrivercardapplcation.parsers.json.JsonParser;

import dagger.Module;
import dagger.Provides;

@Module
public class ParsersModule {
    @Provides
    public JsonParser<CardApplicationForm> jsonParserCardAppl(){
        return new GsonJsonParser<>(CardApplicationForm.class, CardApplicationForm[].class);
    }

    @Provides
    public JsonParser<Driver> jsonParserDriver(){
        return new GsonJsonParser<>(Driver.class, Driver[].class);
    }

    @Provides
    public JsonParser<Picture> jsonParserPicture(){
        return new GsonJsonParser<>(Picture.class, Picture[].class);
    }

    @Provides
    public JsonParser<User> jsonParserUser(){
        return new GsonJsonParser<>(User.class, User[].class);
    }
}
