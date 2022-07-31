package com.test.login;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.sleep;

public class VerifyCloseForgotPasswordPopupTest extends PrepareLoginTestData{

    @Test
    void verifyCloseForgotPasswordPopup(){
        ClientLoginPage clientLoginPage = new ClientLoginPage()
                .clickForgotPasswordLink()
                .clickSendMeBackButton();
        sleep(3000);
        Assertions.assertFalse(clientLoginPage.isForgotPasswordPopupShown(),
                "'Forgot Password' popup should not be shown");
    }
}
