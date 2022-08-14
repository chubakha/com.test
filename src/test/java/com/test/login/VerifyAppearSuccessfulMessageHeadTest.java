package com.test.login;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.sleep;

public class VerifyAppearSuccessfulMessageHeadTest extends PrepareLoginTestData {

    @Test
    void verifyAppearSuccessfulMessageHead(){
        ForgotPasswordOverlay forgotPasswordOverlay = new LoginCabinetPage()
                .clickForgotPasswordLink()
                .setEmailField(faker.internet().emailAddress())
                .clickSendButton();
        sleep(2000);
        Assertions.assertTrue(forgotPasswordOverlay.isSuccessfulMessageHeadShown(),
                "'Success' should be shown");
    }
}
