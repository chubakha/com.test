package com.test.login;

import com.test.GenericPage;
import com.test.admin_panel.MainAdminPage;
import com.test.forgot_password_mail.MailHogIncomingPage;
import com.test.forgot_password_mail.YopmailIncomingMailPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;

public class VerifyTokenWithoutLastSymbolTest extends PrepareLoginTestData {

    @Test
    void verifyTokenWithoutLastSymbol() {

        new LoginCabinetPage()
                .clickForgotPasswordLink()
                .setEmailField(clientEmail)
                .clickSendButton();
        boolean isProd = new YopmailIncomingMailPage().isProductionDomainShown(url());
        if (isProd) {
            GenericPage
                    .openYopmailPage()
                    .setLoginField(clientEmail)
                    .clickLoginButton();
            sleep(3000);
            new YopmailIncomingMailPage()
                    .clickRefreshButton()
                    .switchEmailIframe();
            sleep(3000);
            GenericPage.openAnyLink(new YopmailIncomingMailPage().getForgetPasswordTokenMinusOneSymbol());
        } else {
            GenericPage
                    .openMailHogPage()
                    .clickIncomingEmail(clientEmail);
            GenericPage.openAnyLink(new MailHogIncomingPage().getForgetPasswordTokenMinusOneSymbol());
        }
        sleep(2000);
        Assertions.assertFalse(new LoginCabinetPage().isForgotPasswordPopupShown(),
                "Create new password popup should not be displayed");
    }

    @AfterAll
    static void resetPasswordToDefault(){
        resetDefaultClientPassword(clientEmail);
    }
}
