package com.test.forgot_password_mail;

import com.test.create_new_password.CreateNewPasswordOverlay;
import com.test.login.LoginCabinetPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.sleep;

public class VerifyRedirectForgotPasswordLinkTest extends PrepareForgotPasswordMailData {

    @Test
    void verifyRedirectForgotPasswordLink(){
        new LoginCabinetPage()
                .clickForgotPasswordLink()
                .setEmailField(clientEmail)
                .clickSendButton();
        redirectToLinkFromEmail(clientEmail);
        Assertions.assertEquals("Reset Password",
                new CreateNewPasswordOverlay().getOverlayTitle(), "'Reset Password' should be shown on overlay");
    }

}
