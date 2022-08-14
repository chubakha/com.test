package com.test.login;

import com.codeborne.selenide.Selenide;
import com.test.admin_panel.LoginAdminPage;
import com.test.admin_panel.MainAdminPage;
import com.test.admin_panel.PrepareAdminPanelTestData;
import com.test.admin_panel.clients_section.ViewClientPage;
import com.test.cabinet.manager_cabinet_page.ManagerCabinetPage;
import com.test.create_new_password.CreateNewPasswordOverlay;
import com.test.forgot_password_mail.IncomingMailPage;
import com.test.forgot_password_mail.MainYopmailPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.localStorage;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.url;

public class VerifyLoginAsManagerWithNewPasswordTest extends PrepareLoginTestData {

    @Test
    void verifyLoginAsManagerWithNewPassword(){

        new LoginCabinetPage()
                .clickForgotPasswordLink()
                .setEmailField(managerEmail)
                .clickSendButton();
        boolean isProd = new IncomingMailPage().isProductionDomainShown(url());
        openYopmailPage();
        new MainYopmailPage()
                .setLoginField(managerEmail)
                .clickLoginButton();
        sleep(1000);
        new IncomingMailPage()
                .clickRefreshButton()
                .switchIframe();
        if(isProd){
            openAnyLink(new IncomingMailPage().getProductionForgetPasswordToken());
        }
        else {
            openAnyLink(new IncomingMailPage().getStagingForgetPasswordToken());
        }
        sleep(1000);
        String password = faker.internet().password(8, 15);
        ManagerCabinetPage managerCabinetPage = new CreateNewPasswordOverlay()
                .setPasswordField(password)
                .setRetypePasswordField(password)
                .clickSendButton()
                .clickCloseButton()
                .setEmailField(managerEmail)
                .setPasswordField(password)
                .loginAsManager();
        sleep(2000);
        Assertions.assertTrue(managerCabinetPage.isNewOfferButtonShown(),
                String.format("'%s' button should be shown", managerCabinetPage.getNewOfferButtonText()));
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
                .clickManagersLink()
                .setManagerSearchByEmailField(managerEmail)
                .focusOutSearchFields()
                .clickUpdateButton()
                .setPasswordField(managerPassword)
                .setRepeatPasswordField(managerPassword)
                .clickSaveButton();
        sleep(1000);
        new MainAdminPage().clickLogoutLink();
        sleep(1000);
    }
}
