package com.techelevator.tenmo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.techelevator.tenmo.model.AuthenticatedUser;
import com.techelevator.tenmo.model.UserCredentials;
import com.techelevator.tenmo.services.AuthenticationService;

import java.lang.reflect.Field;

class currentBalanceTest {

    private App app;

    @BeforeEach
    void setUp() {
        app = new App();
    }

    @Test
    void testViewCurrentBalance_NotNegative() throws Exception {
        // Simulate login
        UserCredentials credentials = new UserCredentials("java", "java");
        AuthenticationService authService = new AuthenticationService("http://localhost:8080/");
        AuthenticatedUser user = authService.login(credentials);

        if (user == null) {
            fail("Login failed. Please check your credentials or server status.");
        }

        // Set the authenticated user in the App instance
        Field currentUserField = App.class.getDeclaredField("currentUser");
        currentUserField.setAccessible(true);
        currentUserField.set(app, user);

        // Now test the balance
        double balance = app.getCurrentBalance();

        assertFalse(balance < 0, "Current balance should not be negative");
        System.out.println("Current balance: $" + balance+ " "+  "everything is good ");
    }

}