package com.test.first_registration_page;

import com.test.registration.first_registration_page.CreateCustomRequestOverlay;
import com.test.registration.first_registration_page.FirstRegistrationPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.sleep;

public class VerifyCreateCustomRequestPopupTitleTest extends PrepareFirstRegistrationPageTestData {
    @Test
    void verifyCreateCustomRequestPopupTitle(){
        CreateCustomRequestOverlay createCustomRequestOverlay =
                new FirstRegistrationPage()
                        .clickNeedHelpWithSomethingElseButton();
        Assertions.assertEquals("Create Custom Request", createCustomRequestOverlay.getNeedHelpWithSomethingElseTitle(), "'Create Custom Request' should be shown on popup");
    }
}
