package com.test.login;

import com.test.admin_panel.LoginAdminPage;
import com.test.admin_panel.MainAdminPage;
import com.test.admin_panel.PrepareAdminPanelTestData;
import com.test.create_new_password.CreateNewPasswordOverlay;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.localStorage;
import static com.codeborne.selenide.Selenide.sleep;

public class VerifyLoginAsClientWithOldPasswordTest extends PrepareLoginTestData {

    @Test
    void verifyLoginAsClientWithOldPassword(){

        new LoginCabinetPage()
                .clickForgotPasswordLink()
                .setEmailField(clientEmail)
                .clickSendButton();
        redirectToForgetPasswordToken(clientEmail);
        sleep(2000);
        String password = faker.internet().password(8, 15);
        new CreateNewPasswordOverlay()
                .setPasswordField(password)
                .setRetypePasswordField(password)
                .clickSendButton()
                .clickCloseButton();
        sleep(2000);
        LoginCabinetPage loginCabinetPage = new LoginCabinetPage().setEmailField(clientEmail)
                .setPasswordField(clientPassword)
                .clickInactiveSignUpButton();
        Assertions.assertEquals(ValidationErrorMessagesType.INVALID_USERNAME_AND_PASSWORD_COMBINATION.getValue(),
                loginCabinetPage.getValidationMessage(),
                String.format("'%s' message should be shown next to password field",
                        ValidationErrorMessagesType.INVALID_USERNAME_AND_PASSWORD_COMBINATION.getValue()));
        localStorage().clear();
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
