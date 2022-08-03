package com.test.login;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VerifyAppearInvalidUsernameAndPasswordMessageTest extends PrepareLoginTestData{

    @Test
    void verifyInvalidUsernameAndPasswordMessage(){
        LoginCabinetPage loginCabinetPage = new LoginCabinetPage()
                .setEmailField(faker.internet().emailAddress())
                .setPasswordField(faker.internet().password())
                .clickInactiveSignUpButton();
        Assertions.assertEquals(ValidationErrorMessagesType.INVALID_USERNAME_AND_PASSWORD_COMBINATION.getValue(),
                loginCabinetPage.getValidationMessage(),
                String.format("'%s' message should be shown next to password field",
                        ValidationErrorMessagesType.INVALID_USERNAME_AND_PASSWORD_COMBINATION.getValue()));
    }
}
