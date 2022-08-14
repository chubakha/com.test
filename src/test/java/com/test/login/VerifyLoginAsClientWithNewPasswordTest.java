package com.test.login;

import com.codeborne.selenide.Selenide;
import com.test.admin_panel.LoginAdminPage;
import com.test.admin_panel.MainAdminPage;
import com.test.admin_panel.PrepareAdminPanelTestData;
import com.test.admin_panel.clients_section.ViewClientPage;
import com.test.cabinet.client_cabinet_page.ClientCabinetPage;
import com.test.create_new_password.CreateNewPasswordOverlay;
import com.test.forgot_password_mail.IncomingMailPage;
import com.test.forgot_password_mail.MainYopmailPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.localStorage;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.url;

public class VerifyLoginAsClientWithNewPasswordTest extends PrepareLoginTestData {

    @Test
    void verifyLoginAsClientWithNewPassword(){

        new LoginCabinetPage()
                .clickForgotPasswordLink()
                .setEmailField(clientEmail)
                .clickSendButton();
        boolean isProd = new IncomingMailPage().isProductionDomainShown(url());
        openYopmailPage();
        new MainYopmailPage()
                .setLoginField(clientEmail)
                .clickLoginButton();
        sleep(1000);
        new IncomingMailPage().clickRefreshButton()
                .switchIframe();
        sleep(1000);
        if(isProd){
            openAnyLink(new IncomingMailPage().getProductionForgetPasswordToken());
        }
        else {
            openAnyLink(new IncomingMailPage().getStagingForgetPasswordToken());
        }
        sleep(2000);
        String password = faker.internet().password(8, 15);
        ClientCabinetPage clientCabinetPage = new CreateNewPasswordOverlay()
                .setPasswordField(password)
                .setRetypePasswordField(password)
                .clickSendButton()
                .clickCloseButton()
                .setEmailField(clientEmail)
                .setPasswordField(password)
                .loginAsClient();
        Assertions.assertTrue(clientCabinetPage.isTaskRequestButtonShown(),
                String.format("'%s' button should be shown", clientCabinetPage.getTaskRequestButtonText()));
        Selenide.clearBrowserCookies();
        localStorage().clear();
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
