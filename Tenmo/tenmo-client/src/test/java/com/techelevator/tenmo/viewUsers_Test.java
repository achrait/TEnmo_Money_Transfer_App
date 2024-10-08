

package com.techelevator.tenmo;

import com.techelevator.tenmo.model.AuthenticatedUser;
import com.techelevator.tenmo.model.User;
import com.techelevator.tenmo.services.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class viewUsers_Test{

    @Test
    void testViewUsers() throws Exception {
        App app = new App();

        // Create and set a mock authenticated user
        User mockUser = new User();
        mockUser.setId(1);
        mockUser.setUsername("testuser");
        AuthenticatedUser mockAuthUser = new AuthenticatedUser();
        mockAuthUser.setUser(mockUser);
        mockAuthUser.setToken("test-token");

        // Set the mock authenticated user in the App instance
        Field currentUserField = App.class.getDeclaredField("currentUser");
        currentUserField.setAccessible(true);
        currentUserField.set(app, mockAuthUser);

        // Create mock UserService
        UserService mockUserService = Mockito.mock(UserService.class);
        User[] mockUsers = {
                createUser(1, "user1"),
                createUser(2, "user2"),
                createUser(3, "user3")
        };
        when(mockUserService.getUsers(anyString())).thenReturn(mockUsers);

        // Set the mock UserService in the App instance
        Field userServiceField = App.class.getDeclaredField("userService");
        userServiceField.setAccessible(true);
        userServiceField.set(app, mockUserService);

        // Capture console output
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        // Call the viewUsers method using reflection
        Method viewUsersMethod = App.class.getDeclaredMethod("viewUsers");
        viewUsersMethod.setAccessible(true);
        viewUsersMethod.invoke(app);

        // Get the captured output
        String consoleOutput = outputStreamCaptor.toString();

        // Verify the output
        assertTrue(consoleOutput.contains("-------------------------------------------"));
        assertTrue(consoleOutput.contains("Users"));
        assertTrue(consoleOutput.contains("ID          Name"));
        assertTrue(consoleOutput.contains("1 user1"));
        assertTrue(consoleOutput.contains("2 user2"));
        assertTrue(consoleOutput.contains("3 user3"));

        // Restore original System.out
        System.setOut(System.out);
    }

    private User createUser(int id, String username) {
        User user = new User();
        user.setId(id);
        user.setUsername(username);
        return user;
    }
}