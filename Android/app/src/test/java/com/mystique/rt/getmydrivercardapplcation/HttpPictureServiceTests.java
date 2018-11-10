package com.mystique.rt.getmydrivercardapplcation;

import com.mystique.rt.getmydrivercardapplcation.apputils.Constants;
import com.mystique.rt.getmydrivercardapplcation.models.Picture;
import com.mystique.rt.getmydrivercardapplcation.repositories.base.PictureRepository;
import com.mystique.rt.getmydrivercardapplcation.services.HttpPictureService;

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
public class HttpPictureServiceTests {
    @Mock
    PictureRepository mockRepository;

    @InjectMocks
    HttpPictureService testHttpPictureService;

    private static List<Picture> defaultMockRepositoryContent = Arrays.asList(
            new Picture(1, ""),
            new Picture(2, ""),
            new Picture(3, "yes"));

    @Test
    public void getAllPictures_Should_ReturnAllPicturesFromRepository_When_RepositoryHasPictures() throws IOException {
        // Arrange
        Mockito.when(mockRepository.getAllPictures()).thenReturn(defaultMockRepositoryContent);

        // Act
        List<Picture> result = testHttpPictureService.getAllPictures();
        Picture[] finalResult = new Picture[result.size()];
        finalResult = result.toArray(finalResult);

        Picture[] expected = new Picture[defaultMockRepositoryContent.size()];
        expected = defaultMockRepositoryContent.toArray(expected);

        // Assert
        Assert.assertArrayEquals(expected, finalResult);
    }

    @Test
    public void getPictureById_Should_ReturnPictureFromRepositoryWithThisId_When_RepositoryHasPictureWithThisId() throws IOException {
        Mockito.when(mockRepository.getById(2)).thenReturn(defaultMockRepositoryContent.get(1));

        Picture result = testHttpPictureService.getPictureById(2);

        Picture expected = defaultMockRepositoryContent.get(1);

        Assert.assertEquals(expected.getPictureId(), result.getPictureId());
        Assert.assertEquals(expected.getPicture(), result.getPicture());
        Assert.assertEquals(expected.getLastSetID(), result.getLastSetID());
    }

    @Test
    public void getLastUpdatedPicture_Should_ReturnPictureWithFieldLastSetIDYes() throws IOException {
        Mockito.when(mockRepository.getAllPictures()).thenReturn(defaultMockRepositoryContent);

        Picture result = testHttpPictureService.getLastUpdatedPicture();

        Picture expected = defaultMockRepositoryContent.get(2);

        Assert.assertEquals(expected.getPictureId(), result.getPictureId());
        Assert.assertEquals(expected.getPicture(), result.getPicture());
        Assert.assertEquals(expected.getLastSetID(), result.getLastSetID());
    }

    @Test
    public void addPicture_Should_ReturnPictureWhichIsAdded() throws IOException {
        Mockito.when(mockRepository.add(defaultMockRepositoryContent.get(0))).thenReturn(defaultMockRepositoryContent.get(0));

        Picture result = testHttpPictureService.addPicture(defaultMockRepositoryContent.get(0));

        Picture expected = defaultMockRepositoryContent.get(0);

        Assert.assertEquals(expected.getPictureId(), result.getPictureId());
        Assert.assertEquals(expected.getPicture(), result.getPicture());
        Assert.assertEquals(expected.getLastSetID(), result.getLastSetID());
    }

    @Test
    public void updatePictureById_Should_ReturnPictureWhichIsUpdated() throws IOException {
        Mockito.when(mockRepository.updateById(1, defaultMockRepositoryContent.get(0))).thenReturn(defaultMockRepositoryContent.get(0));

        Picture result = testHttpPictureService.updatePictureById(1, defaultMockRepositoryContent.get(0));

        Picture expected = defaultMockRepositoryContent.get(0);

        Assert.assertEquals(expected.getPictureId(), result.getPictureId());
        Assert.assertEquals(expected.getPicture(), result.getPicture());
        Assert.assertEquals(expected.getLastSetID(), result.getLastSetID());
    }

}

// Arrange
// Act
// Assert