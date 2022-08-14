package com.test.forgot_password_mail;

import com.test.login.LoginCabinetPage;
import com.test.login.PrepareLoginTestData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VerifyForgotPasswordMailSubjectTest extends PrepareLoginTestData {

    @Test
    void verifyForgotPasswordMailSubject(){
        new LoginCabinetPage()
                .clickForgotPasswordLink()
                .setEmailField(clientEmail)
                .clickSendButton();
        openYopmailPage();
        IncomingMailPage incomingMailPage = new MainYopmailPage()
                .setLoginField(clientEmail)
                .clickLoginButton()
                .switchIframe();
        Assertions.assertAll("The forgot password mail should have next conditions:",
                () -> Assertions.assertTrue(incomingMailPage.getMailSubject().contains("To reset your password, please, follow the link below:"),
                        "'To reset your password, please, follow the link below:' should be shown"),
                () -> Assertions.assertTrue(incomingMailPage.getMailSubject().contains("Best regards, Legal Nodes Team."),
                        "'Best regards, Legal Nodes Team.' should be shown")
        );
    }
}
