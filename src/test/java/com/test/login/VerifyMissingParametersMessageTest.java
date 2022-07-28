package com.test.login;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VerifyMissingParametersMessageTest extends PrepareLoginTestData{

    @Test
    void verifyMissingParametersMessage(){
        ClientLoginPage clientLoginPage = new ClientLoginPage()
                .clickInactiveSignUpButton();
        Assertions.assertEquals(ValidationErrorMessagesType.MISSING_PARAMETERS.getValue(),
                clientLoginPage.getValidationMessage(),
                String.format("'%s' message should be shown next to password field", ValidationErrorMessagesType.MISSING_PARAMETERS.getValue()));
    }
}
