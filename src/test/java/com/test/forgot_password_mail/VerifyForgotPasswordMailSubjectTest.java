package com.test.forgot_password_mail;

import com.test.GenericPage;
import com.test.login.LoginCabinetPage;
import com.test.login.PrepareLoginTestData;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.WebDriverRunner.closeWindow;
import static com.codeborne.selenide.WebDriverRunner.url;

public class VerifyForgotPasswordMailSubjectTest extends PrepareForgotPasswordMailData {

    @Test
    void verifyForgotPasswordMailSubject() {
        boolean isProd = new YopmailIncomingMailPage().isProductionDomainShown(url());
        new LoginCabinetPage()
                .clickForgotPasswordLink()
                .setEmailField(clientEmail)
                .clickSendButton();
        if (isProd) {
            YopmailIncomingMailPage yopmailIncomingMailPage = GenericPage
                    .openYopmailPage()
                    .setLoginField(clientEmail)
                    .clickLoginButton()
                    .switchEmailIframe();
            Assertions.assertAll("The forgot password mail should have next conditions:",
                    () -> Assertions.assertTrue(yopmailIncomingMailPage.getMailSubject().contains("To reset your password, please, follow the link below:"),
                            "'To reset your password, please, follow the link below:' should be shown"),
                    () -> Assertions.assertTrue(yopmailIncomingMailPage.getMailSubject().contains("Best regards, Legal Nodes Team."),
                            "'Best regards, Legal Nodes Team.' should be shown")
            );
        } else {
            MailHogIncomingPage mailHogIncomingPage = GenericPage
                    .openMailHogPage()
                    .clickIncomingEmail(clientEmail);
            Assertions.assertAll("The forgot password mail should have next conditions:",
                    () -> Assertions.assertTrue(mailHogIncomingPage.getMailSubject().contains("To reset your password, please, follow the link below:"),
                            "'To reset your password, please, follow the link below:' should be shown"),
                    () -> Assertions.assertTrue(mailHogIncomingPage.getMailSubject().contains("Best regards, Legal Nodes Team."),
                            "'Best regards, Legal Nodes Team.' should be shown")
            );
        }
    }
}
