package com.test.registration.depreciated.first_registration_page;

import com.test.registration.PrepareRegistrationTestData;
import io.qameta.allure.Epic;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.test.registration.PrepareRegistrationTestData.AUTHOR_ALEX_CHU;

@Owner(value = AUTHOR_ALEX_CHU)
public class VerifyCreateCustomRequestPopupTitleTest extends PrepareRegistrationTestData {

    @Test
    void verifyCreateCustomRequestPopupTitle() {
        CreateCustomRequestOverlay createCustomRequestOverlay = new FirstRegistrationPage()
                .clickNeedHelpWithSomethingElseButton();
        Assertions.assertEquals("Create Custom Request", createCustomRequestOverlay.getNeedHelpWithSomethingElseTitle(),
                "'Create Custom Request' should be shown on popup");
    }
}
