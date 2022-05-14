package com.test.registration.first_registration_page;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VerifyCloseCreateCustomRequestPopupTest extends PrepareFirstRegistrationPageTestData {
    @Test
    void verifyCloseCreateCustomRequestPopup(){
        FirstRegistrationPage firstRegistrationPage =
                new FirstRegistrationPage()
                        .clickNeedHelpWithSomethingElseButton()
                        .clickHelpWithSomethingElseClosePopup();
        Assertions.assertFalse(firstRegistrationPage.isNotNeedHelpWithSomethingElse(), "'Create Custom Request' should not be shown");
    }
}
