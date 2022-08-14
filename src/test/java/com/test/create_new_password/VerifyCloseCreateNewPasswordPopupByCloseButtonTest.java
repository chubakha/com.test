package com.test.create_new_password;

import com.codeborne.selenide.Selenide;
import com.test.admin_panel.LoginAdminPage;
import com.test.admin_panel.MainAdminPage;
import com.test.admin_panel.PrepareAdminPanelTestData;
import com.test.admin_panel.clients_section.ViewClientPage;
import com.test.login.LoginCabinetPage;
import com.test.login.PrepareLoginTestData;
import com.test.forgot_password_mail.IncomingMailPage;
import com.test.forgot_password_mail.MainYopmailPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.localStorage;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.url;

public class VerifyCloseCreateNewPasswordPopupByCloseButtonTest extends PrepareLoginTestData {

    @Test
    void verifyCloseCreateNewPasswordPopupByCloseButton(){
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
        new IncomingMailPage().clickRefreshButton()
                .switchIframe();
        if(isProd){
            openAnyLink(new IncomingMailPage().getProductionForgetPasswordToken());
        }
        else {
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
        Assertions.assertFalse(loginCabinetPage.isForgotPasswordPopupShown(),
                "Create new password popup should not be displayed");
        localStorage().clear();
        Selenide.clearBrowserCookies();
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
        sleep(1000);
    }
}
