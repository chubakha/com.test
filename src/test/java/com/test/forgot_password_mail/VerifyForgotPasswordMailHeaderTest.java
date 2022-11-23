package com.test.forgot_password_mail;

import com.test.GenericPage;
import com.test.login.LoginCabinetPage;
import com.test.login.PrepareLoginTestData;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.WebDriverRunner.closeWindow;
import static com.codeborne.selenide.WebDriverRunner.url;

public class VerifyForgotPasswordMailHeaderTest extends PrepareForgotPasswordMailData {

    @Test
    void verifyForgotPasswordMailHeader(){
        boolean isProd = new YopmailIncomingMailPage().isProductionDomainShown(url());
        new LoginCabinetPage()
                .clickForgotPasswordLink()
                .setEmailField(clientEmail)
                .clickSendButton();
        if(isProd){
            YopmailIncomingMailPage yopmailIncomingMailPage = GenericPage
                    .openYopmailPage()
                    .setLoginField(clientEmail)
                    .clickLoginButton()
                    .switchEmailIframe();
            Assertions.assertEquals("Legal Nodes Password Reset", yopmailIncomingMailPage.getMailHeader(),
                        "'Legal Nodes Password Reset' should be shown");
        }
        else{
            MailHogIncomingPage mailHogIncomingPage = GenericPage
                    .openMailHogPage()
                    .clickIncomingEmail(clientEmail);
            Assertions.assertEquals("Legal Nodes Password Reset", mailHogIncomingPage.getMailHeader(),
                        "'Legal Nodes Password Reset' should be shown");
        }

    }
}
