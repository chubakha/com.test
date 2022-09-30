package com.test.login;

import com.test.GenericPage;
import com.test.admin_panel.MainAdminPage;
import com.test.cabinet.manager_cabinet_page.ManagerCabinetPage;
import com.test.create_new_password.CreateNewPasswordOverlay;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.localStorage;
import static com.codeborne.selenide.Selenide.sleep;

public class VerifyLoginAsManagerWithNewPasswordTest extends PrepareLoginTestData {

    @Test
    void verifyLoginAsManagerWithNewPassword(){

        new LoginCabinetPage()
                .clickForgotPasswordLink()
                .setEmailField(managerEmail)
                .clickSendButton();
        redirectToForgetPasswordToken(managerEmail);
        sleep(2000);
        String password = faker.internet().password(8, 15);
        ManagerCabinetPage managerCabinetPage = new CreateNewPasswordOverlay()
                .setPasswordField(password)
                .setRetypePasswordField(password)
                .clickSendButton()
                .clickCloseButton()
                .setEmailField(managerEmail)
                .setPasswordField(password)
                .loginAsManager();
        sleep(3000);
        Assertions.assertTrue(managerCabinetPage.isNewOfferButtonShown(),
                String.format("'%s' button should be shown", managerCabinetPage.getNewOfferButtonText()));
        localStorage().clear();
    }

    @AfterAll
    static void resetPasswordToDefault(){
        GenericPage
                .openLoginAdminPage()
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
        sleep(2000);
        new MainAdminPage().clickLogoutLink();
        sleep(1000);
    }
}
