package com.test.registration.first_registration_page;

import com.test.registration.PrepareRegistrationTestData;
import io.qameta.allure.Epic;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VerifyCreateCustomRequestPopupTitleTest extends PrepareRegistrationTestData {

    @Test
    @Epic(value = "First registration page")
    @Owner(value = "Alex Chu")
    void verifyCreateCustomRequestPopupTitle() {
        CreateCustomRequestOverlay createCustomRequestOverlay = new FirstRegistrationPage()
                .clickNeedHelpWithSomethingElseButton();
        Assertions.assertEquals("Create Custom Request", createCustomRequestOverlay.getNeedHelpWithSomethingElseTitle(),
                "'Create Custom Request' should be shown on popup");
    }
}
