package com.test.forgot_password_mail;

import com.test.create_new_password.CreateNewPasswordOverlay;
import com.test.login.LoginCabinetPage;
import com.test.login.PrepareLoginTestData;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.closeWindow;
import static com.codeborne.selenide.WebDriverRunner.url;

public class VerifyRedirectForgotPasswordLinkTest extends PrepareForgotPasswordMailData {

    @Test
    void verifyRedirectForgotPasswordLink(){
        new LoginCabinetPage()
                .clickForgotPasswordLink()
                .setEmailField(clientEmail)
                .clickSendButton();
        redirectToForgetPasswordToken(clientEmail);
        sleep(2000);
        Assertions.assertEquals("Reset Password",
                new CreateNewPasswordOverlay().getOverlayTitle(), "'Reset Password' should be shown on overlay");
    }

}
