package com.test.login;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VerifyAppearMissingParametersMessageTest extends PrepareLoginTestData{

    @Test
    void verifyMissingParametersMessage(){
        LoginCabinetPage loginCabinetPage = new LoginCabinetPage()
                .clickInactiveSignUpButton();
        Assertions.assertEquals(ValidationErrorMessagesType.MISSING_PARAMETERS.getValue(),
                loginCabinetPage.getValidationMessage(),
                String.format("'%s' message should be shown next to password field", ValidationErrorMessagesType.MISSING_PARAMETERS.getValue()));
    }
}
