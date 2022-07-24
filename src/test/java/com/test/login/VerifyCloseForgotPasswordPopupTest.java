package com.test.login;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.sleep;

public class VerifyCloseForgotPasswordPopupTest extends PrepareLoginTestData{

    @Test
    void verifyCloseForgotPasswordPopup(){
        LoginPage loginPage = new LoginPage()
                .clickForgotPasswordLink()
                .clickSendMeBackButton();
        sleep(3000);
        Assertions.assertFalse(loginPage.forgotPasswordPopupIsShown(),
                "'Forgot Password' popup should not be shown");
    }
}
