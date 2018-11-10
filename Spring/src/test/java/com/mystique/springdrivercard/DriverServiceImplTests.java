package com.mystique.springdrivercard;

import com.mystique.springdrivercard.models.Driver;
import com.mystique.springdrivercard.repositories.CardApplicationRepository;
import com.mystique.springdrivercard.services.driverService.DriverServiceImpl;
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
public class DriverServiceImplTests {
    @Mock
    CardApplicationRepository mockRepository;

    @InjectMocks
    DriverServiceImpl testDriverService;

    private static List<Driver> defaultMockRepositoryContent = Arrays.asList(
            new Driver(1, "12345", "Gogo", "Kocev", ""),
            new Driver(2, "54321", "Petrana", "Marinova", ""),
            new Driver(3, "67890", "Penko", "Samokov", "yes"));

    @Test
    public void getAllDrivers_Should_ReturnAllDriversFromRepository_When_RepositoryHasDrivers() {
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
    public void getDriverById_Should_ReturnDriverFromRepositoryWithThisId_When_RepositoryHasDriverWithThisId() {
        Mockito.when(mockRepository.getDriverByID(2)).thenReturn(defaultMockRepositoryContent.get(1));

        Driver result = testDriverService.getDriverByID(2);

        Driver expected = defaultMockRepositoryContent.get(1);

        Assert.assertEquals(expected.getDriverId(), result.getDriverId());
        Assert.assertEquals(expected.getPersonalNumber(), result.getPersonalNumber());
        Assert.assertEquals(expected.getFirstName(), result.getFirstName());
        Assert.assertEquals(expected.getLastName(), result.getLastName());
        Assert.assertEquals(expected.getLastSetID(), result.getLastSetID());
    }

    @Test
    public void addDriver_Should_ReturnDriverWhichIsAdded() {
        Mockito.when(mockRepository.addDriver(defaultMockRepositoryContent.get(0))).thenReturn(defaultMockRepositoryContent.get(0));

        Driver result = testDriverService.addDriver(defaultMockRepositoryContent.get(0));

        Driver expected = defaultMockRepositoryContent.get(0);

        Assert.assertEquals(expected.getDriverId(), result.getDriverId());
        Assert.assertEquals(expected.getPersonalNumber(), result.getPersonalNumber());
        Assert.assertEquals(expected.getFirstName(), result.getFirstName());
        Assert.assertEquals(expected.getLastName(), result.getLastName());
        Assert.assertEquals(expected.getLastSetID(), result.getLastSetID());
    }

    @Test
    public void updateDriverById_Should_ReturnDriverWhichIsUpdated() {
        Mockito.when(mockRepository.updateDriver(1, defaultMockRepositoryContent.get(0))).thenReturn(defaultMockRepositoryContent.get(0));

        Driver result = testDriverService.updateDriver(1, defaultMockRepositoryContent.get(0));

        Driver expected = defaultMockRepositoryContent.get(0);

        Assert.assertEquals(expected.getDriverId(), result.getDriverId());
        Assert.assertEquals(expected.getPersonalNumber(), result.getPersonalNumber());
        Assert.assertEquals(expected.getFirstName(), result.getFirstName());
        Assert.assertEquals(expected.getLastName(), result.getLastName());
        Assert.assertEquals(expected.getLastSetID(), result.getLastSetID());
    }
}
