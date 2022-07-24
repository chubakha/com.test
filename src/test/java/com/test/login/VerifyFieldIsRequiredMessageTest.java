package com.test.login;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VerifyFieldIsRequiredMessageTest extends PrepareLoginTestData{

    @Test
    void verifyFieldIsRequiredMessage(){
        ForgotPasswordOverlay forgotPasswordOverlay = new LoginPage()
                .clickForgotPasswordLink()
                .clickSendButton();
        Assertions.assertEquals(ValidationErrorMessagesType.FIELD_IS_REQUIRED.getValue(),
                forgotPasswordOverlay.getValidationMessage(),
                String.format("'%s' message should be shown next to 'Enter email' field",
                        ValidationErrorMessagesType.FIELD_IS_REQUIRED.getValue()));
    }
}
