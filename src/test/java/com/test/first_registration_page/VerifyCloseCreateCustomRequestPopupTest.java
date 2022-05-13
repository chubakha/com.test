package com.test.first_registration_page;

import com.test.registration.first_registration_page.CreateCustomRequestOverlay;
import com.test.registration.first_registration_page.FirstRegistrationPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.sleep;

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
