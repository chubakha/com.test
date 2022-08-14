package com.test.login;

import com.codeborne.selenide.Selenide;
import com.test.admin_panel.LoginAdminPage;
import com.test.admin_panel.MainAdminPage;
import com.test.admin_panel.PrepareAdminPanelTestData;
import com.test.admin_panel.clients_section.ViewClientPage;
import com.test.create_new_password.CreateNewPasswordOverlay;
import com.test.forgot_password_mail.IncomingMailPage;
import com.test.forgot_password_mail.MainYopmailPage;
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
        boolean isProd = new IncomingMailPage().isProductionDomainShown(url());
        openYopmailPage();
        new MainYopmailPage()
                .setLoginField(clientEmail)
                .clickLoginButton();
        sleep(2000);
        new IncomingMailPage()
                .clickRefreshButton()
                .switchIframe();
        String oldLink;
        sleep(2000);
        if(isProd){
            oldLink = new IncomingMailPage().getProductionForgetPasswordToken();
            openAnyLink(new IncomingMailPage().getProductionForgetPasswordToken());
        }
        else {
            oldLink = new IncomingMailPage().getStagingForgetPasswordToken();
            openAnyLink(new IncomingMailPage().getStagingForgetPasswordToken());
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
        Selenide.clearBrowserCookies();
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
