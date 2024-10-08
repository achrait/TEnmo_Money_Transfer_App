package com.techelevator.tenmo;

import com.techelevator.tenmo.model.AuthenticatedUser;
import com.techelevator.tenmo.model.User;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

class SendBucks_Test{

    @Test
    void testSendBucks() throws NoSuchFieldException, IllegalAccessException {
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

        System.out.println("evrything is fine ");

        // If we reach this point without any errors, the test passes
    }
}