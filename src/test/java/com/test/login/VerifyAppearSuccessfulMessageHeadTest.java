package com.test.login;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VerifyAppearSuccessfulMessageHeadTest extends PrepareLoginTestData {

    @Test
    void verifyAppearSuccessfulMessageHead(){
        ForgotPasswordOverlay forgotPasswordOverlay = new LoginCabinetPage()
                .clickForgotPasswordLink()
                .setEmailField(faker.internet().emailAddress())
                .clickSendButton();
        Assertions.assertTrue(forgotPasswordOverlay.isSuccessfulMessageHeadShown(),
                "'Success' should be shown");
    }
}
