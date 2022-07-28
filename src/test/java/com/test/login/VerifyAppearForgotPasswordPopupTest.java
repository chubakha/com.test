package com.test.login;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VerifyAppearForgotPasswordPopupTest extends PrepareLoginTestData {

    @Test
    void verifyAppearForgotPasswordPopup(){
        ForgotPasswordOverlay forgotPasswordOverlay = new ClientLoginPage()
                .clickForgotPasswordLink();
        Assertions.assertTrue(forgotPasswordOverlay.forgotPasswordPopupIsShown(),
                "'Forgot Password' popup should be shown");

    }
}
