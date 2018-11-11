package com.mystique.springdrivercard;

import com.mystique.springdrivercard.models.CardApplicationForm;
import com.mystique.springdrivercard.models.Driver;
import com.mystique.springdrivercard.repositories.CardApplicationRepository;
import com.mystique.springdrivercard.services.cardApplicationFormService.CardApplicationServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class CardApplicationFormServiceImplTests {
    @Mock
    CardApplicationRepository mockRepository;

    @InjectMocks
    CardApplicationServiceImpl testCardApplicationFormService;

    private static Driver driver = new Driver(1, "12345", "Gogo", "Kocev", "");
    private static Date dateOfSubmission = new Date();

    private static List<CardApplicationForm> defaultMockRepositoryContent = Arrays.asList(

            new CardApplicationForm(driver, 1, dateOfSubmission, "new", "first", "123456789", ""),
            new CardApplicationForm(driver, 2, dateOfSubmission, "new", "first", "987654321", "yes")
    );

    @Test
    public void getAllCardApplicationForms_Should_ReturnsAllFromsRepository_WhenRepositoryHasForms() {
        //Arrange
        Mockito.when(mockRepository.getAllCardApplications()).thenReturn(defaultMockRepositoryContent);
        //Act
        List<CardApplicationForm> result = testCardApplicationFormService.getAllCardApplications();
        CardApplicationForm[] finalResult = new CardApplicationForm[result.size()];
        finalResult = result.toArray(finalResult);

        CardApplicationForm[] expected = new CardApplicationForm[defaultMockRepositoryContent.size()];
        expected = defaultMockRepositoryContent.toArray(expected);

        //Assert
        Assert.assertArrayEquals(expected, finalResult);

    }

    @Test
    public void addCardApplicationForm_Should_ReturnsAllAddedFromsInRepository_WhenRepositoryHasAddedForm() {
        Mockito.when(mockRepository.addCardApplicationForm(defaultMockRepositoryContent.get(0))).thenReturn(defaultMockRepositoryContent.get(0));

        CardApplicationForm result = testCardApplicationFormService.addCardApplicationForm(defaultMockRepositoryContent.get(0));

        CardApplicationForm expected = defaultMockRepositoryContent.get(0);

        Assert.assertEquals(expected.getCardApplicationFormId(), result.getCardApplicationFormId());
        Assert.assertEquals(expected.getStatus(), result.getStatus());
        Assert.assertEquals(expected.getDateOfSubmission(), result.getDateOfSubmission());
        Assert.assertEquals(expected.getType(), result.getType());
        Assert.assertEquals(expected.getStatusCheckCode(), result.getStatusCheckCode());
        Assert.assertEquals(expected.getLastSetID(), result.getLastSetID());
    }

    @Test
    public void getCardApplicationFormsByID_Should_ReturnsFromWithTheSameIDInRepository_WhenRepositoryHasMatch() {
        Mockito.when(mockRepository.getCardApplicationByID(1)).thenReturn(defaultMockRepositoryContent.get(0));

        CardApplicationForm result = testCardApplicationFormService.getCardApplicationByID(1);

        CardApplicationForm expected = defaultMockRepositoryContent.get(0);

        Assert.assertEquals(expected.getCardApplicationFormId(), result.getCardApplicationFormId());
        Assert.assertEquals(expected.getStatus(), result.getStatus());
        Assert.assertEquals(expected.getDateOfSubmission(), result.getDateOfSubmission());
        Assert.assertEquals(expected.getType(), result.getType());
        Assert.assertEquals(expected.getStatusCheckCode(), result.getStatusCheckCode());
        Assert.assertEquals(expected.getLastSetID(), result.getLastSetID());
    }

    @Test
    public void updatedFormsByID_Should_ReturnsFromWithTheSameIDInRepository_WhenRepositoryHasMatch() {
        Mockito.when(mockRepository.updateCardApplication(1, defaultMockRepositoryContent.get(0))).thenReturn(defaultMockRepositoryContent.get(0));

        CardApplicationForm result = testCardApplicationFormService.updateCardApplication(1, defaultMockRepositoryContent.get(0));

        CardApplicationForm expected = defaultMockRepositoryContent.get(0);

        Assert.assertEquals(expected.getCardApplicationFormId(), result.getCardApplicationFormId());
        Assert.assertEquals(expected.getStatus(), result.getStatus());
        Assert.assertEquals(expected.getDateOfSubmission(), result.getDateOfSubmission());
        Assert.assertEquals(expected.getType(), result.getType());
        Assert.assertEquals(expected.getStatusCheckCode(), result.getStatusCheckCode());
        Assert.assertEquals(expected.getLastSetID(), result.getLastSetID());
    }

}
