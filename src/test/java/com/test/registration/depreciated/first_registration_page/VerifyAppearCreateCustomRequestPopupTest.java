package com.test.registration.depreciated.first_registration_page;

import com.test.registration.PrepareRegistrationTestData;
import io.qameta.allure.Epic;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static com.test.registration.PrepareRegistrationTestData.AUTHOR_ALEX_CHU;

@Owner(value = AUTHOR_ALEX_CHU)
public class VerifyAppearCreateCustomRequestPopupTest extends PrepareRegistrationTestData {

    @Test
    @Epic(value = STEP_FIRST_REGISTRATION_PAGE)
    void verifyAppearCreateCustomRequestPopup() {
        CreateCustomRequestOverlay createCustomRequestOverlay = new FirstRegistrationPage()
                .clickNeedHelpWithSomethingElseButton();
        Assertions.assertTrue(createCustomRequestOverlay.isNeedHelpWithSomethingElseShown(), "'Create Custom Request' should be shown");
    }
}