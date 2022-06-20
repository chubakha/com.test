package com.test.registration.first_registration_page;

import com.test.registration.PrepareRegistrationTestData;
import io.qameta.allure.Epic;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class VerifyAppearCreateCustomRequestPopupTest extends PrepareRegistrationTestData {

    @Test
    @Epic(value = "First registration page")
    @Owner(value = "Alex Chu")
    void verifyAppearCreateCustomRequestPopup() {
        CreateCustomRequestOverlay createCustomRequestOverlay = new FirstRegistrationPage()
                .clickNeedHelpWithSomethingElseButton();
        Assertions.assertTrue(createCustomRequestOverlay.isNeedHelpWithSomethingElseShown(), "'Create Custom Request' should be shown");
    }
}
