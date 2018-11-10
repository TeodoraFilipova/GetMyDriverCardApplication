package com.mystique.springdrivercard;

import com.mystique.springdrivercard.models.User;
import com.mystique.springdrivercard.repositories.CardApplicationRepository;
import com.mystique.springdrivercard.services.userService.UserServiceImpl;
import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTests {

    @Mock
    CardApplicationRepository mockRepository;

    @InjectMocks
    UserServiceImpl testHttpUsersService;

    private static List<User> defaultMockRepositoryContent = Arrays.asList(
            new User("pepelopez", "123456"),
            new User("mochito", "654321"),
            new User("cocacola", "121212")
    );

    @Test
    public void getAllUsers_ReturnsAllUsersFromRepository_WhenRepositoryHasUsers() {
        //Arrange
        Mockito.when(mockRepository.getAllUsers()).thenReturn(defaultMockRepositoryContent);
        //Act
        List<User> result = testHttpUsersService.getAllUsers();
        User[] finalResult = new User[result.size()];
        finalResult = result.toArray(finalResult);

        User[] expected = new User[defaultMockRepositoryContent.size()];
        expected = defaultMockRepositoryContent.toArray(expected);

        //Assert
        Assert.assertArrayEquals(expected, finalResult);

    }

}
