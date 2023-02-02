package com.test.login;

import com.test.create_new_password.CreateNewPasswordOverlay;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class VerifyLoginAsClientWithOldPasswordTest extends PrepareLoginTestData {

    @Test
    void verifyLoginAsClientWithOldPassword(){

        String password = faker.internet().password(8, 15);
        new LoginCabinetPage()
                .clickForgotPasswordLink()
                .setEmailField(clientEmail)
                .clickSendButton();
        redirectToLinkFromEmail(clientEmail);
        LoginCabinetPage loginCabinetPage = new CreateNewPasswordOverlay()
                .setPasswordField(password)
                .setRetypePasswordField(password)
                .clickSendButton()
                .clickCloseButton()
                .setEmailField(clientEmail)
                .setPasswordField(clientPassword)
                .clickInactiveSignUpButton();
        Assertions.assertEquals(ValidationErrorMessagesType.INVALID_USERNAME_AND_PASSWORD_COMBINATION.getValue(),
                loginCabinetPage.getValidationMessage(),
                String.format("'%s' message should be shown next to password field",
                        ValidationErrorMessagesType.INVALID_USERNAME_AND_PASSWORD_COMBINATION.getValue()));
    }

    @AfterAll
    static void resetPasswordToDefault(){
        resetDefaultClientPassword(clientEmail);
    }
}
