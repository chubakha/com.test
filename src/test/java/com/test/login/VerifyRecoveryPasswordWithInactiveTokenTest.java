package com.test.login;

import com.test.GenericPage;
import com.test.create_new_password.CreateNewPasswordOverlay;
import com.test.forgot_password_mail.MailHogRecoveryPasswordMailPage;
import com.test.forgot_password_mail.YopmailInboxMailPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;

public class VerifyRecoveryPasswordWithInactiveTokenTest extends PrepareLoginTestData {

    @Test
    void verifyRecoveryPasswordWithInactiveToken(){

        new LoginCabinetPage()
                .clickForgotPasswordLink()
                .setEmailField(clientEmail)
                .clickSendButton();
        boolean isProd = isProductionDomainShown(url());
        String oldLink;
        if(isProd){
            GenericPage
                    .openYopmailPage()
                    .setLoginField(clientEmail)
                    .clickLoginButton();
            sleep(2000);
            new YopmailInboxMailPage()
                    .clickRefreshButton()
                    .switchEmailIframe();
            sleep(2000);
            oldLink = new YopmailInboxMailPage().getForgetPasswordToken();
            GenericPage.openAnyLink(new YopmailInboxMailPage().getForgetPasswordToken());
        }
        else {
            GenericPage
                    .openMailHogPage()
                    .clickRecoveryPasswordEmail(clientEmail);
            oldLink = new MailHogRecoveryPasswordMailPage().getForgetPasswordToken();
            GenericPage.openAnyLink(new MailHogRecoveryPasswordMailPage().getForgetPasswordToken());
        }

        sleep(2000);
        String password = faker.internet().password(8, 15);
        LoginCabinetPage loginCabinetPage = new CreateNewPasswordOverlay()
                .setPasswordField(password)
                .setRetypePasswordField(password)
                .clickSendButton()
                .clickCloseButton();
        sleep(3000);
        new LoginCabinetPage()
                .clickForgotPasswordLink()
                .setEmailField(clientEmail)
                .clickSendButton();
        GenericPage.openAnyLink(oldLink);
        sleep(2000);
        Assertions.assertFalse(loginCabinetPage.isForgotPasswordPopupShown(),
                "Create new password popup should not be displayed");
    }

    @AfterAll
    static void resetPasswordToDefault(){
        resetDefaultClientPassword(clientEmail);
    }
}
