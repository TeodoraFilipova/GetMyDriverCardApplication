package com.mystique.rt.getmydrivercardapplcation;

import com.mystique.rt.getmydrivercardapplcation.models.CardApplicationForm;
import com.mystique.rt.getmydrivercardapplcation.models.Driver;
import com.mystique.rt.getmydrivercardapplcation.models.User;
import com.mystique.rt.getmydrivercardapplcation.repositories.base.CardApplicationFormRepository;
import com.mystique.rt.getmydrivercardapplcation.repositories.base.UserRepository;
import com.mystique.rt.getmydrivercardapplcation.services.HttpCardApplicationFormService;
import com.mystique.rt.getmydrivercardapplcation.services.HttpUserService;
import com.mystique.rt.getmydrivercardapplcation.validators.base.Validator;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class HttpCardApplicationFormServiceTests {
    @Mock
    CardApplicationFormRepository mockRepository;

    @Mock
    Validator<CardApplicationForm> mockValidator;

    @InjectMocks
    HttpCardApplicationFormService testHttpFormService;

    private static Driver driver = new Driver(1, "12345", "Gogo", "Kocev", "");
    private static Date dateOfSubmission = new Date(2018-11-8);

    private static List<CardApplicationForm> defaultMockRepositoryContent = Arrays.asList(

            new CardApplicationForm(driver, 1,dateOfSubmission,"new","first","123456789", ""),
            new CardApplicationForm(driver, 2,dateOfSubmission, "new","first","987654321","yes")
    );

    @Test
    public void getAllCardApplicationForms_Should_ReturnsAllFromsRepository_WhenRepositoryHasForms() throws Exception{
        //Arrange
        Mockito.when(mockRepository.getAll()).thenReturn(defaultMockRepositoryContent);
        //Act
        List<CardApplicationForm> result = testHttpFormService.getAllForms();
        CardApplicationForm[] finalResult = new CardApplicationForm[result.size()];
        finalResult = result.toArray(finalResult);

        CardApplicationForm[] expected = new CardApplicationForm[defaultMockRepositoryContent.size()];
        expected = defaultMockRepositoryContent.toArray(expected);

        //Assert
        Assert.assertArrayEquals(expected, finalResult);

    }

    @Test
    public void getAddedCardApplicationForms_Should_ReturnsAllAddedFromsInRepository_WhenRepositoryHasAddedForm() throws Exception{
        Mockito.when(mockRepository.add(defaultMockRepositoryContent.get(0))).thenReturn(defaultMockRepositoryContent.get(0));
        Mockito.when(mockValidator.isValid(defaultMockRepositoryContent.get(0))).thenReturn(true);

        CardApplicationForm result = testHttpFormService.addForm(defaultMockRepositoryContent.get(0));

        CardApplicationForm expected = defaultMockRepositoryContent.get(0);

        Assert.assertEquals(expected.getCardApplicationFormId(), result.getCardApplicationFormId());
        Assert.assertEquals(expected.getStatus(), result.getStatus());
        Assert.assertEquals(expected.getDateOfSubmission(), result.getDateOfSubmission());
        Assert.assertEquals(expected.getType(), result.getType());
        Assert.assertEquals(expected.getStatusCheckCode(), result.getStatusCheckCode());
        Assert.assertEquals(expected.getLastSetID(), result.getLastSetID());
    }

    @Test
    public void getCardApplicationFormsByID_Should_ReturnsFromWithTheSameIDInRepository_WhenRepositoryHasMatch() throws Exception{
        Mockito.when(mockRepository.getById(1)).thenReturn(defaultMockRepositoryContent.get(0));

        CardApplicationForm result = testHttpFormService.getFormById(1);

        CardApplicationForm expected = defaultMockRepositoryContent.get(0);

        Assert.assertEquals(expected.getCardApplicationFormId(), result.getCardApplicationFormId());
        Assert.assertEquals(expected.getStatus(), result.getStatus());
        Assert.assertEquals(expected.getDateOfSubmission(), result.getDateOfSubmission());
        Assert.assertEquals(expected.getType(), result.getType());
        Assert.assertEquals(expected.getStatusCheckCode(), result.getStatusCheckCode());
        Assert.assertEquals(expected.getLastSetID(), result.getLastSetID());
    }

    @Test
    public void updatedFormsByID_Should_ReturnsFromWithTheSameIDInRepository_WhenRepositoryHasMatch() throws Exception{
        Mockito.when(mockRepository.updateById(1, defaultMockRepositoryContent.get(0))).thenReturn(defaultMockRepositoryContent.get(0));
        Mockito.when(mockValidator.isValid(defaultMockRepositoryContent.get(0))).thenReturn(true);

        CardApplicationForm result = testHttpFormService.updateFormById(1, defaultMockRepositoryContent.get(0));

        CardApplicationForm expected = defaultMockRepositoryContent.get(0);

        Assert.assertEquals(expected.getCardApplicationFormId(), result.getCardApplicationFormId());
        Assert.assertEquals(expected.getStatus(), result.getStatus());
        Assert.assertEquals(expected.getDateOfSubmission(), result.getDateOfSubmission());
        Assert.assertEquals(expected.getType(), result.getType());
        Assert.assertEquals(expected.getStatusCheckCode(), result.getStatusCheckCode());
        Assert.assertEquals(expected.getLastSetID(), result.getLastSetID());
    }


    @Test
    public void getCardApplicationFormsByStatusCheckCode_Should_ReturnsFromWithTheSameStatusCheckCodeInRepository_WhenRepositoryHasMatch() throws Exception{
        Mockito.when(mockRepository.getAll()).thenReturn(defaultMockRepositoryContent);

        CardApplicationForm result = testHttpFormService.getFormByStatusCheckCode("123456789");

        CardApplicationForm expected = defaultMockRepositoryContent.get(0);

        Assert.assertEquals(expected.getCardApplicationFormId(), result.getCardApplicationFormId());
        Assert.assertEquals(expected.getStatus(), result.getStatus());
        Assert.assertEquals(expected.getDateOfSubmission(), result.getDateOfSubmission());
        Assert.assertEquals(expected.getType(), result.getType());
        Assert.assertEquals(expected.getStatusCheckCode(), result.getStatusCheckCode());
        Assert.assertEquals(expected.getLastSetID(), result.getLastSetID());
    }


    @Test
    public void getFilteredFormsByDriverFirstName_Should_ReturnsFromWithTheSameByDriverFirstNameRepository_WhenRepositoryHasMatch() throws Exception{
        Mockito.when(mockRepository.getAll()).thenReturn(defaultMockRepositoryContent);

        List<CardApplicationForm> result = testHttpFormService.getFilteredFormsByName("Gogo");
        CardApplicationForm[] finalResult = new CardApplicationForm[result.size()];
        finalResult = result.toArray(finalResult);

        CardApplicationForm[] expected = new CardApplicationForm[defaultMockRepositoryContent.size()];
        expected = defaultMockRepositoryContent.toArray(expected);


        Assert.assertEquals(expected, finalResult);
    }

    @Test
    public void getFilteredFormsByDriverLastName_Should_ReturnsFromWithTheSameByDriverLastNameRepository_WhenRepositoryHasMatch() throws Exception{
        Mockito.when(mockRepository.getAll()).thenReturn(defaultMockRepositoryContent);

        List<CardApplicationForm> result = testHttpFormService.getFilteredFormsByName("Kocev");
        CardApplicationForm[] finalResult = new CardApplicationForm[result.size()];
        finalResult = result.toArray(finalResult);

        CardApplicationForm[] expected = new CardApplicationForm[defaultMockRepositoryContent.size()];
        expected = defaultMockRepositoryContent.toArray(expected);


        Assert.assertEquals(expected, finalResult);
    }

    @Test
    public void getFilteredFormsByDriverPersonalNumber_Should_ReturnsFromWithTheSameByDriverPersonalNumberRepository_WhenRepositoryHasMatch() throws Exception{
        Mockito.when(mockRepository.getAll()).thenReturn(defaultMockRepositoryContent);

        List<CardApplicationForm> result = testHttpFormService.getFilteredFormsByPersonalNumber("12345");
        CardApplicationForm[] finalResult = new CardApplicationForm[result.size()];
        finalResult = result.toArray(finalResult);

        CardApplicationForm[] expected = new CardApplicationForm[defaultMockRepositoryContent.size()];
        expected = defaultMockRepositoryContent.toArray(expected);


        Assert.assertEquals(expected, finalResult);
    }



    /*@Test
    public void getFilteredFormsByBySubmissionDate_Should_ReturnsFromWithTheSameBySubmissionDateRepository_WhenRepositoryHasMatch() throws Exception{
        Mockito.when(mockRepository.getAll()).thenReturn(defaultMockRepositoryContent);

        List<CardApplicationForm> result = testHttpFormService.getFilteredFormsBySubmissionDate("2018-11-8");
        CardApplicationForm[] finalResult = new CardApplicationForm[result.size()];
        finalResult = result.toArray(finalResult);

        CardApplicationForm[] expected = new CardApplicationForm[defaultMockRepositoryContent.size()];
        expected = defaultMockRepositoryContent.toArray(expected);


        Assert.assertEquals(expected, finalResult);
    }*/

    @Test
    public void getFilteredFormsByStatus_Should_ReturnsFromWithTheSameStatusRepository_WhenRepositoryHasMatch() throws Exception{
        Mockito.when(mockRepository.getAll()).thenReturn(defaultMockRepositoryContent);

        List<CardApplicationForm> result = testHttpFormService.getFilteredFormsByStatus("new");
        CardApplicationForm[] finalResult = new CardApplicationForm[result.size()];
        finalResult = result.toArray(finalResult);

        CardApplicationForm[] expected = new CardApplicationForm[defaultMockRepositoryContent.size()];
        expected = defaultMockRepositoryContent.toArray(expected);


        Assert.assertEquals(expected, finalResult);
    }

    @Test
    public void getLastUpdatedForm_Should_ReturnFielsWithFieldLastSetIDYes() throws IOException {
        Mockito.when(mockRepository.getAll()).thenReturn(defaultMockRepositoryContent);

        CardApplicationForm result = testHttpFormService.getLastUpdatedForm();

        CardApplicationForm expected = defaultMockRepositoryContent.get(1);

        Assert.assertEquals(expected.getCardApplicationFormId(), result.getCardApplicationFormId());
        Assert.assertEquals(expected.getStatus(), result.getStatus());
        Assert.assertEquals(expected.getDateOfSubmission(), result.getDateOfSubmission());
        Assert.assertEquals(expected.getType(), result.getType());
        Assert.assertEquals(expected.getStatusCheckCode(), result.getStatusCheckCode());
        Assert.assertEquals(expected.getLastSetID(), result.getLastSetID());
    }



}
 //