package com.mystique.rt.getmydrivercardapplcation.diconfig;


import com.mystique.rt.getmydrivercardapplcation.http.HttpRequester;
import com.mystique.rt.getmydrivercardapplcation.models.CardApplicationForm;
import com.mystique.rt.getmydrivercardapplcation.models.Driver;
import com.mystique.rt.getmydrivercardapplcation.models.Picture;
import com.mystique.rt.getmydrivercardapplcation.models.User;
import com.mystique.rt.getmydrivercardapplcation.parsers.json.JsonParser;
import com.mystique.rt.getmydrivercardapplcation.repositories.HttpCardApplicationFormRepository;
import com.mystique.rt.getmydrivercardapplcation.repositories.HttpDriverRepository;
import com.mystique.rt.getmydrivercardapplcation.repositories.HttpPictureRepository;
import com.mystique.rt.getmydrivercardapplcation.repositories.HttpUserRepository;
import com.mystique.rt.getmydrivercardapplcation.repositories.base.CardApplicationFormRepository;
import com.mystique.rt.getmydrivercardapplcation.repositories.base.DriverRepository;
import com.mystique.rt.getmydrivercardapplcation.repositories.base.PictureRepository;
import com.mystique.rt.getmydrivercardapplcation.repositories.base.UserRepository;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RepositoriesModule {

    @Provides
   // @Singleton
    public CardApplicationFormRepository cardApplicationFormRepository(
            @Named("baseServerUrl") String baseServerUrl,
            HttpRequester httpRequester,
            JsonParser<CardApplicationForm> jsonParser
    ) {
        String url = baseServerUrl + "/applications";
        return new HttpCardApplicationFormRepository(url, httpRequester, jsonParser);
    }

    @Provides
  //  @Singleton
    public DriverRepository driverRepository(
            @Named("baseServerUrl") String baseServerUrl,
            HttpRequester httpRequester,
            JsonParser<Driver> jsonParser
    ) {
        String url = baseServerUrl + "/drivers";
        return new HttpDriverRepository(url, httpRequester, jsonParser);
    }

    @Provides
  //  @Singleton
    public PictureRepository pictureRepository(
            @Named("baseServerUrl") String baseServerUrl,
            HttpRequester httpRequester,
            JsonParser<Picture> jsonParser
    ) {
        String url = baseServerUrl + "/pictures";
        return new HttpPictureRepository(url, httpRequester, jsonParser);
    }


    @Provides
 //   @Singleton
    public UserRepository userRepository(
            @Named("baseServerUrl") String baseServerUrl,
            HttpRequester httpRequester,
            JsonParser<User> jsonParser
    ) {
        String url = baseServerUrl + "/users";
        return new HttpUserRepository(url, httpRequester, jsonParser);
    }
}
