package com.test.registration.first_registration_page;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.sleep;

public class VerifyCreateCustomRequestPopupAppearedTest extends PrepareFirstRegistrationPageTestData {
    @Test
    void verifyCreateCustomRequestPopupAppeared() {
        CreateCustomRequestOverlay createCustomRequestOverlay =
                new FirstRegistrationPage()
                        .clickNeedHelpWithSomethingElseButton();
        sleep(3000);
        Assertions.assertTrue(createCustomRequestOverlay.isNeedHelpWithSomethingElse(),"'Create Custom Request' should be shown");
    }
}
