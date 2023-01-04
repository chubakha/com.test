package com.test.forgot_password_mail;

import com.test.GenericPage;
import com.test.login.LoginCabinetPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.WebDriverRunner.url;

public class VerifyForgotPasswordMailHeaderTest extends PrepareForgotPasswordMailData {

    @Test
    void verifyForgotPasswordMailHeader(){
        boolean isProd = isProductionDomainShown(url());
        new LoginCabinetPage()
                .clickForgotPasswordLink()
                .setEmailField(clientEmail)
                .clickSendButton();
        if(isProd){
            YopmailInboxMailPage yopmailInboxMailPage = GenericPage
                    .openYopmailPage()
                    .setLoginField(clientEmail)
                    .clickLoginButton()
                    .switchEmailIframe();
            Assertions.assertEquals("Legal Nodes Password Reset", yopmailInboxMailPage.getMailHeader(),
                        "'Legal Nodes Password Reset' should be shown");
        }
        else{
            MailHogRecoveryPasswordMailPage mailHogRecoveryPasswordMailPage = GenericPage
                    .openMailHogPage()
                    .clickRecoveryPasswordEmail(clientEmail);
            Assertions.assertEquals("Legal Nodes Password Reset", mailHogRecoveryPasswordMailPage.getMailHeader(),
                        "'Legal Nodes Password Reset' should be shown");
        }

    }
}
