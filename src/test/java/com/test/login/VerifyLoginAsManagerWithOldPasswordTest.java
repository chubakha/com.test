package com.test.login;

import com.test.GenericPage;
import com.test.admin_panel.MainAdminPage;
import com.test.create_new_password.CreateNewPasswordOverlay;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class VerifyLoginAsManagerWithOldPasswordTest extends PrepareLoginTestData {

    @Test
    void verifyLoginAsManagerWithOldPassword(){

        new LoginCabinetPage()
                .clickForgotPasswordLink()
                .setEmailField(managerEmail)
                .clickSendButton();
        redirectToForgetPasswordToken(managerEmail);
        sleep(2000);
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
    }

    @AfterAll
    static void resetPasswordToDefault(){
        resetDefaultManagerPassword(managerEmail);
    }

}
