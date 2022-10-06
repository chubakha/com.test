package com.test.login;

import com.test.GenericPage;
import com.test.admin_panel.MainAdminPage;
import com.test.forgot_password_mail.MailHogIncomingPage;
import com.test.forgot_password_mail.YopmailIncomingMailPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.closeWindow;
import static com.codeborne.selenide.Selenide.sleep;
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
                    .clickCookiesAcceptButton()
                    .setLoginField(clientEmail)
                    .clickLoginButton();
            sleep(3000);
            new YopmailIncomingMailPage()
                    .clickRefreshButton()
                    .switchIframe();
            System.out.println("1");
            sleep(3000);
            GenericPage.openAnyLink(new YopmailIncomingMailPage().getForgetPasswordTokenMinusOneSymbol());
        } else {
            GenericPage
                    .openMailHogPage()
                    .clickIncomingEmail(clientEmail);
            System.out.println("2");
            GenericPage.openAnyLink(new MailHogIncomingPage().getForgetPasswordTokenMinusOneSymbol());
        }
        sleep(2000);
        Assertions.assertFalse(new LoginCabinetPage().isForgotPasswordPopupShown(),
                "Create new password popup should not be displayed");
    }

    @AfterAll
    static void resetPasswordToDefault() {
        GenericPage
                .openLoginAdminPage()
                .setUsernameField(stageUsernameAdmin)
                .setPasswordField(stagePasswordAdmin)
                .loginAsAdmin()
                .clickClientsLink()
                .setClientSearchByEmailField(clientEmail)
                .focusOutSearchFields()
                .clickUpdateButton()
                .setPasswordField(clientPassword)
                .setRepeatPasswordField(clientPassword)
                .clickSaveButton();
        sleep(2000);
        new MainAdminPage().clickLogoutLink();
        sleep(1000);
        closeWindow();
    }
}
