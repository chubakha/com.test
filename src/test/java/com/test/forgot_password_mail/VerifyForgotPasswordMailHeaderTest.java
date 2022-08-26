package com.test.forgot_password_mail;

import com.test.login.LoginCabinetPage;
import com.test.login.PrepareLoginTestData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.WebDriverRunner.url;

public class VerifyForgotPasswordMailHeaderTest extends PrepareLoginTestData {

    @Test
    void verifyForgotPasswordMailHeader(){
        boolean isProd = new YopmailIncomingMailPage().isProductionDomainShown(url());
        new LoginCabinetPage()
                .clickForgotPasswordLink()
                .setEmailField(clientEmail)
                .clickSendButton();
        if(isProd){
            openYopmailPage();
            YopmailIncomingMailPage yopmailIncomingMailPage = new YopmailMainPage()
                    .setLoginField(clientEmail)
                    .clickLoginButton()
                    .switchIframe();
            Assertions.assertEquals("Legal Nodes Password Reset", yopmailIncomingMailPage.getMailHeader(),
                        "'Legal Nodes Password Reset' should be shown");
        }
        else{
            openMailHogPage();
            MailHogIncomingPage mailHogIncomingPage = new MailHogMainPage().
                    clickIncomingEmail(clientEmail);
            Assertions.assertEquals("Legal Nodes Password Reset", mailHogIncomingPage.getMailHeader(),
                        "'Legal Nodes Password Reset' should be shown");
        }

    }
}
