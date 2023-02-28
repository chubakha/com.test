package com.test.forgot_password_mail;

import com.test.GenericPage;
import com.test.login.LoginCabinetPage;
import com.test.mailers.MailHogRecoveryPasswordMailPage;
import com.test.mailers.YopmailInboxMailPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.WebDriverRunner.url;

public class VerifyForgotPasswordMailSubjectTest extends PrepareForgotPasswordMailData {

    @Test
    void verifyForgotPasswordMailSubject() {
        boolean isProd = isProductionDomainShown(url());
        new LoginCabinetPage()
                .clickForgotPasswordLink()
                .setEmailField(clientEmail)
                .clickSendButton();
        if (isProd) {
            YopmailInboxMailPage yopmailInboxMailPage = GenericPage
                    .openYopmailPage()
                    .setLoginField(clientEmail)
                    .clickLoginButton()
                    .switchEmailIframe();
            Assertions.assertAll("The forgot password mail should have next conditions:",
                    () -> Assertions.assertTrue(yopmailInboxMailPage.getMailContent().contains("To reset your password, please, follow the link below:"),
                            "'To reset your password, please, follow the link below:' should be shown"),
                    () -> Assertions.assertTrue(yopmailInboxMailPage.getMailContent().contains("Best regards, Legal Nodes Team."),
                            "'Best regards, Legal Nodes Team.' should be shown")
            );
        } else {
            MailHogRecoveryPasswordMailPage mailHogRecoveryPasswordMailPage = GenericPage
                    .openMailHogPage()
                    .clickRecoveryPasswordEmail(clientEmail);
            Assertions.assertAll("The forgot password mail should have next conditions:",
                    () -> Assertions.assertTrue(mailHogRecoveryPasswordMailPage.getMailSubject().contains("To reset your password, please, follow the link below:"),
                            "'To reset your password, please, follow the link below:' should be shown"),
                    () -> Assertions.assertTrue(mailHogRecoveryPasswordMailPage.getMailSubject().contains("Best regards, Legal Nodes Team."),
                            "'Best regards, Legal Nodes Team.' should be shown")
            );
        }
    }
}
