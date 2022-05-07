package com.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;


public class ManagerLoginPageTests extends BaseTest {
    @BeforeEach
    void openPage(){
        open("/");
    }

    private boolean loginEnteringData(String email, String password){
        new LoginPage().loginAsUserByManager(email, password);
        sleep(3000);
        return url().contains("dashboard");
    }

    @Test //positive test
    void positiveTest(){
        Assertions.assertTrue(loginEnteringData(STABLE_MANAGER_EMAIL, STABLE_MANAGER_PASSWORD));
        new UserPage().logoutClickButton();
    }

    @Test //wrong password
    void incorrectPassword(){
        Assertions.assertFalse(loginEnteringData(STABLE_MANAGER_EMAIL, "1234567"));
    }

    @Test //wrong Email
    void incorrectEmail(){
        Assertions.assertFalse(loginEnteringData("client-yop@yopmai.com", STABLE_MANAGER_PASSWORD));
    }

    @Test //email without "@"
    void withoutAt(){
        Assertions.assertFalse(loginEnteringData("client-yopyopmai.com", STABLE_MANAGER_PASSWORD));
    }

    @Test //email without "dot"
    void withoutDot(){
        Assertions.assertFalse(loginEnteringData("client-yop@yopmaicom", STABLE_MANAGER_PASSWORD));
    }
}
