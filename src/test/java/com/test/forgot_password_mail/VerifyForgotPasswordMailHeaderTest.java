package com.test.forgot_password_mail;

import com.test.login.LoginCabinetPage;
import com.test.login.PrepareLoginTestData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VerifyForgotPasswordMailHeaderTest extends PrepareLoginTestData {

    @Test
    void verifyForgotPasswordMailHeader(){
        new LoginCabinetPage()
                .clickForgotPasswordLink()
                .setEmailField(clientEmail)
                .clickSendButton();
        openYopmailPage();
        IncomingMailPage incomingMailPage = new MainYopmailPage()
                .setLoginField(clientEmail)
                .clickLoginButton()
                .switchIframe();
        Assertions.assertEquals("Legal Nodes Password Reset", incomingMailPage.getMailHeader(),
                "'Legal Nodes Password Reset' should be shown");
    }
}
