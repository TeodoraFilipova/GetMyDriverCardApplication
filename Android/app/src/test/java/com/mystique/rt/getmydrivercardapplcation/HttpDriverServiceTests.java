package com.mystique.rt.getmydrivercardapplcation;

import com.mystique.rt.getmydrivercardapplcation.apputils.Constants;
import com.mystique.rt.getmydrivercardapplcation.models.Driver;
import com.mystique.rt.getmydrivercardapplcation.repositories.base.DriverRepository;
import com.mystique.rt.getmydrivercardapplcation.services.HttpDriverService;
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
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class HttpDriverServiceTests {
    @Mock
    DriverRepository mockRepository;

    @Mock
    Validator<Driver> mockValidator;

    @InjectMocks
    HttpDriverService testDriverService;

    private static List<Driver> defaultMockRepositoryContent = Arrays.asList(
            new Driver(1, "12345", "Gogo", "Kocev", ""),
            new Driver(2, "54321", "Petrana", "Marinova", ""),
            new Driver(3, "67890", "Penko", "Samokov", "yes"));

    @Test
    public void getAllDrivers_Should_ReturnAllDriversFromRepository_When_RepositoryHasDrivers() throws IOException {
        // Arrange
        Mockito.when(mockRepository.getAllDrivers()).thenReturn(defaultMockRepositoryContent);

        // Act
        List<Driver> result = testDriverService.getAllDrivers();
        Driver[] finalResult = new Driver[result.size()];
        finalResult = result.toArray(finalResult);

        Driver[] expected = new Driver[defaultMockRepositoryContent.size()];
        expected = defaultMockRepositoryContent.toArray(expected);

        // Assert
        Assert.assertArrayEquals(expected, finalResult);
    }

    @Test
    public void getDriverById_Should_ReturnDriverFromRepositoryWithThisId_When_RepositoryHasDriverWithThisId() throws IOException {
        Mockito.when(mockRepository.getById(2)).thenReturn(defaultMockRepositoryContent.get(1));

        Driver result = testDriverService.getDriverById(2);

        Driver expected = defaultMockRepositoryContent.get(1);

        Assert.assertEquals(expected.getDriverId(), result.getDriverId());
        Assert.assertEquals(expected.getPersonalNumber(), result.getPersonalNumber());
        Assert.assertEquals(expected.getFirstName(), result.getFirstName());
        Assert.assertEquals(expected.getLastName(), result.getLastName());
        Assert.assertEquals(expected.getLastSetID(), result.getLastSetID());
    }

    @Test
    public void getLastUpdatedDriver_Should_ReturnDriverWithFieldLastSetIDYes() throws IOException {
        Mockito.when(mockRepository.getAllDrivers()).thenReturn(defaultMockRepositoryContent);

        Driver result = testDriverService.getLastUpdatedDriver();

        Driver expected = defaultMockRepositoryContent.get(2);

        Assert.assertEquals(expected.getDriverId(), result.getDriverId());
        Assert.assertEquals(expected.getPersonalNumber(), result.getPersonalNumber());
        Assert.assertEquals(expected.getFirstName(), result.getFirstName());
        Assert.assertEquals(expected.getLastName(), result.getLastName());
        Assert.assertEquals(expected.getLastSetID(), result.getLastSetID());
    }

    @Test
    public void getDriverByPersonalNumber_Should_ReturnDriverFromRepositoryWithThisPersonalNumber_When_RepositoryHasMatch() throws IOException {
        Mockito.when(mockRepository.getAllDrivers()).thenReturn(defaultMockRepositoryContent);

        Driver result = testDriverService.getDriverByPersonalNumber("12345");

        Driver expected = defaultMockRepositoryContent.get(0);

        Assert.assertEquals(expected.getDriverId(), result.getDriverId());
        Assert.assertEquals(expected.getPersonalNumber(), result.getPersonalNumber());
        Assert.assertEquals(expected.getFirstName(), result.getFirstName());
        Assert.assertEquals(expected.getLastName(), result.getLastName());
        Assert.assertEquals(expected.getLastSetID(), result.getLastSetID());
    }

    @Test
    public void addDriver_Should_ReturnDriverWhichIsAdded() throws IOException {
        Mockito.when(mockRepository.add(defaultMockRepositoryContent.get(0))).thenReturn(defaultMockRepositoryContent.get(0));
        Mockito.when(mockValidator.isValid(defaultMockRepositoryContent.get(0))).thenReturn(true);

        Driver result = testDriverService.addDriver(defaultMockRepositoryContent.get(0));

        Driver expected = defaultMockRepositoryContent.get(0);

        Assert.assertEquals(expected.getDriverId(), result.getDriverId());
        Assert.assertEquals(expected.getPersonalNumber(), result.getPersonalNumber());
        Assert.assertEquals(expected.getFirstName(), result.getFirstName());
        Assert.assertEquals(expected.getLastName(), result.getLastName());
        Assert.assertEquals(expected.getLastSetID(), result.getLastSetID());
    }

    @Test
    public void updateDriverById_Should_ReturnDriverWhichIsUpdated() throws IOException {
        Mockito.when(mockRepository.updateById(1, defaultMockRepositoryContent.get(0))).thenReturn(defaultMockRepositoryContent.get(0));
        Mockito.when(mockValidator.isValid(defaultMockRepositoryContent.get(0))).thenReturn(true);

        Driver result = testDriverService.updateDriverById(1, defaultMockRepositoryContent.get(0));

        Driver expected = defaultMockRepositoryContent.get(0);

        Assert.assertEquals(expected.getDriverId(), result.getDriverId());
        Assert.assertEquals(expected.getPersonalNumber(), result.getPersonalNumber());
        Assert.assertEquals(expected.getFirstName(), result.getFirstName());
        Assert.assertEquals(expected.getLastName(), result.getLastName());
        Assert.assertEquals(expected.getLastSetID(), result.getLastSetID());
    }
}
