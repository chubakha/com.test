package com.test.registration.first_registration_page;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VerifyCreateCustomRequestPopupTitleTest extends PrepareFirstRegistrationPageTestData {
    @Test
    void verifyCreateCustomRequestPopupTitle(){
        CreateCustomRequestOverlay createCustomRequestOverlay =
                new FirstRegistrationPage()
                        .clickNeedHelpWithSomethingElseButton();
        Assertions.assertEquals("Create Custom Request", createCustomRequestOverlay.getNeedHelpWithSomethingElseTitle(), "'Create Custom Request' should be shown on popup");
    }
}
