package com.mystique.rt.getmydrivercardapplcation;


import com.mystique.rt.getmydrivercardapplcation.models.User;
import com.mystique.rt.getmydrivercardapplcation.repositories.base.UserRepository;
import com.mystique.rt.getmydrivercardapplcation.services.HttpUserService;

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
public class HttpUserServiceTests {

    @Mock
    UserRepository mockRepository;

    @InjectMocks
    HttpUserService testHttpUsersService;

    private static List<User> defaultMockRepositoryContent = Arrays.asList(
            new User("pepelopez", "123456"),
            new User("mochito", "654321"),
            new User("cocacola", "121212")
    );

    @Test
    public void getAllUsers_ReturnsAllUsersFromRepository_WhenRepositoryHasUsers() throws Exception{
        //Arrange
        Mockito.when(mockRepository.getAll()).thenReturn(defaultMockRepositoryContent);
        //Act
        List<User> result = testHttpUsersService.getAllUsers();
        User[] finalResult = new User[result.size()];
        finalResult = result.toArray(finalResult);

        User[] expected = new User[defaultMockRepositoryContent.size()];
        expected = defaultMockRepositoryContent.toArray(expected);

        //Assert
        Assert.assertArrayEquals(expected, finalResult);

    }

    @Test
    public void getUserByUsernameAndPassword_Should_ReturnsOneUserFromRepositoryMatchingPattern_WhenRepositoryHasUser() throws Exception{
        //Arrange
        Mockito.when(mockRepository.getAll()).thenReturn(defaultMockRepositoryContent);

        //Act
        User result = testHttpUsersService.getUserByUsernameAndPassword("pepelopez", "123456");
        User expected = defaultMockRepositoryContent.get(0);

        //Assert
        Assert.assertEquals(expected.getUsername(), result.getUsername());
        Assert.assertEquals(expected.getPassword(), result.getPassword());

    }


}
