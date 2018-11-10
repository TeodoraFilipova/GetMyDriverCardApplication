package com.mystique.springdrivercard;

import org.junit.*;

public class UserServiceTests {
    @Before
    public void initTest() {
        System.out.println("Init test.");
    }

    @After
    public void cleanTest() {
        System.out.println("Clean test.");
    }

    @BeforeClass
    public static void initAllTests() {
        System.out.println("Init all tests.");
    }

    @AfterClass
    public static void cleanAllTests() {
        System.out.println("Clean all tests.");
    }

    @Test
    public void stackIsEmptyWhenCreated() {
        System.out.println("Test empty stack.");
        // Arrange
        Stack s = new ArrayStack();

        // Act
        boolean isEmpty = s.isEmpty();

        // Assert
        Assert.assertTrue("New stack should be empty.", isEmpty);
    }

}
