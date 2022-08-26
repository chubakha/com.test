package com.test.login;

import com.test.admin_panel.LoginAdminPage;
import com.test.admin_panel.MainAdminPage;
import com.test.admin_panel.PrepareAdminPanelTestData;
import com.test.forgot_password_mail.MailHogIncomingPage;
import com.test.forgot_password_mail.MailHogMainPage;
import com.test.forgot_password_mail.YopmailIncomingMailPage;
import com.test.forgot_password_mail.YopmailMainPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.url;

public class VerifyTokenPlusOneSymbolTest extends PrepareLoginTestData {

    @Test
    void verifyTokenPlusOneSymbol(){

        new LoginCabinetPage()
                .clickForgotPasswordLink()
                .setEmailField(clientEmail)
                .clickSendButton();
        boolean isProd = new YopmailIncomingMailPage().isProductionDomainShown(url());
        if(isProd){
            openYopmailPage();
            new YopmailMainPage()
                    .setLoginField(clientEmail)
                    .clickLoginButton();
            sleep(2000);
            new YopmailIncomingMailPage()
                    .clickRefreshButton()
                    .switchIframe();
            sleep(2000);
            openAnyLink(new MailHogIncomingPage().getForgetPasswordTokenPlusOneSymbol());
        }
        else {
            openMailHogPage();
            new MailHogMainPage().
                    clickIncomingEmail(clientEmail);
            openAnyLink(new MailHogIncomingPage().getForgetPasswordTokenPlusOneSymbol());
        }
        sleep(2000);
        Assertions.assertFalse(new LoginCabinetPage().isForgotPasswordPopupShown(),
                "Create new password popup should not be displayed");
    }

    @AfterAll
    static void resetPasswordToDefault(){
        PrepareAdminPanelTestData.openLoginAdminPage();
        new LoginAdminPage()
                .setUsernameField(usernameAdmin)
                .setPasswordField(passwordAdmin)
                .loginAsAdmin()
                .clickClientsLink()
                .setClientSearchByEmailField(clientEmail)
                .focusOutSearchFields()
                .clickUpdateButton()
                .setPasswordField(clientPassword)
                .setRepeatPasswordField(clientPassword)
                .clickSaveButton();
        sleep(1000);
        new MainAdminPage().clickLogoutLink();
        sleep(2000);
    }
}
