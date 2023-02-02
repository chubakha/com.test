package com.test.login;

import com.test.create_new_password.CreateNewPasswordOverlay;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VerifyLoginAsManagerWithOldPasswordTest extends PrepareLoginTestData {

    @Test
    void verifyLoginAsManagerWithOldPassword(){

        String password = faker.internet().password(8, 15);
        new LoginCabinetPage()
                .clickForgotPasswordLink()
                .setEmailField(dataGenerationManagerEmail)
                .clickSendButton();
        redirectToLinkFromEmail(dataGenerationManagerEmail);
        LoginCabinetPage loginCabinetPage = new CreateNewPasswordOverlay()
                .setPasswordField(password)
                .setRetypePasswordField(password)
                .clickSendButton()
                .clickCloseButton()
                .setEmailField(dataGenerationManagerEmail)
                .setPasswordField(dataGenerationManagerPassword)
                .clickInactiveSignUpButton();
        Assertions.assertEquals(ValidationErrorMessagesType.INVALID_USERNAME_AND_PASSWORD_COMBINATION.getValue(),
                loginCabinetPage.getValidationMessage(),
                String.format("'%s' message should be shown next to password field",
                        ValidationErrorMessagesType.INVALID_USERNAME_AND_PASSWORD_COMBINATION.getValue()));
    }

    @AfterAll
    static void resetPasswordToDefault(){
        resetDefaultManagerPassword(dataGenerationManagerEmail);
    }

}
