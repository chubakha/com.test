package com.test.login;

import com.test.admin_panel.LoginAdminPage;
import com.test.admin_panel.MainAdminPage;
import com.test.admin_panel.PrepareAdminPanelTestData;
import com.test.create_new_password.CreateNewPasswordOverlay;
import com.test.forgot_password_mail.MailHogIncomingPage;
import com.test.forgot_password_mail.MailHogMainPage;
import com.test.forgot_password_mail.YopmailIncomingMailPage;
import com.test.forgot_password_mail.YopmailMainPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.localStorage;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.url;

public class VerifyRecoveryPasswordWithInactiveTokenTest extends PrepareLoginTestData {

    @Test
    void verifyRecoveryPasswordWithInactiveToken(){

        new LoginCabinetPage()
                .clickForgotPasswordLink()
                .setEmailField(clientEmail)
                .clickSendButton();
        boolean isProd = new YopmailIncomingMailPage().isProductionDomainShown(url());
        String oldLink;
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
            oldLink = new YopmailIncomingMailPage().getForgetPasswordToken();
            openAnyLink(new YopmailIncomingMailPage().getForgetPasswordToken());
        }
        else {
            openMailHogPage();
            new MailHogMainPage().
                    clickIncomingEmail(clientEmail);
            oldLink = new MailHogIncomingPage().getForgetPasswordToken();
            openAnyLink(new MailHogIncomingPage().getForgetPasswordToken());
        }

        sleep(2000);
        String password = faker.internet().password(8, 15);
        LoginCabinetPage loginCabinetPage = new CreateNewPasswordOverlay()
                .setPasswordField(password)
                .setRetypePasswordField(password)
                .clickSendButton()
                .clickCloseButton();
        sleep(2000);
        new LoginCabinetPage()
                .clickForgotPasswordLink()
                .setEmailField(clientEmail)
                .clickSendButton();
        openAnyLink(oldLink);
        sleep(2000);
        Assertions.assertFalse(loginCabinetPage.isForgotPasswordPopupShown(),
                "Create new password popup should not be displayed");
        localStorage().clear();
        sleep(2000);
    }

    @AfterEach
    void resetPasswordToDefault(){
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
        sleep(1000);
    }
}
