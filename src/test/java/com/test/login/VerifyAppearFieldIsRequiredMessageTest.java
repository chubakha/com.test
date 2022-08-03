package com.test.login;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VerifyAppearFieldIsRequiredMessageTest extends PrepareLoginTestData{

    @Test
    void verifyFieldIsRequiredMessage(){
        ForgotPasswordOverlay forgotPasswordOverlay = new LoginCabinetPage()
                .clickForgotPasswordLink()
                .clickSendButton();
        Assertions.assertEquals(ValidationErrorMessagesType.FIELD_IS_REQUIRED.getValue(),
                forgotPasswordOverlay.getValidationMessage(),
                String.format("'%s' message should be shown next to 'Enter email' field",
                        ValidationErrorMessagesType.FIELD_IS_REQUIRED.getValue()));
    }
}
