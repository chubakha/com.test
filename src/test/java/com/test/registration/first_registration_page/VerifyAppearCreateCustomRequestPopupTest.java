package com.test.registration.first_registration_page;

import com.test.registration.PrepareRegistrationTestData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.sleep;

public class VerifyAppearCreateCustomRequestPopupTest extends PrepareRegistrationTestData {
    @Test
    void verifyAppearCreateCustomRequestPopup() {
        CreateCustomRequestOverlay createCustomRequestOverlay = new FirstRegistrationPage()
                .clickNeedHelpWithSomethingElseButton();
        Assertions.assertTrue(createCustomRequestOverlay.isNeedHelpWithSomethingElseShown(), "'Create Custom Request' should be shown");
    }
}
