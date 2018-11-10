package com.mystique.springdrivercard;

import com.mystique.springdrivercard.models.Picture;
import com.mystique.springdrivercard.repositories.CardApplicationRepository;
import com.mystique.springdrivercard.services.pictureService.PictureServiceImpl;
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
public class PictureServiceImplTests {
    @Mock
    CardApplicationRepository mockRepository;

    @InjectMocks
    PictureServiceImpl testPictureService;

    private static List<Picture> defaultMockRepositoryContent = Arrays.asList(
            new Picture(1, ""),
            new Picture(2, ""),
            new Picture(3, "yes"));

    @Test
    public void getAllPictures_Should_ReturnAllPicturesFromRepository_When_RepositoryHasPictures() {
        // Arrange
        Mockito.when(mockRepository.getAllPictures()).thenReturn(defaultMockRepositoryContent);

        // Act
        List<Picture> result = testPictureService.getAllPictures();
        Picture[] finalResult = new Picture[result.size()];
        finalResult = result.toArray(finalResult);

        Picture[] expected = new Picture[defaultMockRepositoryContent.size()];
        expected = defaultMockRepositoryContent.toArray(expected);

        // Assert
        Assert.assertArrayEquals(expected, finalResult);
    }

    @Test
    public void getPictureById_Should_ReturnPictureFromRepositoryWithThisId_When_RepositoryHasPictureWithThisId() {
        Mockito.when(mockRepository.getPictureByID(2)).thenReturn(defaultMockRepositoryContent.get(1));

        Picture result = testPictureService.getPictureByID(2);

        Picture expected = defaultMockRepositoryContent.get(1);

        Assert.assertEquals(expected.getPictureId(), result.getPictureId());
        Assert.assertEquals(expected.getPicture(), result.getPicture());
        Assert.assertEquals(expected.getLastSetID(), result.getLastSetID());
    }

    @Test
    public void addPicture_Should_ReturnPictureWhichIsAdded() {
        Mockito.when(mockRepository.addNewPicture(defaultMockRepositoryContent.get(0))).thenReturn(defaultMockRepositoryContent.get(0));

        Picture result = testPictureService.addNewPicture(defaultMockRepositoryContent.get(0));

        Picture expected = defaultMockRepositoryContent.get(0);

        Assert.assertEquals(expected.getPictureId(), result.getPictureId());
        Assert.assertEquals(expected.getPicture(), result.getPicture());
        Assert.assertEquals(expected.getLastSetID(), result.getLastSetID());
    }

    @Test
    public void updatePictureById_Should_ReturnPictureWhichIsUpdated() throws IOException {
        Mockito.when(mockRepository.updatePicture(1, defaultMockRepositoryContent.get(0))).thenReturn(defaultMockRepositoryContent.get(0));

        Picture result = testPictureService.updatePicture(1, defaultMockRepositoryContent.get(0));

        Picture expected = defaultMockRepositoryContent.get(0);

        Assert.assertEquals(expected.getPictureId(), result.getPictureId());
        Assert.assertEquals(expected.getPicture(), result.getPicture());
        Assert.assertEquals(expected.getLastSetID(), result.getLastSetID());
    }

}
