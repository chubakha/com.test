package com.test.login;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VerifyInvalidUsernameAndPasswordMessageTest extends PrepareLoginTestData{

    @Test
    void verifyInvalidUsernameAndPasswordMessage(){
        LoginPage loginPage = new LoginPage()
                .setEmailField(faker.internet().emailAddress())
                .setPasswordField(faker.internet().password())
                .clickInactiveSignUpButton();
        Assertions.assertEquals(ValidationErrorMessagesType.INVALID_USERNAME_AND_PASSWORD_COMBINATION.getValue(),
                loginPage.getValidationMessage(),
                String.format("'%s' message should be shown next to password field",
                        ValidationErrorMessagesType.INVALID_USERNAME_AND_PASSWORD_COMBINATION.getValue()));
    }
}
