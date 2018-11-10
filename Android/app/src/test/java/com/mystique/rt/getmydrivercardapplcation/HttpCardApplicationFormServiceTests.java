package com.mystique.rt.getmydrivercardapplcation;

import com.mystique.rt.getmydrivercardapplcation.models.CardApplicationForm;
import com.mystique.rt.getmydrivercardapplcation.models.Driver;
import com.mystique.rt.getmydrivercardapplcation.models.User;
import com.mystique.rt.getmydrivercardapplcation.repositories.base.CardApplicationFormRepository;
import com.mystique.rt.getmydrivercardapplcation.repositories.base.UserRepository;
import com.mystique.rt.getmydrivercardapplcation.services.HttpCardApplicationFormService;
import com.mystique.rt.getmydrivercardapplcation.services.HttpUserService;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class HttpCardApplicationFormServiceTests {
    @Mock
    CardApplicationFormRepository mockRepository;

    @InjectMocks
    HttpCardApplicationFormService testHttpFormService;

    private static List<CardApplicationForm> defaultMockRepositoryContent = Arrays.asList(

            new CardApplicationForm()
    );

}
