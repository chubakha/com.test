package com.test.registration.first_registration_page;

import com.test.registration.PrepareRegistrationTestData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.sleep;

public class VerifyAppearCreateCustomRequestPopupTest extends PrepareRegistrationTestData {
    @Test
    void verifyCreateCustomRequestPopupAppeared() {
        CreateCustomRequestOverlay createCustomRequestOverlay = new FirstRegistrationPage()
                .clickNeedHelpWithSomethingElseButton();
        sleep(1000);
        Assertions.assertTrue(createCustomRequestOverlay.isNeedHelpWithSomethingElseShown(), "'Create Custom Request' should be shown");
    }
}
