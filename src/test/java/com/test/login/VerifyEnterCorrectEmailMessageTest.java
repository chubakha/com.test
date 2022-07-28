package com.test.login;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VerifyEnterCorrectEmailMessageTest extends PrepareLoginTestData {

    @Test
    void verifyEnterCorrectEmailMessage(){
        ForgotPasswordOverlay forgotPasswordOverlay = new ClientLoginPage()
                .clickForgotPasswordLink()
                .setEmailField(faker.name().username())
                .clickSendButton();
        Assertions.assertEquals(ValidationErrorMessagesType.ENTER_CORRECT_EMAIL.getValue(),
                forgotPasswordOverlay.getValidationMessage(),
                String.format("'%s' message should be shown next to 'Enter email' field",
                        ValidationErrorMessagesType.ENTER_CORRECT_EMAIL.getValue()));
    }
}
