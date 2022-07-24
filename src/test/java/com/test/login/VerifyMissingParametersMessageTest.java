package com.test.login;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VerifyMissingParametersMessageTest extends PrepareLoginTestData{

    @Test
    void verifyMissingParametersMessage(){
        LoginPage loginPage = new LoginPage()
                .clickInactiveSignUpButton();
        Assertions.assertEquals(ValidationErrorMessagesType.MISSING_PARAMETERS.getValue(),
                loginPage.getValidationMessage(),
                String.format("'%s' message should be shown next to password field", ValidationErrorMessagesType.MISSING_PARAMETERS.getValue()));
    }
}
