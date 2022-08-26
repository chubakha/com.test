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

public class VerifyLoginAsManagerWithOldPasswordTest extends PrepareLoginTestData {

    @Test
    void verifyLoginAsManagerWithOldPassword(){

        new LoginCabinetPage()
                .clickForgotPasswordLink()
                .setEmailField(managerEmail)
                .clickSendButton();
        redirectToForgetPasswordToken(managerEmail);
        sleep(1000);
        String password = faker.internet().password(8, 15);
        LoginCabinetPage loginCabinetPage = new CreateNewPasswordOverlay()
                .setPasswordField(password)
                .setRetypePasswordField(password)
                .clickSendButton()
                .clickCloseButton()
                .setEmailField(managerEmail)
                .setPasswordField(managerPassword)
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
