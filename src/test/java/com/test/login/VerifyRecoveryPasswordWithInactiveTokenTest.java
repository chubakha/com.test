package com.test.login;

import com.test.GenericPage;
import com.test.create_new_password.CreateNewPasswordOverlay;
import com.test.mailers.MailHogRecoveryPasswordMailPage;
import com.test.mailers.YopmailInboxMailPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.WebDriverRunner.url;

public class VerifyRecoveryPasswordWithInactiveTokenTest extends PrepareLoginTestData {

    @Test
    void verifyRecoveryPasswordWithInactiveToken(){

        String password = faker.internet().password(8, 15);
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
            new YopmailInboxMailPage()
                    .clickRefreshButton()
                    .switchEmailIframe();
            oldLink = new YopmailInboxMailPage().getLinkFromProdEmail();
            GenericPage.openAnyLink(new YopmailInboxMailPage().getLinkFromProdEmail());
        }
        else {
            GenericPage
                    .openMailHogPage()
                    .clickRecoveryPasswordEmail(clientEmail);
            oldLink = new MailHogRecoveryPasswordMailPage().getLinkFromStageEmail();
            GenericPage.openAnyLink(new MailHogRecoveryPasswordMailPage().getLinkFromStageEmail());
        }

        LoginCabinetPage loginCabinetPage = new CreateNewPasswordOverlay()
                .setPasswordField(password)
                .setRetypePasswordField(password)
                .clickSendButton()
                .clickCloseButton();
        new LoginCabinetPage()
                .clickForgotPasswordLink()
                .setEmailField(clientEmail)
                .clickSendButton();
        GenericPage.openAnyLink(oldLink);
        Assertions.assertFalse(loginCabinetPage.isForgotPasswordPopupShown(),
                "Create new password popup should not be displayed");
    }

    @AfterAll
    static void resetPasswordToDefault(){
        resetDefaultClientPassword(clientEmail);
    }
}
