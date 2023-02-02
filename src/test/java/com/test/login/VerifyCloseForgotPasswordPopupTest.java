package com.test.login;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.sleep;

public class VerifyCloseForgotPasswordPopupTest extends PrepareLoginTestData{

    @Test
    void verifyCloseForgotPasswordPopup(){
        LoginCabinetPage loginCabinetPage = new LoginCabinetPage()
                .clickForgotPasswordLink()
                .clickSendMeBackButton();
        Assertions.assertFalse(loginCabinetPage.isForgotPasswordPopupShown(),
                "'Forgot Password' popup should not be shown");
    }
}
