

package com.mystique.rt.getmydrivercardapplcation.diconfig;

import com.google.gson.Gson;
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

/**
 * <h1>RepositoriesModule</h1>
 *
 * <b>Description: </b> This class is a part of the Dagger dependency injection configuration.
 * It provides and injects instances of CardApplicationFormRepository, DriverRepository,
 * PictureRepository, and UserRepository.
 *
 * @author  Mystique Team
 * @version 1.0
 * @since   2018-11-12
 */
@Module
public class RepositoriesModule {

    @Provides
    @Singleton
    public CardApplicationFormRepository cardApplicationFormRepository(
            @Named("baseServerUrl") String baseServerUrl,
            HttpRequester httpRequester,
            Gson jsonParser
    ) {
        String url = baseServerUrl + "/applications";
        return new HttpCardApplicationFormRepository(url, httpRequester, jsonParser);
    }

    @Provides
    @Singleton
    public DriverRepository driverRepository(
            @Named("baseServerUrl") String baseServerUrl,
            HttpRequester httpRequester,
            Gson jsonParser
    ) {
        String url = baseServerUrl + "/drivers";
        return new HttpDriverRepository(url, httpRequester, jsonParser);
    }

    @Provides
    @Singleton
    public PictureRepository pictureRepository(
            @Named("baseServerUrl") String baseServerUrl,
            HttpRequester httpRequester,
            Gson jsonParser
    ) {
        String url = baseServerUrl + "/pictures";
        return new HttpPictureRepository(url, httpRequester, jsonParser);
    }


    @Provides
    @Singleton
    public UserRepository userRepository(
            @Named("baseServerUrl") String baseServerUrl,
            HttpRequester httpRequester,
            JsonParser<User> jsonParser
    ) {
        String url = baseServerUrl + "/users";
        return new HttpUserRepository(url, httpRequester, jsonParser);
    }
}
